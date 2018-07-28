package ru.s4nchez.crackerfinance.screens.page;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.utils.MyLog;
import ru.s4nchez.crackerfinance.utils.MyToast;

public class PageFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        TextView text = view.findViewById(R.id.textView);
        text.setText("Fragment #" + mPage);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        MyToast.get(getContext()).show("onResume", mPage);
    }
}