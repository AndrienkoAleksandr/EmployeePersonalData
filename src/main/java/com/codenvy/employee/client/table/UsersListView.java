package com.codenvy.employee.client.table;

import com.codenvy.employee.client.View;
import com.codenvy.employee.client.entity.User;

import java.util.List;

/**
 * Created by Andrienko Alexander  on 21.08.14.
 */
public interface UsersListView extends View<UsersListView.ActionDelegate> {

    public interface ActionDelegate {

        void onDeleteButtonClicked();

        void onEditButtonClicked();

        void onAddButtonClicked();

        void onSelectedUser(User user);

        void onInfoLinkClicked();
    }

    void setUsers(List<User> users);
}
