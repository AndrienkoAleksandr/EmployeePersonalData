package com.codenvy.employee.client;

import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.presenter.impl.EditUserDialogBoxPresenterImpl;
import com.codenvy.employee.client.presenter.impl.UsersListPresenterImpl;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDataModule implements EntryPoint {

    public void onModuleLoad() {
        EditUserDialogBoxPresenter editUserDialogBoxPresenter = new EditUserDialogBoxPresenterImpl();
        UsersListPresenterImpl usersListPresenter = new UsersListPresenterImpl(editUserDialogBoxPresenter);
        usersListPresenter.go(RootLayoutPanel.get());
    }
}
