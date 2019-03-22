package com.example.eyepetizer.network;

import com.example.eyepetizer.database.JsonRootBean;
import com.example.eyepetizer.system.Global;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author popeg
 */
public interface EyepetizerApiService {

    @GET(Global.API_DISCOVER)
    Call<JsonRootBean> getTabInfo();

}
