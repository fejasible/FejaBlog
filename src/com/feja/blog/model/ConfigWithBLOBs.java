package com.feja.blog.model;

import com.feja.blog.util.JsonUtil;

public class ConfigWithBLOBs extends Config {
    private String blogDescribe;

    private String profile;

    public String getBlogDescribe() {
        return blogDescribe;
    }

    public void setBlogDescribe(String blogDescribe) {
        this.blogDescribe = blogDescribe == null ? null : blogDescribe.trim();
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }

	@Override
	public String toString() {
		return JsonUtil.writeValueAsString(this);
	}
}