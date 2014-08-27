package com.codenvy.employee.client.presenter;

import com.codenvy.employee.client.entity.User;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Created by Andrienko Alexander  on 21.08.14.
 */
public interface UsersListPresenter {
    void go(HasWidgets container);

    void onDeleteButtonClicked();

    void onShowButtonEditClicked();

    void onShowButtonAddClicked();

    void onSelectedUser(User user);
}
