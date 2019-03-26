package com.example.eyepetizer.home;

import com.example.eyepetizer.database.Banner;
import com.example.eyepetizer.database.BannerBean;
import com.example.eyepetizer.database.Type;
import com.example.eyepetizer.database.TypeRootBean;
import com.example.eyepetizer.utils.LogUtils;
import com.example.eyepetizer.utils.RxUtils;

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
    private Disposable fetchTypeData;

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

    }

    @Override
    public void getTypeData() {

        fetchTypeData = interactor.fetchTypeData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onTypeDataFetchSuccess,this::onTypeDataFetchFailed);

    }

    /**
     * 分类列表数据获取失败执行方法
     * @param throwable 异常信息
     */
    private void onTypeDataFetchFailed(Throwable throwable) {
        LogUtils.logError(113,"error113",throwable);
        view.tst("error113",false);
    }

    /**
     * 获取分类列表信息成功执行方法
     * @param typeRootBean 分类列表数据
     */
    private void onTypeDataFetchSuccess(TypeRootBean typeRootBean) {
        view.loadTypeList(typeRootBean.getType());
    }

    /**
     * 获取Banner数据失败时执行方法
     * @param throwable 异常信息
     */
    private void onBannerDataFetchFailed(Throwable throwable) {
        LogUtils.logError(112,"error112",throwable);
        view.tst("error112",false);
    }

    /**
     * 获取Banner数据成功时执行方法
     * @param bannerBean Banner数据
     */
    private void onBannerDataFetchSuccess(BannerBean bannerBean) {
        view.loadBannerData(bannerBean.getBanner());
    }

    @Override
    public void destroy() {
        view = null;
        RxUtils.unsubscribe(fetchBannerData,fetchTypeData);
    }

}
