package com.codenvy.employee.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by Andrienko Alexander on 29.08.14.
 */
public class RedirectToPageInfoEvent extends GwtEvent<RedirectToPageInfoEventHandler> {

    public static Type<RedirectToPageInfoEventHandler> TYPE = new Type<RedirectToPageInfoEventHandler>();

    @Override
    public Type<RedirectToPageInfoEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RedirectToPageInfoEventHandler handler) {
        handler.redirectToPageInfo(this);
    }
}
