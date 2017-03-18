import java.util.*;


public class EDInt {
    String Sdigit;

    //SortedSet<String> numberSet = new TreeSet<>();
    //КОНСТРУКТОР ВРОДЕ КАК
    public EDInt(String strDigit) {

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
            this.Sdigit = strDigit;

    }

    public String summa(EDInt str2) {
        StringBuilder RezultSum = new StringBuilder();
        StringBuilder strBuilder = new StringBuilder(Sdigit);
        StringBuilder strBuilder2 = new StringBuilder(str2.Sdigit);
        //Подведение чисел под общий знаменатель
        if (strBuilder.length() != strBuilder2.length()) {

            while (strBuilder.length() > strBuilder2.length()) {
                strBuilder2.reverse().append(0).reverse();
            }

            while (strBuilder2.length() > strBuilder.length()) {
                strBuilder.reverse().append(0).reverse();
            }

        }

        int Int, Int2;
        char Char, Char2;
        int ost = 0;
        //Поразрядное сложение чисел
        for (int i = strBuilder.length() - 1; i >= 0; i--) {
            Char = strBuilder.charAt(i);
            Int = Character.getNumericValue(Char);
            Char2 = strBuilder2.charAt(i);
            Int2 = Character.getNumericValue(Char2);
            int sum = 0;
            if (ost == 0) {
                sum = Int + Int2;
                ost = sum / 10;
                sum = sum % 10;
            } else {
                sum = Int + Int2 + ost;
                ost = sum / 10;
                sum = sum % 10;
            }

            RezultSum.append("" + sum);


        }
        if (ost != 0) {
            RezultSum.append("" + ost);
        }
        RezultSum = new StringBuilder(delzero(RezultSum.reverse()));


        Sdigit=RezultSum.toString();
        return Sdigit;

    }

    private String delzero(StringBuilder str) {
        while (str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        EDInt a = new EDInt("5");
        EDInt b = new EDInt("555555");
        String c=a.summa(b);
        System.out.println(c);
    }
}


