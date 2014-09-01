package com.codenvy.employee.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class EmployeeDataModule implements EntryPoint {

    public void onModuleLoad() {
        HandlerManager simpleEventBus = new HandlerManager(null);

        ApplicationController applicationController = new ApplicationController(simpleEventBus);
        applicationController.bind();
        applicationController.go(RootLayoutPanel.get());
    }
}
