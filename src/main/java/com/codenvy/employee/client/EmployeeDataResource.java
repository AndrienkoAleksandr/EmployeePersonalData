package com.codenvy.employee.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

import static com.google.gwt.resources.client.ClientBundle.Source;

/**
 * Created by Andrienko Alexander on 28.08.14.
 */
public interface EmployeeDataResource extends ClientBundle {

    static final EmployeeDataResource INSTANCE = GWT.create(EmployeeDataResource.class);

    @Source("css/EmployeePersonalData.css")
    EmployDataStyle employDataStyle();

    @Source("img/buildings.jpg")
    ImageResource imgBuildings();

    @Source("text/EmployeeTable")
    TextResource textEmployeeTable();

    @Source("text/CompanyInfo")
    TextResource textCompanyInfo();

    public interface EmployDataStyle extends CssResource {
        String editButtonOfUserList();

        String cellStyle();

        String link();

        String table();

        String textFromResource();

        String imgBuildings();

        String headerTableStyle();
    }
}
