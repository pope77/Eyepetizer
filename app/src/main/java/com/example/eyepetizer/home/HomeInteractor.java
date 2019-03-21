package com.example.eyepetizer.home;

/**
 * M层接口
 * @author popeg
 */
public interface HomeInteractor {

    interface OnDataCallback{

        void onGetSuccess(String data);

        void onGetFailes(String errorMsg);

    }

    void getData(OnDataCallback onDataCallback);

}
