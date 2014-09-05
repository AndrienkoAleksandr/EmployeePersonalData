package com.codenvy.employee.client;

import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.table.UserChangedCallBack;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.*;

/**
 * Created by logarifm on 05.09.14.
 */
public class EditUserDialogBoxPresenterTest {

    private EditUserDialogBoxView dialogBoxView;

    private EmployeeDataConstants constants;

    private User emptyUser;

    private User realUserForEdit;

    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    private final String firstName = "Ivan";

    private final String lastName = "Vigovsky";

    private final String address = "Chernigiv";

    private  UserChangedCallBack userChangedCallBack;

    @Before
    public void init() {
        dialogBoxView = mock(EditUserDialogBoxView.class);
        constants = mock(EmployeeDataConstants.class);
        emptyUser = new User();
        userChangedCallBack = mock(UserChangedCallBack.class);
        realUserForEdit = new User(firstName, lastName, address);
        editUserDialogBoxPresenter = new EditUserDialogBoxPresenter(dialogBoxView, constants, emptyUser);
    }

    @Test
    public void showDialogUserForEditNull() {
        editUserDialogBoxPresenter.showDialog(null, userChangedCallBack);
        verify(dialogBoxView).showDialog();
    }

    @Test
    public void showDialogUserForEditNotNull() {
        editUserDialogBoxPresenter.showDialog(realUserForEdit, userChangedCallBack);
        verify(dialogBoxView).showDialog();
    }

    @Test
    public void testOnOkButtonClickedCheckCallBack() {
        editUserDialogBoxPresenter.onOkButtonClicked();
        when(dialogBoxView.getFirstName()).thenReturn(firstName);
        when(dialogBoxView.getLastName()).thenReturn(lastName);
        when(dialogBoxView.getAddress()).thenReturn(address);
        verify(userChangedCallBack).onChanged(realUserForEdit);
    }

//    @Test
//    public void testOnOkButtonClickedCheckHideDialogBox() {
//        editUserDialogBoxPresenter.onOkButtonClicked();
//        verify(dialogBoxView).hideDialog();
//    }

    @Test
    public void testOnCancelButtonClicked() {
        editUserDialogBoxPresenter.onCancelButtonClicked();
        verify(dialogBoxView).hideDialog();
    }
}
