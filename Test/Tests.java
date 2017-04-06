import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;


public class Tests {



    @Test
    public void summa() {
        EDLargeInteger edLI = new EDLargeInteger("987");
        EDLargeInteger edLI2= new EDLargeInteger("93299");
        BigInteger BI =new BigInteger(edLI.toString());
        BigInteger BI2=new BigInteger(edLI2.toString());
        assertEquals(BI.add(BI2).toString(), edLI.summa(edLI2).toString());
    }

    @Test
    public void proizv() {
        EDLargeInteger edLI = new EDLargeInteger("987");
        EDLargeInteger edLI2= new EDLargeInteger("93299");
        BigInteger BI =new BigInteger(edLI.toString());
        BigInteger BI2=new BigInteger(edLI2.toString());
        assertEquals(BI.multiply(BI2).toString(), edLI.proizv(edLI2).toString());
    }

    @Test
    public void subtraction() {
        EDLargeInteger edLI = new EDLargeInteger("93299");
        EDLargeInteger edLI2= new EDLargeInteger("932");
        BigInteger BI =new BigInteger(edLI.toString());
        BigInteger BI2=new BigInteger(edLI2.toString());
        assertEquals(BI.subtract(BI2).toString(), edLI.subtraction(edLI2).toString());


    }

    @Test
    public void divide() {
        EDLargeInteger edLI = new EDLargeInteger("987");
        EDLargeInteger edLI2= new EDLargeInteger("93299");
        BigInteger BI =new BigInteger(edLI.toString());
        BigInteger BI2=new BigInteger(edLI2.toString());
        assertEquals(BI.divide(BI2).toString(), edLI.div(edLI2).toString());
    }

    @Test
    public void mod() {
        EDLargeInteger edLI = new EDLargeInteger("987");
        EDLargeInteger edLI2= new EDLargeInteger("93299");
        BigInteger BI =new BigInteger(edLI.toString());
        BigInteger BI2=new BigInteger(edLI2.toString());
        assertEquals(BI.mod(BI2).toString(), edLI.mod(edLI2).toString());
    }

    @Test
    public void max() {
        EDLargeInteger edLI = new EDLargeInteger("987");
        EDLargeInteger edLI2= new EDLargeInteger("93299");
        BigInteger BI =new BigInteger(edLI.toString());
        BigInteger BI2=new BigInteger(edLI2.toString());
        assertEquals(BI.max(BI2).toString(), edLI.max(edLI2).toString());
    }

    @Test
    public void min() {
        EDLargeInteger edLI = new EDLargeInteger("987");
        EDLargeInteger edLI2= new EDLargeInteger("93299");
        BigInteger BI =new BigInteger(edLI.toString());
        BigInteger BI2=new BigInteger(edLI2.toString());
        assertEquals(BI.min(BI2).toString(), edLI.min(edLI2).toString());
    }

    @Test
    public void equals() {
        assertEquals(true,new EDLargeInteger("100").equals(new EDLargeInteger("100")));
        assertEquals(false,new EDLargeInteger("100").equals(new EDLargeInteger("101")));
    }

    @Test
    public void compareTo() {
        EDLargeInteger edLI = new EDLargeInteger("987");
        EDLargeInteger edLI2= new EDLargeInteger("93299");
        BigInteger BI =new BigInteger(edLI.toString());
        BigInteger BI2=new BigInteger(edLI2.toString());
        assertEquals(BI.compareTo(BI2), edLI.compareTo(edLI2));
    }
}
