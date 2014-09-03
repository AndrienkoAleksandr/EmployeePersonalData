package com.codenvy.employee.client.gin;

import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.info.PageInfoPresenter;
import com.codenvy.employee.client.mvp.Presenter;
import com.codenvy.employee.client.table.UsersListPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Created by logarifm on 03.09.14.
 */
@GinModules(PresenterModule.class)
public interface PresenterInjector extends Ginjector {
    UsersListPresenterInjector INSTANCE = GWT.create(UsersListPresenterInjector.class);
    UsersListPresenter getUsersListPresenter();
    PageInfoPresenter getPageInfoPresenter();
    EditUserDialogBoxPresenter getEditUserDialogBoxPresenter();
}
