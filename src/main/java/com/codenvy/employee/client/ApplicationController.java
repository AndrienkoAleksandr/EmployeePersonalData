package com.codenvy.employee.client;

import com.codenvy.employee.client.constants.EmployeeDataConstants;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxViewImpl;
import com.codenvy.employee.client.event.RedirectToListPageEvent;
import com.codenvy.employee.client.event.RedirectToListPageEventHandler;
import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.event.RedirectToPageInfoEventHandler;
import com.codenvy.employee.client.info.PageInfoPresenter;
import com.codenvy.employee.client.info.PageInfoViewImpl;
import com.codenvy.employee.client.mvp.Presenter;
import com.codenvy.employee.client.table.UsersListPresenter;
import com.codenvy.employee.client.table.UsersListView;
import com.codenvy.employee.client.table.UsersListViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Created by Andrienko Alexander on 29.08.14.
 */
public class ApplicationController implements ValueChangeHandler<String> {

    interface Tokens {
        final String INFO = "info";

        final String LIST_USER = "list";
    }

    private Presenter presenter;

    private final HandlerManager eventBus;

    private HasWidgets container;

    private final EmployeeDataConstants constants;

    public ApplicationController(HandlerManager eventBus) {
        EmployeeDataResource.INSTANCE.employDataStyle().ensureInjected();
        this.eventBus = eventBus;
        this.constants = GWT.create(EmployeeDataConstants.class);
        History.newItem("");
        bind();
    }

    public void bind() {
        History.addValueChangeHandler(this);

        eventBus.addHandler(RedirectToPageInfoEvent.TYPE, new RedirectToPageInfoEventHandler() {

            @Override
            public void redirectToPageInfo(RedirectToPageInfoEvent RedirectToPageInfoEvent) {
                History.newItem(Tokens.INFO);
            }
        });

        eventBus.addHandler(RedirectToListPageEvent.TYPE, new RedirectToListPageEventHandler() {

            @Override
            public void redirectToPageList(RedirectToListPageEvent redirectToListPageEvent) {
                History.newItem(Tokens.LIST_USER);
            }
        });

    }

    public void go(HasWidgets container) {
        this.container = container;
        if (History.getToken().equals("") || History.getToken().equals(Tokens.LIST_USER)) {
            History.newItem(Tokens.LIST_USER);
        }
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> stringValueChangeEvent) {
        switch (stringValueChangeEvent.getValue()) {
            case Tokens.INFO:
                PageInfoViewImpl pageInfoView = new PageInfoViewImpl();
                presenter = new PageInfoPresenter(pageInfoView, eventBus);
                break;

            default:
                EditUserDialogBoxView dialogBoxView = new EditUserDialogBoxViewImpl();
                EditUserDialogBoxPresenter dialogBoxPresenter =
                        new EditUserDialogBoxPresenter(dialogBoxView, constants);

                UsersListView usersListView = new UsersListViewImpl(constants);
                presenter = new UsersListPresenter(dialogBoxPresenter, usersListView, eventBus);
                break;
        }

        presenter.go(container);
    }
}