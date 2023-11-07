package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Contacts {

    private final List<Contact> contactList = new ArrayList<>();

    public List<Contact> getContactList() {
        return contactList;
    }
}
