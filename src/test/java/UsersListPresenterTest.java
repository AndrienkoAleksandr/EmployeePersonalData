import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.table.UserChangedCallBack;
import com.codenvy.employee.client.table.UsersListPresenter;
import com.codenvy.employee.client.table.UsersListView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Andrienko Alexander on 05.09.14.
 * This class test class com.codenvy.employee.client.table.UsersListPresenter.java
 */
@RunWith(MockitoJUnitRunner.class)
public class UsersListPresenterTest {
    @Mock
    private UsersListView usersView;

    @Mock
    private EventBus eventBus;

    @Mock
    private HasWidgets container;

    @Mock
    private User user;

    @Mock
    private EditUserDialogBoxPresenter dialogBoxPresenter;

    @InjectMocks
    private UsersListPresenter usersListPresenter;

    private List<User> users;

    @Before
    public void setUp() {
        users = null;
    }

    @Test
    public void testGoMockCheckMethodClearOfWidgets() {
        usersListPresenter.go(container);

        verify(usersView).setUsers(anyListOf(User.class));

        verify(container).clear();
        verify(usersView).asWidget();
        verify(container).add(eq(usersView.asWidget()));
    }

    @Test
    public void testOnInfoLinkClicked() {
        usersListPresenter.onInfoLinkClicked();

        verify(eventBus).fireEvent(any(RedirectToPageInfoEvent.class));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testOnDeleteButtonClickedCheckSetUsers() {

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                users = (List<User>) invocationOnMock.getArguments()[0];
                return null;
            }
        }).when(usersView).setUsers(anyListOf(User.class));

        usersListPresenter.go(container);
        reset(usersView);

        User userForDeleting = new User("testName", "testLastName", "testAddress");

        users.add(userForDeleting);

        int amountUsersBeforeDeleting = users.size();

        usersListPresenter.onSelectedUser(userForDeleting);

        usersListPresenter.onDeleteButtonClicked();

        verify(usersView).setUsers(anyListOf(User.class));

        assertEquals(amountUsersBeforeDeleting - 1, users.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testOnAddButtonClickedWithSelectedUserNotNull() {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                users = (List<User>) invocationOnMock.getArguments()[0];
                return null;
            }
        }).when(usersView).setUsers(anyListOf(User.class));

        usersListPresenter.go(container);
        reset(usersView);

        int amountUsersBeforeAdding = users.size();

        usersListPresenter.onSelectedUser(user);

        doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                UserChangedCallBack callBack = (UserChangedCallBack) invocationOnMock.getArguments()[1];
                callBack.onChanged(user);

                return null;
            }
        }).when(dialogBoxPresenter).showDialog(any(User.class), any(UserChangedCallBack.class));

        usersListPresenter.onAddButtonClicked();

        verify(dialogBoxPresenter).showDialog(any(User.class), any(UserChangedCallBack.class));
        verify(usersView).setUsers(anyListOf(User.class));

        assertEquals(amountUsersBeforeAdding + 1, users.size());

    }

    @Test
    public void testOnEditButtonClickedWithSelectedUserNotNull() {
        User userTest = new User("test", "test", "test");
        usersListPresenter.onSelectedUser(userTest);

        doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                UserChangedCallBack callBack = (UserChangedCallBack) invocationOnMock.getArguments()[1];
                callBack.onChanged(new User("testName", "testLastName", "testAddress"));

                return null;
            }
        }).when(dialogBoxPresenter).showDialog(any(User.class), any(UserChangedCallBack.class));

        usersListPresenter.onEditButtonClicked();

        assertEquals(userTest.getFirstName(), "testName");
        assertEquals(userTest.getLastName(), "testLastName");
        assertEquals(userTest.getAddress(), "testAddress");
        verify(usersView).setUsers(anyListOf(User.class));
    }

    @Test
    public void testOnEditButtonClickedWithSelectedUserNull() {
        usersListPresenter.onSelectedUser(null);

        usersListPresenter.onEditButtonClicked();

        verify(dialogBoxPresenter, never()).showDialog(any(User.class), any(UserChangedCallBack.class));
    }
}
