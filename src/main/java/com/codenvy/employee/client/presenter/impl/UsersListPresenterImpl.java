package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.view.UsersListView;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by logarifm on 21.08.14.
 */
public class UsersListPresenterImpl implements UsersListPresenter {

    private User selectedUser;

    private UsersListView usersListView;

    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    private List<User> users;

    public UsersListPresenterImpl(EditUserDialogBoxPresenter presenter) {
        this.editUserDialogBoxPresenter = presenter;
        users = new LinkedList<User>();
        users.addAll(getLisUsersFromServer());
    }

    @Override
    public void go(HasWidgets container, UsersListView usersListView) {
        this.usersListView = usersListView;
        usersListView.setUsers(getLisUsersFromServer());
        container.add((Widget)usersListView);
    }

    @Override
    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    @Override
    public User getSelectedUser() {
        return selectedUser;
    }

    @Override
    public void deleteUser() {
        users.remove(selectedUser);
        selectedUser = null;
        usersListView.setUsers(users);
    }

    @Override
    public void showDialog(User userForEdit)  {
        CallBack callBack = new CallBack();
        editUserDialogBoxPresenter.showDialog(users.get(users.indexOf(userForEdit)), callBack);
    }

    public class CallBack extends com.codenvy.employee.client.CallBack{
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
