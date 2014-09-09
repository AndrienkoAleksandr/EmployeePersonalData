import com.codenvy.employee.client.EmployeeDataConstants;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
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
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.Assert.assertNotNull;
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

    @Spy
    private User realUser;

    @Mock
    private User someEmptyUserMock;

    @Mock
    private EditUserDialogBoxView editUserDialogBoxViewMock;

    @Mock
    private EmployeeDataConstants constantsMock;

    @Mock
    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    @Mock
    UserChangedCallBack callBack;

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

//    @Test
//    public void testOnAddButtonClickedWithAnySelectedUser() {
//
//        usersListPresenter.onAddButtonClicked();
//
//        doAnswer(new Answer() {
//            @Override
//            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
//                UserChangedCallBack callBack = (UserChangedCallBack) invocationOnMock.getArguments()[0];
//
//                verify(callBack, never()).onChanged(any(User.class));
//
//                return null;
//            }
//        }).when(editUserDialogBoxPresenter).showDialog(any(User.class), any(UserChangedCallBack.class));
//    }

    @Test
    public void testOnAddButtonClickedWithNullSelectedUser() {
        usersListPresenter.onSelectedUser(null);
        reset(editUserDialogBoxPresenter);

        ArgumentCaptor<UserChangedCallBack> callbackCaptor = ArgumentCaptor.forClass(UserChangedCallBack.class);

        doNothing().when(editUserDialogBoxPresenter).showDialog(any(User.class), callbackCaptor.capture());

        usersListPresenter.onAddButtonClicked();

        final UserChangedCallBack userChangedCallBack = spy(callbackCaptor.getValue());

        doNothing().when(userChangedCallBack).onChanged(any(User.class));

        assertNotNull(userChangedCallBack);

        doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                userChangedCallBack.onChanged(any(User.class));

                return null;
            }
        }).when(editUserDialogBoxPresenter).onOkButtonClicked();

        editUserDialogBoxPresenter.onOkButtonClicked();

        verify(userChangedCallBack).onChanged(any(User.class));
    }

    @Test
    public void testOnEditButtonClickedWithNullSelectedUser() {
        usersListPresenter.onSelectedUser(someEmptyUserMock);
        reset(editUserDialogBoxPresenter);

        ArgumentCaptor<UserChangedCallBack> callbackCaptor = ArgumentCaptor.forClass(UserChangedCallBack.class);

        doNothing().when(editUserDialogBoxPresenter).showDialog(any(User.class), callbackCaptor.capture());

        usersListPresenter.onEditButtonClicked();

        final UserChangedCallBack userChangedCallBack = spy(callbackCaptor.getValue());

        doNothing().when(userChangedCallBack).onChanged(any(User.class));

        assertNotNull(userChangedCallBack);

        doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                userChangedCallBack.onChanged(any(User.class));

                return null;
            }
        }).when(editUserDialogBoxPresenter).onOkButtonClicked();

        editUserDialogBoxPresenter.onOkButtonClicked();

        verify(userChangedCallBack).onChanged(any(User.class));
    }

    private ArgumentCaptor<UserChangedCallBack> callbackCaptor;

    private UserChangedCallBack changedCallBack;

    @Test
    public void testOnAddButtonClickedWithNotNullSelectedUser() {
        usersListPresenter.onSelectedUser(null);

       callbackCaptor = ArgumentCaptor.forClass(UserChangedCallBack.class);

        doAnswer(new Answer<Object>() {
            public Void answer(InvocationOnMock invocation) {
//                ((EditUserDialogBoxPresenter)invocation.getMock()).onOkButtonClicked();
                changedCallBack = spy(callbackCaptor.getValue());
                changedCallBack.onChanged(realUser);
                return null;
            }
        }).when(editUserDialogBoxPresenter).showDialog(any(User.class), callbackCaptor.capture());

        usersListPresenter.onAddButtonClicked();

        verify(changedCallBack).onChanged(any(User.class));

    }

    @Test
    public void testOnEditButtonClickedWithNotNullSelectedUser() {
        usersListPresenter.onSelectedUser(realUser);
//        usersListPresenter.onSelectedUser(null);

        callbackCaptor = ArgumentCaptor.forClass(UserChangedCallBack.class);

        doAnswer(new Answer<Object>() {
            public Void answer(InvocationOnMock invocation) {
//                ((EditUserDialogBoxPresenter)invocation.getMock()).onOkButtonClicked();
                changedCallBack = spy(callbackCaptor.getValue());
                changedCallBack.onChanged(realUser);
                return null;
            }
        }).when(editUserDialogBoxPresenter).showDialog(any(User.class), callbackCaptor.capture());

        usersListPresenter.onEditButtonClicked();

        verify(changedCallBack).onChanged(any(User.class));

    }

//    @Test
//    public void testOnEditButtonClickedWithSelectedUserNull() {
//        doAnswer(new Answer() {
//            @Override
//            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
//                UserChangedCallBack callBack = (UserChangedCallBack) invocationOnMock.getArguments()[0];
//
//                verify(callBack, never()).onChanged(any(User.class));
//
//                return null;
//            }
//        }).when(editUserDialogBoxPresenter).showDialog(isNull(User.class), any(UserChangedCallBack.class));
//    }
//
//    @Test
//    public void testOnEditButtonClickedWithSelectedUserNotNull() {
//        doAnswer(new Answer() {
//            @Override
//            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
//                UserChangedCallBack callBack = (UserChangedCallBack) invocationOnMock.getArguments()[0];
//
//                verify(callBack).onChanged(any(User.class));
//
//                return null;
//            }
//        }).when(editUserDialogBoxPresenter).showDialog(any(User.class), any(UserChangedCallBack.class));
//    }
}
