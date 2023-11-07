package org.example;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ContactsApp {

    private final ContactsService contactsService;

    private final Initializer initializer;

    public ContactsApp(ContactsService contactsService, Initializer initializer) {
        this.contactsService = contactsService;
        this.initializer = initializer;
    }


    public void startApp() {
        initializer.initContacts();
        Scanner in = new Scanner(System.in);
        String exit = "";
        while (!exit.equals("exit")) {
            System.out.print("Введите команду: ");
            String input = in.nextLine();
            String action = parseActionByInput(input);
            switch (action) {
                case "printAll" :
                    contactsService.printAllContacts();
                    break;
                case "add" :
                    contactsService.addContact(input);
                    break;
                case "delete" :
                    contactsService.deleteContact(input);
                    break;
                case "save" :
                    contactsService.saveContacts();
                    break;
                case "help" :
                    System.out.println("printAll - Вывести список всех контактов. Пример ввода: printAll");
                    System.out.println("add: <контакт> - Добавить новый контакт в список контактов. Пример ввода: add: Иванов Иван Иванович; +79876546565; test@example.ru");
                    System.out.println("delete: <email> - Удалить контакт по email. Пример ввода: delete: test@example.ru");
                    System.out.println("save - Сохранить имеющиеся контакты в файл. Пример ввода: save");
                    System.out.println("exit - Выйти из приложения. Пример ввода: exit");
                    System.out.println("help - Получить список доступных команд. Пример ввода: help");

                    break;
                case "exit" :
                    exit = "exit";
                    contactsService.doExit();
                    break;
                default:
                    System.out.println("Не верная команда. Для получения списка доступных команд введите - help");
                    break;
            }
        }
        in.close();
    }


    private String parseActionByInput(String input) {
        if(input.startsWith("add:")) {
            return "add";
        }
        if(input.equals("printAll")) {
            return "printAll";
        }
        if(input.startsWith("delete: ")) {
            return "delete";
        }
        if(input.equals("save")) {
            return "save";
        }
        if(input.equals("exit")) {
            return "exit";
        }
        if(input.equals("help")) {
            return "help";
        }
        return "";
    }
}
