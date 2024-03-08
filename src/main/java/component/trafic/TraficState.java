package component.trafic;


import java.util.HashMap;
import java.util.Map;

public interface TraficState {

    String getName();

    void next(TraficLight context);


    enum StatesEnum implements TraficState {
        Red("Красный"), Yellow("Жёлтый"), Green("Зеленый");

        Map<Object, StatesEnum> priorStateMap = new HashMap<>(); // Для реализации игры  : зеленый-желтый-красный-желтый-зеленый
        String color;
        // Сохраняю состояния до смены на текущее.
        // по нему и отпрелеляю сдедующее.
        // эта игра состояниями не интересует сфетофор, логика реализована в самом состянии.
        // Изменение логики смены состояний не будет влиять на код Светофора. т.е. не потребует вмешательств в светофор.


        StatesEnum(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "StatesEnum{" +
                    "color='" + color + '\'' +
                    //", priorState=" + priorState +
                    '}';
        }

        @Override
        public String getName() {
            return color;
        }

        @Override
        public void next(TraficLight context) {
            StatesEnum priorState = priorStateMap.get(context);

            StatesEnum nextState = switch (this) {
                //Начальный свет
                //крайние света
                case Red -> Yellow;
                case Green -> Yellow;
                //  А на желтом нужно думать. Следующий цвет зависит от текущего.
                case Yellow -> priorState == Green ? Red : Green;
                case null -> Green;
                //case default -> Green;
            };
            System.out.println("Следующий свет : " + nextState);

            nextState.priorStateMap.put(context, this);
            context.setState(nextState);
        }
    }
}
