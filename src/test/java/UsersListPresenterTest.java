import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.table.UserChangedCallBack;
import com.codenvy.employee.client.table.UsersListPresenter;
import com.codenvy.employee.client.table.UsersListView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Andrienko Alexander on 05.09.14.
 * This class test class com.codenvy.employee.client.table.UsersListPresenter.java
 */
@GwtModule("com.codenvy.employee.EmployeeData")
public class UsersListPresenterTest extends GwtTestWithMockito {
    @Mock
    private UsersListView usersListViewMock;

    @Mock
    private EventBus eventBusMock;

    @Mock
    private HasWidgets containerMock;

    @Mock
    private User userMock;

    @Mock
    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    @InjectMocks
    private UsersListPresenter usersListPresenter;

    @Test
    public void testGoMockCheckMethodClearOfWidgets() {
        usersListPresenter.go(containerMock);

        verify(usersListViewMock).setUsers(anyListOf(User.class));
        verify(containerMock).clear();
        verify(usersListViewMock).asWidget();
        verify(containerMock).add(eq(usersListViewMock.asWidget()));
    }

    @Test
    public void testOnInfoLinkClicked() {
        usersListPresenter.onInfoLinkClicked();

        verify(eventBusMock).fireEvent(any(RedirectToPageInfoEvent.class));
    }

    @Test
    public void testOnDeleteButtonClickedCheckSetUsers() {
        usersListPresenter.onDeleteButtonClicked();

        verify(usersListViewMock).setUsers(anyListOf(User.class));
    }

    @Test
    public void testOnEditButtonClickedWithSelectedUserNotNull() {
        usersListPresenter.onSelectedUser(userMock);

        final UserChangedCallBack[] callBack = new UserChangedCallBack[1];

        doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                callBack[0] = (UserChangedCallBack) invocationOnMock.getArguments()[1];
                callBack[0] = spy(callBack[0]);
                callBack[0].onChanged(userMock);

                return null;
            }
        }).when(editUserDialogBoxPresenter).showDialog(any(User.class), Mockito.isA(UserChangedCallBack.class));

        usersListPresenter.onEditButtonClicked();

        verify(callBack[0]).onChanged(userMock);
    }

    @Test
    public void testOnEditButtonClickedWithSelectedUserNull() {
        usersListPresenter.onSelectedUser(null);

        final UserChangedCallBack[] callBack = new UserChangedCallBack[1];

        doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                callBack[0] = (UserChangedCallBack) invocationOnMock.getArguments()[1];

                return null;
            }
        }).when(editUserDialogBoxPresenter).showDialog(any(User.class), Mockito.isA(UserChangedCallBack.class));

        usersListPresenter.onEditButtonClicked();

        assertEquals(callBack[0], null);
    }

    @Test
    public void testOnAddButtonClickedWithSelectedUserNotNull() {
        usersListPresenter.onSelectedUser(userMock);

        final UserChangedCallBack[] callBack = new UserChangedCallBack[1];

        doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                callBack[0] = (UserChangedCallBack) invocationOnMock.getArguments()[1];
                callBack[0] = spy(callBack[0]);
                callBack[0].onChanged(userMock);

                return null;
            }
        }).when(editUserDialogBoxPresenter).showDialog(any(User.class), Mockito.isA(UserChangedCallBack.class));

        usersListPresenter.onAddButtonClicked();

        verify(callBack[0]).onChanged(userMock);
    }

    @Test
    public void testOnAddButtonClickedWithSelectedUserNull() {
        usersListPresenter.onSelectedUser(null);

        final UserChangedCallBack[] callBack = new UserChangedCallBack[1];

        doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                callBack[0] = (UserChangedCallBack) invocationOnMock.getArguments()[1];
                callBack[0] = spy(callBack[0]);
                callBack[0].onChanged(userMock);

                return null;
            }
        }).when(editUserDialogBoxPresenter).showDialog(any(User.class), Mockito.isA(UserChangedCallBack.class));

        usersListPresenter.onAddButtonClicked();

        verify(callBack[0]).onChanged(userMock);
    }


}
