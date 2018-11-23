package com.amber.data;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
    @JSONField(name = "First Name",ordinal = 0)
    private String firstName;
    @JSONField(name = "Last Name", ordinal = 1)
    private String lastName;
    @JSONField(name="Email Address", ordinal = 2)
    private String emailAddress;

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
