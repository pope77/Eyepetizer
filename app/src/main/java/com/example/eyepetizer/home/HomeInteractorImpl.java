package com.example.eyepetizer.home;

import com.example.eyepetizer.database.Banner;
import com.example.eyepetizer.database.BannerBean;
import com.example.eyepetizer.database.TypeRootBean;
import com.example.eyepetizer.network.EyepetizerWebService;
import com.example.eyepetizer.system.Global;
import com.example.eyepetizer.utils.LogUtils;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * M层
 *
 * @author popeg
 */
public class HomeInteractorImpl implements HomeInteractor {

    private Throwable error;
//    private OnBannerDataCallback onBannerDataCallback;
    private OnTypeListCallback onTypeListCallback;

    private EyepetizerWebService eyepetizerWebService;

    HomeInteractorImpl(EyepetizerWebService eyepetizerWebService){
        this.eyepetizerWebService = eyepetizerWebService;
    }

//    @Override
//    public void getBannerData(OnBannerDataCallback onBannerDataCallback) {
//        this.onBannerDataCallback = onBannerDataCallback;
//        getBannerBean();
//    }

    @Override
    public void getTypeList(OnTypeListCallback onTypeListCallback) {
        this.onTypeListCallback = onTypeListCallback;
        getTypeListInfo();
    }

    @Override
    public Observable<BannerBean> fetchBannerData() {
        return eyepetizerWebService.getBannerInfo();
    }

    /**
     * 获取分类列表逻辑方法
     */
    private void getTypeListInfo() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Global.API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EyepetizerWebService service = retrofit.create(EyepetizerWebService.class);
        Call<TypeRootBean> call = service.getTypeListInfo();
        call.enqueue(new Callback<TypeRootBean>() {
            @Override
            public void onResponse(Call<TypeRootBean> call, Response<TypeRootBean> response) {
                if (onTypeListCallback != null) {
                    onTypeListCallback.onGetSuccess(response.body().getType());
                    onTypeListCallback = null;
                }
            }

            @Override
            public void onFailure(Call<TypeRootBean> call, Throwable t) {
                LogUtils.logError(111, "retrofit执行onFailure", t);
                if (onTypeListCallback != null) {
                    onTypeListCallback.onGetFailed("error111");
                    onTypeListCallback = null;
                }
            }
        });
    }

    /**
     * 获取首页根数据方法
     */
//    private void getBannerBean() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Global.API_BASE)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        EyepetizerWebService service = retrofit.create(EyepetizerWebService.class);
//        Call<BannerBean> call = service.getBannerInfo();
//        call.enqueue(new Callback<BannerBean>() {
//            @Override
//            public void onResponse(Call<BannerBean> call, Response<BannerBean> response) {
//                List<Banner> banners = response.body().getBanner();
//                error = null;
//                if (onBannerDataCallback != null) {
//                    onBannerDataCallback.onGetSuccess(banners);
//                    onBannerDataCallback = null;
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BannerBean> call, Throwable t) {
//                LogUtils.logError(110, "retrofit执行onFailure", t);
//                if (onBannerDataCallback != null) {
//                    onBannerDataCallback.onGetFailed("error110");
//                    onBannerDataCallback = null;
//                }
//            }
//        });
//    }

}
