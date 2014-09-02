package com.codenvy.employee.client.table;

import com.codenvy.employee.client.entity.User;

/**
 * Created by Andrienko Alexander  on 24.08.2014.
 */
public interface UserChangedCallBack {
    void onChanged(User user);
}
