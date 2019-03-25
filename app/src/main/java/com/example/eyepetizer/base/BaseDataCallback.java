package com.example.eyepetizer.base;

/**
 * 基础数据回调接口
 * @author popeg
 */
public interface BaseDataCallback {

    /**
     * 获取数据失败回调方法
     * @param msg 错误信息
     */
    void onGetFailed(String msg);

}
