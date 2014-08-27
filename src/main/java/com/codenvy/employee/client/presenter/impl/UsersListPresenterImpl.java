package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.view.UserListViewTypeOfEvent;
import com.codenvy.employee.client.view.UsersListView;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrienko Alexander  on 21.08.14.
 */
public class UsersListPresenterImpl implements UsersListPresenter {

    private User selectedUser;

    private final UsersListView usersListView;

    private final EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User("Bogdan", "Petrenenko", "Kaniv"));
        users.add(new User("Xolod", "Ivan", "Kaniv"));
        users.add(new User("Stateman", "Konstantin", "Kiev"));
        users.add(new User("Fermi", "Gustav", "Kiev"));
        users.add(new User("Ammundcen", "Den", "Kiev"));
    }

    public UsersListPresenterImpl(EditUserDialogBoxPresenter presenter, UsersListView usersListView) {
        this.editUserDialogBoxPresenter = presenter;
        this.usersListView = usersListView;
    }

    @Override
    public void go(HasWidgets container) {
        //set data to userListView's table
        usersListView.setUsers(users);

        container.clear();
        container.add(usersListView.asWidget());
    }

    @Override
    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    @Override
    public void onDeleteButtonClicked() {
        users.remove(selectedUser);
        selectedUser = null;
        usersListView.setUsers(users);
    }

    @Override
    public void onShowButtonClicked(UserListViewTypeOfEvent userListViewTypeOfEvent) {
        CallBack callBack = new CallBack();
        if (userListViewTypeOfEvent == UserListViewTypeOfEvent.ADD_USER) {
            editUserDialogBoxPresenter.showDialog(null, callBack);
        }
        if (userListViewTypeOfEvent == UserListViewTypeOfEvent.EDIT_USER && selectedUser != null) {
            editUserDialogBoxPresenter.showDialog(selectedUser, callBack);
        }
        if (userListViewTypeOfEvent == UserListViewTypeOfEvent.EDIT_USER && selectedUser == null) {
            Window.alert("You nothing selected!");
        }
    }

    public class CallBack extends com.codenvy.employee.client.CallBack {
        @Override
        public void onchange(User user) {
            users.add(user);
            usersListView.setUsers(users);
        }

        @Override
        public void onchange() {
            usersListView.setUsers(users);
        }
    }
}
