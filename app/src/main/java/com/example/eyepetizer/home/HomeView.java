package com.example.eyepetizer.home;

import com.example.eyepetizer.base.BaseView;
import com.example.eyepetizer.database.Banner;
import com.example.eyepetizer.database.Type;

import java.util.List;

/**
 * V层接口
 * @author popeg
 */
public interface HomeView extends BaseView {

    /**
     * 加载banner数据
     * @param banners banner数据
     */
    void loadBannerData(List<Banner> banners);

    /**
     * 加载分类列表数据
     * @param typeList 分类列表
     */
    void loadTypeList(List<Type> typeList);

}
