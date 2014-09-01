package com.codenvy.employee.client.event;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.view.CallBack;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by logarifm on 01.09.14.
 */
public class AddUserEvent extends GwtEvent<AddUserEventHandler>{

    public static final Type<AddUserEventHandler> TYPE = new Type<AddUserEventHandler>();

    private final User selectedUser;

    private final CallBack callBack;

    public AddUserEvent(User selectedUser, CallBack callBack) {
        this.selectedUser = selectedUser;
        this.callBack = callBack;
    }

    @Override
    public Type<AddUserEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AddUserEventHandler handler) {
        handler.addButtonClicked(selectedUser, callBack);
    }
}
