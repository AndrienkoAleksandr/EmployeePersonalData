import com.codenvy.employee.client.EmployeeDataConstants;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.table.UserChangedCallBack;
import com.codenvy.employee.client.table.UsersListPresenter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Andrienko Alexander on 05.09.14.
 * This is test for class com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter.java
 */
@RunWith(MockitoJUnitRunner.class)
public class EditUserDialogBoxPresenterTest {
    @Mock
    private EditUserDialogBoxView dialogView;

    @Mock
    private User realUserForEdit;

    @Mock
    EmployeeDataConstants constants;

    @Mock
    private UserChangedCallBack userChangedCallBack;

    @Mock
    private UsersListPresenter presenter;

    @InjectMocks
    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    @Test
    public void testShowDialogCheckTextForTextBoxWhenUserNull() {
        editUserDialogBoxPresenter.showDialog(null, userChangedCallBack);

        verify(dialogView).setText(anyString());
        verify(dialogView).setFirstName("");
        verify(dialogView).setLastName("");
        verify(dialogView).setAddress("");

        verify(dialogView).showDialog();
    }

    @Test
    public void testShowDialogCheckTextForTextBoxWhenUserNotNull() {
        editUserDialogBoxPresenter.showDialog(new User("Ivan", "White", "Address"), userChangedCallBack);

        verify(dialogView).setText(anyString());
        verify(dialogView).setFirstName("Ivan");
        verify(dialogView).setLastName("White");
        verify(dialogView).setAddress("Address");

        verify(dialogView).showDialog();
    }

    @Test
    public void testOnOkButtonClickedCallBackNull() {
        editUserDialogBoxPresenter.showDialog(realUserForEdit, null);

        editUserDialogBoxPresenter.onOkButtonClicked();

        verify(userChangedCallBack, never()).onChanged(any(User.class));
        verify(dialogView).hideDialog();
    }

    @Test
    public void testOnOkButtonClickedCallBackNotNull() {
        editUserDialogBoxPresenter.showDialog(realUserForEdit, userChangedCallBack);

        editUserDialogBoxPresenter.onOkButtonClicked();

        verify(userChangedCallBack).onChanged(any(User.class));
        verify(dialogView).hideDialog();
    }

    @Test
    public void testOnCancelButtonClicked() {
        editUserDialogBoxPresenter.onCancelButtonClicked();

        verify(dialogView).hideDialog();
    }
}