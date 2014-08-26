package com.codenvy.employee.client.presenter;

import com.codenvy.employee.client.CallBack;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.view.EditUserDialogBox;

/**
 * Created by logarifm on 22.08.14.
 */
public interface EditUserDialogBoxPresenter {
    void onShowButtonClicked(User selectedUser, CallBack callBack);
    void saveUser();
}
