package com.codenvy.employee.client.gin;

import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxViewImpl;
import com.codenvy.employee.client.table.UsersListView;
import com.codenvy.employee.client.table.UsersListViewImpl;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/**
 * Created by Andrienko Alexander on 02.09.14.
 */
public class UserListPresenterModule extends AbstractGinModule {
    @Provides
    @Singleton
    public HandlerManager getEventBus() {
        return new HandlerManager(null);
    }

    @Override
    protected void configure() {
        bind(EditUserDialogBoxView.class).to(EditUserDialogBoxViewImpl.class);
        bind(UsersListView.class).to(UsersListViewImpl.class);
    }
}
