package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.view.UsersListView;
import com.codenvy.employee.client.view.impl.enumeration.TypeButtonOfUsersListView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HasWidgets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by logarifm on 21.08.14.
 */
public class UsersListPresenterImpl implements UsersListPresenter {

    private User selectedUser;

    private final UsersListView usersListView;

    private final EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    private final List<User> users;

    public UsersListPresenterImpl(UsersListView usersListView, EditUserDialogBoxPresenter presenter) {
        this.usersListView = usersListView;
        this.editUserDialogBoxPresenter = presenter;
        users = new ArrayList<>();
        users.addAll(getLisUsersFromServer());
    }

    @Override
    public void go(HasWidgets container) {
        usersListView.setUsers(getLisUsersFromServer());

        container.clear();
        container.add(usersListView.asWidget());
    }

    @Override
    public void setSelectedUser(User selectedUser) {
        GWT.log("news" + users.contains(selectedUser));
        this.selectedUser = selectedUser;
    }

    @Override
    public void onDeleteButtonClicked() {
        users.remove(selectedUser);
        selectedUser = null;
        usersListView.setUsers(users);
    }

    @Override
    public void onShowButtonClicked(TypeButtonOfUsersListView typeOfButton)  {
        CallBack callBack = new CallBack();
        if (typeOfButton == TypeButtonOfUsersListView.EDIT && selectedUser != null) {
            editUserDialogBoxPresenter.onShowButtonClicked(selectedUser, callBack);
        }
        if (typeOfButton == TypeButtonOfUsersListView.ADD) {
            editUserDialogBoxPresenter.onShowButtonClicked(null, callBack);
        }
    }

    public class CallBack extends com.codenvy.employee.client.CallBack{
        @Override
        public void onchange(User user) {
            users.add(user);
            usersListView.setUsers(users);
        }

        @Override
        public void onchange() {
            GWT.log("* *" + selectedUser.getFirstName() + " " + selectedUser.getLastName() + " " + selectedUser.getAddress());
            for (User user:users) {
                GWT.log("* *" + user.getFirstName() + " " + user.getLastName() + " " + user.getAddress() + " \n");
            }
            usersListView.setUsers(users);
        }
    }

    //hard code realization
    public List<User> getLisUsersFromServer() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("Bogdan", "Petrenenko", "Kaniv"));
        userList.add(new User("Xolod", "Ivan", "Kaniv"));
        userList.add(new User("Stateman", "Konstantin", "Kiev"));
        userList.add(new User("Fermi", "Gustav", "Kiev"));
        userList.add(new User("Ammundcen", "Den", "Kiev"));
        return userList;
    }
}
