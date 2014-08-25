package com.codenvy.employee.client.view.impl;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.view.UsersListView;
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

import java.util.List;

/**
 * Created by logarifm on 19.08.14.
 */
public class UsersListViewImpl extends Composite implements UsersListView {

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

    @Override
    public void setUsers(List<User> users) {
        if (usersTable.getColumnCount() == 0) {
            drawUserTable(users);
        }
        usersTable.setRowData(users);
    }

    private UsersListPresenter usersListPresenter;

    private static UsersListUiBinder ourUiBinder = GWT.create(UsersListUiBinder.class);

    public UsersListViewImpl(UsersListPresenter usersListPresenter) {
        initWidget(ourUiBinder.createAndBindUi(this));

        this.usersListPresenter = usersListPresenter;

        addHandlerToButtonAdd();
        addHandlerToButtonDelete();
        addHandlerToButtonEdit();
    }

    public void drawUserTable(final List<User> users) {
        //create column
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

        //put column to table
        usersTable.addColumn(firstName, "Name");
        usersTable.addColumn(lastName, "Surname");
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

    private void addHandlerToButtonDelete() {

        delete.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                usersListPresenter.deleteUser();
            }
        });

    }

    private void addHandlerToButtonAdd() {

        add.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                usersListPresenter.showDialog(null);
            }
        });

    }

    private void addHandlerToButtonEdit() {

        edit.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                if (usersListPresenter.getSelectedUser() != null) {
                    usersListPresenter.showDialog(usersListPresenter.getSelectedUser());
                }
            }
        });
    }
}