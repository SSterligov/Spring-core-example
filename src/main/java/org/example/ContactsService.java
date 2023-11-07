package org.example;

public interface ContactsService {

    void printAllContacts();
    void addContact(String input);
    void saveContacts();
    void deleteContact(String email);
    void doExit();
}

