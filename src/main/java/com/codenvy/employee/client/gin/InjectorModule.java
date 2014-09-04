package com.codenvy.employee.client.gin;


import com.codenvy.employee.client.EmployeeDataConstants;
import com.codenvy.employee.client.EmployeeDataResource;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxViewImpl;
import com.codenvy.employee.client.info.PageInfoView;
import com.codenvy.employee.client.info.PageInfoViewImpl;
import com.codenvy.employee.client.table.UsersListView;
import com.codenvy.employee.client.table.UsersListViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.gwt.event.shared.SimpleEventBus;

/**
 * Created by Andrienko Alexander on 03.09.14.
 */
public class InjectorModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

        bind(EditUserDialogBoxView.class).to(EditUserDialogBoxViewImpl.class);

        bind(UsersListView.class).to(UsersListViewImpl.class);

        bind(EmployeeDataConstants.class).in(Singleton.class);

        bind(PageInfoView.class).to(PageInfoViewImpl.class);
    }
}
