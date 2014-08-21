package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.ui.EditUserDialogBox;
import com.codenvy.employee.client.view.impl.UsersListViewImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by logarifm on 21.08.14.
 */
public class UsersListPresenterImpl implements UsersListPresenter {

    private User selectedUser;

    private List<User> users = new ArrayList<User>();

    public UsersListPresenterImpl() {
        addSomeUser();
        users.addAll(addSomeUser());
    }

    public List<User> getUsers() {
        return users;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void deleteUser() {
        if (users.size() > 0) {
            users.remove(selectedUser);
            //todo
            selectedUser = null;
        }
    }

    public void editUser(User userUpdate) {
            selectedUser.setFirstName(userUpdate.getFirstName());
            selectedUser.setLastName(userUpdate.getLastName());
            selectedUser.setAddress(userUpdate.getAddress());
    }

    public void addUser(User newUser) {
    users.add(newUser);
    }

    public List<User> addSomeUser() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("Bogdan", "Petrenenko", "Kaniv"));
        userList.add(new User("Xolod", "Ivan", "Kaniv"));
        userList.add(new User("Nepuizckrunuci", "Konstantin", "Kiev"));
        userList.add(new User("Fermi", "Gustav", "Kiev"));
        userList.add(new User("Ammundcen", "Den", "Kiev"));
        return userList;
    }
}
