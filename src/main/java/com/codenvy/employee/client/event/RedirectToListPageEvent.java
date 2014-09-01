package com.codenvy.employee.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by Andrienko Alexander on 31.08.2014.
 */
public class RedirectToListPageEvent extends GwtEvent<RedirectToListPageEventHandler> {

    public static final Type<RedirectToListPageEventHandler> TYPE = new Type<RedirectToListPageEventHandler>();

    @Override
    public Type<RedirectToListPageEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RedirectToListPageEventHandler redirectToListPageEventHandler) {
        redirectToListPageEventHandler.redirectToPageList(this);
    }
}
