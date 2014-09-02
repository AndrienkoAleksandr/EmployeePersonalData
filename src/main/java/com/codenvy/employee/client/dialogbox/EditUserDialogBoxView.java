package com.codenvy.employee.client.dialogbox;

import com.codenvy.employee.client.table.UserChangedCallBack;
import com.codenvy.employee.client.mvp.View;
import com.codenvy.employee.client.entity.User;

/**
 * Created by Andrienko Alexander  on 22.08.14.
 */
public interface EditUserDialogBoxView extends View<EditUserDialogBoxView.ActionDelegate> {

    public interface ActionDelegate {

        void showDialog(User selectedUser, UserChangedCallBack callBack);

        void okButtonClicked();

        void cancelButtonClicked();
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