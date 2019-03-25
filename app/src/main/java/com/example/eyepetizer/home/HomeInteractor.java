package com.example.eyepetizer.home;

import com.example.eyepetizer.base.BaseDataCallback;
import com.example.eyepetizer.database.Banner;

import java.util.List;

/**
 * M层接口
 * @author popeg
 */
public interface HomeInteractor {

    interface OnBannerDataCallback extends BaseDataCallback {

        /**
         * 获取Banner数据回调接口
         * @param data 回调数据
         */
        void onGetSuccess(List<Banner> data);

    }

    /**
     * 获取Banner展示数据
     * @param onBannerDataCallback 数据回调
     */
    void getBannerData(OnBannerDataCallback onBannerDataCallback);

}
