package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.view.EditUserDialogBoxView;
import com.codenvy.employee.client.view.UserChangedCallBack;

/**
 * Created by Andrienko Alexander  on 22.08.14.
 */
public class EditUserDialogBoxPresenterImpl implements EditUserDialogBoxPresenter {

    private final EditUserDialogBoxView editUserDialogBoxView;

    private UserChangedCallBack callBack;

    private User userForEdit;

    public EditUserDialogBoxPresenterImpl(EditUserDialogBoxView editUserDialogBoxView) {
        this.editUserDialogBoxView = editUserDialogBoxView;
        this.editUserDialogBoxView.setPresenter(this);
        userForEdit = new User("", "", "");
    }

    @Override
    public void onShowDialog(User userForEdit, UserChangedCallBack callback) {
        this.callBack = callback;

        if (userForEdit == null) {
            initDialog("Add", "", "", "");
        } else {
            initDialog("Edit", userForEdit.getFirstName(), userForEdit.getLastName(), userForEdit.getAddress());
        }

        //show and move to center of display
        editUserDialogBoxView.showDialog();
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

        editUserDialogBoxView.hideDialog();
    }

    @Override
    public void onCancelButtonClicked() {
        editUserDialogBoxView.hideDialog();
    }
}
