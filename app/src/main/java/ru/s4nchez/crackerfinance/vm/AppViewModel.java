package ru.s4nchez.crackerfinance.vm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import ru.s4nchez.crackerfinance.model.Account;
import ru.s4nchez.crackerfinance.model.Bank;
import ru.s4nchez.crackerfinance.model.Operation;
import ru.s4nchez.crackerfinance.model.Rates;

public class AppViewModel extends ViewModel {

    private Bank bank;
    private MutableLiveData<Account> currentAccount = new MutableLiveData<>();
    private MutableLiveData<Boolean> ratesIsLoaded = new MutableLiveData<>();

    public AppViewModel() {
        bank = new Bank();
        currentAccount.setValue(bank.getAccounts().get(1));
        ratesIsLoaded.setValue(false);
    }

    public void setCurrentAccount(int i) {
        Account account = bank.getAccountByIndex(i);
        currentAccount.setValue(account);
    }

    public void addOperation(Operation operation) {
        Account account = currentAccount.getValue();
        account.addOperation(operation);
        currentAccount.setValue(account);
    }

    public void removeOperation(int position) {
        Account account = currentAccount.getValue();
        account.removeOperation(position);
        currentAccount.setValue(account);
    }

    public List<Operation> getOperations() {
        return currentAccount.getValue().getOperations();
    }

    public MutableLiveData<Account> getCurrentAccount() {
        return currentAccount;
    }

    public MutableLiveData<Boolean> getRatesIsLoaded() {
        return ratesIsLoaded;
    }

    public void setRatesIsLoaded(boolean ratesIsLoaded) {
        this.ratesIsLoaded.setValue(ratesIsLoaded);
    }

    public Bank getBank() {
        return bank;
    }
}