package com.geektech.instagram.model;

import android.net.Uri;

public class Post {
    private String name;
    private Uri profile;
    private Uri image;
    private Integer likeNumber;

    public Post() {
    }

    public Post(Uri  profile, String name, Uri  image) {
        this.profile = profile;
        this.name = name;
        this.image = image;
    }

    public Uri getProfile() {
        return profile;
    }


    public String getName() {
        return name;
    }



    public Uri getImage() {
        return image;
    }


}
