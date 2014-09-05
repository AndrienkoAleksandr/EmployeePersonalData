package com.codenvy.employee.client;

import com.codenvy.employee.client.event.RedirectToListPageEvent;
import com.codenvy.employee.client.info.PageInfoPresenter;
import com.codenvy.employee.client.info.PageInfoView;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by logarifm on 05.09.14.
 */
public class PageInfoPresenterTest {

    private PageInfoView pageInfoView;

    private SimpleEventBus simpleEventBus;

    private PageInfoPresenter pageInfoPresenter;

    private HasWidgets container;

    @Before
    public void init() {
        pageInfoView = mock(PageInfoView.class);

        simpleEventBus = spy(new SimpleEventBus());

        pageInfoPresenter = new PageInfoPresenter(pageInfoView, simpleEventBus);

        container = mock(HasWidgets.class);
    }

    @Test
    public void testGoClear() {
        pageInfoPresenter.go(container);
        verify(container).clear();
    }

    @Test
    public void testGoAdd() {
        pageInfoPresenter.go(container);
        verify(container).add(pageInfoView.asWidget());
    }

    @Test
    public void testOnBackToListHyperlinkClicked() {
        pageInfoPresenter.onBackToListHyperlinkClicked();
        verify(simpleEventBus).fireEvent(any(RedirectToListPageEvent.class));
    }

}
