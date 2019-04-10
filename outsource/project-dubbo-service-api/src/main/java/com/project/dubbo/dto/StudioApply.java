package com.project.dubbo.dto;

import java.io.Serializable;
import java.util.Date;

public class StudioApply implements Serializable {
    private Integer id;

    private String studioname;

    private Integer projectid;

    private Integer studioid;

    private Date applytime;

    private Integer state;

    private Double complete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudioname() {
        return studioname;
    }

    public void setStudioname(String studioname) {
        this.studioname = studioname == null ? null : studioname.trim();
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getStudioid() {
        return studioid;
    }

    public void setStudioid(Integer studioid) {
        this.studioid = studioid;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getComplete() {
        return complete;
    }

    public void setComplete(Double complete) {
        this.complete = complete;
    }
}