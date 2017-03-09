import org.junit.Test;

import static org.junit.Assert.*;


public class Tests {
    EDLargeInteger edLI = new EDLargeInteger("");


    @Test
    public void summa() {
        edLI = new EDLargeInteger("987");
        assertEquals("985", edLI.summa(
                new EDLargeInteger("-2")));
        assertEquals("incompatible types", edLI.summa(new EDLargeInteger("dsal;slad;")));

    }

    @Test
    public void proizv() {
        edLI = new EDLargeInteger("95689");
        assertEquals("-64968696182621", edLI.proizv(
                new EDLargeInteger("-678956789")));
        assertEquals("incompatible types", edLI.proizv(new EDLargeInteger("--2132133")));
    }

    @Test
    public void subtraction() {
        edLI = new EDLargeInteger("78979586");
        assertEquals("78979590",
                edLI.subtraction(
                        new EDLargeInteger("-4")));
        assertEquals("incompatible types", edLI.subtraction(new EDLargeInteger("0132-902913")));

    }

    @Test
    public void divide() {
        edLI = new EDLargeInteger("9801");
        assertEquals("-99", edLI.divide(
                new EDLargeInteger("-99")));
    }

    @Test
    public void mod() {
        edLI = new EDLargeInteger("126");
        assertEquals("-1", edLI.mod(new EDLargeInteger("-25")));
    }

    @Test
    public void max() {
        assertEquals("603290432", edLI.max(
                new EDLargeInteger("603290432"),
                new EDLargeInteger("-703290432")));
        assertEquals("equal", edLI.min(new EDLargeInteger("234890"), new EDLargeInteger("234890")));
    }

    @Test
    public void min() {
        assertEquals("-73121329", edLI.min(
                new EDLargeInteger("67132982139"),
                new EDLargeInteger("-73121329")));

        assertEquals("equal", edLI.min(new EDLargeInteger("120301320132"), new EDLargeInteger("120301320132")));
    }

    @Test
    public void equal() {
        assertEquals(true, edLI.equal(new EDLargeInteger("23489932234"), new EDLargeInteger("23489932234")));
        assertEquals(false, edLI.equal(new EDLargeInteger("23-9b48234"), new EDLargeInteger("23-9b48234")));
        assertEquals(true, edLI.equal(new EDLargeInteger("-08432098"), new EDLargeInteger("-08432098")));
    }
}
