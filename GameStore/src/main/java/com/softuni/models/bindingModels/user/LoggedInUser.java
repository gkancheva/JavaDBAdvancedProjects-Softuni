package com.softuni.models.bindingModels.user;

import com.softuni.entities.enums.Role;

/**
 * Created on 1.8.2017 г..
 */
public class LoggedInUser extends BaseUser {
    private long id;
    private Role role;
    private String fullName;

    public LoggedInUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
