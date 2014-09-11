package com.codenvy.employee.client.table;

import com.codenvy.employee.client.EmployeeDataConstants;
import com.codenvy.employee.client.EmployeeDataResource;
import com.codenvy.employee.client.entity.User;
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
import com.google.inject.Singleton;

import java.util.List;

/**
 * Created by Andrienko Alexander  on 19.08.14.
 */
public class UsersListViewImpl extends Composite implements UsersListView {

    @Singleton
    public interface UsersListUiBinder extends UiBinder<Widget, UsersListViewImpl> {
    }

    @UiField
    CellTable<User> usersTable;

    @UiField
    Button delete;

    @UiField
    Button edit;

    @UiField
    Button add;

    @UiField
    Button note;

    @UiField
    Label labelListEmployee;

    @UiField
    Hyperlink linkInfo;

    @UiField
    Image imageBuildings;

    @UiField(provided = true)
    final EmployeeDataResource resource;

    @UiField(provided = true)
    final EmployeeDataConstants constants;

    private ActionDelegate actionDelegate;

    @Inject
    public UsersListViewImpl(EmployeeDataConstants constants,
                             EmployeeDataResource resource,
                             UsersListUiBinder ourUiBinder) {
        this.resource = resource;
        this.constants = constants;

        initWidget(ourUiBinder.createAndBindUi(this));
        drawUserTable();
        writeTextInHeader();
        addStyleToView();
    }

    public void setDelegate(ActionDelegate actionDelegate) {
        this.actionDelegate = actionDelegate;
    }

    private void writeTextInHeader() {
        labelListEmployee.setText(resource.textEmployeeTable().getText());
    }

    private void addStyleToView() {
        usersTable.getHeader(0).setHeaderStyleNames(resource.employDataStyle().headerTableStyle());
        usersTable.getHeader(1).setHeaderStyleNames(resource.employDataStyle().headerTableStyle());
        usersTable.getHeader(2).setHeaderStyleNames(resource.employDataStyle().headerTableStyle());
        usersTable.setStyleName(resource.employDataStyle().cellStyle());

        linkInfo.addStyleName(resource.employDataStyle().link());

        imageBuildings.addStyleName(resource.employDataStyle().imgBuildings());
    }

    @Override
    public void setUsers(List<User> users) {
        usersTable.setRowData(users);
    }

    private void drawUserTable() {
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
        firstName.setCellStyleNames(resource.employDataStyle().cellStyle());
        lastName.setCellStyleNames(resource.employDataStyle().cellStyle());
        address.setCellStyleNames(resource.employDataStyle().cellStyle());

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

    @UiHandler("note")
    public void onNoteButtonClicked(ClickEvent clickEvent) {
        actionDelegate.onNoteButtonClicked();
    }
}