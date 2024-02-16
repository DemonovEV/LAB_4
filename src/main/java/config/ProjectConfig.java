package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Random;
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
    int max() {
        return 100;
    }

    @Bean
    int min() {
        return 1;
    }

    @Bean
    int random() {

        return new Random().nextInt();
    }

}
