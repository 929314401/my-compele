package com.studio.work.dubbo.dto;

import java.util.Date;

public class WorkStudio {
    private Integer id;

    private String workName;

    private String descb;

    private Date start;

    private String ip;

    private String address;

    private String toux;

    private Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName == null ? null : workName.trim();
    }

    public String getDescb() {
        return descb;
    }

    public void setDescb(String descb) {
        this.descb = descb == null ? null : descb.trim();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getToux() {
        return toux;
    }

    public void setToux(String toux) {
        this.toux = toux == null ? null : toux.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}