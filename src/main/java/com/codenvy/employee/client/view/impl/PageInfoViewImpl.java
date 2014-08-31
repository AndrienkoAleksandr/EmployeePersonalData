package com.codenvy.employee.client.view.impl;

import com.codenvy.employee.client.EmployeeDataResource;
import com.codenvy.employee.client.presenter.PageInfoPresenter;
import com.codenvy.employee.client.view.PageInfoView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by logarifm on 29.08.14.
 */
public class PageInfoViewImpl extends Composite implements PageInfoView{

    interface PageInfoViewUiBinder extends UiBinder<Widget, PageInfoViewImpl> {
    }

    private static PageInfoViewUiBinder ourUiBinder = GWT.create(PageInfoViewUiBinder.class);

    private PageInfoPresenter pageInfoPresenter;

    @UiField
    Label infoLabel;

    @UiField
    Hyperlink backToListLink;

    public PageInfoViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
        infoLabel.setText(EmployeeDataResource.INSTANCE.textCompanyInfo().getText());
    }

    public void setPageInfoPresenter(PageInfoPresenter pageInfoPresenter) {
        this.pageInfoPresenter = pageInfoPresenter;
    }

    @UiHandler("backToListLink")
    void onBackToListHyperLinkClicked(ClickEvent clickEvent) {
        pageInfoPresenter.onBackToListHyperlinkClicked();
    }
}