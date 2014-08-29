package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.event.RedirectToPageInfoEventHandler;
import com.codenvy.employee.client.presenter.PageInfoPresenter;
import com.codenvy.employee.client.view.PageInfoView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Created by logarifm on 29.08.14.
 */
public class PageInfoPresenterImpl implements PageInfoPresenter {

    private final PageInfoView pageInfoView;

    private final EventBus eventBus;

    HasWidgets container;

    public PageInfoPresenterImpl(PageInfoView pageInfoView, EventBus eventBus) {
        this.pageInfoView = pageInfoView;
        this.eventBus = eventBus;
        eventBus.addHandler(RedirectToPageInfoEvent.TYPE, new RedirectToPageInfoEventHandler() {
            @Override
            public void redirectToPageInfo(RedirectToPageInfoEvent redirectToPageInfoEvent, HasWidgets container) {
                go(container);
            }
        });
    }

    public void go(HasWidgets container) {
        container.clear();
        container.add(pageInfoView.asWidget());
    }
}
