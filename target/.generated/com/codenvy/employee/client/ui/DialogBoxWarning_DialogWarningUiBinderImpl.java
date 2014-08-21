package com.codenvy.employee.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class DialogBoxWarning_DialogWarningUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.codenvy.employee.client.ui.DialogBoxWarning>, com.codenvy.employee.client.ui.DialogBoxWarning.DialogWarningUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("Ok")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.codenvy.employee.client.ui.DialogBoxWarning owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final com.codenvy.employee.client.ui.DialogBoxWarning owner;


    public Widgets(final com.codenvy.employee.client.ui.DialogBoxWarning owner) {
      this.owner = owner;
    }

    SafeHtml template_html1() {
      return template.html1();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private com.codenvy.employee.client.ui.DialogBoxWarning_DialogWarningUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private com.codenvy.employee.client.ui.DialogBoxWarning_DialogWarningUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final com.codenvy.employee.client.ui.DialogBoxWarning_DialogWarningUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.codenvy.employee.client.ui.DialogBoxWarning_DialogWarningUiBinderImpl_GenBundle) GWT.create(com.codenvy.employee.client.ui.DialogBoxWarning_DialogWarningUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_waringMessage());
      f_FlowPanel1.add(get_ok());


      return f_FlowPanel1;
    }

    /**
     * Getter for waringMessage called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_waringMessage() {
      return build_waringMessage();
    }
    private com.google.gwt.user.client.ui.Label build_waringMessage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label waringMessage = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      this.owner.waringMessage = waringMessage;

      return waringMessage;
    }

    /**
     * Getter for ok called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Button get_ok() {
      return build_ok();
    }
    private com.google.gwt.user.client.ui.Button build_ok() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button ok = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      ok.setHTML(template_html1().asString());


      this.owner.ok = ok;

      return ok;
    }
  }
}
