package com.example.eyepetizer.home;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eyepetizer.BaseApplication;
import com.example.eyepetizer.R;
import com.example.eyepetizer.database.JsonRootBean;
import com.example.eyepetizer.database.TabInfo;
import com.example.eyepetizer.database.TabList;
import com.example.eyepetizer.network.EyepetizerApiService;
import com.example.eyepetizer.system.Global;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        retrofitTest();
    }

    private void retrofitTest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Global.API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EyepetizerApiService service = retrofit.create(EyepetizerApiService.class);
        Call<JsonRootBean> call = service.getTabInfo();
        call.enqueue(new Callback<JsonRootBean>() {
            @Override
            public void onResponse(Call<JsonRootBean> call, Response<JsonRootBean> response) {
                response.body();
            }

            @Override
            public void onFailure(Call<JsonRootBean> call, Throwable t) {

            }
        });
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
