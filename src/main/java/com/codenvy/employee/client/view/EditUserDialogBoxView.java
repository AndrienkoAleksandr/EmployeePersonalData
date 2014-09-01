package com.codenvy.employee.client.view;

import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by Andrienko Alexander  on 22.08.14.
 */
public interface EditUserDialogBoxView extends IsWidget {
    void setPresenter(EditUserDialogBoxPresenter editUserDialogBoxPresenter);

    void setText(String title);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setAddress(String address);

    String getFirstName();

    String getLastName();

    String getAddress();

    void showDialog();

    void hideDialog();
}
