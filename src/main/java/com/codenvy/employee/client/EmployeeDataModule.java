package com.codenvy.employee.client;

import com.codenvy.employee.client.gin.Injector;
import com.codenvy.employee.client.gin.InjectorModule;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class EmployeeDataModule implements EntryPoint {

    public void onModuleLoad() {
        Injector injector = GWT.create(Injector.class);
        ApplicationController applicationController = injector.getApplicationController();
        applicationController.bind();

        applicationController.go(RootLayoutPanel.get());
    }
}
