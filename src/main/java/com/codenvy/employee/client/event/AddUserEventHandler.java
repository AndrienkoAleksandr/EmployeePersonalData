package com.codenvy.employee.client.event;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.view.CallBack;
import com.google.gwt.event.shared.EventHandler;

/**
 * Created by logarifm on 01.09.14.
 */
public interface AddUserEventHandler extends EventHandler {
    void addButtonClicked(User selectedUser, CallBack callBack);
}
