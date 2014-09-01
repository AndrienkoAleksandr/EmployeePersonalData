package com.codenvy.employee.client.view;

import com.codenvy.employee.client.entity.User;

/**
 * Created by Andrienko Alexander  on 24.08.2014.
 */
public interface UserChangedCallBack {
    public abstract void onChanged(User user);
}
