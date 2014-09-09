import com.codenvy.employee.client.event.RedirectToListPageEvent;
import com.codenvy.employee.client.info.PageInfoPresenter;
import com.codenvy.employee.client.info.PageInfoView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;
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
@GwtModule("com.codenvy.employee.EmployeeData")
public class PageInfoPresenterTest extends GwtTestWithMockito {

    @Mock
    private PageInfoView pageInfoView;

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
    }

    @Test
    public void testGoMethodAddOfContainer() {
        pageInfoPresenter.go(container);

        verify(container).add(eq(pageInfoView.asWidget()));
    }

    @Test
    public void testOnBackToListHyperlinkClicked() {
        pageInfoPresenter.onBackToListHyperlinkClicked();

        verify(eventBus).fireEvent(any(RedirectToListPageEvent.class));
    }
}