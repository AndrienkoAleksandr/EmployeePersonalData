import com.codenvy.employee.client.event.RedirectToListPageEvent;
import com.codenvy.employee.client.info.PageInfoPresenter;
import com.codenvy.employee.client.info.PageInfoView;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.HasWidgets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by Andrienko Alexander on 05.09.14.
 * This is test for class com.codenvy.employee.client.info.PageInfoPresenter.java
 */
@RunWith(MockitoJUnitRunner.class)
public class PageInfoPresenterTest {

    @Mock
    private PageInfoView pageInfoView;

    @Spy
    private SimpleEventBus simpleEventBus;

    @Mock
    private HasWidgets container;

    @InjectMocks
    private PageInfoPresenter pageInfoPresenter;

    @Test
    public void testGoMethodClearOfContainer() {
        pageInfoPresenter.go(container);
        verify(container).clear();
    }

    @Test
    public void testGoMethodAddOfContainer() {
        pageInfoPresenter.go(container);
        verify(container).add(pageInfoView.asWidget());
    }

    @Test
    public void testOnBackToListHyperlinkClicked() {
        pageInfoPresenter.onBackToListHyperlinkClicked();
        verify(simpleEventBus).fireEvent(any(RedirectToListPageEvent.class));
    }
}