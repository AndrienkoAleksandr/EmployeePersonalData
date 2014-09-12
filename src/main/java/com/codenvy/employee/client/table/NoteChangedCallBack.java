package com.codenvy.employee.client.table;

import com.codenvy.employee.client.entity.Note;

/**
 * Created by logarifm on 11.09.14.
 */
public interface NoteChangedCallBack {
    void onChangedNote(Note note);
}
