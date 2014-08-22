package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.view.impl.EditUserDialogBoxImpl;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;


/**
 * Created by logarifm on 22.08.14.
 */
public class EditUserDialogBoxPresenterImpl implements EditUserDialogBoxPresenter {

    private EditUserDialogBoxImpl editUserDialogBox = new EditUserDialogBoxImpl(this);

    private UsersListPresenterImpl.CallBack  callBack;

    private User userForEdit;

    public void showDialog(User userForEdit, UsersListPresenterImpl.CallBack  callback) {
        this.callBack = callback;
        if (userForEdit == null) {
            userForEdit = new User("", "", "");
            initDialog("Add", "", "", "");
        } else {
            initDialog("Edit", userForEdit.getFirstName(), userForEdit.getLastName(), userForEdit.getAddress());
        }

        //show dialog box
        editUserDialogBox.center();

        this.userForEdit = userForEdit;
    }

    private void initDialog(String title, String firstName, String lastName, String address) {
        editUserDialogBox.setText(title);
        editUserDialogBox.setFirstName(firstName);
        editUserDialogBox.setLastName(lastName);
        editUserDialogBox.setAddress(address);
    }


    private void getDataFromDialogBox() {
        userForEdit.setFirstName(editUserDialogBox.getFirstName());
        userForEdit.setLastName(editUserDialogBox.getLastName());
        userForEdit.setAddress(editUserDialogBox.getAddress());

    }

    public void saveUser() {
        getDataFromDialogBox();
        if (editUserDialogBox.getText().equals("Add")) {
            callBack.onchange(userForEdit);
        } else {
            callBack.onchange();
        }
    }
}
