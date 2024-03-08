package component;


import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString
public class Feedback implements Comparable{
    String text;
    int mark;

    @Override
    public int compareTo(Object o) {
       // if (!o instanceof Feedback feedback2) ;
        return this.mark-((Feedback)o).mark;
    }
}
