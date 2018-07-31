package ru.s4nchez.crackerfinance.screens.general;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.s4nchez.crackerfinance.BaseFragment;
import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.Settings;
import ru.s4nchez.crackerfinance.model.Account;
import ru.s4nchez.crackerfinance.model.currency.Currencies;
import ru.s4nchez.crackerfinance.model.currency.Currency;
import ru.s4nchez.crackerfinance.vm.AppViewModel;

public class GeneralInformationFragment extends BaseFragment implements ViewContract {

    private static final String DIALOG_ID = "CHANGE_ACCOUNT_DIALOG";

    private static String ratesText = "";
    private final OkHttpClient client = new OkHttpClient();

    @BindView(R.id.account)
    TextView viewAccount;

    @BindView(R.id.budget)
    TextView viewBudget;

    @BindView(R.id.frameAccount)
    CardView frameAccount;

    @BindView(R.id.rates)
    TextView rates;

    @BindView(R.id.progressBarRates)
    ProgressBar progressBarRates;

    private MainScreenPresenter presenter;
    private Account account;
    private boolean ratesIsLoaded;
    private AppViewModel viewModel;

    public static GeneralInformationFragment newInstance() {
        return new GeneralInformationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_general_information, container, false);

        butterKnifeUnbinder = ButterKnife.bind(this, v);

        viewAccount.setSelected(true);

        viewModel = ViewModelProviders.of(getActivity()).get(AppViewModel.class);

        MutableLiveData<Account> liveDataAccount = viewModel.getCurrentAccount();
        account = liveDataAccount.getValue();

        MutableLiveData<Boolean> liveDataRatesIsLoaded = viewModel.getRatesIsLoaded();
        ratesIsLoaded = liveDataRatesIsLoaded.getValue();

        presenter = new MainScreenPresenter(new MainScreenModel(getContext(), account));
        presenter.attachView(this);

        liveDataAccount.observe(getActivity(), this::updateAccountUI);
        liveDataRatesIsLoaded.observe(getActivity(), this::updateRatesUI);

        if (!ratesIsLoaded) {
            loadCurrency();
        }

        return v;
    }

    private void loadCurrency() {
        String currentCurrencyStr = Settings.get().getCurrency(getActivity());
        final Currency currentCurrency = Currencies.get().getCurrencyByCode(currentCurrencyStr);
        final List<Currency> other = Currencies.get().getCurrenciesExceptOne(currentCurrency);
        String q = Helper.getCurrencyParamForRequest(currentCurrency, other);

        Request request = new Request.Builder()
                .url(Helper.getUrl(q))
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String myResponse = response.body().string();
                getActivity().runOnUiThread(() -> {
                    String result = "";
                    try {
                        result = Helper.getRatesStringForView(myResponse, currentCurrency, other);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ratesText = result;
                    viewModel.setRatesIsLoaded(true);
                });
            }
        });
    }

    private void updateAccountUI(Account account) {
        if (presenter.hasView()) {
            presenter.setAccount(account);
            presenter.showAccount();
            presenter.showBudget();
        }
    }

    private void updateRatesUI(boolean flag) {
        ratesIsLoaded = flag;
        if (presenter.hasView()) {
            rates.setVisibility(flag ? View.VISIBLE : View.GONE);
            progressBarRates.setVisibility(!flag ? View.VISIBLE : View.GONE);
            rates.setText(ratesText);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void setBudget(String s) {
        viewBudget.setText(s);
    }

    @Override
    public void setAccount(String account) {
        viewAccount.setText(account);
    }

    @OnClick(R.id.frameAccount)
    void frameAccountOnClick(View view) {
        FragmentManager fm = getFragmentManager();
        ChangeAccountDialogFragment dialog = ChangeAccountDialogFragment.newInstance();
        dialog.show(fm, DIALOG_ID);
    }
}