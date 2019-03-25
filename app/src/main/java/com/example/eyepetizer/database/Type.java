package com.example.eyepetizer.database;


/**
 * @author popeg
 */
public class Type {

    private int id;
    private String name;
    private String description;
    private String bgPicture;
    private String headerImage;
    private int defaultAuthorId;
    private int tagId;
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

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setBgPicture(String bgPicture) {
         this.bgPicture = bgPicture;
     }
     public String getBgPicture() {
         return bgPicture;
     }

    public void setHeaderImage(String headerImage) {
         this.headerImage = headerImage;
     }
     public String getHeaderImage() {
         return headerImage;
     }

    public void setDefaultAuthorId(int defaultAuthorId) {
         this.defaultAuthorId = defaultAuthorId;
     }
     public int getDefaultAuthorId() {
         return defaultAuthorId;
     }

    public void setTagId(int tagId) {
         this.tagId = tagId;
     }
     public int getTagId() {
         return tagId;
     }

}