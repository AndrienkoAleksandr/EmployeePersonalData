package client.test;

import com.codenvy.employee.client.ApplicationController;
import com.codenvy.employee.client.EmployeeDataConstants;
import com.codenvy.employee.client.EmployeeDataResource;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxViewImpl;
import com.codenvy.employee.client.entity.User;
import com.codenvy.employee.client.info.PageInfoPresenter;
import com.codenvy.employee.client.info.PageInfoViewImpl;
import com.codenvy.employee.client.mvp.Presenter;
import com.codenvy.employee.client.table.UsersListPresenter;
import com.codenvy.employee.client.table.UsersListView;
import com.codenvy.employee.client.table.UsersListViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Andrienko Alexander on 08.09.14.
 */
public class GWTTestCaseApplicationController extends GWTTestCase {

    private SimpleEventBus simpleEventBus;

    private EmployeeDataResource employeeDataResource;

    private EmployeeDataConstants employeeDataConstants;

    private Presenter usersListPresenter;

    private Presenter userPageInfoPresenter;

    private EditUserDialogBoxView editUserDialogBoxView;

    private EditUserDialogBoxPresenter editUserDialogBoxPresenter;

    private UsersListView usersListView;

    private ApplicationController appController;


    @Before
    public void init() {
        employeeDataResource = GWT.create(EmployeeDataResource.class);
        employeeDataConstants = GWT.create(EmployeeDataConstants.class);
        simpleEventBus = GWT.create(SimpleEventBus.class);

        PageInfoViewImpl pageInfoView = new PageInfoViewImpl(employeeDataConstants,
                employeeDataResource,
                GWT.<PageInfoViewImpl.PageInfoViewUiBinder>create(PageInfoViewImpl.PageInfoViewUiBinder.class));

        userPageInfoPresenter = new PageInfoPresenter(pageInfoView, simpleEventBus);

        editUserDialogBoxView = new EditUserDialogBoxViewImpl(employeeDataConstants,
                GWT.<EditUserDialogBoxViewImpl.EditUserDialogBoxUI>create(EditUserDialogBoxViewImpl.EditUserDialogBoxUI.class));

        usersListView = new UsersListViewImpl(employeeDataConstants, employeeDataResource,
                GWT.<UsersListViewImpl.UsersListUiBinder>create(UsersListViewImpl.UsersListUiBinder.class));

        editUserDialogBoxPresenter = new EditUserDialogBoxPresenter(editUserDialogBoxView, employeeDataConstants, GWT.<User>create(User.class));

        usersListPresenter = new UsersListPresenter(editUserDialogBoxPresenter, usersListView, simpleEventBus);

        appController = new ApplicationController(simpleEventBus, employeeDataResource, userPageInfoPresenter, usersListPresenter);

        appController.go(RootLayoutPanel.get());

    }

    @Test
    public void testTest() {
        init();
        assertTrue(true);
    }

    @Override
    public String getModuleName() {
        return "EmployeeDataJUnit";
    }
}
