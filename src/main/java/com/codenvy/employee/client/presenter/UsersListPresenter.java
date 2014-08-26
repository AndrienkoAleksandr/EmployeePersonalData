package com.codenvy.employee.client.presenter;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.view.UserListViewTypeOfEvent;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Created by logarifm on 21.08.14.
 */
public interface UsersListPresenter {
    void go(HasWidgets container);
    void onDeleteButtonClicked();
    void onShowButtonClicked(UserListViewTypeOfEvent userListViewTypeOfEvent);
    void setSelectedUser(User user);
}
