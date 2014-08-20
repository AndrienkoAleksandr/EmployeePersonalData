package com.codenvy.employee.client;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.ui.EditUserDialogBox;
import com.codenvy.employee.client.ui.UsersList;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataModule implements EntryPoint {

    public void onModuleLoad() {
        final UsersList usersList = GWT.create(UsersList.class);
        final EditUserDialogBox dialogBox = GWT.create(EditUserDialogBox.class);

        usersList.addListOfUsers(addSomeUser());
        Button editButton = usersList.getEdit();

        editButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                dialogBox.setText("Edit");
                User selectedUser = usersList.getSelectedUser();
                dialogBox.setUserData(selectedUser);
                dialogBox.center();
            }
        });
        Button addButton = usersList.getAdd();
        addButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                dialogBox.setText("Add");
                dialogBox.clearUserData();
                User newUser = dialogBox.getUserData();
                usersList.addUser(newUser);
                dialogBox.center();
            }
        });
        Button okButton = dialogBox.getOkButton();
        Button cancelButton = dialogBox.getCancelButton();

        okButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                User changedUser = dialogBox.getUserData();
                usersList.editUser(changedUser);
                dialogBox.hide();
            }
        });
        cancelButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                dialogBox.hide();
            }
        });
        RootLayoutPanel.get().add(usersList);
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
