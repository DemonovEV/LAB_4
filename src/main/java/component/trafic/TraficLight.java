package component.trafic;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TraficLight {
    @PostConstruct
    void init()
    {
        System.out.println("init");
    }

    @PreDestroy
            void des()
    {
        System.out.println("PreDestroy");
    }
    TraficState state;

    public TraficLight() {
        this.state = TraficState.StatesEnum.Yellow;
    }

    void setState(TraficState state)
    {
        this.state = state;
    }

    public void next()
    {
       // System.out.println("Был свет : " +state );
        state.next(this);
      //  System.out.println("Стал свет : " +state );
    }
}
