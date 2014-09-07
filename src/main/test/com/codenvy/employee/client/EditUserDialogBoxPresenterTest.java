package com.codenvy.employee.client;

import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.table.UserChangedCallBack;
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
    private EditUserDialogBoxView dialogBoxView;

    @Mock
    private User realUserForEdit;

    @Mock
    EmployeeDataConstants constants;

    @Mock
    private  UserChangedCallBack userChangedCallBack;

    @InjectMocks
    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    @Test
    public void showDialogCheckUserForEditNull() {
        editUserDialogBoxPresenter.showDialog(null, userChangedCallBack);

        verify(dialogBoxView).showDialog();
    }

    @Test
    public void showDialogCheckUserForEditNotNull() {
        editUserDialogBoxPresenter.showDialog(realUserForEdit, userChangedCallBack);

        verify(dialogBoxView).showDialog();
    }

    @Test
    public void showDialogCheckUserCheckSetTextsToFields() {
        editUserDialogBoxPresenter.showDialog(new User("Ivan", "Dron", "Address"), userChangedCallBack);

        verify(dialogBoxView).setText(anyString());
        verify(dialogBoxView).setFirstName("Ivan");
        verify(dialogBoxView).setLastName("Dron");
        verify(dialogBoxView).setAddress("Address");
    }

    @Test
    public void showDialogCheckUserCheckSetAnyTextsToFields() {
        editUserDialogBoxPresenter.showDialog(new User("Ivan", "Dron", "Address"), userChangedCallBack);

        verify(dialogBoxView).setText(anyString());
        verify(dialogBoxView).setFirstName(anyString());
        verify(dialogBoxView).setLastName(anyString());
        verify(dialogBoxView).setAddress(anyString());
    }


    @Test
    public void testOnOkButtonClickedCheckCallBack() {
        editUserDialogBoxPresenter.showDialog(realUserForEdit, userChangedCallBack);
        editUserDialogBoxPresenter.onOkButtonClicked();

        verify(userChangedCallBack).onChanged(any(User.class));
    }

    @Test
    public void testOnOkButtonClickedCheckCallBackNull() {
        editUserDialogBoxPresenter.showDialog(realUserForEdit, null);
        editUserDialogBoxPresenter.onOkButtonClicked();

        verify(userChangedCallBack, never()).onChanged(any(User.class));
    }

    @Test
     public void testOnOkButtonClickedCheckHideDialogBox() {
        editUserDialogBoxPresenter.showDialog(realUserForEdit, userChangedCallBack);
        editUserDialogBoxPresenter.onOkButtonClicked();

        verify(dialogBoxView).hideDialog();
    }

    @Test
    public void testOnCancelButtonClicked() {
        editUserDialogBoxPresenter.onCancelButtonClicked();
        verify(dialogBoxView).hideDialog();
    }
}
