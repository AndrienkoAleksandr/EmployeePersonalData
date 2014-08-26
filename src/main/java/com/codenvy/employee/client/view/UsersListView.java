package com.codenvy.employee.client.view;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.UsersListPresenter;

import java.util.List;

/**
 * Created by logarifm on 21.08.14.
 */
public interface UsersListView {
    void setUsersListPresenter(UsersListPresenter usersListPresenter);
    void setUsers(List<User> users);
}
