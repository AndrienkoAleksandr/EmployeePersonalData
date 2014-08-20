package com.codenvy.employee.client.ui;

import com.codenvy.employee.client.entity.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

/**
 * Created by logarifm on 19.08.14.
 */
public class EditUserDialogBox extends DialogBox {

    interface UserEditable extends UiBinder<Widget, EditUserDialogBox> {
    }

    @UiField
    FlowPanel dialogPanel;

    public UserEditable userEditor = GWT.create(UserEditable.class);

    public EditUserDialogBox() {
        add(userEditor.createAndBindUi(this));
    }

    @Override
    public void hide() {
        super.hide();;
    }

    @UiField
    TextBox firstName;

    @UiField
    TextBox secondName;

    @UiField
    TextBox address;

    @UiField
    Button okButton;

    @UiField
    Button cancelButton;

    public User addUser() {
        return new User(firstName.getValue(), secondName.getValue(), address.getValue());
    }

    public User EditUser(User user) {
        return new User(firstName.getValue(), secondName.getValue(), address.getValue());
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public Button getOkButton() {
        return okButton;
    }

   public User getUserData() {
       return new User(firstName.getValue(), secondName.getValue(), address.getValue());
   }

    public void setUserData(User selectedUser) {
        firstName.setValue(selectedUser.getFirstName());
        secondName.setValue(selectedUser.getLastName());
        address.setValue(selectedUser.getAddress());
    }

    public void clearUserData() {
        firstName.setValue("");
        secondName.setValue("");
        address.setValue("");
    }

}
