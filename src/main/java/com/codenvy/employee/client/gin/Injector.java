package com.codenvy.employee.client.gin;

import com.codenvy.employee.client.ApplicationController;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Created by logarifm on 03.09.14.
 */
@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {

    ApplicationController getApplicationController();

}
