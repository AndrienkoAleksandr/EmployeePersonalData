package com.codenvy.employee.client.gin;

import com.codenvy.employee.client.dialogbox.EditUserDialogBoxView;
import com.codenvy.employee.client.dialogbox.EditUserDialogBoxViewImpl;
import com.google.gwt.inject.client.AbstractGinModule;

/**
 * Created by USER on 02.09.2014.
 */
public class EditUserDialogBoxPresenterModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(EditUserDialogBoxView.class).to(EditUserDialogBoxViewImpl.class);
//        bind(EmployeeDataConstants.class).in(Singleton.class);
    }
}
