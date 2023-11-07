package org.example;

import java.util.List;

public class CheckContactResult {

    Contact checkingContact = null;

    StringBuilder errorMessage = new StringBuilder();


    public Contact getCheckingContact() {
        return checkingContact;
    }

    public void setCheckingContact(Contact checkingContact) {
        this.checkingContact = checkingContact;
    }

    public StringBuilder getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(StringBuilder errorMessage) {
        this.errorMessage = errorMessage;
    }
}
