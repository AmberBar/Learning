package com.amber.data;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.annotation.JSONField;

public class User {

    @Excel(name="First Name", orderNum = "1")
    @JSONField(name = "First Name",ordinal = 0)
    private String firstName;
    @Excel(name="Last Name", orderNum = "0")
    @JSONField(name = "Last Name", ordinal = 1)
    private String lastName;
    @Excel(name="Email Address", orderNum = "2")
    @JSONField(name="Email Address", ordinal = 2)
    private String emailAddress;

    public User() {

    }
    public User(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
