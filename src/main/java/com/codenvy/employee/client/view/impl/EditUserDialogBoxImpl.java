package com.codenvy.employee.client.view.impl;

import com.codenvy.employee.client.presenter.impl.EditUserDialogBoxPresenterImpl;
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

    public EditUserDialogBoxUI userEditor = GWT.create(EditUserDialogBoxUI.class);

    private EditUserDialogBoxPresenterImpl editUserDialogBoxPresenter;

    public EditUserDialogBoxImpl(EditUserDialogBoxPresenterImpl editUserDialogBoxPresenter) {
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

    public String getLastName() {
        return lastName.getValue();
    }

    public String getAddress() {
        return address.getValue();
    }

    public String getFirstName() {
        return firstName.getValue();
    }

    public void setFirstName(String firstName) {
        this.firstName.setValue(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.setValue(lastName);
    }

    public void setAddress(String address) {
        this.address.setValue(address);
    }

    public void initHandlersForUserDialogBox() {

        okButton.addClickHandler(new ClickHandler() {

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
