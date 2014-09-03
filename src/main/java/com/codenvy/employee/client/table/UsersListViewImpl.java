package com.codenvy.employee.client.table;

import com.codenvy.employee.client.EmployeeDataResource;
import com.codenvy.employee.client.constants.EmployeeDataConstants;
import com.codenvy.employee.client.entity.User;
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
import com.google.inject.Inject;

import java.util.List;

/**
 * Created by Andrienko Alexander  on 19.08.14.
 */
public class UsersListViewImpl extends Composite implements UsersListView {

    interface UsersListUiBinder extends UiBinder<Widget, UsersListViewImpl> {
    }

    private final EmployeeDataConstants constants;

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

    private ActionDelegate actionDelegate;

    @Inject
    public UsersListViewImpl(EmployeeDataConstants constants) {
        this.constants = constants;
        UsersListUiBinder ourUiBinder = GWT.create(UsersListUiBinder.class);
        initWidget(ourUiBinder.createAndBindUi(this));

        drawUserTable();
        writeTextInHeader();
        addStyleToView();
    }

    public void setDelegate(ActionDelegate actionDelegate) {
        this.actionDelegate = actionDelegate;
    }

    private void writeTextInHeader() {
        labelListEmployee.setText(EmployeeDataResource.INSTANCE.textEmployeeTable().getText());
    }

    private void addStyleToView() {
        usersTable.getHeader(0).setHeaderStyleNames(EmployeeDataResource.INSTANCE.employDataStyle().headerTableStyle());
        usersTable.getHeader(1).setHeaderStyleNames(EmployeeDataResource.INSTANCE.employDataStyle().headerTableStyle());
        usersTable.getHeader(2).setHeaderStyleNames(EmployeeDataResource.INSTANCE.employDataStyle().headerTableStyle());
        usersTable.setStyleName(EmployeeDataResource.INSTANCE.employDataStyle().cellStyle());
        linkInfo.addStyleName(EmployeeDataResource.INSTANCE.employDataStyle().link());
        imageBuildings.addStyleName(EmployeeDataResource.INSTANCE.employDataStyle().imgBuildings());
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
        usersTable.addColumn(firstName, constants.firstTableColumnText());

        TextColumn<User> lastName = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return user.getLastName();
            }
        };
        usersTable.addColumn(lastName, constants.secondTableColumnText());

        TextColumn<User> address = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return user.getAddress();
            }
        };
        usersTable.addColumn(address, constants.thirdTableColumnText());

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
                        actionDelegate.onSelectedUser(mySelectionModel.getSelectedObject());
                    }
                }
        );
    }

    @UiHandler("delete")
    public void onDeleteButtonClicked(ClickEvent clickEvent) {
        actionDelegate.onDeleteButtonClicked();
    }

    @UiHandler("add")
    public void onAddButtonClicked(ClickEvent clickEvent) {
        actionDelegate.onAddButtonClicked();
    }


    @UiHandler("edit")
    public void onEditButtonClicked(ClickEvent clickEvent) {
        actionDelegate.onEditButtonClicked();
    }

    @UiHandler("linkInfo")
    public void onLinkInfoClicked(ClickEvent clickEvent) {
        actionDelegate.onInfoLinkClicked();
    }
}