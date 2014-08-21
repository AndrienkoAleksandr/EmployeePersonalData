package com.codenvy.employee.client.presenter;

import com.codenvy.employee.client.entity.User;

import java.util.List;

/**
 * Created by logarifm on 21.08.14.
 */
public interface UsersListPresenter {
    List<User> getUsers();
    void setSelectedUser(User selectedUser);
    User getSelectedUser();
    void deleteUser();
    void editUser(User userUpdate);
    void addUser(User newUser);
    List<User> addSomeUser();
}
