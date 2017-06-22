import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;


public class Tests {


    @Test
    public void summa() {
        EDLargeInteger edLI = new EDLargeInteger("986789678967");
        EDLargeInteger edLI2 = new EDLargeInteger("89798568967");
        BigInteger BI = new BigInteger(edLI.toString());
        BigInteger BI2 = new BigInteger(edLI2.toString());
        assertEquals(BI.add(BI2).toString(), edLI.summa(edLI2).toString());
        assertEquals(new EDLargeInteger("99"), new EDLargeInteger("0").summa(new EDLargeInteger("99")));

    }

    @Test
    public void multiply() {
        EDLargeInteger edLI = new EDLargeInteger("234892348453390523");
        EDLargeInteger edLI2 = new EDLargeInteger("930045045909096786089586");
        BigInteger BI = new BigInteger(edLI.toString());
        BigInteger BI2 = new BigInteger(edLI2.toString());
        assertEquals(BI.multiply(BI2).toString(), edLI.multiply(edLI2).toString());
        assertEquals(new EDLargeInteger("0"), new EDLargeInteger("0").multiply(new EDLargeInteger("99")));
    }

    @Test
    public void subtraction() {
        EDLargeInteger edLI = new EDLargeInteger("327942787842378");
        EDLargeInteger edLI2 = new EDLargeInteger("98978909078907");
        BigInteger BI = new BigInteger(edLI.toString());
        BigInteger BI2 = new BigInteger(edLI2.toString());
        assertEquals(BI.subtract(BI2).toString(), edLI.subtraction(edLI2).toString());
        assertEquals(null, new EDLargeInteger("0").subtraction(new EDLargeInteger("99")));
        assertEquals(new EDLargeInteger("99"), new EDLargeInteger("99").subtraction(new EDLargeInteger("0")));

    }

    @Test
    public void div() {
        EDLargeInteger edLI = new EDLargeInteger("1321332147457575678");
        EDLargeInteger edLI2 = new EDLargeInteger("8932");
        BigInteger BI = new BigInteger(edLI.toString());
        BigInteger BI2 = new BigInteger(edLI2.toString());
        assertEquals(BI.divide(BI2).toString(), edLI.div(edLI2).toString());
        assertEquals(new EDLargeInteger("0"), new EDLargeInteger("0").div(new EDLargeInteger("99")));
        //При делении на ноль выбрасывается ArithmeticException("EDLargeInteger divide by zero");
    }

    @Test
    public void mod() {
        EDLargeInteger edLI = new EDLargeInteger("98765456789876");
        EDLargeInteger edLI2 = new EDLargeInteger("567");
        BigInteger BI = new BigInteger(edLI.toString());
        BigInteger BI2 = new BigInteger(edLI2.toString());
        assertEquals(BI.mod(BI2).toString(), edLI.mod(edLI2).toString());
    }

    @Test
    public void max() {
        EDLargeInteger edLI = new EDLargeInteger("111111111");
        EDLargeInteger edLI2 = new EDLargeInteger("111111112");
        BigInteger BI = new BigInteger(edLI.toString());
        BigInteger BI2 = new BigInteger(edLI2.toString());
        assertEquals(BI.max(BI2).toString(), edLI.max(edLI2).toString());
    }

    @Test
    public void min() {
        EDLargeInteger edLI = new EDLargeInteger("96859578685959");
        EDLargeInteger edLI2 = new EDLargeInteger("96859578685958");
        BigInteger BI = new BigInteger(edLI.toString());
        BigInteger BI2 = new BigInteger(edLI2.toString());
        assertEquals(BI.min(BI2).toString(), edLI.min(edLI2).toString());
    }

    @Test
    public void equals() {
        assertEquals(true, new EDLargeInteger("100").equals(new EDLargeInteger("100")));
        assertEquals(false, new EDLargeInteger("100").equals(new EDLargeInteger("101")));
    }

    @Test
    public void compareTo() {
        EDLargeInteger edLI = new EDLargeInteger("987");
        EDLargeInteger edLI2 = new EDLargeInteger("93299");
        BigInteger BI = new BigInteger(edLI.toString());
        BigInteger BI2 = new BigInteger(edLI2.toString());
        assertEquals(BI.compareTo(BI2), edLI.compareTo(edLI2));
    }

}
