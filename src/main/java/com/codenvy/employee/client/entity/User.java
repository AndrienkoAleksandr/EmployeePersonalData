package com.codenvy.employee.client.entity;

import com.google.inject.Inject;

/**
 * Created by Andrienko Alexander on 19.08.14.
 */
public class User {
    private String firstName;
    private String lastName;
    private String address;
    private Note note;

    @Inject
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

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
