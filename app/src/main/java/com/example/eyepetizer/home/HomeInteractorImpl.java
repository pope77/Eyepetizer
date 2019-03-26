package com.example.eyepetizer.home;

import com.example.eyepetizer.database.BannerBean;
import com.example.eyepetizer.database.TypeRootBean;
import com.example.eyepetizer.network.EyepetizerWebService;

import io.reactivex.Observable;

/**
 * M层
 *
 * @author popeg
 */
public class HomeInteractorImpl implements HomeInteractor {

    private Throwable error;

    private EyepetizerWebService eyepetizerWebService;

    HomeInteractorImpl(EyepetizerWebService eyepetizerWebService){
        this.eyepetizerWebService = eyepetizerWebService;
    }


    @Override
    public Observable<BannerBean> fetchBannerData() {
        return eyepetizerWebService.getBannerInfo();
    }

    @Override
    public Observable<TypeRootBean> fetchTypeData() {
        return eyepetizerWebService.getTypeListInfo();
    }

}
