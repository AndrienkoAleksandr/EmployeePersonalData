package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.CallBack;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.view.EditUserDialogBoxView;

/**
 * Created by Andrienko Alexander  on 22.08.14.
 */
public class EditUserDialogBoxPresenterImpl implements EditUserDialogBoxPresenter {

    private final EditUserDialogBoxView editUserDialogBoxView;

    private CallBack callBack;

    private User userForEdit;

    public EditUserDialogBoxPresenterImpl(EditUserDialogBoxView editUserDialogBoxView) {
        this.editUserDialogBoxView = editUserDialogBoxView;
    }

    @Override
    public void onShowDialog(User userForEdit, CallBack callback) {
        this.callBack = callback;

        if (userForEdit == null) {
            userForEdit = new User("", "", "");
            initDialog("Add", "", "", "");
        } else {
            initDialog("Edit", userForEdit.getFirstName(), userForEdit.getLastName(), userForEdit.getAddress());
        }

        this.userForEdit = userForEdit;

        //show and move to center of display
        editUserDialogBoxView.center();
    }

    private void initDialog(String title, String firstName, String lastName, String address) {
        editUserDialogBoxView.setText(title);
        editUserDialogBoxView.setFirstName(firstName);
        editUserDialogBoxView.setLastName(lastName);
        editUserDialogBoxView.setAddress(address);
    }

    private void getDataFromDialogBox() {
        userForEdit.setFirstName(editUserDialogBoxView.getFirstName());
        userForEdit.setLastName(editUserDialogBoxView.getLastName());
        userForEdit.setAddress(editUserDialogBoxView.getAddress());
    }

    @Override
    public void onOkButtonClicked() {
        getDataFromDialogBox();
        callBack.onChanged(userForEdit);
        editUserDialogBoxView.hide();
    }

    @Override
    public void onCancelButtonClicked() {
        editUserDialogBoxView.hide();
    }
}
