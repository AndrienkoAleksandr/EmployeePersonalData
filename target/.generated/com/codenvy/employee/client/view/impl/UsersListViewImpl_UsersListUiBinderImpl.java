package com.codenvy.employee.client.view.impl;

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

public class UsersListViewImpl_UsersListUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.codenvy.employee.client.view.impl.UsersListViewImpl>, com.codenvy.employee.client.view.impl.UsersListViewImpl.UsersListUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("Edit")
    SafeHtml html1();
     
    @Template("Add")
    SafeHtml html2();
     
    @Template("Delete")
    SafeHtml html3();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.codenvy.employee.client.view.impl.UsersListViewImpl owner) {


    return new Widgets(owner).get_f_LayoutPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final com.codenvy.employee.client.view.impl.UsersListViewImpl owner;


    public Widgets(final com.codenvy.employee.client.view.impl.UsersListViewImpl owner) {
      this.owner = owner;
      build_f_FlowPanel2();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private com.codenvy.employee.client.view.impl.UsersListViewImpl_UsersListUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private com.codenvy.employee.client.view.impl.UsersListViewImpl_UsersListUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final com.codenvy.employee.client.view.impl.UsersListViewImpl_UsersListUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.codenvy.employee.client.view.impl.UsersListViewImpl_UsersListUiBinderImpl_GenBundle) GWT.create(com.codenvy.employee.client.view.impl.UsersListViewImpl_UsersListUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for f_LayoutPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.LayoutPanel get_f_LayoutPanel1() {
      return build_f_LayoutPanel1();
    }
    private com.google.gwt.user.client.ui.LayoutPanel build_f_LayoutPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.LayoutPanel f_LayoutPanel1 = (com.google.gwt.user.client.ui.LayoutPanel) GWT.create(com.google.gwt.user.client.ui.LayoutPanel.class);
      // Setup section.
      f_LayoutPanel1.add(get_usersTable());
      f_LayoutPanel1.add(get_f_FlowPanel2());
      f_LayoutPanel1.setWidgetLeftRight(get_f_FlowPanel2(), 55, com.google.gwt.dom.client.Style.Unit.PCT, 20, com.google.gwt.dom.client.Style.Unit.PCT);
      f_LayoutPanel1.setWidgetTopBottom(get_f_FlowPanel2(), 10, com.google.gwt.dom.client.Style.Unit.PCT, 60, com.google.gwt.dom.client.Style.Unit.PCT);


      return f_LayoutPanel1;
    }

    /**
     * Getter for usersTable called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.cellview.client.CellTable get_usersTable() {
      return build_usersTable();
    }
    private com.google.gwt.user.cellview.client.CellTable build_usersTable() {
      // Creation section.
      final com.google.gwt.user.cellview.client.CellTable usersTable = (com.google.gwt.user.cellview.client.CellTable) GWT.create(com.google.gwt.user.cellview.client.CellTable.class);
      // Setup section.


      this.owner.usersTable = usersTable;

      return usersTable;
    }

    /**
     * Getter for f_FlowPanel2 called 3 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel f_FlowPanel2;
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel2() {
      return f_FlowPanel2;
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel2() {
      // Creation section.
      f_FlowPanel2 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel2.add(get_edit());
      f_FlowPanel2.add(get_add());
      f_FlowPanel2.add(get_delete());
      f_FlowPanel2.setWidth("15%");


      return f_FlowPanel2;
    }

    /**
     * Getter for edit called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_edit() {
      return build_edit();
    }
    private com.google.gwt.user.client.ui.Button build_edit() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button edit = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      edit.setHTML(template_html1().asString());


      this.owner.edit = edit;

      return edit;
    }

    /**
     * Getter for add called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_add() {
      return build_add();
    }
    private com.google.gwt.user.client.ui.Button build_add() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button add = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      add.setHTML(template_html2().asString());


      this.owner.add = add;

      return add;
    }

    /**
     * Getter for delete called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_delete() {
      return build_delete();
    }
    private com.google.gwt.user.client.ui.Button build_delete() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button delete = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      delete.setHTML(template_html3().asString());


      this.owner.delete = delete;

      return delete;
    }
  }
}
