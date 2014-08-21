package com.codenvy.employee.client.entity;

import java.io.Serializable;

/**
 * Created by logarifm on 19.08.14.
 */
public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String address;

    public User() {
    }

    public User(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User update(User userUpdate) {
        firstName = userUpdate.getFirstName();
        lastName = userUpdate.getLastName();
        address = userUpdate.getAddress();
        return this;
    }
}
