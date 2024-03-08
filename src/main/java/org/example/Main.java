package org.example;

import component.Feedback;
import component.trafic.TraficLight;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.function.Predicate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {


    static void formatterPatternSwitch(Object o) {
        switch (o) {

            case Integer i -> System.out.println("Integer");
            case Long l -> System.out.println("Long");
            case Double d -> System.out.println("Double");
            case String s -> System.out.println("String s");
            case null -> System.out.println("NULL");
            default -> System.out.println("Default s");
        }
    }

    static void formatterPatternSwitch2(int i) {
        switch (i) {
            case 5:
                System.out.println("5");
            case 6:
                System.out.println("6");
            case 7:
                System.out.println("7");
            default:
                System.out.println("Default s");
        }
    }

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext("config","component");

        System.out.println(context.getBean(String.class));
        System.out.println(context.getBean(Date.class));

        Predicate p=context.getBean(Predicate.class);
        for (int i = 0; i < 10; i++) {

            System.out.println("Протестируем  предикат : " + i + " preducate = " + p.test(i));
        }
        System.out.println("max=" + context.getBean("max", Integer.TYPE));

        System.out.println("min=" + context.getBean("min", Integer.TYPE));

        System.out.println("random=" + context.getBean("random", Integer.TYPE));
        System.out.println("random=" + context.getBean("random", Integer.TYPE));
        System.out.println("random=" + context.getBean("random", Integer.TYPE));
        System.out.println("random=" + context.getBean("random", Integer.TYPE));
        //           System.out.println(ThreadLocalRandom.current().nextInt(5, 6));
        Feedback f3 = context.getBean("feedback3", Feedback.class);
        Feedback f4 = context.getBean("feedback4", Feedback.class);
        Feedback f5 = context.getBean("feedback5", Feedback.class);

        Feedback bestFeedback = context.getBean("bestFeedback", Feedback.class);

        System.out.println(f3);
        System.out.println(f4);
        System.out.println(f5);
        System.out.println(bestFeedback);

        System.out.println(f3 == bestFeedback);
        System.out.println(f4 == bestFeedback);
        System.out.println(f5 == bestFeedback);

        TraficLight tf = context.getBean(TraficLight.class);
        System.out.println(tf);
  tf = context.getBean(TraficLight.class);
        System.out.println(tf);

        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();

        System.out.println("Asd2123");
    }


}