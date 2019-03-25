package com.example.eyepetizer.home;

import com.example.eyepetizer.database.Banner;

import java.util.List;

/**
 * P层
 * @author popeg
 */
public class HomePresenterImpl implements HomePresenter {

    private HomeView view;
    private HomeInteractor interactor;

    HomePresenterImpl(HomeInteractor interactor){
        this.interactor = interactor;
    }

    @Override
    public void bindView(HomeView view) {
        this.view = view;
    }

    @Override
    public void getBannerData() {
        interactor.getBannerData(new HomeInteractor.OnBannerDataCallback() {
            @Override
            public void onGetFailed(String msg) {
                view.tst(msg,false);
            }

            @Override
            public void onGetSuccess(List<Banner> banners) {
                view.loadBannerData(banners);
            }

        });
    }
}
