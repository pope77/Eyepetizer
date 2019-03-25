package com.example.eyepetizer.database;
import java.util.List;


/**
 * @author popeg
 */
public class BannerBean {

    private List<Banner> banner;
    public void setBanner(List<Banner> banner) {
         this.banner = banner;
     }
     public List<Banner> getBanner() {
         return banner;
     }

}