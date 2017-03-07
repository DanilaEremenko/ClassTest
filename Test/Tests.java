import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 801674 on 24.02.2017.
 */
public class Tests {
    EDLargeInteger edLI = new EDLargeInteger("");


    @Test
    public void suma() {
        edLI=new EDLargeInteger("987");
        assertEquals("985", edLI.suma(
                new EDLargeInteger("-2")));

    }

    @Test
    public void proizv() {
        edLI=new EDLargeInteger("95689");
        assertEquals("-64968696182621", edLI.proizv(

                new EDLargeInteger("-678956789")));

    }

    @Test
    public void subtraction() {
        edLI=new EDLargeInteger("78979586");
        assertEquals("78979590",
                edLI.subtraction(
                        new EDLargeInteger("-4")));

    }

    @Test
    public void divide() {
        edLI=new EDLargeInteger("9801");
        assertEquals("-99", edLI.divide(
                new EDLargeInteger(-99)));
    }

    @Test
    public void max() {
        assertEquals("603290432", edLI.max(
                new EDLargeInteger("603290432"),
                new EDLargeInteger("-703290432")));

    }

    @Test
    public void min(){
        assertEquals("-7",edLI.min(
                new EDLargeInteger("6"),
                new EDLargeInteger("-7")));
    }
    }
