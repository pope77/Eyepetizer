package com.example.eyepetizer.database;


import java.util.List;

/**
 * @author popeg
 */
public class TypeRootBean {

    private List<Type> type;
    public void setType(List<Type> type) {
         this.type = type;
     }
     public List<Type> getType() {
         return type;
     }

}