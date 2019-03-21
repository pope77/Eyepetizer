package com.example.eyepetizer.home;

/**
 * P层接口
 * @author popeg
 */
public interface HomePresenter {

    /**
     * 绑定View层
     * @param view 被绑定视图层视图
     */
    void bindView(HomeView view);

    void getData();

}
