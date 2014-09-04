package com.codenvy.employee.client.dialogbox;

import com.codenvy.employee.client.mvp.View;
import com.google.inject.ImplementedBy;

/**
 * Created by Andrienko Alexander  on 22.08.14.
 */
@ImplementedBy(EditUserDialogBoxViewImpl.class)
public interface EditUserDialogBoxView extends View<EditUserDialogBoxView.ActionDelegate> {

    public interface ActionDelegate {

        void onOkButtonClicked();

        void onCancelButtonClicked();
    }

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
