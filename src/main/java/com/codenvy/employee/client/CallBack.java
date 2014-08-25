package com.codenvy.employee.client;

import com.codenvy.employee.client.entity.User;

/**
 * Created by User on 24.08.2014.
 */
public abstract class CallBack {
    public abstract void onchange(User user);
    public abstract void onchange();
}
