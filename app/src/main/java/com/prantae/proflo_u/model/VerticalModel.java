package com.prantae.proflo_u.model;

public class VerticalModel {
    Integer imageUrl;
    String name,desc;

    public VerticalModel(String name, int imageUrl, String desc) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


