package org.example.config;

import org.example.ContactsService;
import org.example.InitContactsService;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application-init.properties")
@Profile("init")
public class InitAppConfig {

    @Bean
    public ContactsService contactsService() {
        return new InitContactsService();
    }

}
