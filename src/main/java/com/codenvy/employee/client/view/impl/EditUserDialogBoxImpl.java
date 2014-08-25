package com.codenvy.employee.client.view.impl;

import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.view.EditUserDialogBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by logarifm on 19.08.14.
 */
public class EditUserDialogBoxImpl extends DialogBox implements EditUserDialogBox {

    interface EditUserDialogBoxUI extends UiBinder<Widget, EditUserDialogBoxImpl> {
    }

    private EditUserDialogBoxUI userEditor = GWT.create(EditUserDialogBoxUI.class);

    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    public EditUserDialogBoxImpl(EditUserDialogBoxPresenter editUserDialogBoxPresenter) {
        add(userEditor.createAndBindUi(this));
        this.editUserDialogBoxPresenter = editUserDialogBoxPresenter;
        initHandlersForUserDialogBox();
    }

    @UiField
    TextBox firstName;

    @UiField
    TextBox lastName;

    @UiField
    TextBox address;

    @UiField
    Button okButton;

    @UiField
    Button cancelButton;

    @Override
    public String getLastName() {
        return lastName.getValue();
    }

    @Override
    public String getAddress() {
        return address.getValue();
    }

    @Override
    public String getFirstName() {
        return firstName.getValue();
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName.setValue(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName.setValue(lastName);
    }

    @Override
    public void setAddress(String address) {
        this.address.setValue(address);
    }

    public void initHandlersForUserDialogBox() {

        okButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent clickEvent) {
                editUserDialogBoxPresenter.saveUser();
                hide();
            }

        });

        cancelButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent clickEvent) {
                hide();
            }
        });
    }
}
