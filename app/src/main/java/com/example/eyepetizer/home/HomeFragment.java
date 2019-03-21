package com.example.eyepetizer.home;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eyepetizer.BaseApplication;
import com.example.eyepetizer.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * V层
 *
 * @author popeg
 */
public class HomeFragment extends Fragment implements HomeView {

    @Inject
    HomePresenter presenter;
    @BindView(R.id.recyclerView_home)
    RecyclerView recyclerViewHome;
    @BindView(R.id.textView2)
    TextView textView2;
    Unbinder unbinder;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((BaseApplication) getActivity().getApplication()).createHomeComponent().inject(this);
        presenter.bindView(this);
        presenter.getData();
    }

    @Override
    public void loadData(String data) {
        textView2.setText(data);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
