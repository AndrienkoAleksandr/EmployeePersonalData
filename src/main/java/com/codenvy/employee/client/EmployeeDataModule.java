package com.codenvy.employee.client;

import com.codenvy.employee.client.gin.Injector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class EmployeeDataModule implements EntryPoint {

    public void onModuleLoad() {
        ApplicationController applicationController = Injector.INSTANCE.getApplicationController();
        applicationController.bind();
        applicationController.go(RootLayoutPanel.get());
    }
}
