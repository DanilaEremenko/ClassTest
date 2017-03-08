import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 801674 on 24.02.2017.
 */
public class Tests {
    EDLargeInteger edLI = new EDLargeInteger("");


    @Test
    public void summa() {
        edLI=new EDLargeInteger("987");
        assertEquals("985", edLI.summa(
                new EDLargeInteger("-2")));
        assertEquals("incompatible types",edLI.summa(new EDLargeInteger("dsal;slad;")));

    }

    @Test
    public void proizv() {
        edLI=new EDLargeInteger("95689");
        assertEquals("-64968696182621", edLI.proizv(
                new EDLargeInteger("-678956789")));
       assertEquals("incompatible types",edLI.proizv(new EDLargeInteger("--2132133")));
    }

    @Test
    public void subtraction() {
        edLI=new EDLargeInteger("78979586");
        assertEquals("78979590",
                edLI.subtraction(
                        new EDLargeInteger("-4")));
        assertEquals("incompatible types",edLI.subtraction(new EDLargeInteger("01329029-13")));

    }

    @Test
    public void divide() {
        edLI=new EDLargeInteger("9801");
        assertEquals("-99", edLI.divide(
                new EDLargeInteger(-99)));
    }
@Test
public void mod(){
        edLI=new EDLargeInteger("126");
        assertEquals("-1",edLI.mod(new EDLargeInteger(-125)));
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

        assertEquals("equal",edLI.min(new EDLargeInteger("120301320132"),new EDLargeInteger("120301320132")));
    }
    }
