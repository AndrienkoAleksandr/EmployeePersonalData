package com.codenvy.employee.client.dialogbox;

import com.codenvy.employee.client.UserChangedCallBack;
import com.codenvy.employee.client.View;
import com.codenvy.employee.client.entity.User;

/**
 * Created by Andrienko Alexander  on 22.08.14.
 */
public interface EditUserDialogBoxView extends View<EditUserDialogBoxView.ActionDelegate> {

    public interface ActionDelegate {

        void onShowDialog(User selectedUser, UserChangedCallBack callBack);

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
