package com.example.eyepetizer.network;

import com.example.eyepetizer.database.BannerBean;
import com.example.eyepetizer.database.TypeRootBean;
import com.example.eyepetizer.system.Global;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author popeg
 */
public interface EyepetizerApiService {

    /**
     * 获取Banner数据
     * @return BannerInfo
     */
    @GET(Global.API_BANNER)
    Call<BannerBean> getBannerInfo();

    /**
     * 获取分类列表数据
     * @return TypeListInfo
     */
    @GET(Global.API_TYPE)
    Call<TypeRootBean> getTypeListInfo();

}
