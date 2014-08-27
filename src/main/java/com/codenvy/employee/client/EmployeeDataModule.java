package com.codenvy.employee.client;

import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.presenter.impl.EditUserDialogBoxPresenterImpl;
import com.codenvy.employee.client.presenter.impl.UsersListPresenterImpl;
import com.codenvy.employee.client.view.EditUserDialogBoxView;
import com.codenvy.employee.client.view.UsersListView;
import com.codenvy.employee.client.view.impl.EditUserDialogBoxViewViewImpl;
import com.codenvy.employee.client.view.impl.UsersListViewImpl;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class EmployeeDataModule implements EntryPoint {

    public void onModuleLoad() {
        //init EditUserDialogBoxPresenter
        EditUserDialogBoxView editUserDialogBoxView = new EditUserDialogBoxViewViewImpl();
        EditUserDialogBoxPresenter editUserDialogBoxPresenter = new EditUserDialogBoxPresenterImpl(editUserDialogBoxView);

        editUserDialogBoxView.setEditUserDialogBoxPresenter(editUserDialogBoxPresenter);

        //init UsersListPresenter
        UsersListView usersListView = new UsersListViewImpl();
        UsersListPresenter usersListPresenter = new UsersListPresenterImpl(editUserDialogBoxPresenter, usersListView);

        usersListView.setUsersListPresenter(usersListPresenter);

        usersListPresenter.go(RootLayoutPanel.get());
    }
}
