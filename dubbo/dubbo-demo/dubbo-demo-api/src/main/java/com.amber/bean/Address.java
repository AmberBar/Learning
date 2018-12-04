package com.amber.bean;

import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = 6943276838107851374L;
    private Integer id;
    private String address;
    private Integer userId;

    public Address(Integer id, String address, Integer userId) {
        this.id = id;
        this.address = address;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", userId=" + userId +
                '}';
    }
}
