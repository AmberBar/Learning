package com.amber.data;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class User {
    @Excel(name="Last Name", orderNum = "0")
    private String lastName;
    @Excel(name="First Name", orderNum = "1")
    private String firstName;
    @Excel(name="Email Address", orderNum = "2")
    private String emailAddress;
    @Excel(name="CMS Role", orderNum = "3")
    private String cmsRole;
    @Excel(name="Call Letters", orderNum = "4")
    private String cellLetters;
    @Excel(name="Author (Yes/No)", orderNum = "5")
    private String author;

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

    public String getCmsRole() {
        return cmsRole;
    }

    public void setCmsRole(String cmsRole) {
        this.cmsRole = cmsRole;
    }

    public String getCellLetters() {
        return cellLetters;
    }

    public void setCellLetters(String cellLetters) {
        this.cellLetters = cellLetters;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", cmsRole='" + cmsRole + '\'' +
                ", cellLetters='" + cellLetters + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
