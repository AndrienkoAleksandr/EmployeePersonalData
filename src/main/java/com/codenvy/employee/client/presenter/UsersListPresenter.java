package com.codenvy.employee.client.presenter;

import com.codenvy.employee.client.entity.User;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Panel;

import java.util.List;

/**
 * Created by logarifm on 21.08.14.
 */
public interface UsersListPresenter {
     void go(HasWidgets container);
    void deleteUser();
    void showDialog();
}
