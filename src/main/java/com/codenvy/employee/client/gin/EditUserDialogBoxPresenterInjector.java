package com.codenvy.employee.client.gin;

import com.codenvy.employee.client.dialogbox.EditUserDialogBoxPresenter;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Created by USER on 02.09.2014.
 */
@GinModules(EditUserDialogBoxPresenterModule.class)
public interface EditUserDialogBoxPresenterInjector extends Ginjector {
    EditUserDialogBoxPresenter getEditUserDialogBoxPresenter();
}
