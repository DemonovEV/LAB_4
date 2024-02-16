package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.function.Predicate;

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

    @Bean
    Predicate<Integer> predicate()
    {
        return integer -> integer>=2&&integer<=5;
    }


    @Bean
    int Max() {
        return 100;
    }

    @Bean
    int Min() {
        return 1;
    }

}
