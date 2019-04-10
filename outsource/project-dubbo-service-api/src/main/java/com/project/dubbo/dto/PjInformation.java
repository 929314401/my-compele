package com.project.dubbo.dto;

import java.io.Serializable;
import java.util.Date;

public class PjInformation implements Serializable {
    private Integer id;

    private String message;

    private Date starttime;

    private Date stoptime;

    private Double money;

    private Integer bid;

    private Integer companyid;

    private Integer studioid;

    private String cm;

    private String sm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getStoptime() {
        return stoptime;
    }

    public void setStoptime(Date stoptime) {
        this.stoptime = stoptime;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getStudioid() {
        return studioid;
    }

    public void setStudioid(Integer studioid) {
        this.studioid = studioid;
    }

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm == null ? null : cm.trim();
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm == null ? null : sm.trim();
    }
}