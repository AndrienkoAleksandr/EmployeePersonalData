import com.codenvy.employee.client.EmployeeDataConstants;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.entity.Note;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.event.RedirectToPageInfoEvent;
import com.codenvy.employee.client.note.NoteDialogPresenter;
import com.codenvy.employee.client.table.NoteChangedCallBack;
import com.codenvy.employee.client.table.UserChangedCallBack;
import com.codenvy.employee.client.table.UsersListPresenter;
import com.codenvy.employee.client.table.UsersListView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Andrienko Alexander on 05.09.14.
 * This class test class com.codenvy.employee.client.table.UsersListPresenter.java
 */
@GwtModule("com.codenvy.employee.EmployeeData")
public class UsersListPresenterTest extends GwtTestWithMockito {
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

    @Mock
    private EmployeeDataConstants constants;

    @Mock
    private NoteDialogPresenter noteDialogPresenter;

    @Mock
    private Note note;

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

        when(constants.noneSelectedUserWarning()).thenReturn("You nothing selected!!!");

        usersListPresenter.onEditButtonClicked();
        verify(dialogBoxPresenter, never()).showDialog(any(User.class), any(UserChangedCallBack.class));
        verify(constants).noneSelectedUserWarning();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testOnAddButtonClicked() {

        ArgumentCaptor<List> usersCapture = ArgumentCaptor.forClass(List.class);
        doNothing().when(usersView).setUsers(usersCapture.capture());

        usersListPresenter.go(container);

        users = ((List<User>) usersCapture.getValue());
        reset(usersView);

        int amountUsersBeforeAdding = users.size();

        usersListPresenter.onSelectedUser(user);

        ArgumentCaptor<UserChangedCallBack> userCapture = ArgumentCaptor.forClass(UserChangedCallBack.class);

        usersListPresenter.onAddButtonClicked();

        verify(dialogBoxPresenter).showDialog(any(User.class), userCapture.capture());

        userCapture.getValue().onChanged(user);

        verify(dialogBoxPresenter).showDialog(any(User.class), any(UserChangedCallBack.class));

        verify(usersView).setUsers(anyListOf(User.class));

        assertTrue(users.contains(user));

        assertEquals(amountUsersBeforeAdding + 1, users.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testOnDeleteButtonClickedCheckSetUsers() {
        //get users
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                users = (List<User>) invocationOnMock.getArguments()[0];
                return null;
            }
        }).when(usersView).setUsers(anyListOf(User.class));

        usersListPresenter.go(container);

        //add new user for deleting
        final User userForDeleting = new User("testName", "testLastName", "testAddress");

        doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                UserChangedCallBack callBack = (UserChangedCallBack) invocationOnMock.getArguments()[1];
                callBack.onChanged(userForDeleting);
                return null;
            }
        }).when(dialogBoxPresenter).showDialog(any(User.class), any(UserChangedCallBack.class));

        usersListPresenter.onAddButtonClicked();

        reset(usersView);

        int amountUsersBeforeDeleting = users.size();

        //delete user
        usersListPresenter.onSelectedUser(userForDeleting);

        usersListPresenter.onDeleteButtonClicked();

        verify(usersView).setUsers(anyListOf(User.class));

        assertFalse(users.contains(userForDeleting));

        assertEquals(amountUsersBeforeDeleting - 1, users.size());
    }

    @Test
    public void testOnNoteButtonClickedWhenSelectedUserNotNull() {
        usersListPresenter.onSelectedUser(user);

        ArgumentCaptor<NoteChangedCallBack> noteChangedCallBackCaptor
                = ArgumentCaptor.forClass(NoteChangedCallBack.class);

        usersListPresenter.onNoteButtonClicked();

        verify(noteDialogPresenter).showDialog(any(Note.class), noteChangedCallBackCaptor.capture());

        noteChangedCallBackCaptor.getValue().onChangedNote(note);

        verify(user).setNote(note);
    }

    @Test
    public void testOnNoteButtonClickedWhenSelectedUserNull() {
        usersListPresenter.onSelectedUser(null);

        usersListPresenter.onNoteButtonClicked();

        verify(noteDialogPresenter, never()).showDialog(any(Note.class), any(NoteChangedCallBack.class));
    }
}
