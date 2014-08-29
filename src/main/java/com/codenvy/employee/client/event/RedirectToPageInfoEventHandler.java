package com.codenvy.employee.client.event;


import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

import java.awt.*;

/**
 * Created by logarifm on 29.08.14.
 */
public interface RedirectToPageInfoEventHandler extends EventHandler {
    void redirectToPageInfo(RedirectToPageInfoEvent RedirectToPageInfoEvent, HasWidgets container);
}
