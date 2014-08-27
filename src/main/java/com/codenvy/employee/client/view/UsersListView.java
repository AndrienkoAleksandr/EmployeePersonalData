package com.codenvy.employee.client.view;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.google.gwt.user.client.ui.IsWidget;

import java.util.List;

/**
 * Created by Andrienko Alexander  on 21.08.14.
 */
public interface UsersListView extends IsWidget {
    void setUsersListPresenter(UsersListPresenter usersListPresenter);

    void setUsers(List<User> users);
}
