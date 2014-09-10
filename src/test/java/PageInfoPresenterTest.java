import com.codenvy.employee.client.event.RedirectToListPageEvent;
import com.codenvy.employee.client.info.PageInfoPresenter;
import com.codenvy.employee.client.info.PageInfoView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Created by Andrienko Alexander on 05.09.14.
 * This is test for class com.codenvy.employee.client.info.PageInfoPresenter.java
 */
@RunWith(MockitoJUnitRunner.class)
public class PageInfoPresenterTest {

    @Mock
    private PageInfoView InfoView;

    @Mock
    private EventBus eventBus;

    @Mock
    private HasWidgets container;

    @InjectMocks
    private PageInfoPresenter pageInfoPresenter;

    @Test
    public void testGoMethodClearOfContainer() {
        pageInfoPresenter.go(container);

        verify(container).clear();
        verify(InfoView).asWidget();
        verify(container).add(eq(InfoView.asWidget()));
    }

    @Test
    public void testOnBackToListHyperlinkClicked() {
        pageInfoPresenter.onBackToListHyperlinkClicked();

        verify(eventBus).fireEvent(any(RedirectToListPageEvent.class));
    }
}