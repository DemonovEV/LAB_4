package org.example;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println(context.getBean(String.class));
        System.out.println(context.getBean(Date.class));
    }
}