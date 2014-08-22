package com.codenvy.employee.client.presenter;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.impl.UsersListPresenterImpl;

/**
 * Created by logarifm on 22.08.14.
 */
public interface EditUserDialogBoxPresenter {
    void showDialog(User selectedUser, UsersListPresenterImpl.CallBack callBack);
}
