package com.example.eyepetizer.base;

import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * fragment基础类
 *
 * @author popeg
 */
public class BaseFragment extends Fragment {

    /**
     * toast显示 可选长短时
     * @param msg toast显示信息
     * @param isShowLongTime 是否显示长时
     */
    public void tst(String msg, boolean isShowLongTime) {
        if (isShowLongTime) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
        }
    }

}
