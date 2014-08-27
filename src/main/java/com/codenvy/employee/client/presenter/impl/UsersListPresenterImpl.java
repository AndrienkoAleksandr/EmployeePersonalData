package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.CallBack;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.presenter.UsersListPresenter;
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

    private final List<User> users;

    @SuppressWarnings("deprecation")
    private static final List<User> temp;

    static {
        temp = new ArrayList<>();
        temp.add(new User("Bogdan", "Petrenenko", "Kaniv"));
        temp.add(new User("Xolod", "Ivan", "Kaniv"));
        temp.add(new User("Stateman", "Konstantin", "Kiev"));
        temp.add(new User("Fermi", "Gustav", "Kiev"));
        temp.add(new User("Ammundcen", "Den", "Kiev"));
    }

    public UsersListPresenterImpl(EditUserDialogBoxPresenter presenter, UsersListView usersListView) {
        this.editUserDialogBoxPresenter = presenter;
        this.usersListView = usersListView;
        users = new ArrayList<>(temp);
    }

    @Override
    public void go(HasWidgets container) {
        //set data to userListView's table
        usersListView.setUsers(users);

        container.clear();
        container.add(usersListView.asWidget());
    }

    @Override
    public void onSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    @Override
    public void onDeleteButtonClicked() {
        users.remove(selectedUser);

        selectedUser = null;

        usersListView.setUsers(users);
    }

    @Override
    public void onShowButtonAddClicked() {
        CallBack callBack = new CallBack() {
            @Override
            public void onChanged(User user) {
                users.add(user);
                usersListView.setUsers(users);
            }
        };
        editUserDialogBoxPresenter.onShowDialog(null, callBack);
    }

    @Override
    public void onShowButtonEditClicked() {
        CallBack callBack = new CallBack() {
            @Override
            public void onChanged(User user) {
                selectedUser.setFirstName(user.getFirstName());
                selectedUser.setLastName(user.getLastName());
                selectedUser.setAddress(user.getAddress());

                usersListView.setUsers(users);
            }
        };

        if (selectedUser != null) {
            editUserDialogBoxPresenter.onShowDialog(selectedUser, callBack);
        } else {
            Window.alert("You nothing selected!");
        }
    }
}
