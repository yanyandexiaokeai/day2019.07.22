package com.bittech.client.entity;

import lombok.Data;

/*
user表的实体类
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String brief;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String psssword) {
        this.password = psssword;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
