package org.example;

import java.text.MessageFormat;

public class Contact {

    private String fullName;
    private String phoneNumber;
    private String email;

    public Contact(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void printContact() {
        System.out.println(MessageFormat.format("{0} | {1} | {2}", fullName, phoneNumber, email));
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Contact) {
            Contact c2 = (Contact)obj;
            if(this.fullName.equals(c2.fullName) && this.phoneNumber.equals(c2.phoneNumber) && this.email.equals(c2.email)) {
                return true;
            }
        }
        return false;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
