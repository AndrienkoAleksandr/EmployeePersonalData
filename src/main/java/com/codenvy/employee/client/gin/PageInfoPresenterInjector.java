package com.codenvy.employee.client.gin;

import com.codenvy.employee.client.info.PageInfoPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Created by Andrienko Alexander on 03.09.14.
 */
@GinModules(PageInfoPresenterModule.class)
public interface PageInfoPresenterInjector extends Ginjector{
    PageInfoPresenterInjector INSTANCE = GWT.create(PageInfoPresenterInjector.class);

    PageInfoPresenter getPageInfoPresenter();
}
