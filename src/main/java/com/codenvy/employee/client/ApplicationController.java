package com.codenvy.employee.client;

import com.codenvy.employee.client.event.RedirectToListPageEvent;
import com.codenvy.employee.client.event.RedirectToListPageEventHandler;
import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.event.RedirectToPageInfoEventHandler;
import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.presenter.Presenter;
import com.codenvy.employee.client.presenter.impl.EditUserDialogBoxPresenterImpl;
import com.codenvy.employee.client.presenter.impl.PageInfoPresenterImpl;
import com.codenvy.employee.client.presenter.impl.UsersListPresenterImpl;
import com.codenvy.employee.client.view.EditUserDialogBoxView;
import com.codenvy.employee.client.view.UsersListView;
import com.codenvy.employee.client.view.impl.EditUserDialogBoxViewViewImpl;
import com.codenvy.employee.client.view.impl.PageInfoViewImpl;
import com.codenvy.employee.client.view.impl.UsersListViewImpl;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Created by Andrienko Alexander on 29.08.14.
 */
public class ApplicationController implements ValueChangeHandler<String>{

    interface Tokens {
        final String INFO = "info";

        final String LIST_USER = "list";
    }

    private Presenter presenter;

    private final HandlerManager eventBus;

    private HasWidgets container;

    public ApplicationController(HandlerManager eventBus) {
        this.eventBus = eventBus;
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
                presenter = new PageInfoPresenterImpl(pageInfoView, eventBus);
                pageInfoView.setPageInfoPresenter((com.codenvy.employee.client.presenter.PageInfoPresenter) presenter);
                break;

            default:
                EditUserDialogBoxView dialogBoxView = new EditUserDialogBoxViewViewImpl();
                EditUserDialogBoxPresenter dialogBoxPresenter = new EditUserDialogBoxPresenterImpl(dialogBoxView);
                dialogBoxView.setPresenter(dialogBoxPresenter);

                UsersListView usersListView = new UsersListViewImpl();
                presenter = new UsersListPresenterImpl(dialogBoxPresenter, usersListView, eventBus);
                usersListView.setPresenter((com.codenvy.employee.client.presenter.UsersListPresenter) presenter);
                break;
        }

        presenter.go(container);
    }
}
