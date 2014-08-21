package com.codenvy.employee.client;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.ui.DialogBoxWarning;
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

    private User selectedUser;

    public void onModuleLoad() {
        final UsersList usersList = GWT.create(UsersList.class);
        final EditUserDialogBox dialogBox = GWT.create(EditUserDialogBox.class);

        usersList.addListOfUsers(addSomeUser());
        Button editButton = usersList.getEdit();

        editButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                dialogBox.setText("Edit");
                selectedUser = usersList.getSelectedUser();
                if (selectedUser != null){
                    dialogBox.setUserData(selectedUser);
                    dialogBox.center();
                } else {
                    DialogBoxWarning dialogBoxWarning = GWT.create(DialogBoxWarning.class);
                    dialogBoxWarning.center();
                    dialogBoxWarning.getWaringMessage().setText("You don't select any user...");
                }
            }
        });
        Button addButton = usersList.getAdd();
        addButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                dialogBox.setText("Add");
                dialogBox.clearUserData();
                dialogBox.center();
            }
        });
        Button okButton = dialogBox.getOkButton();
        Button cancelButton = dialogBox.getCancelButton();

        okButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
            switch (dialogBox.getText()) {
                case  "Edit":
                    selectedUser.update(dialogBox.getUserData());
                    usersList.updateUserTable();
                    dialogBox.hide();
                    break;
                case "Add":
                    User newUser = dialogBox.getUserData();
                    usersList.addUser(newUser);
            }
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
