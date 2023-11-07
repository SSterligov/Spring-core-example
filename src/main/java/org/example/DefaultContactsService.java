package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


@Component
public class DefaultContactsService implements ContactsService {

    private final Contacts contacts;

    private final CheckContact checkContact;

    @Value("${app.save.file}")
    String saveFile;

    public DefaultContactsService(Contacts contacts, CheckContact checkContact1) {
        this.contacts = contacts;
        this.checkContact = checkContact1;
    }


    @Override
    public void printAllContacts() {
        for(Contact contact : contacts.getContactList()) {
            contact.printContact();
        }
    }

    @Override
    public void addContact(String input) {
        String contactStr = input.replace("add: ", "");
        CheckContactResult checkContactResult = checkContact.checkContact(contactStr);
        if(checkContactResult.getCheckingContact() != null) {
            contacts.getContactList().add(checkContactResult.getCheckingContact());
            System.out.println("Контакт добавлен.");
        }else {
            System.out.println("Контакт не добавлен, по причине:");
            System.out.println(checkContactResult.getErrorMessage().toString());
        }
    }

    @Override
    public void saveContacts() {
        List<String> contactsStr = new ArrayList<>();
        for(Contact contact : contacts.getContactList()) {
            contactsStr.add(MessageFormat.format("{0};{1};{2}", contact.getFullName(),contact.getPhoneNumber(),contact.getEmail()));
        }
        Path out = Paths.get("src/main/resources/"+saveFile);
        try {
            Files.write(out, contactsStr, Charset.defaultCharset());
            System.out.println("Контакты сохранены в файл: " + "src/main/resources/"+saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContact(String email) {
        String emailStr = email.replace("delete: ", "");
        boolean result = false;
        Contact targetContact = null;
        for(Contact contact : contacts.getContactList()) {
            if(contact.getEmail().equalsIgnoreCase(emailStr.trim())) {
                targetContact = contact;
            }
        }
        if(targetContact != null) {
            if(contacts.getContactList().remove(targetContact)) {
                result = true;
            }
        }
        System.out.println(result ? "Контакт удалён" : "Контакт не удалён.");
    }

    @Override
    public void doExit() {
        Path out = Paths.get("src/main/resources/"+saveFile);
        try {
            Files.writeString(out, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
