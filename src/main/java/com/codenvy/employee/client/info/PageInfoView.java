package com.codenvy.employee.client.info;

import com.codenvy.employee.client.mvp.View;
import com.google.inject.ImplementedBy;

/**
 * Created by Andrienko Alexander on 29.08.14.
 */
@ImplementedBy(PageInfoViewImpl.class)
public interface PageInfoView extends View<PageInfoView.ActionDelegate> {

    interface ActionDelegate {
        void onBackToListHyperlinkClicked();
    }
}
