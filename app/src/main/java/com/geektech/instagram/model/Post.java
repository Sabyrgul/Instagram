package com.geektech.instagram.model;

public class Post {
    private String profile;
    private String name;
    private String image;
    private Integer likeNumber;

    public Post() {
    }

    public Post(String profile, String name, String image) {
        this.profile = profile;
        this.name = name;
        this.image = image;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
