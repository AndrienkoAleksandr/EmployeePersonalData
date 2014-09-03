package com.codenvy.employee.client.gin;

import com.codenvy.employee.client.table.UsersListPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Created by Andrienko Alexander on 02.09.14.
 */
@GinModules(UserListPresenterModule.class)
public interface UsersListPresenterInjector extends Ginjector {
    UsersListPresenterInjector INSTANCE = GWT.create(UsersListPresenterInjector.class);

    UsersListPresenter getUsersListPresenter();
}