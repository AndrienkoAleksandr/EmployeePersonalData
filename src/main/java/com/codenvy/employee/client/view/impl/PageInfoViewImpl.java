package com.codenvy.employee.client.view.impl;

import com.codenvy.employee.client.EmployeeDataResource;
import com.codenvy.employee.client.view.PageInfoView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by logarifm on 29.08.14.
 */
public class PageInfoViewImpl extends Composite implements PageInfoView{

    interface PageInfoViewUiBinder extends UiBinder<Widget, PageInfoViewImpl> {
    }

    private static PageInfoViewUiBinder ourUiBinder = GWT.create(PageInfoViewUiBinder.class);

    @UiField
    Label infoLabel;

    public PageInfoViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
        infoLabel.setText(EmployeeDataResource.INSTANCE.textCompanyInfo().getText());
    }
}