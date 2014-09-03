package com.codenvy.employee.client.dialogbox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.gwt.user.client.ui.DialogBox;

/**
 * Created by Andrienko Alexander  on 19.08.14.
 */

@Singleton
public class EditUserDialogBoxViewImpl extends DialogBox implements EditUserDialogBoxView {

    interface EditUserDialogBoxUI extends UiBinder<Widget, EditUserDialogBoxViewImpl> {
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

    private ActionDelegate actionDelegate;

    @Inject
    public EditUserDialogBoxViewImpl(EditUserDialogBoxUI userEditor) {
        add(userEditor.createAndBindUi(this));
    }

    @Override
    public void setDelegate(ActionDelegate actionDelegate) {
        this.actionDelegate = actionDelegate;
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
    public void onOkButtonClicked(ClickEvent clickEvent) {
        actionDelegate.okButtonClicked();
    }

    @UiHandler("cancelButton")
    public void onCancelButtonClicked(ClickEvent clickEvent) {
        actionDelegate.cancelButtonClicked();
    }

    public void showDialog() {
        center();
    }

    public void hideDialog() {
        hide();
    }
}
