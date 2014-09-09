package client.test;

import com.codenvy.employee.client.ApplicationController;
import com.codenvy.employee.client.EmployeeDataResource;
import com.codenvy.employee.client.mvp.Presenter;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import static com.codenvy.employee.client.EmployeeDataResource.EmployDataStyle;
import static org.mockito.Mockito.*;

/**
 * Created by Andrienko Alexander on 07.09.2014.
 */
@GwtModule("com.codenvy.employee.EmployeeData")
public class GwtTestApplicationController extends GwtTestWithMockito {

    @Spy
    private SimpleEventBus simpleEventBus;

    @Mock
    private EmployeeDataResource employeeDataResource;

    @Mock
    private HasWidgets container;

    @Mock
    private ValueChangeEvent valueChangeEvent;

    @Mock
    private Presenter usersListPresenter;

    @Mock
    private Presenter userPageInfoPresenter;


    private ApplicationController appController;

    @Mock
    private EmployDataStyle style;

    @Before
    public void init() {

        when(employeeDataResource.employDataStyle()).thenReturn(style);

        appController = new ApplicationController(simpleEventBus, employeeDataResource,
                userPageInfoPresenter, usersListPresenter);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testOnValueChangeWhenGetValueInfo() {

        when(valueChangeEvent.getValue()).thenReturn("info");

        appController.go(container);
        appController.onValueChange(valueChangeEvent);

        verify(userPageInfoPresenter, times(1)).go(container);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testOnValueChangeWhenGetValueList() {

        when(valueChangeEvent.getValue()).thenReturn("list");

        appController.go(container);
        appController.onValueChange(valueChangeEvent);

        verify(usersListPresenter, times(2)).go(container);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testOnValueChangeScriptValue() {

        when(valueChangeEvent.getValue()).thenReturn("list").
                thenReturn("info").
                thenReturn("list").
                thenReturn("info").
                thenReturn("info");

        appController.go(container);
        reset(usersListPresenter);

        appController.onValueChange(valueChangeEvent);

        verify(usersListPresenter, times(1)).go(container);

        appController.onValueChange(valueChangeEvent);

        verify(userPageInfoPresenter, times(1)).go(container);

        appController.onValueChange(valueChangeEvent);
        verify(usersListPresenter, times(2)).go(container);

        appController.onValueChange(valueChangeEvent);
        verify(userPageInfoPresenter, times(2)).go(container);

        appController.onValueChange(valueChangeEvent);
        verify(userPageInfoPresenter, times(3)).go(container);
    }
}
