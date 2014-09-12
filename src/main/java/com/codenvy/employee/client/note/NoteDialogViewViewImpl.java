package com.codenvy.employee.client.note;

import com.codenvy.employee.client.EmployeeDataConstants;
import com.codenvy.employee.client.EmployeeDataResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Created by Andrienko Alexander on 11.09.14.
 */

public class NoteDialogViewViewImpl extends DialogBox implements NoteDialogView {
    @Singleton
    interface NoteDialogUiBinder extends UiBinder<Widget, NoteDialogViewViewImpl> {
    }

    private static NoteDialogUiBinder ourUiBinder = GWT.create(NoteDialogUiBinder.class);

    private Delegate actionDelegate;

    @UiField
    TextArea noteArea;

    @UiField
    Button close;

    @UiField(provided = true)
    final EmployeeDataConstants locale;

    @UiField(provided = true)
    final EmployeeDataResource res;

    @Inject
    public NoteDialogViewViewImpl(EmployeeDataConstants locale, EmployeeDataResource res) {
        this.locale = locale;
        this.res = res;

        add(ourUiBinder.createAndBindUi(this));
        setText(locale.noteDialogCaption());
    }

    @Override
    public void showDialog() {
        center();
    }

    @Override
    public void hideDialog() {
        hide();
    }

    @Override
    public void setNoteArea(String note) {
        noteArea.setText(note);
    }

    @Override
    public String getNoteArea() {
        return noteArea.getText();
    }

    @Override
    public void setDelegate(Delegate actionDelegate) {
        this.actionDelegate = actionDelegate;
    }

    @UiHandler("close")
    public void handleClick(ClickEvent event) {
        actionDelegate.onCloseButtonDelegate();
    }
}