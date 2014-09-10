package com.codenvy.employee.client.table;

import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.mvp.Presenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrienko Alexander  on 21.08.14.
 */
public class UsersListPresenter implements UsersListView.ActionDelegate, Presenter {

    private User selectedUser;

    private final UsersListView usersListView;

    private final EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    private final List<User> users;

    private final UserChangedCallBack callBackForAddUser;

    private final UserChangedCallBack callBackForEditUser;

    private final EventBus eventBus;

    @Inject
    public UsersListPresenter(EditUserDialogBoxPresenter editUserDialogBoxPresenter,
                              final UsersListView usersListView,
                              EventBus eventBus) {
        this.usersListView = usersListView;
        this.usersListView.setDelegate(this);

        this.eventBus = eventBus;
        this.users = new ArrayList<>();
        this.editUserDialogBoxPresenter = editUserDialogBoxPresenter;

        callBackForAddUser = new UserChangedCallBack() {
            @Override
            public void onChanged(User user) {
                users.add(user);
                usersListView.setUsers(users);
            }
        };

        callBackForEditUser = new UserChangedCallBack() {
            @Override
            public void onChanged(User user) {
                selectedUser.setFirstName(user.getFirstName());
                selectedUser.setLastName(user.getLastName());
                selectedUser.setAddress(user.getAddress());

                usersListView.setUsers(users);
            }
        };
    }

    @Override
    public void go(HasWidgets container) {
        //set data to userListView's table
        usersListView.setUsers(users);

        container.clear();
        container.add(usersListView.asWidget());
    }

    @Override
    public void onSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    @Override
    public void onInfoLinkClicked() {
        eventBus.fireEvent(new RedirectToPageInfoEvent());
    }

    @Override
    public void onDeleteButtonClicked() {
        users.remove(selectedUser);

        selectedUser = null;

        usersListView.setUsers(users);
    }

    @Override
    public void onAddButtonClicked() {
        editUserDialogBoxPresenter.showDialog(null, callBackForAddUser);
    }

    @Override
    public void onEditButtonClicked() {
        if (selectedUser != null) {
            editUserDialogBoxPresenter.showDialog(selectedUser, callBackForEditUser);
        }
    }
}
