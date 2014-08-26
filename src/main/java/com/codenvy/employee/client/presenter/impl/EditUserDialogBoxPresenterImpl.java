package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.CallBack;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.view.EditUserDialogBox;

/**
 * Created by logarifm on 22.08.14.
 */
public class EditUserDialogBoxPresenterImpl implements EditUserDialogBoxPresenter {

    private final EditUserDialogBox editUserDialogBox;

    private CallBack callBack;

    private User userForEdit;

    public EditUserDialogBoxPresenterImpl(EditUserDialogBox editUserDialogBox) {
        this.editUserDialogBox = editUserDialogBox;
    }

    @Override
    public void onShowButtonClicked(User userForEdit, CallBack callback) {
        this.callBack = callback;
        if (userForEdit == null) {
            userForEdit = new User("", "", "");
            initDialog("Add", "", "", "");
        } else {
            initDialog("Edit", userForEdit.getFirstName(), userForEdit.getLastName(), userForEdit.getAddress());
        }

        this.userForEdit = userForEdit;

        //show dialog box
        editUserDialogBox.center();
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

    @Override
    public void saveUser() {
        getDataFromDialogBox();
        if (editUserDialogBox.getText().equals("Add")) {
            callBack.onchange(userForEdit);
        } else {
            callBack.onchange();
        }
    }
}
