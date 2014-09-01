package com.codenvy.employee.client.constants;

import com.google.gwt.i18n.client.Constants;

/**
 * Created by USER on 01.09.2014.
 */
public interface EmployeeDataConstants extends Constants{
    //links
    @DefaultStringValue("About company")
    String infoLinkText();

    @DefaultStringValue("Back to list")
    String listUsersLinkText();

    //edit buttons
    @DefaultStringValue("Edit")
    String editButtonText();

    @DefaultStringValue("Add")
    String addButtonText();

    @DefaultStringValue("Delete")
    String deleteButtonText();

    //dialogBox
    @DefaultStringValue("Ok")
    String okButtonText();

    @DefaultStringValue("Cancel")
    String cancelButtonText();

    @DefaultStringValue("First name")
    String firstNameTextBox();

    @DefaultStringValue("Surname")
    String lastNameTextBox();

    @DefaultStringValue("Address")
    String addressTextBox();

    @DefaultStringArrayValue({"Edit", "Add"})
    String[] dialogBoxText();

    //alert
    @DefaultStringValue("You nothing selected!")
    String alertText();

    //table
    @DefaultStringValue("First name")
    String firstTableColumnText();

    @DefaultStringValue("Surname")
    String secondTableColumnText();

    @DefaultStringValue("Address")
    String thirdTableColumnText();
}
