package com.codenvy.employee.client.gin;


import com.codenvy.employee.client.EmployeeDataConstants;
import com.codenvy.employee.client.EmployeeDataResource;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxViewImpl;
import com.codenvy.employee.client.gin.annotation.PageInfo;
import com.codenvy.employee.client.gin.annotation.UserList;
import com.codenvy.employee.client.info.PageInfoPresenter;
import com.codenvy.employee.client.info.PageInfoView;
import com.codenvy.employee.client.info.PageInfoViewImpl;
import com.codenvy.employee.client.mvp.Presenter;
import com.codenvy.employee.client.table.UsersListPresenter;
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

        bind(Presenter.class).annotatedWith(PageInfo.class).to(PageInfoPresenter.class);

        bind(Presenter.class).annotatedWith(UserList.class).to(UsersListPresenter.class);
    }
}
