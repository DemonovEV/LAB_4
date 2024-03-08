package config;


import component.Feedback;
import component.trafic.TraficLight;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
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
        return 11;
    }

    @Bean
    int min() {
        return 3;
    }


    /*
    5 random. Создайте бин типа int, который при каждом его запросе возвращает новое случайное значение в диапазоне от 0 до 99.  При этом необходимо обеспечить, чтобы:
1.     Минимальное и максимальное значения задавались бинами из задачи 4
2.     Возвращаемые им числа не повторялись до тех пор, пока не использованы все значения в диапазоне от минимального до максимального.
     */
    static LinkedList<Integer> shuffleList=new LinkedList();
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    int random() {
        if (shuffleList.isEmpty())
        {// Инициализация
            for (int i = min(); i <=max() ; i++) {
                 shuffleList.add(i);
            }
            Collections.shuffle(shuffleList);
        }

        return  shuffleList.poll();
    }
@Bean
    Feedback feedback4()
    {
        return new Feedback("Очень хорошо",4);
    }
    @Bean
    Feedback feedback3()
    {
        return new Feedback("Сойдёт",4);
    }
    @Bean
    Feedback feedback5()
    {
        return new Feedback("Сложно сказать",random());
    }
    @Bean
    Feedback bestFeedback()
    {
        Feedback result;
        result=feedback3();

        if ( result.compareTo(feedback4())<0) result=feedback4();
        if ( result.compareTo(feedback5())<0) result=feedback5();

        return result;
    }

    @Bean
    TraficLight traficLight()
    {
        return new TraficLight();
    }




}
