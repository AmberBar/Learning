package com.amber.data.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
public class UserVO {
    @Excel(name="Last Name", orderNum = "0")
    private String lastName;
    @Excel(name="First Name", orderNum = "1")
    private String firstName;
    @Excel(name="Email Address", orderNum = "2")
    private String emailAddress;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
