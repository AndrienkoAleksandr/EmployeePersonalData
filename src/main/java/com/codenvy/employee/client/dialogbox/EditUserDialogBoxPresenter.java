package com.codenvy.employee.client.dialogbox;

import com.codenvy.employee.client.EmployeeDataConstants;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.table.UserChangedCallBack;
import com.google.inject.Inject;

/**
 * Created by Andrienko Alexander on 22.08.14.
 */
public class EditUserDialogBoxPresenter implements EditUserDialogBoxView.ActionDelegate {

    private final EditUserDialogBoxView editUserDialogBoxView;

    private UserChangedCallBack callBack;

    private final EmployeeDataConstants constants;

    private User userForEdit;

    @Inject
    public EditUserDialogBoxPresenter(EditUserDialogBoxView editUserDialogBoxView, EmployeeDataConstants constants) {
        this.editUserDialogBoxView = editUserDialogBoxView;
        this.editUserDialogBoxView.setDelegate(this);
        this.constants = constants;
        userForEdit = new User("", "", "");
    }

    public void showDialog(User userForEdit, UserChangedCallBack callback) {
        this.callBack = callback;

        if (userForEdit == null) {
            initDialog(constants.addDialogBoxText(), "", "", "");
        } else {
            initDialog(constants.editDialogBoxText(), userForEdit.getFirstName(), userForEdit.getLastName(), userForEdit.getAddress());
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
    public void okButtonClicked() {
        getDataFromDialogBox();

        callBack.onChanged(userForEdit);

        editUserDialogBoxView.hideDialog();
    }

    @Override
    public void cancelButtonClicked() {
        editUserDialogBoxView.hideDialog();
    }
}
