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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Andrienko Alexander on 05.09.14.
 * This class test class com.codenvy.employee.client.table.UsersListPresenter.java
 */
@RunWith(MockitoJUnitRunner.class)
public class UsersListPresenterTest {
    @Mock
    private UsersListView usersListView;

    @Spy
    private SimpleEventBus eventBus;

    @Mock
    private HasWidgets container;

    @Spy
    private User realUser;

    @Spy
    User someEmptyUser;

    @Mock
    EditUserDialogBoxView editUserDialogBoxView;

    @Mock
    EmployeeDataConstants constants;

    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    private UsersListPresenter usersListPresenter;

    @Before
    public void init(){
        editUserDialogBoxPresenter =
                spy(new EditUserDialogBoxPresenter(editUserDialogBoxView, constants, someEmptyUser));

        usersListPresenter = new UsersListPresenter(editUserDialogBoxPresenter, usersListView, eventBus);
    }

    @Test
    public void testGoMockCheckMethodClearOfWidgets() {
        usersListPresenter.go(container);

        verify(container).clear();
    }

    @Test
    public void testGoMockCheckMethodAddOfWidgets() {
        usersListPresenter.go(container);

        verify(container).add(usersListView.asWidget());
    }

    @Test
    @SuppressWarnings("unchecked")
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
    @SuppressWarnings("unchecked")
    public void testOnDeleteButtonClickedCheckSetUsers() {
        usersListPresenter.onDeleteButtonClicked();

        verify(usersListView).setUsers(any(List.class));
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
}
