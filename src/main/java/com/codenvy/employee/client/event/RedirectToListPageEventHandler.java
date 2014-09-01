package com.codenvy.employee.client.event;


import com.google.gwt.event.shared.EventHandler;

/**
 * Created by Andrienko Alexander on 31.08.2014.
 */
public interface RedirectToListPageEventHandler extends EventHandler {
    void redirectToPageList(RedirectToListPageEvent redirectToListPageEvent);
}
