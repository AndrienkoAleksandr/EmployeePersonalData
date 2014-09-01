package com.codenvy.employee.client.event;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.view.CallBack;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by logarifm on 01.09.14.
 */
public class EditUserEvent extends GwtEvent<EditUserEventHandler> {

    public static final Type<EditUserEventHandler> TYPE = new Type<EditUserEventHandler>();

    private final User user;

    private final CallBack callBack;

    public EditUserEvent(User user, CallBack callBack) {
        this.user = user;
        this.callBack = callBack;
    }

    @Override
    public Type<EditUserEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(EditUserEventHandler handler) {
        handler.EditButtonClicked(user, callBack);
    }
}
