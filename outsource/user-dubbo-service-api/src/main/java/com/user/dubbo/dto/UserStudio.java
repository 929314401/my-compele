package com.user.dubbo.dto;

import java.io.Serializable;
import java.util.Date;

public class UserStudio implements Serializable {
    private Integer userId;

    private String name;

    private String descb;

    private Date registertime;

    private String tex;

    private Integer start;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescb() {
        return descb;
    }

    public void setDescb(String descb) {
        this.descb = descb == null ? null : descb.trim();
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public String getTex() {
        return tex;
    }

    public void setTex(String tex) {
        this.tex = tex == null ? null : tex.trim();
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}