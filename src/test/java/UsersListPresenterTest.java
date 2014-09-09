import com.codenvy.employee.client.EmployeeDataConstants;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.table.UserChangedCallBack;
import com.codenvy.employee.client.table.UsersListPresenter;
import com.codenvy.employee.client.table.UsersListView;
import com.google.gwt.event.shared.SimpleEventBus;
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
    private UsersListView usersListView;

    @Spy
    private SimpleEventBus eventBus;

    @Mock
    private HasWidgets container;

    @Spy
    private User realUser;

    @Spy
    private User someEmptyUser;

    @Mock
    private EditUserDialogBoxView editUserDialogBoxView;

    @Mock
    private EmployeeDataConstants constants;

    @Mock
    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    @InjectMocks
    private UsersListPresenter usersListPresenter;

    @Mock
    UserChangedCallBack callBack;

    @Test
    public void testGoMockCheckMethodClearOfWidgets() {
        usersListPresenter.go(container);

        verify(usersListView).setUsers(anyListOf(User.class));
        verify(container).clear();
        verify(usersListView).asWidget();
        verify(container).add(eq(usersListView.asWidget()));
    }

    @Test
    public void testOnInfoLinkClicked() {
        usersListPresenter.onInfoLinkClicked();

        verify(eventBus).fireEvent(any(RedirectToPageInfoEvent.class));
    }

    @Test
    public void testOnDeleteButtonClickedCheckSetUsers() {
        usersListPresenter.onDeleteButtonClicked();

        verify(usersListView).setUsers(anyListOf(User.class));
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
        usersListPresenter.onSelectedUser(someEmptyUser);
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

    @Test
    public void testOnEditButtonClickedWithNotNullSelectedUser() {

        doAnswer(new Answer<Object>() {
            public Void answer(InvocationOnMock invocation) {
                verify((UserChangedCallBack) invocation.getArguments()[1]).onChanged(any(User.class));
                return null;
            }
        }).when(editUserDialogBoxPresenter).showDialog(any(User.class), any(UserChangedCallBack.class));

        usersListPresenter.onAddButtonClicked();
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
