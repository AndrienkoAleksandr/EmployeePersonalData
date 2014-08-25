package com.codenvy.employee.client.presenter;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.view.UsersListView;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Created by logarifm on 21.08.14.
 */
public interface UsersListPresenter {
    void go(HasWidgets container, UsersListView usersListView);
    void deleteUser();
    void showDialog(User userForEdit);
    User getSelectedUser();
    void setSelectedUser(User user);
}
