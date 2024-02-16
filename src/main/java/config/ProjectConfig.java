package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class ProjectConfig {

    @Bean
    String stringOne()
    {
        return "Hello world";
    }

    @Bean
    Date DateOne()
    {
        return new Date();
    }
}
