package com.amber.bean;

import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = -7650447022579457766L;
    private Integer id;
    private String code;
    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", address=" + address +
                '}';
    }
}
