package com.codenvy.employee.client.view;

import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.google.gwt.user.client.ui.DialogBox;

/**
 * Created by Andrienko Alexander  on 22.08.14.
 */
public interface EditUserDialogBoxView {
    void setEditUserDialogBoxPresenter(EditUserDialogBoxPresenter editUserDialogBoxPresenter);

    void setText(String title);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setAddress(String address);

    String getFirstName();

    String getLastName();

    String getAddress();

    //show and move to center dialog
    void center();

    void hide();

}
