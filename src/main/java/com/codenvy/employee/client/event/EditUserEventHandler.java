package com.codenvy.employee.client.event;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.view.CallBack;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;

/**
 * Created by logarifm on 01.09.14.
 */
public interface EditUserEventHandler extends EventHandler {
    void EditButtonClicked(User selectedUser, CallBack callBack);
}
