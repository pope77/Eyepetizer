package com.example.eyepetizer.database;

/**
 * @author popeg
 */
public class TabList {

    /**
     * id
     */
    private int id;
    /**
     * 名称
     */
    private String name;
    /**
     * api链接
     */
    private String apiUrl;
    private int tabType;
    private int nameType;
    private String adTrack;
    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setApiUrl(String apiUrl) {
         this.apiUrl = apiUrl;
     }
     public String getApiUrl() {
         return apiUrl;
     }

    public void setTabType(int tabType) {
         this.tabType = tabType;
     }
     public int getTabType() {
         return tabType;
     }

    public void setNameType(int nameType) {
         this.nameType = nameType;
     }
     public int getNameType() {
         return nameType;
     }

    public void setAdTrack(String adTrack) {
         this.adTrack = adTrack;
     }
     public String getAdTrack() {
         return adTrack;
     }

}