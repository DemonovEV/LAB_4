package org.example;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.function.Predicate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println(context.getBean(String.class));
        System.out.println(context.getBean(Date.class));

        Predicate p=context.getBean(Predicate.class);
        for (int i = 0; i < 10; i++) {

        System.out.println("Протестируем  предикат : " +i + " preducate = " + p.test(i));
        }

        System.out.println(context.getBean("Max", Integer.TYPE));

        System.out.println(context.getBean("Min", Integer.TYPE));
    }
}