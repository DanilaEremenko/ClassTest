import com.sun.org.apache.regexp.internal.RE;
import netscape.javascript.JSException;
import sun.plugin.javascript.navig.Array;
import sun.security.tools.keytool.Resources_zh_CN;

import java.math.BigInteger;
import java.util.*;

public class EDLargeInteger {

    private String Sdigit;
    private ArrayList<Integer> IntArray = new ArrayList<Integer>();

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
        for (int i = 0; i < strDigit.length(); i++) {

            IntArray.add(Character.getNumericValue(strDigit.charAt(i)));
        }

    }

    public int compareTo(EDLargeInteger str2) {
        ArrayList<Integer> massInt = new ArrayList<Integer>(IntArray);
        ArrayList<Integer> massInt2 = new ArrayList<Integer>(str2.IntArray);
        int Rezult = 0;
        if (massInt.size() == massInt2.size()) {
            for (int i = 0; i < massInt.size(); ) {
                if (massInt.get(i) == massInt2.get(i)) {
                    i++;
                } else {
                    if (massInt.get(i) > massInt2.get(i)) {
                        Rezult = 1;
                        break;
                    } else if (massInt2.get(i) > massInt.get(i)) {
                        Rezult = -1;
                        break;
                    }
                }


            }
        } else {
            if (massInt.size() > massInt2.size())
                Rezult = 1;
            else if (massInt2.size() > massInt.size())
                Rezult = -1;

        }
        return Rezult;
    }


    //СЛОЖЕНИЕ
    public EDLargeInteger summa(EDLargeInteger str2) {
        StringBuilder RezultSum = new StringBuilder();
        ArrayList<Integer> massInt = new ArrayList<Integer>(IntArray);
        ArrayList<Integer> massInt2 = new ArrayList<Integer>(str2.IntArray);
        //Подведение чисел под общий знаменатель
        if (massInt.size() != massInt2.size()) {

            while (massInt.size() > massInt2.size()) {
                massInt2.add(0, 0);
            }

            while (massInt2.size() > massInt.size()) {
                massInt.add(0, 0);
            }

        }


        int ost = 0;
//Сложение массивов
        for (int i = massInt.size() - 1; i >= 0; i--) {
            int sum = 0;
            if (ost == 0) {
                sum = massInt.get(i) + massInt2.get(i);
                ost = sum / 10;
                sum = sum % 10;
            } else {
                sum = massInt.get(i) + massInt2.get(i) + ost;
                ost = sum / 10;
                sum = sum % 10;
            }

            RezultSum.append(Integer.toString(sum));

        }
        if (ost != 0) {
            RezultSum.append(Integer.toString(ost));
        }

        RezultSum.reverse();
EDLargeInteger Rezult=new EDLargeInteger(delzero(RezultSum.toString()));
        return Rezult;

    }


    //ВЫЧИТАНИЕ
    public EDLargeInteger subtraction(EDLargeInteger str2) {
        StringBuilder RezultSub = new StringBuilder();
        ArrayList<Integer> massInt = new ArrayList<Integer>(IntArray);
        ArrayList<Integer> massInt2 = new ArrayList<Integer>(str2.IntArray);


        //Подведение чисел под общий знаменатель
        if (massInt.size() != massInt2.size()) {

            while (massInt.size() > massInt2.size()) {
                massInt2.add(0, 0);
            }

            while (massInt2.size() > massInt.size()) {
                massInt.add(0, 0);
            }

        }

        for (int i = 0; i < massInt.size(); i++) {
            if (massInt.get(i) > massInt2.get(i)) {
                break;
            }
            if (massInt.get(i) < massInt2.get(i)) {
                return null;
            }
        }


        for (int i = massInt.size() - 1; i >= 0; i--) {
            int sum = 0;
            if (massInt.get(i) < massInt2.get(i)) {
                massInt.set(i - 1, massInt.get(i - 1) - 1);
                sum = massInt.get(i) + 10 - massInt2.get(i);
            } else {
                sum = massInt.get(i) - massInt2.get(i);
            }
            RezultSub.reverse().append(Integer.toString((sum))).reverse();


        }

        return toEDLargeInteger(delzero(RezultSub.toString()));

    }


    //УМНОЖЕНИЕ
    public EDLargeInteger proizv(EDLargeInteger str2) {


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
        EDLargeInteger Rezult = new EDLargeInteger("");
        String RezultProizv = "0";
        for (int i = 0; i < strBuilder.length(); i++) {
            Rezult = Rezult.summa(toEDLargeInteger(stringBuilderslog[i].toString()));
        }

        return Rezult;

    }

    //ДЕЛЕНИЕ
    public EDLargeInteger div(EDLargeInteger str2) {
        ArrayList<Integer> Rezult = new ArrayList<Integer>();
        StringBuilder massStr = new StringBuilder(Sdigit);
        StringBuilder massStr2 = new StringBuilder(str2.Sdigit);
        EDLargeInteger nol = new EDLargeInteger("0");
        while ((massStr.length() - massStr2.length()) > 1) {
            massStr2.append("0");
            if ((massStr.length() - massStr2.length() == 1) && (Integer.valueOf(massStr.charAt(0)) > Integer.valueOf(massStr2.charAt(0)))) {
                massStr2.append("0");
            }


        }
        EDLargeInteger a = new EDLargeInteger(massStr.toString());
        EDLargeInteger b = new EDLargeInteger(massStr2.toString());
        EDLargeInteger boriginal = new EDLargeInteger(str2.Sdigit);
        Rezult.add(0, 0);
        while ((boriginal.equals(b) != true) || (a.subtraction(b) != null)) {
            if (a.subtraction(b) != null) {
                a = a.subtraction(b);
                Rezult.set(Rezult.size() - 1, Rezult.get(Rezult.size() - 1) + 1);
                for (int j = Rezult.size() - 1; j >= 0; j--) {
                    if (Rezult.get(j) == 10) {
                        if (j == 0) {
                            Rezult.add(0, 1);
                            Rezult.set(1, 0);
                        } else {
                            Rezult.set(j, 0);
                            Rezult.set(j - 1, Rezult.get(j - 1) + 1);
                        }
                    }
                }
            }
            if ((boriginal.equals(b) == true) && (a.subtraction(b) == null)) {
                return toEDLargeInteger(Rezult);
            }
            if (a.equals(nol) == true) {
                while (massStr2.toString().equals(str2.Sdigit) != true) {
                    Rezult.add(Rezult.size(), 0);
                    massStr2.reverse().deleteCharAt(0).reverse();
                }
            } else {
                while ((a.subtraction(b) == null)) {
                    b = new EDLargeInteger(massStr2.reverse().deleteCharAt(0).reverse().toString());
                    Rezult.add(Rezult.size(), 0);
                    if ((boriginal.equals(b) == true) && (a.subtraction(b) == null))
                        return toEDLargeInteger(Rezult);
                }
            }

        }

        return delzero(toEDLargeInteger(Rezult));
    }

    //ОСТАТОК ОТ ДЕЛЕНИЯ
    public EDLargeInteger mod(EDLargeInteger divisor) {
        EDLargeInteger delimoe = new EDLargeInteger(Sdigit);
        EDLargeInteger chastnoe = new EDLargeInteger(delimoe.div(divisor).toString());
        return delimoe.subtraction(divisor.proizv(chastnoe));
    }


    // ВОЗВРАТ БОЛЬШЕГО
    public EDLargeInteger max(EDLargeInteger str2) {
        EDLargeInteger str = new EDLargeInteger(Sdigit);
        if (str.compareTo(str2) == 1)
            return delzero(str);
        else {
            return delzero(str2);
        }


    }


    //ВОЗВРАТ МЕНЬШЕГО
    public EDLargeInteger min(EDLargeInteger str2) {
        EDLargeInteger str = new EDLargeInteger(Sdigit);
        if (str.compareTo(str2) == 1)
            return delzero(str2);
        else {
            return delzero(str);
        }

    }


    //СРАВНЕНИЕ НА РАВЕНСТВО
    public boolean equals(EDLargeInteger str2) {
        EDLargeInteger str = new EDLargeInteger(Sdigit);
        if (str.compareTo(str2) == 0) {
            return true;
        } else {
            return false;
        }
    }



    public void delete(int number) {
        StringBuilder str = new StringBuilder(Sdigit);
        Sdigit=str.deleteCharAt(number).toString();
        IntArray.remove(number);

    }


    public Integer size() {
        return IntArray.size();

    }


    public String toString() {
        return "" + Sdigit;
    }


    //НЕ ДЛЯ ТЕСТОВ

    private String delzero(String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        while ((strBuilder.charAt(0) == '0') && (strBuilder.length() > 1)) {
            strBuilder.deleteCharAt(0);
        }
        return strBuilder.toString();
    }


    private EDLargeInteger delzero(EDLargeInteger ed) {
        StringBuilder strBuilder = new StringBuilder(ed.toString());
        while ((strBuilder.charAt(0) == '0') && (strBuilder.length() > 1)) {
            strBuilder.deleteCharAt(0);
        }
        ed=new EDLargeInteger(strBuilder.toString());
        return ed;
    }


    private EDLargeInteger toEDLargeInteger(ArrayList<Integer> massInt) {
        String string = "";
        for (int i = 0; i < massInt.size(); i++) {
            string += massInt.get(i);
        }
        EDLargeInteger ed = new EDLargeInteger(delzero(string));
        return ed;
    }


    private EDLargeInteger toEDLargeInteger(String string) {
        EDLargeInteger ed = new EDLargeInteger(string);
        return ed;

    }




    //СРАВНЕНИЕ С РАБОТОЙ BGI
    public static void main(String[] args) {
        EDLargeInteger a = new EDLargeInteger("2300040540650000956865488");
        EDLargeInteger b = new EDLargeInteger("1289438434533");
        BigInteger d = new BigInteger(a.toString());
        BigInteger c = new BigInteger(b.toString());
        System.out.println();
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
        System.out.println(a.div(b));
        System.out.println(d.divide(c));
        System.out.println("Деление с остатком");
        System.out.println(a.mod(b));
        System.out.println(d.mod(c));
        System.out.println("Compare");
        System.out.println(a.compareTo(b));
        System.out.println(d.compareTo(c));
        System.out.println("Сравнение больше");
        System.out.println(a.max(b));
        System.out.println(d.max(c));
        System.out.println("Сравнение меньше ");
        System.out.println(a.min(b));
        System.out.println(d.min(c));
        System.out.println("Сравнение на равенство");
        System.out.println(a.equals(b));
        System.out.println(d.equals(c));

    }
}
