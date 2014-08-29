package com.codenvy.employee.client.view.impl;

import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.view.EditUserDialogBoxView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

/**
 * Created by Andrienko Alexander  on 19.08.14.
 */
public class EditUserDialogBoxViewViewImpl extends DialogBox implements EditUserDialogBoxView {

    interface EditUserDialogBoxUI extends UiBinder<Widget, EditUserDialogBoxViewViewImpl> {
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

    private static EditUserDialogBoxUI userEditor = GWT.create(EditUserDialogBoxUI.class);

    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    public EditUserDialogBoxViewViewImpl() {
        add(userEditor.createAndBindUi(this));
    }

    @Override
    public void setPresenter(EditUserDialogBoxPresenter editUserDialogBoxPresenter) {
        this.editUserDialogBoxPresenter = editUserDialogBoxPresenter;
    }

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

    @UiHandler("okButton")
    void onOkButtonClicked(ClickEvent clickEvent) {
        editUserDialogBoxPresenter.onOkButtonClicked();
    }

    @UiHandler("cancelButton")
    void onCancelButtonClicked(ClickEvent clickEvent) {
        editUserDialogBoxPresenter.onCancelButtonClicked();
    }

    public void showDialog() {
        center();
    }

    public void hideDialog() {
        hide();
    }
}
