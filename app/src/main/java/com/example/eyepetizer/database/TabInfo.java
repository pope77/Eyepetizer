package com.example.eyepetizer.database;
import java.util.List;


/**
 * @author popeg
 */
public class TabInfo {

    private List<TabList> tabList;
    private int defaultIdx;
    public void setTabList(List<TabList> tabList) {
         this.tabList = tabList;
     }
     public List<TabList> getTabList() {
         return tabList;
     }

    public void setDefaultIdx(int defaultIdx) {
         this.defaultIdx = defaultIdx;
     }
     public int getDefaultIdx() {
         return defaultIdx;
     }

}