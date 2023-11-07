package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class Initializer {

    private Contacts contacts;

    @Value("${app.init.file}")
    private String initFile;

    public Initializer(Contacts contacts) {
        this.contacts = contacts;
    }


    public void initContacts() {
        List<Contact> contactList = contacts.getContactList();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src\\main\\resources\\" + initFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(";");
                String fio = "";
                String phoneNumber = "";
                String email = "";
                for (int i = 0; i < arr.length; i++) {
                    if(i==0) fio = arr[i];
                    if(i==1) phoneNumber = arr[i];
                    if(i==2) email = arr[i];
                }
                Contact contact = new Contact(fio, phoneNumber, email);
                contactList.add(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при чтении файла: " + initFile);
        }
    }

    public Contacts getContacts() {
        return contacts;
    }

}
