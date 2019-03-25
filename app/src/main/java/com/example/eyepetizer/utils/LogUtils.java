package com.example.eyepetizer.utils;

import android.util.Log;

/**
 * 日志生成工具类
 *
 * @author popeg
 */
public class LogUtils {

    /**
     * 生成错误信息日志
     * @param errorCode 错误码
     * @param errorMsg 错误信息
     */
    public static void logError(int errorCode, String errorMsg) {
        Log.i("error" + errorCode, errorMsg);
    }

    /**
     * 生成错误信息日志
     * @param errorCode 错误码
     * @param errorMsg 错误信息
     * @param t 抛出异常
     */
    public static void logError(int errorCode, String errorMsg, Throwable t) {
        Log.i("error" + errorCode, errorMsg, t);
    }

}
