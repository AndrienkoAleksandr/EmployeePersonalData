package com.codenvy.employee.client.note;

import com.codenvy.employee.client.mvp.View;
import com.google.inject.ImplementedBy;

/**
 * Created by Andrienko Alexander on 11.09.14.
 */
@ImplementedBy(NoteDialogViewViewImpl.class)
public interface NoteDialogView extends View<NoteDialogView.Delegate> {

    public interface Delegate {

        public void onCloseButtonDelegate();
    }

    void showDialog();

    void hideDialog();

    void setNoteArea(String note);

    String getNoteArea();
}
