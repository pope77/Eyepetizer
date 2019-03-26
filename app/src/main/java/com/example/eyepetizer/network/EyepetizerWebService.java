package com.example.eyepetizer.network;

import com.example.eyepetizer.database.BannerBean;
import com.example.eyepetizer.database.TypeRootBean;
import com.example.eyepetizer.system.Global;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author popeg
 */
public interface EyepetizerWebService {

    /**
     * 获取Banner数据
     * @return BannerInfo
     */
    @GET(Global.API_BANNER)
    Observable<BannerBean> getBannerInfo();

    /**
     * 获取分类列表数据
     * @return TypeListInfo
     */
    @GET(Global.API_TYPE)
    Observable<TypeRootBean> getTypeListInfo();

}
