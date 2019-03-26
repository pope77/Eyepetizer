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

    /**
     * 获取Banner数据
     */
    void getBannerData();

    /**
     * 获取分类列表数据
     */
    void getTypeData();

    /**
     * 销毁
     */
    void destroy();
}
