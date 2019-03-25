package com.example.eyepetizer.home;

import com.example.eyepetizer.base.BaseView;
import com.example.eyepetizer.database.Banner;

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

}
