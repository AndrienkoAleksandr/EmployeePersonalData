package com.codenvy.employee.client;

import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.table.UserChangedCallBack;
import com.codenvy.employee.client.table.UsersListPresenter;
import com.codenvy.employee.client.table.UsersListView;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by logarifm on 05.09.14.
 */
public class UsersListPresenterTest {

    private UsersListPresenter usersListPresenter;

    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    private UsersListView usersListView;

    private SimpleEventBus eventBus;

    private HasWidgets container;

    private User realUser;

    @Before
    public void init(){

        EditUserDialogBoxView editUserDialogBoxView = mock(EditUserDialogBoxView.class);

        EmployeeDataConstants constants = mock(EmployeeDataConstants.class);

        User someEmptyUser = spy(new User());

        editUserDialogBoxPresenter =
                spy(new EditUserDialogBoxPresenter(editUserDialogBoxView,
                        constants, someEmptyUser));

        eventBus = spy(new SimpleEventBus());

        usersListView = mock(UsersListView.class);

        container = mock(HasWidgets.class);

        usersListPresenter = new UsersListPresenter(editUserDialogBoxPresenter,
                usersListView, eventBus);

        realUser = new User("firstName", "SecondName", "Address");
    }

    @Test
    public void testGoMockClear() {
        usersListPresenter.go(container);

        verify(container).clear();
    }

    @Test
    public void testGoMockAdd() {
        usersListPresenter.go(container);

        verify(container).add(usersListView.asWidget());
    }

    @Test
    public void testGoMockSetUsers() {
        usersListPresenter.go(container);

        verify(usersListView).setUsers(any(List.class));
    }


    @Test
    public void testOnInfoLinkClicked() {
        usersListPresenter.onInfoLinkClicked();

        verify(eventBus).fireEvent(any(RedirectToPageInfoEvent.class));
    }

    @Test
    public void testOnDeleteButtonClickedSetUsers() {
        usersListPresenter.onDeleteButtonClicked();

        verify(usersListView).setUsers(any(List.class));
    }

    @Test
    public void onEditButtonClickedUserNotNull() {
        doCallRealMethod().when(editUserDialogBoxPresenter).showDialog(any(User.class), any(UserChangedCallBack.class));

        usersListPresenter.onSelectedUser(realUser);
        usersListPresenter.onEditButtonClicked();

        verify(editUserDialogBoxPresenter).showDialog(any(User.class), any(UserChangedCallBack.class));
    }

    @Test
    public void onEditButtonClickedUserNull() {
        doCallRealMethod().when(editUserDialogBoxPresenter).showDialog(any(User.class), any(UserChangedCallBack.class));

        usersListPresenter.onSelectedUser(null);
        usersListPresenter.onEditButtonClicked();

        verify(editUserDialogBoxPresenter, times(0)).showDialog(any(User.class), any(UserChangedCallBack.class));
    }

    @Test
    public void testOnAddButtonClickedSelectedUserNull() {
        doCallRealMethod().when(editUserDialogBoxPresenter).showDialog(isNull(User.class), any(UserChangedCallBack.class));

        usersListPresenter.onSelectedUser(null);
        usersListPresenter.onAddButtonClicked();

        verify(editUserDialogBoxPresenter).showDialog(isNull(User.class), any(UserChangedCallBack.class));
    }

    @Test
    public void testOnAddButtonClickedSelectedUserNotNull() {
        doCallRealMethod().when(editUserDialogBoxPresenter).
                showDialog(isNull(User.class), any(UserChangedCallBack.class));

        usersListPresenter.onSelectedUser(realUser);
        usersListPresenter.onAddButtonClicked();

        verify(editUserDialogBoxPresenter).showDialog(isNull(User.class), any(UserChangedCallBack.class));
    }
}
