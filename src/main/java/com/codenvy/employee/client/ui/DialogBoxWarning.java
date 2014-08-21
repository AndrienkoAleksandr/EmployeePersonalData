package com.codenvy.employee.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by logarifm on 21.08.14.
 */
public class DialogBoxWarning extends DialogBox {
    interface DialogWarningUiBinder extends UiBinder<Widget, DialogBoxWarning> {
    }

    @UiField
    Label waringMessage;

    @UiField
    Button ok;

    private static DialogWarningUiBinder ourUiBinder = GWT.create(DialogWarningUiBinder.class);

    public DialogBoxWarning() {
        add(ourUiBinder.createAndBindUi(this));
        setText("Warning!");
        ok.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                hide();
            }
        });
    }

    public Label getWaringMessage() {
        return waringMessage;
    }
}