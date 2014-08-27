package com.codenvy.employee.client.view.impl;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.view.UserListViewTypeOfEvent;
import com.codenvy.employee.client.view.UsersListView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import java.util.List;

/**
 * Created by Andrienko Alexander  on 19.08.14.
 */
public class UsersListViewImpl extends Composite implements UsersListView {

    interface UsersListUiBinder extends UiBinder<Widget, UsersListViewImpl> {
    }

    private UsersListPresenter usersListPresenter;

    @UiField
    CellTable<User> usersTable;

    @UiField
    Button delete;

    @UiField
    Button edit;

    @UiField
    Button add;

    public UsersListViewImpl() {
        UsersListUiBinder ourUiBinder = GWT.create(UsersListUiBinder.class);
        initWidget(ourUiBinder.createAndBindUi(this));
        drawUserTable();
    }

    public void setUsersListPresenter(UsersListPresenter usersListPresenter) {
        this.usersListPresenter = usersListPresenter;
    }

    @Override
    public void setUsers(List<User> users) {
        usersTable.setRowData(users);
    }

    public void drawUserTable() {
        TextColumn<User> firstName = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return user.getFirstName();
            }
        };
        usersTable.addColumn(firstName, "Name");

        TextColumn<User> lastName = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return user.getLastName();
            }
        };
        usersTable.addColumn(lastName, "Surname");

        TextColumn<User> address = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return user.getAddress();
            }
        };
        usersTable.addColumn(address, "Address");

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

    @UiHandler("delete")
    void onDeleteButtonClicked(ClickEvent clickEvent) {
        usersListPresenter.onDeleteButtonClicked();
    }

    @UiHandler("add")
    void onAddButtonClicked(ClickEvent clickEvent) {
        usersListPresenter.onShowButtonClicked(UserListViewTypeOfEvent.ADD_USER);
    }


    @UiHandler("edit")
    void onEditButtonClicked(ClickEvent clickEvent) {
        usersListPresenter.onShowButtonClicked(UserListViewTypeOfEvent.EDIT_USER);
    }
}