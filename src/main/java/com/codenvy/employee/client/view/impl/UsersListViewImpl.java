package com.codenvy.employee.client.view.impl;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.view.UsersListView;
import com.codenvy.employee.client.view.impl.enumeration.TypeButtonOfUsersListView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.*;

import java.util.List;

/**
 * Created by logarifm on 19.08.14.
 */
public class UsersListViewImpl extends Composite implements UsersListView {

    interface UsersListUiBinder extends UiBinder<Widget, UsersListViewImpl> {
    }

    private static UsersListUiBinder ourUiBinder = GWT.create(UsersListUiBinder.class);

    @UiField
    CellTable<User> usersTable;

    @UiField
    Button delete;

    @UiField
    Button edit;

    @UiField
    Button add;

    @UiField
    SimplePager simplePager;

    private AsyncDataProvider<User> provider = null;

    private UsersListPresenter usersListPresenter;

    public UsersListViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public void setUsers(final List<User> users) {

        if (usersTable.getColumnCount() == 0) {
            drawUserTable();
             provider = new AsyncDataProvider<User>() {
                @Override
                protected void onRangeChanged(HasData<User> display) {
                    GWT.log("i'm work!");
                    provider.updateRowCount(users.size(), true);
                    updateRowData(0, users);
                }
            };
            provider.addDataDisplay(usersTable);
            simplePager.setDisplay(usersTable);
        }
        provider.updateRowCount(users.size(), true);
        usersTable.setRowData(users);
    }

    @Override
    public void setUsersListPresenter(UsersListPresenter usersListPresenter) {
        this.usersListPresenter = usersListPresenter;
    }

    private void drawUserTable() {
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



//        final NoSelectionModel<User> selectionModel = new NoSelectionModel<User>();
//        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//
//            @Override
//            public void onSelectionChange(SelectionChangeEvent event) {
//                usersListPresenter.setSelectedUser(selectionModel.getLastSelectedObject());
//                GWT.log("message" + selectionModel.getLastSelectedObject().getFirstName());
//            }
//        });
//        usersTable.setSelectionModel(selectionModel);

//        final NoSelectionModel<User> selectionModel = new NoSelectionModel<User>();
//        SelectionChangeEvent.Handler ff = new SelectionChangeEvent.Handler() {
//
//            @Override
//            public void onSelectionChange(SelectionChangeEvent event) {
//                GWT.log("source" + event.getSource());
//                usersListPresenter.setSelectedUser(selectionModel.getLastSelectedObject());
//            }
//        };
//        selectionModel.addSelectionChangeHandler(ff);
//        usersTable.setSelectionModel(selectionModel);
//        ff.onSelectionChange(null);
    }

    @UiHandler("delete")
    void onDeleteButtonClicked(ClickEvent clickEvent) {
                usersListPresenter.onDeleteButtonClicked();
    }


    @UiHandler("add")
    void onEditButtonClicked(ClickEvent clickEvent) {
                usersListPresenter.onShowButtonClicked(TypeButtonOfUsersListView.ADD);
    }

    @UiHandler("edit")
     void onAddButtonClicked(ClickEvent clickEvent) {
        usersListPresenter.onShowButtonClicked(TypeButtonOfUsersListView.EDIT);
    }

}