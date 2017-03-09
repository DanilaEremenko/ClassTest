import java.util.*;


public class EDInt {
    String Sdigit;

    //SortedSet<String> numberSet = new TreeSet<>();
    //КОНСТРУКТОР ВРОДЕ КАК
    public EDInt(String  strDigit) {

        int sovpadenie = 0;
        StringBuilder digits = new StringBuilder("0123456789");
        char massChar[] = new char[10];
        for (int j = 0; j < 10; j++) {
            massChar[j] = digits.charAt(j);
        }
        for (int i = 0; i < strDigit.length(); i++) {
            for (int j = 0; j < 10; j++) {
                if (strDigit.charAt(i) == massChar[j]) {
                    sovpadenie += 1;
                    break;

                }
            }
        }
        if (sovpadenie != strDigit.length()) {
            {
                throw new IllegalArgumentException();
            }
        } else if (sovpadenie == strDigit.length())
            this.Sdigit=strDigit;

    }

//    public EDInt summa(EDInt str2)
//    {
//    }

    private EDInt delzero(EDInt edi) {
        StringBuilder str = new StringBuilder(edi.Sdigit);
        while (str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }
        return edi;
    }

    public static void main(String[] args) {
        EDInt a=new EDInt("5");
        System.out.println(a);
    }
}


