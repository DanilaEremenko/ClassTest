import java.math.BigInteger;
import java.util.*;

public class EDLargeInteger {

    private String Sdigit;
    private byte Compare = 0;
    private String Maxdigit;
    private String Mindigit;
    private boolean Equals = true;


    public EDLargeInteger(String strDigit) {


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


    private void Comparator(EDLargeInteger str2) {
        StringBuilder strBuilder = new StringBuilder(Sdigit);
        StringBuilder strBuilder2 = new StringBuilder(str2.Sdigit);
        this.Maxdigit = strBuilder.toString();
        this.Mindigit = strBuilder2.toString();
        this.Compare = 0;
        this.Equals = true;
        if (strBuilder.length() > strBuilder2.length()) {
            this.Maxdigit = strBuilder.toString();
            this.Mindigit = strBuilder2.toString();
            this.Compare = 1;
            this.Equals = false;
        }
        if (strBuilder2.length() > strBuilder.length()) {
            this.Mindigit = strBuilder.toString();
            this.Maxdigit = strBuilder2.toString();
            this.Compare = -1;
            this.Equals = false;
        }
        if (strBuilder.length() == strBuilder2.length()) {

            for (int i = 0; i < strBuilder.length(); ) {
                int massInt = Character.getNumericValue(strBuilder.charAt(i));
                int massInt2 = Character.getNumericValue(strBuilder2.charAt(i));
                if (massInt == massInt2) {
                    i++;
                } else {
                    if (massInt > massInt2) {
                        this.Maxdigit = strBuilder.toString();
                        this.Mindigit = strBuilder2.toString();
                        this.Compare = 1;
                        this.Equals = false;
                        break;
                    } else if (massInt2 > massInt) {
                        this.Mindigit = strBuilder.toString();
                        this.Maxdigit = strBuilder2.toString();
                        this.Compare = -1;
                        this.Equals = false;
                        break;
                    }
                }


            }


        }
    }


    //СЛОЖЕНИЕ
    public String summa(EDLargeInteger str2) {
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


        int massInt, massInt2;
        int ost = 0;
//Сложение массивов
        for (int i = strBuilder.length() - 1; i >= 0; i--) {
            massInt = Character.getNumericValue(strBuilder.charAt(i));
            massInt2 = Character.getNumericValue(strBuilder2.charAt(i));
            int sum = 0;
            if (ost == 0) {
                sum = massInt + massInt2;
                ost = sum / 10;
                sum = sum % 10;
            } else {
                sum = massInt + massInt2 + ost;
                ost = sum / 10;
                sum = sum % 10;
            }

            String a = Integer.toString(sum);
            RezultSum.append(a);

        }
        if (ost != 0) {
            RezultSum.append(Integer.toString(ost));
        }

        RezultSum.reverse();

        return delzero(RezultSum.toString());

    }


    //ВЫЧИТАНИЕ
    public String subtraction(EDLargeInteger str2) {
        StringBuilder RezultSub = new StringBuilder();
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

        int massInt[] = new int[strBuilder.length()];
        int massInt2[] = new int[strBuilder.length()];
        int ost = 0;

        for (int i = strBuilder.length() - 1; i >= 0; i--) {
            massInt[i] = Character.getNumericValue(strBuilder.charAt(i));
            massInt2[i] = Character.getNumericValue(strBuilder2.charAt(i));
        }
        if (massInt[0] < massInt2[0]) {
            throw new IllegalArgumentException();
        } else {

            for (int i = strBuilder.length() - 1; i >= 0; i--) {
                int sum = 0;
                if (massInt[i] < massInt2[i]) {
                    massInt[i - 1] = massInt[i - 1] - 1;
                    sum = massInt[i] + 10 - massInt2[i];
                } else {
                    sum = massInt[i] - massInt2[i];
                }
                RezultSub.reverse().append(Integer.toString((sum))).reverse();


            }

            return delzero(RezultSub.toString());
        }
    }


    //ДЕЛЕНИЕ
    public String divide(EDLargeInteger divisor) {
        StringBuilder delimoe = new StringBuilder(Sdigit);
        StringBuilder delitel = new StringBuilder(divisor.Sdigit);
        StringBuilder strBuilder = new StringBuilder();
        StringBuilder strBuilder2 = new StringBuilder();
        String RezultDiv="";
        int massInt[] = new int[delimoe.length() - 1];
        int massInt2[] = new int[delitel.length() - 1];
        for (int i = 0; i < delimoe.length(); i++) {
            massInt[i] = Character.getNumericValue(delimoe.charAt(i));
            massInt2[i] = Character.getNumericValue(delitel.charAt(i));
        }


        for(int i=0;strBuilder.length()< delitel.length();i++) {
            if(strBuilder.length()<delitel.length())
            {
                strBuilder.append(massInt2[i]);
            }
            else if(strBuilder.length()==delitel.length())
            {
                String str=strBuilder.toString();
                while(str!="0") {
                    str=subtraction(str,delitel.toString());
                    RezultDiv=summa(RezultDiv,"1");

                }
            }
        }




return "";
}

    //ОСТАТОК ОТ ДЕЛЕНИЯ
    public String mod(EDLargeInteger divisor) {
        StringBuilder strBuilder = new StringBuilder(Sdigit);
        StringBuilder strBuilder2 = new StringBuilder(divisor.Sdigit);
        StringBuilder RezultDiv = new StringBuilder();
        int divisor2 = 1;

        for (int i = 0; i < strBuilder2.length(); i++) {
            int a = Character.getNumericValue(strBuilder2.charAt(i));
            if (i > 0) {
                divisor2 = divisor2 * 10 + a;
            } else {
                divisor2 = a;
            }
        }
        char massChar[] = new char[strBuilder.length()];
        int massInt[] = new int[strBuilder.length()];
        int div = 0;//частное
        int ost = 0;//остаток при вычитании
        int delimoe;


        for (int i = 0; i < strBuilder.length(); i++) {

            massChar[i] = strBuilder.charAt(i);
            massInt[i] = Character.getNumericValue(massChar[i]);
        }
        for (int i = 0; i < strBuilder.length(); ) {

            delimoe = ost * 10 + massInt[i];
            while (delimoe < divisor2) {
                delimoe = delimoe * 10 + massInt[i + 1];
                i++;
            }

            div = delimoe / divisor2;
            ost = delimoe % divisor2;
            String s = Integer.toString(div);
            RezultDiv.append(s);
            i++;

            while ((i < strBuilder.length()) && (massInt[i] == 0)) {
                RezultDiv.append("0");
                i++;
            }

        }


        String Rezultdivide = "" + ost;
        return Rezultdivide;

    }

    //УМНОЖЕНИЕ
    public String proizv(EDLargeInteger str2) {


        StringBuilder strBuilder = new StringBuilder(Sdigit);
        StringBuilder strBuilder2 = new StringBuilder(str2.Sdigit);

        if (strBuilder.length() != strBuilder2.length()) {

            while (strBuilder.length() > strBuilder2.length()) {
                strBuilder2.reverse().append(0).reverse();
            }

            while (strBuilder2.length() > strBuilder.length()) {
                strBuilder.reverse().append(0).reverse();
            }

        }


        StringBuilder[] stringBuilderslog = new StringBuilder[strBuilder.length()];
        for (int i = strBuilder.length() - 1; i >= 0; i--) {
            stringBuilderslog[i] = new StringBuilder();
        }


//Получаем составные части произведения которые потом нужно сложить
        int massInt[] = new int[strBuilder.length()];
        int massInt2[] = new int[strBuilder.length()];

        for (int i = strBuilder.length() - 1; i >= 0; i--) {
            massInt[i] = Character.getNumericValue(strBuilder.charAt(i));
            massInt2[i] = Character.getNumericValue(strBuilder2.charAt(i));
        }

        int proizv = 0;
        int ost = 0;


        for (int i = strBuilder.length() - 1; i >= 0; i--) {
            for (int j = strBuilder.length() - 1; j >= 0; j--) {


                if (ost == 0) {

                    proizv = massInt[j] * massInt2[i];
                    ost = proizv / 10;
                    proizv = proizv % 10;

                } else {

                    proizv = massInt[j] * massInt2[i] + ost;
                    ost = proizv / 10;
                    proizv = proizv % 10;

                }

                stringBuilderslog[i].append(Integer.toString(proizv));


            }


            int k = i;
            if (ost == 0) {
                stringBuilderslog[i].reverse();
                while (k < (strBuilder.length() - 1)) {
                    k++;
                    stringBuilderslog[i].append("0");
                }
            } else {
                stringBuilderslog[i].append(ost).reverse();
                while (k < (strBuilder.length() - 1)) {
                    k++;
                    stringBuilderslog[i].append("0");
                }

            }
            ost = 0;


        }
//Получили составные части произведения


        //  Подведение чисел под общий знаменатель
        int max = 0;
        for (int i = 0; i < strBuilder.length(); i++) {
            if (max < stringBuilderslog[i].length())
                max = stringBuilderslog[i].length();
        }

        for (int i = 0; i < strBuilder.length(); i++) {
            if (stringBuilderslog[i].length() < max) {
                while (stringBuilderslog[i].length() < max) {
                    stringBuilderslog[i].reverse().append(0).reverse();
                }
            }

        }
        String stringslog[] = new String[strBuilder.length()];


        for (int i = strBuilder.length() - 1; i >= 0; i--) {
            stringslog[i] = stringBuilderslog[i].toString();
        }

        String RezultProizv = "0";
        for (int i = 0; i < strBuilder.length(); i++) {
            RezultProizv = summa(RezultProizv, stringslog[i]);
        }

        return delzero(RezultProizv);

    }

    //ВОЗВРАТ БОЛЬШЕГО
    public String max(EDLargeInteger str2) {
        Comparator(str2);
        return Maxdigit;
    }

    //ВОЗВРАТ МЕНЬШЕГО
    public String min(EDLargeInteger str2) {
        Comparator(str2);
        return Mindigit;
    }

    //СРАВНЕНИЕ НА РАВЕНСТВО
    public boolean equals(EDLargeInteger str2) {
        Comparator(str2);
        return Equals;
    }

    public byte compareTo(EDLargeInteger str2) {

        Comparator(str2);
        return Compare;
    }


//НЕ ДЛЯ ТЕСТОВ

    private String subtraction(String str,String str2) {
        StringBuilder RezultSub = new StringBuilder();
        StringBuilder strBuilder=new StringBuilder(str);
        StringBuilder strBuilder2=new StringBuilder(str2);

        //Подведение чисел под общий знаменатель
        if (strBuilder.length() != strBuilder2.length()) {

            while (strBuilder.length() > strBuilder2.length()) {
                strBuilder2.reverse().append(0).reverse();
            }

            while (strBuilder2.length() > strBuilder.length()) {
                strBuilder.reverse().append(0).reverse();
            }

        }

        int massInt[] = new int[strBuilder.length()];
        int massInt2[] = new int[strBuilder.length()];
        int ost = 0;

        for (int i = strBuilder.length() - 1; i >= 0; i--) {
            massInt[i] = Character.getNumericValue(strBuilder.charAt(i));
            massInt2[i] = Character.getNumericValue(strBuilder2.charAt(i));
        }
        if (massInt[0] < massInt2[0]) {
            throw new IllegalArgumentException();
        } else {

            for (int i = strBuilder.length() - 1; i >= 0; i--) {
                int sum = 0;
                if (massInt[i] < massInt2[i]) {
                    massInt[i - 1] = massInt[i - 1] - 1;
                    sum = massInt[i] + 10 - massInt2[i];
                } else {
                    sum = massInt[i] - massInt2[i];
                }
                RezultSub.reverse().append(Integer.toString((sum))).reverse();


            }


        }
        return RezultSub.toString();
    }

    //СЛОЖЕНИЕ
    private String summa(String str, String str2) {
        // Создание strBuilder и strBuilder2
        StringBuilder strBuilder = new StringBuilder(str);
        StringBuilder strBuilder2 = new StringBuilder(str2);
        if (strBuilder2.length() > strBuilder.length()) {
            strBuilder = new StringBuilder(str2);
            strBuilder2 = new StringBuilder(str);
        }

        strBuilder.reverse();
        strBuilder2.reverse();
        StringBuilder RezultSumbuilder = new StringBuilder("");
        //Подведение чисел под общий знаменатель
        if (strBuilder.length() != strBuilder2.length()) {

            while (strBuilder.length() > strBuilder2.length()) {
                strBuilder2.append(0);
            }

            while (strBuilder2.length() > strBuilder.length()) {
                strBuilder.append(0);
            }

        }


        /*Создание массивов massInt[] massChar[] massInt2[] и massChar2[]
        * чтобы переводить и поразрядно складывать цифры чисел*/

        int[] massInt = new int[strBuilder.length()];
        char[] massChar = new char[strBuilder.length()];
        int[] massInt2 = new int[strBuilder.length()];
        char[] massChar2 = new char[strBuilder.length()];
        int ost = 0;
//Сложение массивов
        for (int i = 0; i < (strBuilder.length()); i++) {
            massChar[i] = strBuilder.charAt(i);
            massInt[i] = Character.getNumericValue(massChar[i]);
            massChar2[i] = strBuilder2.charAt(i);
            massInt2[i] = Character.getNumericValue(massChar2[i]);
            int sum = 0;
            if (ost == 0) {
                sum = massInt[i] + massInt2[i];
                ost = sum / 10;
                sum = sum % 10;
            } else {
                sum = massInt[i] + massInt2[i] + ost;
                ost = sum / 10;
                sum = sum % 10;
            }

            String a = Integer.toString(sum);
            RezultSumbuilder.append(a);

            /*System.out.println("Сумма в разряде равна" + sum);*/
        }
        if (ost != 0) {
            String a = Integer.toString(ost);
            RezultSumbuilder.append(a);
        }
        //Вывод ответа в сравнении с подсчетом через BigInteger
        RezultSumbuilder.reverse();
        String RezultSum = RezultSumbuilder.toString();
        RezultSum = RezultSum.replaceFirst("^0*", "");
        return RezultSum;
    }

    //УДАЛЕНИЕ НЕЗНАЧАЩИХ НУЛЕЙ
    private String delzero(String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        while ((strBuilder.charAt(0) == '0') && (strBuilder.length() > 1)) {
            strBuilder.deleteCharAt(0);
        }

        return strBuilder.toString();
    }

    public static void main(String[] args) {

        EDLargeInteger a = new EDLargeInteger("95623489299999999999999");
        EDLargeInteger b = new EDLargeInteger("95623489299999999999999");
        BigInteger d = new BigInteger("95623489299999999999999");
        BigInteger c = new BigInteger("95623489299999999999999");
        System.out.println(a);
        System.out.println(a.summa(b));
        System.out.println("Сложение");
        System.out.println(a.summa(b));
        System.out.println(d.add(c));
        System.out.println("Вычитание");
        System.out.println(a.subtraction(b));
        System.out.println(d.subtract(c));
        System.out.println("Произведение");
        System.out.println(a.proizv(b));
        System.out.println(d.multiply(c));
        System.out.println("Деление");
//      System.out.println(a.divide(b));
        System.out.println(d.divide(c));
//        System.out.println("Деление с остатком");
//        System.out.println(a.mod(b));
//        System.out.println(d.mod(c));
        System.out.println("Сравнение больше");
        System.out.println(a.max(b));
        System.out.println(d.max(c));
        System.out.println("Сравнение меньше ");
        System.out.println(a.min(b));
        System.out.println(d.min(c));
        System.out.println("Сравнение на равенство");
        System.out.println(a.equals(b));
        System.out.println(d.equals(c));
        System.out.println(d.compareTo(c));
        System.out.println(a.compareTo(b));
        EDLargeInteger x = new EDLargeInteger("95623489299999999999999");
        EDLargeInteger y = new EDLargeInteger("95623489212412");
        System.out.println(x.max(y));
        System.out.println(x.min(y));
        System.out.println(x.compareTo(y));
        System.out.println(x.equals(y));


    }
}

