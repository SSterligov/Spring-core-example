package org.example.config;

import org.example.DefaultContactsService;
import org.springframework.context.annotation.*;

@ComponentScan("org.example")
@Configuration
@PropertySources(value = {
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:application-default.properties")
})
public class DefaultAppConfig {

}
