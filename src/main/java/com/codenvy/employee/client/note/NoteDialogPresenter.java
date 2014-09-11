package com.codenvy.employee.client.note;

import com.codenvy.employee.client.entity.Note;
import com.codenvy.employee.client.table.NoteChangedCallBack;
import com.google.inject.Inject;

/**
 * Created by logarifm on 11.09.14.
 */
public class NoteDialogPresenter implements NoteDialog.Delegate {

    private NoteDialog noteDialog;

    private Note note;

    NoteChangedCallBack noteChangedCallBack;

    @Inject
    public NoteDialogPresenter(NoteDialog noteDialog) {
        this.noteDialog = noteDialog;
        noteDialog.setDelegate(this);
    }

    @Override
    public void onCloseButtonDelegate() {
        String changedTextOfNote = noteDialog.getNote();
        this.note.setText(changedTextOfNote);

        noteChangedCallBack.onChangedNote(this.note);

        noteDialog.hideDialog();
    }

    public void showDialog(Note note, NoteChangedCallBack noteChangedCallBack) {
        this.noteChangedCallBack = noteChangedCallBack;

        if (note == null) {
            this.note = new Note("");
        } else {
            this.note = note;
        }
        noteDialog.setNote(this.note.getText());
        noteDialog.showDialog();
    }
}
