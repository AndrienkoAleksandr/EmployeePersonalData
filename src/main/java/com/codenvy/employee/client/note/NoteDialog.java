package com.codenvy.employee.client.note;

import com.codenvy.employee.client.entity.Note;
import com.codenvy.employee.client.mvp.View;
import com.codenvy.employee.client.table.NoteChangedCallBack;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.inject.ImplementedBy;

/**
 * Created by logarifm on 11.09.14.
 */
@ImplementedBy(NoteDialogImpl.class)
public interface NoteDialog extends View<NoteDialog.Delegate> {

    public interface Delegate {

        public void onCloseButtonDelegate();
    }

    void showDialog();

    void hideDialog();

    void setNote(String note);

    String getNote();
}
