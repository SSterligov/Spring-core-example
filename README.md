# Spring-core-example

__Точка входа:__ src/main/java/org/example/Main.java

__Профиль приложения в файле application-properties:__

___init -___ Инициализируется список контактов из файла resources/init-contacts.txt

___default -___ Инициализируется список контактов из файла resources/contacts.txt, который при старте приложения пустой. 

__Список доступных команд:__

___help___ Получить список доступных команд.

___printAll___  Вывести список всех контактов.

___add: <контакт>___  Добавить новый контакт в список контактов. Пример ввода: _add: Иванов Иван Иванович; +79876546565; test@example.ru_

___delete: <email>___ Удалить контакт по email. Пример ввода: _delete: test@example.ru_

___save___ Сохранить имеющиеся контакты в файл. Файлы сохраняются в файл resources/contacts.txt

___exit___ Выйти из приложения. Файл с контактами очищается resources/contacts.txt
