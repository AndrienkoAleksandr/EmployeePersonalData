package com.codenvy.employee.client;

import com.codenvy.employee.client.event.RedirectToListPageEvent;
import com.codenvy.employee.client.event.RedirectToListPageEventHandler;
import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.event.RedirectToPageInfoEventHandler;
import com.codenvy.employee.client.gin.annotation.PageInfo;
import com.codenvy.employee.client.gin.annotation.UserList;
import com.codenvy.employee.client.mvp.Presenter;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

/**
 * Created by Andrienko Alexander on 29.08.14.
 */
public class ApplicationController implements ValueChangeHandler<String> {

    private enum Tokens {
        INFO("info"), LIST_USER("list");

        String token;

        String getToken() {
            return token;
        }

        Tokens(String token) {
            this.token = token;
        }
    }

    private Presenter infoPagePresenter;

    private Presenter userListPresenter;

    private final EventBus eventBus;

    private HasWidgets container;

    @Inject
    public ApplicationController(EventBus eventBus, EmployeeDataResource resource,
                                 @PageInfo Presenter infoPagePresenter, @UserList Presenter userListPresenter) {

        resource.employDataStyle().ensureInjected();

        this.eventBus = eventBus;

        this.infoPagePresenter = infoPagePresenter;
        this.userListPresenter = userListPresenter;

        bind();
    }

    private void bind() {
        History.addValueChangeHandler(this);

        eventBus.addHandler(RedirectToPageInfoEvent.TYPE, new RedirectToPageInfoEventHandler() {

            @Override
            public void redirectToPageInfo(RedirectToPageInfoEvent RedirectToPageInfoEvent) {
                History.newItem(Tokens.INFO.getToken());
            }
        });

        eventBus.addHandler(RedirectToListPageEvent.TYPE, new RedirectToListPageEventHandler() {

            @Override
            public void redirectToPageList(RedirectToListPageEvent redirectToListPageEvent) {
                History.newItem(Tokens.LIST_USER.getToken());
            }
        });

    }

    public void go(HasWidgets container) {
        this.container = container;
        if (History.getToken().equals("") || History.getToken().equals(Tokens.LIST_USER.getToken())) {
            History.newItem(Tokens.LIST_USER.getToken());
        }
        if (History.getToken().equals(Tokens.INFO.getToken())) {
            History.newItem(Tokens.INFO.getToken());
        }

        History.fireCurrentHistoryState();
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> stringValueChangeEvent) {

        String currentToken = stringValueChangeEvent.getValue();

        if (Tokens.INFO.getToken().equals(currentToken)) {
            infoPagePresenter.go(container);
        } else {
            userListPresenter.go(container);
        }
    }
}