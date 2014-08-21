package com.codenvy.employee.client.ui;

import com.codenvy.employee.client.entity.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by logarifm on 19.08.14.
 */
public class UsersList extends Composite {

    interface UsersListUiBinder extends UiBinder<Widget, UsersList> {
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    private User selectedUser;

    @UiField
    CellTable<User> usersTable;

    @UiField
    Button delete;

    @UiField
    Button edit;

    @UiField
    Button add;

    public Button getEdit() {
        return edit;
    }

    public Button getAdd() {
        return add;
    }

    List<User> users = new ArrayList<User>();

    private static UsersListUiBinder ourUiBinder = GWT.create(UsersListUiBinder.class);

    public UsersList() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public void addListOfUsers(List<User> users) {
        this.users.addAll(users);
        usersTable.setSize("50%", "50%");
        drawUserTable();
    }

    public void addUser(User user) {
        users.add(user);
        writeToLog(String.valueOf(users.size()));
        updateUserTable();
    }

    public void updateUserTable() {
        usersTable.setRowCount(users.size());
        usersTable.setRowData(users);
        //todo
        writeToLog(users.size() + " count of row " + usersTable.getRowCount());
    }

    private void drawUserTable() {
        TextColumn<User> firstName = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return user.getFirstName();
            }
        };
        TextColumn<User> lastName = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return user.getLastName();
            }
        };
        TextColumn<User> address = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return user.getAddress();
            }
        };
        usersTable.addColumn(firstName, "Name");
        usersTable.addColumn(lastName, "Surname");
        usersTable.addColumn(address, "Address");
        updateUserTable();

        final SingleSelectionModel<User> mySelectionModel = new SingleSelectionModel<User>();
        usersTable.setSelectionModel(mySelectionModel);
        mySelectionModel.addSelectionChangeHandler(
                new SelectionChangeEvent.Handler() {
                    public void onSelectionChange(SelectionChangeEvent event) {
                        selectedUser = mySelectionModel.getSelectedObject();
                    }
                }
        );

        delete.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                if (users.size() > 0) {
                    users.remove(selectedUser);
                    //todo
                    selectedUser = null;
                }
                updateUserTable();
            }
        });
    }

    //todo delete this method after, it was created for debug
    private void writeToLog(String logMessage) {
        Logger logger = Logger.getLogger("NameOfYourLogger");
        logger.log(Level.SEVERE, logMessage);
    }
}