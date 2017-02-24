import  org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by 801674 on 24.02.2017.
 */
public class Tests {
    Proekt proekt=new Proekt(299);
    @Test
    public void sum(){
        assertEquals("398",proekt.sum(new Proekt("199")));

    }

}
