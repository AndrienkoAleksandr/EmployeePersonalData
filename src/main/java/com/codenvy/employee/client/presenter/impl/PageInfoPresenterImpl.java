package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.event.RedirectToListPageEvent;
import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.event.RedirectToPageInfoEventHandler;
import com.codenvy.employee.client.presenter.PageInfoPresenter;
import com.codenvy.employee.client.view.PageInfoView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Created by logarifm on 29.08.14.
 */
public class PageInfoPresenterImpl implements PageInfoPresenter {

    private final PageInfoView pageInfoView;

    private final EventBus eventBus;

    public PageInfoPresenterImpl(PageInfoView pageInfoView, EventBus eventBus) {
        this.pageInfoView = pageInfoView;
        this.eventBus = eventBus;
        this.eventBus.addHandler(RedirectToPageInfoEvent.TYPE, new RedirectToPageInfoEventHandler() {
            @Override
            public void redirectToPageInfo(RedirectToPageInfoEvent redirectToPageInfoEvent) {
                go(redirectToPageInfoEvent.getHasWidgets());
            }
        });
    }

    public void go(HasWidgets container) {
        container.clear();
        container.add(pageInfoView.asWidget());
    }

    @Override
    public void onBackToListHyperlinkClicked() {
        History.newItem("info");
        eventBus.fireEvent(new RedirectToListPageEvent());
}
}
