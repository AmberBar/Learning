package com.amber.data;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class Roles {
    @Excel(name = "Role", orderNum = "0")
    private String role;
    @Excel(name = "Type", orderNum = "1")
    private String type;
    @Excel(name = "Short Description", orderNum = "2")
    private String shortDescription;
    @Excel(name="Long Description", orderNum = "3")
    private String longDescription;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
