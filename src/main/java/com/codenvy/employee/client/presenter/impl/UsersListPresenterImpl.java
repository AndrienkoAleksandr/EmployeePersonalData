package com.codenvy.employee.client.presenter.impl;

import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.event.RedirectToListPageEvent;
import com.codenvy.employee.client.event.RedirectToListPageEventHandler;
import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.presenter.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.presenter.UsersListPresenter;
import com.codenvy.employee.client.view.CallBack;
import com.codenvy.employee.client.view.UsersListView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrienko Alexander  on 21.08.14.
 */
public class UsersListPresenterImpl implements UsersListPresenter {

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

    private final EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    private final List<User> users;

    private final CallBack callBackForAddUser;

    private final CallBack callBackForEditUser;

    private final EventBus eventBus;

    private HasWidgets container;

    public UsersListPresenterImpl(EditUserDialogBoxPresenter presenter, final UsersListView usersListView, EventBus eventBus) {
        this.editUserDialogBoxPresenter = presenter;
        this.usersListView = usersListView;
        this.eventBus = eventBus;
        this.users = new ArrayList<>(temp);

        //todo
        eventBus.addHandler(RedirectToListPageEvent.TYPE, new RedirectToListPageEventHandler() {
            @Override
            public void redirectToPageList(RedirectToListPageEvent redirectToListPageEvent) {
                go(container);
            }
        });

        callBackForAddUser = new CallBack() {
            @Override
            public void onChanged(User user) {
                users.add(new User(user.getFirstName(), user.getLastName(), user.getAddress()));
                usersListView.setUsers(users);
            }
        };

        callBackForEditUser = new CallBack() {
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
        this.container = container;
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
        History.newItem("list");
        eventBus.fireEvent(new RedirectToPageInfoEvent(container));
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
