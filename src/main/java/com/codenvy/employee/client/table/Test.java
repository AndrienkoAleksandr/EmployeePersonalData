package com.codenvy.employee.client.table;

import com.codenvy.employee.client.EmployeeDataConstants;
import com.google.gwt.core.client.GWT;

/**
 * Created by logarifm on 03.09.14.
 */
public class Test {
    EmployeeDataConstants getEmployeeDataConstants() {
        return GWT.create(EmployeeDataConstants.class);
    }
}
