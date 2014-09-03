package com.codenvy.employee.client.gin;

import com.codenvy.employee.client.ApplicationController;
import com.codenvy.employee.client.info.PageInfoPresenter;
import com.codenvy.employee.client.table.UsersListPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by logarifm on 03.09.14.
 */
@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {

    Injector INSTANCE = GWT.create(Injector.class);

    UsersListPresenter getUsersListPresenter();

    PageInfoPresenter getPageInfoPresenter();

    ApplicationController getApplicationController();

    Widget getDialogBox();
}
