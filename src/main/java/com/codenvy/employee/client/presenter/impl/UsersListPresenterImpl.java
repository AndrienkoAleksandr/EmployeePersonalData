package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.view.UsersListView;
import com.codenvy.employee.client.view.impl.UsersListViewImpl;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by logarifm on 21.08.14.
 */
public class UsersListPresenterImpl implements UsersListPresenter {

    private User selectedUser;

    private UsersListViewImpl usersListView;

    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    private List<User> users;

    public UsersListPresenterImpl(EditUserDialogBoxPresenter presenter) {
        this.editUserDialogBoxPresenter = presenter;
        users = new ArrayList<User>();
        users.addAll(getLisUsersFromServer());
    }

    @Override
    public void go(HasWidgets container) {
        usersListView = new UsersListViewImpl(this, users);
        container.add(usersListView);
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    @Override
    public void deleteUser() {
        users.remove(selectedUser);
        selectedUser = null;
        usersListView.setUsers(users);
    }

    public void showDialog()  {
        CallBack callBack = new CallBack();
        editUserDialogBoxPresenter.showDialog(selectedUser, callBack);
    }

    public class CallBack {
        public void onchange(User user) {
            users.add(user);
            usersListView.setUsers(users);
        }

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
