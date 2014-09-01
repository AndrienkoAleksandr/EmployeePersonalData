package com.codenvy.employee.client.view;

import com.codenvy.employee.client.presenter.PageInfoPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by Andrienko Alexander on 29.08.14.
 */
public interface PageInfoView extends IsWidget {
    public void setPageInfoPresenter(PageInfoPresenter pageInfoPresenter);
}
