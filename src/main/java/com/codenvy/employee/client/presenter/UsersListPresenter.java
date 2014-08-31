package com.codenvy.employee.client.presenter;

import com.codenvy.employee.client.entity.User;

/**
 * Created by Andrienko Alexander  on 21.08.14.
 */
public interface UsersListPresenter extends Presenter{
    void onDeleteButtonClicked();

    void onEditButtonClicked();

    void onAddButtonClicked();

    void onSelectedUser(User user);

    void onInfoLinkClicked();
}
