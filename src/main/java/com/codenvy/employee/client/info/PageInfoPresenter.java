package com.codenvy.employee.client.info;

import com.codenvy.employee.client.event.RedirectToListPageEvent;
import com.codenvy.employee.client.mvp.Presenter;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

/**
 * Created by Andrienko Alexander on 29.08.14.
 */
public class PageInfoPresenter implements PageInfoView.ActionDelegate, Presenter {

    private final PageInfoView pageInfoView;

    private final HandlerManager eventBus;

    @Inject
    public PageInfoPresenter(PageInfoView pageInfoView, HandlerManager eventBus) {
        this.pageInfoView = pageInfoView;
        this.pageInfoView.setDelegate(this);

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
