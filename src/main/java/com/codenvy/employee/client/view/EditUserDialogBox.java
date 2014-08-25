package com.codenvy.employee.client.view;

/**
 * Created by logarifm on 22.08.14.
 */
public interface EditUserDialogBox {
    void center();
    void setText(String title);
    String getText();
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setAddress(String address);
    String getFirstName();
    String getLastName();
    String getAddress();
}
