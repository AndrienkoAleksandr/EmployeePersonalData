package com.codenvy.employee.client.gin;

import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxViewImpl;
import com.codenvy.employee.client.gin.annotation.DialogBox;
import com.codenvy.employee.client.gin.annotation.UserList;
import com.codenvy.employee.client.table.UsersListView;
import com.codenvy.employee.client.table.UsersListViewImpl;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * Created by logarifm on 02.09.14.
 */
public class UserListPresenterModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(EditUserDialogBoxView.class).to(EditUserDialogBoxViewImpl.class);
        bind(UsersListView.class).to(UsersListViewImpl.class);
        bind(HandlerManager.class).in(Singleton.class);
    }
}
