package com.example.eyepetizer.home;

import com.example.eyepetizer.database.Banner;
import com.example.eyepetizer.database.BannerBean;
import com.example.eyepetizer.database.Type;
import com.example.eyepetizer.database.TypeRootBean;
import com.example.eyepetizer.utils.LogUtils;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * P层
 * @author popeg
 */
public class HomePresenterImpl implements HomePresenter {

    private HomeView view;
    private HomeInteractor interactor;
    private Disposable fetchBannerData;

    HomePresenterImpl(HomeInteractor interactor){
        this.interactor = interactor;
    }

    @Override
    public void bindView(HomeView view) {
        this.view = view;
    }

    @Override
    public void getBannerData() {

        fetchBannerData = interactor.fetchBannerData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onBannerDataFetchSuccess,this::onBannerDataFetchFailed);

//        interactor.getBannerData(new HomeInteractor.OnBannerDataCallback() {
//            @Override
//            public void onGetFailed(String msg) {
//                view.tst(msg,false);
//            }
//
//            @Override
//            public void onGetSuccess(List<Banner> banners) {
//                view.loadBannerData(banners);
//            }
//
//        });
    }

    private void onBannerDataFetchFailed(Throwable throwable) {
        LogUtils.logError(112,"error112",throwable);
        view.tst("error112",false);
    }

    private void onBannerDataFetchSuccess(BannerBean bannerBean) {
        view.loadBannerData(bannerBean.getBanner());
    }

    @Override
    public void getTypeData() {
        interactor.getTypeList(new HomeInteractor.OnTypeListCallback() {
            @Override
            public void onGetSuccess(List<Type> typeList) {
                view.loadTypeList(typeList);
            }

            @Override
            public void onGetFailed(String msg) {
                view.tst(msg,false);
            }
        });
    }
}
