package com.codenvy.employee.client;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.view.impl.UsersListViewImpl;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class EmployeeDataModule implements EntryPoint {

    public void onModuleLoad() {
        final UsersListViewImpl usersListViewImpl = GWT.create(UsersListViewImpl.class);
        RootLayoutPanel.get().add(usersListViewImpl);
    }
}
