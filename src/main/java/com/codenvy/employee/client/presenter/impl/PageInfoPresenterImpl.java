package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.event.RedirectToListPageEvent;
import com.codenvy.employee.client.presenter.PageInfoPresenter;
import com.codenvy.employee.client.view.PageInfoView;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Created by logarifm on 29.08.14.
 */
public class PageInfoPresenterImpl implements PageInfoPresenter {

    private final PageInfoView pageInfoView;

    private final HandlerManager eventBus;

    public PageInfoPresenterImpl(PageInfoView pageInfoView, HandlerManager eventBus) {
        this.pageInfoView = pageInfoView;
        this.eventBus = eventBus;
    }

    public void go(HasWidgets container) {
        container.clear();
        container.add(pageInfoView.asWidget());
    }

    @Override
    public void onBackToListHyperlinkClicked() {
        eventBus.fireEvent(new RedirectToListPageEvent());
}
}
