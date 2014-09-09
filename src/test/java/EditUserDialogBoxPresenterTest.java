import com.codenvy.employee.client.EmployeeDataConstants;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.table.UserChangedCallBack;
import com.codenvy.employee.client.table.UsersListPresenter;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Andrienko Alexander on 05.09.14.
 * This is test for class com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter.java
 */
@GwtModule("com.codenvy.employee.EmployeeData")
public class EditUserDialogBoxPresenterTest extends GwtTestWithMockito {
    @Mock
    private EditUserDialogBoxView dialogBoxViewMock;

    @Mock
    private User realUserForEditMock;

    @Mock
    EmployeeDataConstants constantsMock;

    @Mock
    private  UserChangedCallBack userChangedCallBackMock;

    @Mock
    private UsersListPresenter usersListPresenterMock;

    @InjectMocks
    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    @Test
    public void testShowDialogCheckTextForTextBoxWhenUserNull() {
        editUserDialogBoxPresenter.showDialog(null, userChangedCallBackMock);

        verify(dialogBoxViewMock).setText(anyString());
        verify(dialogBoxViewMock).setFirstName("");
        verify(dialogBoxViewMock).setLastName("");
        verify(dialogBoxViewMock).setAddress("");
        verify(dialogBoxViewMock).showDialog();
    }

    @Test
    public void testShowDialogCheckTextForTextBoxWhenUserNotNull() {
        editUserDialogBoxPresenter.showDialog(new User("Ivan", "White", "Address"), userChangedCallBackMock);

        verify(dialogBoxViewMock).setText(anyString());
        verify(dialogBoxViewMock).setFirstName("Ivan");
        verify(dialogBoxViewMock).setLastName("White");
        verify(dialogBoxViewMock).setAddress("Address");
        verify(dialogBoxViewMock).showDialog();
    }

    @Test
    public void testOnOkButtonClickedCallBackNull() {
        editUserDialogBoxPresenter.showDialog(realUserForEditMock, null);

        editUserDialogBoxPresenter.onOkButtonClicked();

        verify(userChangedCallBackMock, never()).onChanged(any(User.class));
        verify(dialogBoxViewMock).hideDialog();
    }

    @Test
     public void testOnOkButtonClickedCallBackNotNull() {
        editUserDialogBoxPresenter.showDialog(realUserForEditMock, userChangedCallBackMock);

        editUserDialogBoxPresenter.onOkButtonClicked();

        verify(userChangedCallBackMock).onChanged(any(User.class));
        verify(dialogBoxViewMock).hideDialog();
    }

    @Test
    public void testOnCancelButtonClicked() {
        editUserDialogBoxPresenter.onCancelButtonClicked();

        verify(dialogBoxViewMock).hideDialog();
    }
}
