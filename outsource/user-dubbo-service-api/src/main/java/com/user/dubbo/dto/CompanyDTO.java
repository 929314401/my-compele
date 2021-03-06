package com.user.dubbo.dto;

import java.io.Serializable;
import java.util.Date;

public class CompanyDTO  extends User  {
    private String name;

    private String message;

    private Date registertime;

    private String address;

    private String tex;

    private String filed;

    private Integer number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTex() {
        return tex;
    }

    public void setTex(String tex) {
        this.tex = tex == null ? null : tex.trim();
    }

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed == null ? null : filed.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", registertime=" + registertime +
                ", address='" + address + '\'' +
                ", tex='" + tex + '\'' +
                ", filed='" + filed + '\'' +
                ", number=" + number +
                '}';
    }
}
