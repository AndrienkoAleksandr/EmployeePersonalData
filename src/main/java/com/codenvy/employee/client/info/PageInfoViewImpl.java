package com.codenvy.employee.client.info;

import com.codenvy.employee.client.EmployeeDataConstants;
import com.codenvy.employee.client.EmployeeDataResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Created by Andrienko Alexander on 29.08.14.
 */
public class PageInfoViewImpl extends Composite implements PageInfoView {

    @Singleton
    public interface PageInfoViewUiBinder extends UiBinder<Widget, PageInfoViewImpl> {
    }

    private ActionDelegate actionDelegate;

    @UiField
    Label infoLabel;

    @UiField
    Hyperlink backToListLink;

    @UiField(provided = true)
    final EmployeeDataConstants constants;

    @Inject
    public PageInfoViewImpl(EmployeeDataConstants constants,
                            EmployeeDataResource resource,
                            PageInfoViewUiBinder ourUiBinder) {

        this.constants = constants;

        initWidget(ourUiBinder.createAndBindUi(this));
        infoLabel.setText(resource.textCompanyInfo().getText());
    }

    public void setDelegate(ActionDelegate actionDelegate) {
        this.actionDelegate = actionDelegate;
    }

    @UiHandler("backToListLink")
    public void onBackToListHyperLinkClicked(ClickEvent clickEvent) {
        actionDelegate.onBackToListHyperlinkClicked();
    }
}