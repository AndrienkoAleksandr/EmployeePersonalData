package com.codenvy.employee.client.view;

import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;

/**
 * Created by Andrienko Alexander  on 22.08.14.
 */
public interface EditUserDialogBox {
    void setEditUserDialogBoxPresenter(EditUserDialogBoxPresenter editUserDialogBoxPresenter);

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
