import com.codenvy.employee.client.event.RedirectToListPageEvent;
import com.codenvy.employee.client.info.PageInfoPresenter;
import com.codenvy.employee.client.info.PageInfoView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTestWithMockito;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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
    private PageInfoView pageInfoViewMock;

    @Mock
    private EventBus eventBusMock;

    @Mock
    private HasWidgets containerMock;

    @InjectMocks
    private PageInfoPresenter pageInfoPresenter;

    @Test
    public void testGoMethodClearOfContainer() {
        pageInfoPresenter.go(containerMock);

        verify(containerMock).clear();
        verify(pageInfoViewMock).asWidget();
        verify(containerMock).add(eq(pageInfoViewMock.asWidget()));
    }

    @Test
    public void testOnBackToListHyperlinkClicked() {
        pageInfoPresenter.onBackToListHyperlinkClicked();

        verify(eventBusMock).fireEvent(any(RedirectToListPageEvent.class));
    }
}