package com.codenvy.employee.client.gin;

import com.codenvy.employee.client.info.PageInfoView;
import com.codenvy.employee.client.info.PageInfoViewImpl;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/**
 * Created by Andrienko Alexander on 03.09.14.
 */
public class PageInfoPresenterModule extends AbstractGinModule {
    @Provides
    @Singleton
    HandlerManager getEventBus() {
        return new HandlerManager(null);
    }

    @Override
    protected void configure() {
        bind(PageInfoView.class).to(PageInfoViewImpl.class);
    }
}
