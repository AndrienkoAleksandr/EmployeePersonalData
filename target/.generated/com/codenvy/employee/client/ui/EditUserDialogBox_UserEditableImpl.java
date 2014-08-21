package com.codenvy.employee.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class EditUserDialogBox_UserEditableImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.codenvy.employee.client.ui.EditUserDialogBox>, com.codenvy.employee.client.ui.EditUserDialogBox.UserEditable {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.codenvy.employee.client.ui.EditUserDialogBox owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final com.codenvy.employee.client.ui.EditUserDialogBox owner;


    public Widgets(final com.codenvy.employee.client.ui.EditUserDialogBox owner) {
      this.owner = owner;
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private com.codenvy.employee.client.ui.EditUserDialogBox_UserEditableImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private com.codenvy.employee.client.ui.EditUserDialogBox_UserEditableImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final com.codenvy.employee.client.ui.EditUserDialogBox_UserEditableImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.codenvy.employee.client.ui.EditUserDialogBox_UserEditableImpl_GenBundle) GWT.create(com.codenvy.employee.client.ui.EditUserDialogBox_UserEditableImpl_GenBundle.class);
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
      f_FlowPanel1.add(get_f_Label2());
      f_FlowPanel1.add(get_firstName());
      f_FlowPanel1.add(get_f_Label3());
      f_FlowPanel1.add(get_secondName());
      f_FlowPanel1.add(get_f_Label4());
      f_FlowPanel1.add(get_address());
      f_FlowPanel1.add(get_okButton());
      f_FlowPanel1.add(get_cancelButton());
      f_FlowPanel1.setVisible(true);


      return f_FlowPanel1;
    }

    /**
     * Getter for f_Label2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label2() {
      return build_f_Label2();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label2() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label2.setText("First name");


      return f_Label2;
    }

    /**
     * Getter for firstName called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.TextBox get_firstName() {
      return build_firstName();
    }
    private com.google.gwt.user.client.ui.TextBox build_firstName() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox firstName = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.


      this.owner.firstName = firstName;

      return firstName;
    }

    /**
     * Getter for f_Label3 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label3() {
      return build_f_Label3();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label3() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label3.setText("Surname");


      return f_Label3;
    }

    /**
     * Getter for secondName called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.TextBox get_secondName() {
      return build_secondName();
    }
    private com.google.gwt.user.client.ui.TextBox build_secondName() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox secondName = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.


      this.owner.secondName = secondName;

      return secondName;
    }

    /**
     * Getter for f_Label4 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label4() {
      return build_f_Label4();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label4() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label4.setText("Address");


      return f_Label4;
    }

    /**
     * Getter for address called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.TextBox get_address() {
      return build_address();
    }
    private com.google.gwt.user.client.ui.TextBox build_address() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox address = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.


      this.owner.address = address;

      return address;
    }

    /**
     * Getter for okButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Button get_okButton() {
      return build_okButton();
    }
    private com.google.gwt.user.client.ui.Button build_okButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button okButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      okButton.setText("Ok");


      this.owner.okButton = okButton;

      return okButton;
    }

    /**
     * Getter for cancelButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Button get_cancelButton() {
      return build_cancelButton();
    }
    private com.google.gwt.user.client.ui.Button build_cancelButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button cancelButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      cancelButton.setText("Cancel");


      this.owner.cancelButton = cancelButton;

      return cancelButton;
    }
  }
}
