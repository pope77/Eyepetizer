package com.example.eyepetizer.home;

/**
 * M层
 * @author popeg
 */
public class HomeInteractorImpl implements HomeInteractor {
    @Override
    public void getData(OnDataCallback onDataCallback) {
        onDataCallback.onGetSuccess("成功");
    }
}
