package com.codenvy.employee.client.table;

import com.codenvy.employee.client.UserChangedCallBack;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.presenter.Presenter;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrienko Alexander  on 21.08.14.
 */
public class UsersListPresenterImpl implements UsersListView.ActionDelegate, Presenter {

    @SuppressWarnings("deprecation")
    private static final List<User> temp = Arrays.asList(
            new User("Bogdan", "Petrenenko", "Kaniv"),
            new User("Xolod", "Ivan", "Kaniv"),
            new User("Stateman", "Konstantin", "Kiev"),
            new User("Fermi", "Gustav", "Kiev"),
            new User("Ammundcen", "Den", "Kiev")
    );

    private User selectedUser;

    private final UsersListView usersListView;

    private final EditUserDialogBoxView.ActionDelegate editUserDialogBoxPresenter;

    private final List<User> users;

    private final UserChangedCallBack callBackForAddUser;

    private final UserChangedCallBack callBackForEditUser;

    private final HandlerManager eventBus;

    public UsersListPresenterImpl(EditUserDialogBoxView.ActionDelegate presenter, final UsersListView usersListView,
                                  HandlerManager eventBus) {
        this.editUserDialogBoxPresenter = presenter;
        this.usersListView = usersListView;
        this.usersListView.setDelegate(this);
        this.eventBus = eventBus;
        this.users = new ArrayList<>(temp);

        callBackForAddUser = new UserChangedCallBack() {
            @Override
            public void onChanged(User user) {
                users.add(new User(user.getFirstName(), user.getLastName(), user.getAddress()));
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
        editUserDialogBoxPresenter.onShowDialog(null, callBackForAddUser);
    }

    @Override
    public void onEditButtonClicked() {
        if (selectedUser != null) {
            editUserDialogBoxPresenter.onShowDialog(selectedUser, callBackForEditUser);
        } else {
            Window.alert("You nothing selected!");
        }
    }
}
