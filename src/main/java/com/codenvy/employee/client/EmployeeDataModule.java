package com.codenvy.employee.client;

import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.presenter.PageInfoPresenter;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.presenter.impl.EditUserDialogBoxPresenterImpl;
import com.codenvy.employee.client.presenter.impl.PageInfoPresenterImpl;
import com.codenvy.employee.client.presenter.impl.UsersListPresenterImpl;
import com.codenvy.employee.client.view.EditUserDialogBoxView;
import com.codenvy.employee.client.view.PageInfoView;
import com.codenvy.employee.client.view.UsersListView;
import com.codenvy.employee.client.view.impl.EditUserDialogBoxViewViewImpl;
import com.codenvy.employee.client.view.impl.PageInfoViewImpl;
import com.codenvy.employee.client.view.impl.UsersListViewImpl;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class EmployeeDataModule implements EntryPoint {

    public void onModuleLoad() {

        EventBus simpleEventBus = new SimpleEventBus();

        EmployeeDataResource.INSTANCE.employDataStyle().ensureInjected();
        //init EditUserDialogBoxPresenter
        EditUserDialogBoxView editUserDialogBoxView = new EditUserDialogBoxViewViewImpl();
        EditUserDialogBoxPresenter editUserDialogBoxPresenter =
                new EditUserDialogBoxPresenterImpl(editUserDialogBoxView);

        editUserDialogBoxView.setPresenter(editUserDialogBoxPresenter);

        //init PageInfoPresenter
        PageInfoView pageInfoView = new PageInfoViewImpl();
        PageInfoPresenter pageInfoPresenter = new PageInfoPresenterImpl(pageInfoView, simpleEventBus);

        pageInfoView.setPageInfoPresenter(pageInfoPresenter);

        //init UsersListPresenter
        UsersListView usersListView = new UsersListViewImpl();
        UsersListPresenter usersListPresenter =
                new UsersListPresenterImpl(editUserDialogBoxPresenter, usersListView, simpleEventBus);

        usersListView.setPresenter(usersListPresenter);

        usersListPresenter.go(RootLayoutPanel.get());
    }
}
