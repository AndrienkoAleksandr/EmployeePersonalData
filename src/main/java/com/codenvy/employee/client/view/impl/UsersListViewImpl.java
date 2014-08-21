package com.codenvy.employee.client.view.impl;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.presenter.impl.UsersListPresenterImpl;
import com.codenvy.employee.client.ui.DialogBoxWarning;
import com.codenvy.employee.client.ui.EditUserDialogBox;
import com.codenvy.employee.client.view.UserListView;
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

/**
 * Created by logarifm on 19.08.14.
 */
public class UsersListViewImpl extends Composite implements UserListView {

    interface UsersListUiBinder extends UiBinder<Widget, UsersListViewImpl> {
    }

    @UiField
    CellTable<User> usersTable;

    @UiField
    Button delete;

    @UiField
    Button edit;

    @UiField
    Button add;

    private UsersListPresenter usersListPresenter;

    private final EditUserDialogBox dialogBox = GWT.create(EditUserDialogBox.class);

    private static UsersListUiBinder ourUiBinder = GWT.create(UsersListUiBinder.class);

    //constructor
    public UsersListViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
        usersTable.setSize("50%", "50%");
        usersListPresenter = new UsersListPresenterImpl();
        drawUserTable();
        initUserDialogBox();
        initButtonAdd();
        initButtonDelete();
        initButtonEdit();
    }

    public void updateUserTable() {
        usersTable.setRowCount(usersListPresenter.getUsers().size());
        usersTable.setRowData(usersListPresenter.getUsers());
    }

    public void drawUserTable() {
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

        //add handler for table
        final SingleSelectionModel<User> mySelectionModel = new SingleSelectionModel<User>();
        usersTable.setSelectionModel(mySelectionModel);
        mySelectionModel.addSelectionChangeHandler(
                new SelectionChangeEvent.Handler() {
                    public void onSelectionChange(SelectionChangeEvent event) {
                        usersListPresenter.setSelectedUser(mySelectionModel.getSelectedObject());
                    }
                }
        );
    }

    private void initUserDialogBox() {
        dialogBox.getOkButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                switch (dialogBox.getText()) {
                    case "Edit":
                        usersListPresenter.editUser(dialogBox.getUserData());
                        updateUserTable();
                        break;
                    case "Add":
                        User newUser = dialogBox.getUserData();
                        usersListPresenter.addUser(newUser);
                        updateUserTable();
                }
                dialogBox.hide();
            }
        });
        dialogBox.getCancelButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                dialogBox.hide();
            }
        });
    }

    public void initButtonAdd() {
        add.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                dialogBox.setText("Add");
                dialogBox.clearUserData();
                dialogBox.center();
            }
        });
    }

    public void initButtonDelete() {
        delete.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                usersListPresenter.deleteUser();
                updateUserTable();
            }
        });
    }

    public void initButtonEdit() {
        edit.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                dialogBox.setText("Edit");
                User selectedUser = usersListPresenter.getSelectedUser();
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
    }
}