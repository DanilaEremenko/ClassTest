import  org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by 801674 on 24.02.2017.
 */
public class Tests {
Proekt proekt=new Proekt("");
    @Test
    public void suma(){
        assertEquals("885616141",proekt.suma(new Proekt("884659354"),new Proekt("956787")));

    }
    @Test
    public  void proizv(){
        assertEquals("64968696182621",proekt.proizv(new Proekt("95689"),new Proekt("678956789")));

    }
    @Test
    public void subtraction(){
        assertEquals("3326370759",proekt.subtraction(new Proekt("3405350345"),new Proekt("78979586")));
    }


}
