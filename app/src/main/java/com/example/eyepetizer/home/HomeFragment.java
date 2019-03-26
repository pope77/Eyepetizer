package com.example.eyepetizer.home;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.eyepetizer.BaseApplication;
import com.example.eyepetizer.R;
import com.example.eyepetizer.base.BaseFragment;
import com.example.eyepetizer.database.Banner;
import com.example.eyepetizer.database.Type;
import com.example.eyepetizer.home.adapter.TypeListAdapter;
import com.example.eyepetizer.utils.ScreenUtil;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * V层
 *
 * @author popeg
 */
public class HomeFragment extends BaseFragment implements HomeView {

    @Inject
    HomePresenter presenter;
    Unbinder unbinder;
    @BindView(R.id.XBanner_home)
    XBanner xBanner;
    @BindView(R.id.textView_hotSort)
    TextView textViewHotSort;
    @BindView(R.id.textView_welcome)
    TextView textViewWelcome;
    @BindView(R.id.recyclerView_hotSort)
    RecyclerView recyclerViewHotSort;
    @BindView(R.id.scrollView_home)
    ScrollView scrollViewHome;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        ((BaseApplication) getActivity().getApplication()).createHomeComponent().inject(this);
        presenter.bindView(this);
        presenter.getBannerData();
        presenter.getTypeData();
        return view;
    }


    @Override
    public void loadBannerData(List<Banner> banners) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                ScreenUtil.getScreenWidth(getActivity()) / 2);
        xBanner.setLayoutParams(layoutParams);
        xBanner.setPageTransformer(Transformer.Default);
        xBanner.setData(banners,null);
        xBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                tst("点击了第" + position+1 + "个话题", false);
            }
        });
        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(((Banner)model).getUrl()).into((ImageView) view);
            }
        });
    }

    @Override
    public void loadTypeList(List<Type> typeList) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerViewHotSort.setLayoutManager(layoutManager);
        List<Type> types = new ArrayList<>();
        if (typeList.size() > 16) {
            for (int i = 0; i < 16; i++) {
                types.add(typeList.get(i));
            }
        }
        TypeListAdapter adapter= new TypeListAdapter(types,getActivity());
        recyclerViewHotSort.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.destroy();
    }
}
