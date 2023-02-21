package com.example.wallpaperapp;

public class WallPaperModel {
    private String  image, id;

    public WallPaperModel(String image, String id) {
        this.image = image;
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
