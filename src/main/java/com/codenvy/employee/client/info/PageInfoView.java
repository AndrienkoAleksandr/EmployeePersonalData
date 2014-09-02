package com.codenvy.employee.client.info;

import com.codenvy.employee.client.View;

/**
 * Created by Andrienko Alexander on 29.08.14.
 */
public interface PageInfoView extends View<PageInfoView.ActionDelegate> {

    interface ActionDelegate {
        void onBackToListHyperlinkClicked();
    }
}
