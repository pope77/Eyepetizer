package com.example.eyepetizer.home;

import com.example.eyepetizer.base.BaseDataCallback;
import com.example.eyepetizer.database.BannerBean;
import com.example.eyepetizer.database.Type;
import com.example.eyepetizer.database.TypeRootBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * M层接口
 * @author popeg
 */
public interface HomeInteractor {

    Observable<BannerBean> fetchBannerData();

    Observable<TypeRootBean> fetchTypeData();

}
