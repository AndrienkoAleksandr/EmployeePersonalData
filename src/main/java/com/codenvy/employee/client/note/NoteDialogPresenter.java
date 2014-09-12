package com.codenvy.employee.client.note;

import com.codenvy.employee.client.entity.Note;
import com.codenvy.employee.client.table.NoteChangedCallBack;
import com.google.inject.Inject;

/**
 * Created by Andrienko Alexander on 11.09.14.
 */
public class NoteDialogPresenter implements NoteDialogView.Delegate {

    private final NoteDialogView noteDialogView;

    private Note note;

    private NoteChangedCallBack noteChangedCallBack;

    @Inject
    public NoteDialogPresenter(NoteDialogView noteDialogView) {
        this.noteDialogView = noteDialogView;

        noteDialogView.setDelegate(this);
    }

    public void showDialog(Note note, NoteChangedCallBack noteChangedCallBack) {
        this.noteChangedCallBack = noteChangedCallBack;

        if (note == null) {
            note = new Note("");
        }
        this.note = note;

        noteDialogView.setNoteArea(this.note.getText());
        noteDialogView.showDialog();
    }

    @Override
    public void onCloseButtonDelegate() {
        String changedTextOfNote = noteDialogView.getNoteArea();
        note.setText(changedTextOfNote);

        noteChangedCallBack.onChangedNote(note);

        noteDialogView.hideDialog();
    }
}
