package com.codenvy.employee.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

import javax.xml.soap.Text;

/**
 * Created by Andrienko Alexander on 28.08.14.
 */
public interface EmployeeDataResource extends ClientBundle {

    static final EmployeeDataResource INSTANCE = GWT.create(EmployeeDataResource.class);

    @ClientBundle.Source("com/codenvy/employee/css/EmployeePersonalData.css")
    EmployDataStyle employDataStyle();

    @ClientBundle.Source("com/codenvy/employee/img/buildings.jpg")
    ImageResource imgBuildings();

    @ClientBundle.Source("com/codenvy/employee/text/EmployeeTable")
    TextResource textEmployeeTable();

    @ClientBundle.Source("com/codenvy/employee/text/CompanyInfo")
    TextResource textCompanyInfo();
}
