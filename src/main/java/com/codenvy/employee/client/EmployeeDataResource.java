package com.codenvy.employee.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

/**
 * Created by logarifm on 28.08.14.
 */
public interface EmployeeDataResource extends ClientBundle {

    static final EmployeeDataResource INSTANCE = GWT.create(EmployeeDataResource.class);

    @ClientBundle.Source("com/codenvy/employee/css/EmployeePersonalData.css")
    EmployDataStyle employDataStyle();
}
