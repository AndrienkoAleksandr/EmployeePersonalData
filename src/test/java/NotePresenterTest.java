import com.codenvy.employee.client.entity.Note;
import com.codenvy.employee.client.note.NoteDialogPresenter;
import com.codenvy.employee.client.note.NoteDialogView;
import com.codenvy.employee.client.table.NoteChangedCallBack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Andrienko Alexander on 12.09.14.
 * This is test for class com.codenvy.employee.client.note.NoteDialogPresenter.java
 */
@RunWith(MockitoJUnitRunner.class)
public class NotePresenterTest {

    @Mock
    private NoteDialogView view;

    @Mock
    private NoteChangedCallBack noteChangedCallBack;

    @Mock
    private Note note;

    @InjectMocks
    private NoteDialogPresenter noteDialogPresenter;

    @Test
    public void testShowDialogWhenNoteIsNull() {
        noteDialogPresenter.showDialog(null, noteChangedCallBack);

        verify(view).setNoteArea(eq(""));
        verify(view).showDialog();
    }

    @Test
    public void testShowDialogWhenNoteIsNotNull() {
        String testLine = "test line";
        when(note.getText()).thenReturn(testLine);
        noteDialogPresenter.showDialog(note, noteChangedCallBack);

        verify(view).setNoteArea(testLine);
        verify(view).showDialog();
    }

    @Test
     public void testOnCloseButtonDelegate() {
        String testLine = "test text";

        noteDialogPresenter.showDialog(note, noteChangedCallBack);
        reset(view);

        when(view.getNoteArea()).thenReturn(testLine);

        noteDialogPresenter.onCloseButtonDelegate();

        verify(view).getNoteArea();

        verify(note).setText(eq(testLine));

        verify(noteChangedCallBack).onChangedNote(note);

        verify(view).hideDialog();
    }
}
