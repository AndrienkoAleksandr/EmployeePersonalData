package com.codenvy.employee.client.entity;

/**
 * Created by logarifm on 11.09.14.
 */
public class Note {

    private String text = "";

    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
