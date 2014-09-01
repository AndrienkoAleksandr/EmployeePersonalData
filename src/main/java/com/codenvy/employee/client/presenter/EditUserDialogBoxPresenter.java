package com.codenvy.employee.client.presenter;

import com.codenvy.employee.client.view.UserChangedCallBack;
import com.codenvy.employee.client.entity.User;

/**
 * Created by Andrienko Alexander on 22.08.14.
 */
public interface EditUserDialogBoxPresenter {
    void onShowDialog(User selectedUser, UserChangedCallBack callBack);

    void onOkButtonClicked();

    void onCancelButtonClicked();
}
