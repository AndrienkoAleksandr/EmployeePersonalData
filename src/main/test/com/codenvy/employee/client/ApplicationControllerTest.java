//package com.codenvy.employee.client;
//
//import com.codenvy.employee.client.mvp.Presenter;
//import com.google.gwt.event.logical.shared.ValueChangeEvent;
//import com.google.gwt.event.shared.SimpleEventBus;
//import com.google.gwt.user.client.ui.HasWidgets;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Spy;
//import org.mockito.runners.MockitoJUnitRunner;
//
///**
// * Created by Andrienko Alexander on 07.09.2014.
// */
//@RunWith(MockitoJUnitRunner.class)
//public class ApplicationControllerTest {
//    @Spy
//    private SimpleEventBus simpleEventBus;
//
//    @Mock
//    private EmployeeDataResource employeeDataResource;
//
//    @Mock
//    private Presenter infoPagePresenter;
//
//    @Mock
//    private Presenter userListPresenter;
//
//    @InjectMocks
//    private ApplicationController appController;
//
//    @Mock
//    private HasWidgets container;
//
//    @Mock
//    private ValueChangeEvent valueChangeEvent;
//
//    @Test
//    @SuppressWarnings("unchecked")
//    public void testOnValueChange() {
////        when(valueChangeEvent.getValue()).thenReturn("info");
////
////        appController.onValueChange(valueChangeEvent);
////        verify(infoPagePresenter).go(container);
//    }
//}
