package com.example.eyepetizer.home;

import com.example.eyepetizer.base.BaseDataCallback;
import com.example.eyepetizer.database.Banner;
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

//    interface OnBannerDataCallback extends BaseDataCallback {
//
//        /**
//         * 获取成功回调接口
//         * @param data 回调数据
//         */
//        void onGetSuccess(List<Banner> data);
//
//    }
//
//    /**
//     * 获取Banner展示数据
//     * @param onBannerDataCallback 数据回调
//     */
//    void getBannerData(OnBannerDataCallback onBannerDataCallback);

    interface OnTypeListCallback extends BaseDataCallback{

        /**
         * 获取成功回调接口
         * @param typeList 分类列表
         */
        void onGetSuccess(List<Type> typeList);

    }

    /**
     * 获取分类列表数据
     * @param onTypeListCallback 数据回调接口
     */
    void getTypeList(OnTypeListCallback onTypeListCallback);

    Observable<BannerBean> fetchBannerData();

}
