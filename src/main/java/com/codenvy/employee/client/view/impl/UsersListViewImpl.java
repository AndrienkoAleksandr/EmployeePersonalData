package com.codenvy.employee.client.view.impl;

import com.codenvy.employee.client.EmployeeDataResource;
import com.codenvy.employee.client.constants.EmployeeDataConstants;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.view.UsersListView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.*;
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

    private final EmployeeDataConstants CONSTANTS = GWT.create(EmployeeDataConstants.class);

    @UiField
    CellTable<User> usersTable;

    @UiField
    Button delete;

    @UiField
    Button edit;

    @UiField
    Button add;

    @UiField
    Label labelListEmployee;

    @UiField
    Hyperlink linkInfo;

    @UiField
    Image imageBuildings;

    public UsersListViewImpl() {
        UsersListUiBinder ourUiBinder = GWT.create(UsersListUiBinder.class);

        initWidget(ourUiBinder.createAndBindUi(this));

        drawUserTable();
        writeTextInHeader();
        addStyleToView();
    }

    private void writeTextInHeader() {
        GWT.log(EmployeeDataResource.INSTANCE.textEmployeeTable().getText());
        labelListEmployee.setText(EmployeeDataResource.INSTANCE.textEmployeeTable().getText());
    }

    private void addStyleToView() {
        usersTable.setStyleName(EmployeeDataResource.INSTANCE.employDataStyle().cellStyle());
        linkInfo.addStyleName(EmployeeDataResource.INSTANCE.employDataStyle().link());
        imageBuildings.addStyleName(EmployeeDataResource.INSTANCE.employDataStyle().imgBuildings());
    }

    public void setPresenter(UsersListPresenter usersListPresenter) {
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
        usersTable.addColumn(firstName, CONSTANTS.firstTableColumnText());

        TextColumn<User> lastName = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return user.getLastName();
            }
        };
        usersTable.addColumn(lastName, CONSTANTS.secondTableColumnText());

        TextColumn<User> address = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return user.getAddress();
            }
        };
        usersTable.addColumn(address, CONSTANTS.thirdTableColumnText());

        //add style to table
        firstName.setCellStyleNames(EmployeeDataResource.INSTANCE.employDataStyle().cellStyle());
        lastName.setCellStyleNames(EmployeeDataResource.INSTANCE.employDataStyle().cellStyle());
        address.setCellStyleNames(EmployeeDataResource.INSTANCE.employDataStyle().cellStyle());

        //add handler for table
        final SingleSelectionModel<User> mySelectionModel = new SingleSelectionModel<User>();
        usersTable.setSelectionModel(mySelectionModel);
        mySelectionModel.addSelectionChangeHandler(

                new SelectionChangeEvent.Handler() {
                    public void onSelectionChange(SelectionChangeEvent event) {
                        usersListPresenter.onSelectedUser(mySelectionModel.getSelectedObject());
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
        usersListPresenter.onAddButtonClicked();
    }


    @UiHandler("edit")
    void onEditButtonClicked(ClickEvent clickEvent) {
        usersListPresenter.onEditButtonClicked();
    }

    @UiHandler("linkInfo")
    void onLinkInfoClicked(ClickEvent clickEvent) {
        usersListPresenter.onInfoLinkClicked();
    }
}