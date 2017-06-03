package com.webproject.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Shaurav on 4/27/2017.
 */

@Entity
@Table(name = "users")
public class User {

    private String username;

    @Id
    private int user_id;
    private String password;
    private boolean enable = true;
    private String authority;

    public User(String username, int user_id, String password, boolean enable, String authority) {
        this.username = username;
        this.user_id = user_id;
        this.password = password;
        this.enable = enable;
        this.authority = authority;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", user_id=" + user_id +
                ", password='" + password + '\'' +
                ", enable=" + enable +
                ", authority='" + authority + '\'' +
                '}';
    }
}
