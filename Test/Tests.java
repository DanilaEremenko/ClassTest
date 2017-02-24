import  org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by 801674 on 24.02.2017.
 */
public class Tests {
    Proekt proekt=new Proekt();
    @Test
    public void sum(){
        assertEquals("198",proekt.sum("99","99"));

    }
    @Test
    public void sum2(){
        assertEquals("198",proekt.sum(99,99));

    }

}
