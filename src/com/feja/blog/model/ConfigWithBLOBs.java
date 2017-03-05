package com.feja.blog.model;

public class ConfigWithBLOBs extends Config {
    private byte[] blogDescribe;

    private byte[] profile;

    public byte[] getBlogDescribe() {
        return blogDescribe;
    }

    public void setBlogDescribe(byte[] blogDescribe) {
        this.blogDescribe = blogDescribe;
    }

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }
}