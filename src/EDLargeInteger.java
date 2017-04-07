import com.sun.org.apache.regexp.internal.RE;
import netscape.javascript.JSException;
import sun.plugin.javascript.navig.Array;
import sun.security.tools.keytool.Resources_zh_CN;

import java.math.BigInteger;
import java.util.*;

public class EDLargeInteger implements Comparable<EDLargeInteger> {

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


    //СЛОЖЕНИЕ
    public EDLargeInteger summa(EDLargeInteger str2) {
        ArrayList<Integer> Rezult = new ArrayList<Integer>();
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
            Rezult.add(0, sum);

        }
        if (ost != 0) {
            Rezult.add(0, ost);
        }

        return toEDLargeInteger(Rezult);

    }


    //ВЫЧИТАНИЕ
    public EDLargeInteger subtraction(EDLargeInteger str2) {
        ArrayList<Integer> Rezult = new ArrayList<Integer>();
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
            Rezult.add(0, sum);


        }

        return toEDLargeInteger(Rezult);

    }


    //УМНОЖЕНИЕ
    public EDLargeInteger proizv(EDLargeInteger str2) {
        ArrayList<Integer> massInt = new ArrayList<Integer>(IntArray);
        ArrayList<Integer> massInt2 = new ArrayList<Integer>(str2.IntArray);
        if (massInt.size() < massInt2.size()) {
            massInt = new ArrayList<Integer>(str2.IntArray);
            massInt2 = new ArrayList<Integer>(IntArray);

        }

        ArrayList[] massSlog = new ArrayList[massInt2.size()];
        for (int i = 0; i < massInt2.size(); i++) {
            massSlog[i] = new ArrayList<Integer>();
        }


//Получаем составные части произведения которые потом нужно сложить

        int proizv;
        int ost = 0;


        for (int i = massInt2.size() - 1; i >= 0; i--) {
            for (int j = massInt.size() - 1; j >= 0; j--) {

                proizv = massInt.get(j) * massInt2.get(i) + ost;
                ost = proizv/10;
                proizv = proizv % 10;
                massSlog[i].add(0, proizv);


            }

            if(ost!=0)
                massSlog[i].add(0,ost);

            int k = massInt2.size() - i-1;
            while (k > 0) {
                k--;
                massSlog[i].add (0);
            }

ost=0;
        }


        EDLargeInteger Rezult = new EDLargeInteger("");
        for (int i = 0; i < massInt2.size(); i++) {
            Rezult = Rezult.summa(toEDLargeInteger(massSlog[i]));
        }

        return Rezult;

    }


    //ДЕЛЕНИЕ
    public EDLargeInteger div(EDLargeInteger str2) {
        ArrayList<Integer> Rezult = new ArrayList<Integer>();
        ArrayList<Integer> massStr3 = new ArrayList<Integer>(IntArray);
        ArrayList<Integer> massStr4 = new ArrayList<Integer>(str2.IntArray);
        EDLargeInteger nol = new EDLargeInteger("0");
        while ((massStr3.size() - massStr4.size()) > 1) {
            massStr4.add(0);
            if ((massStr3.size() - massStr4.size() == 1) && (massStr3.get(0) > massStr4.get(0))) {
                massStr4.add(0);
            }


        }
        EDLargeInteger a = new EDLargeInteger(ArraytoString(massStr3));
        EDLargeInteger b = new EDLargeInteger(ArraytoString(massStr4));
        if (a.compareTo(b) == -1)
            return new EDLargeInteger("0");
        if (a.compareTo(b) == 0)
            return new EDLargeInteger("1");
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
            if ((boriginal.equals(b)) && (a.subtraction(b) == null)) {
                return toEDLargeInteger(Rezult);
            }
            if (a.equals(nol) == true) {
                while (ArraytoString(massStr4).equals(str2.Sdigit) != true) {
                    Rezult.add(Rezult.size(), 0);
                    massStr4.remove(massStr4.size() - 1);
                }
            } else {
                while ((a.subtraction(b) == null)) {
                    massStr4.remove(massStr4.size() - 1);
                    b = new EDLargeInteger(ArraytoString(massStr4));
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
        return delimoe.subtraction(chastnoe.proizv(divisor));
    }


    @Override
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


    public boolean equals(EDLargeInteger str2) {
        EDLargeInteger str = new EDLargeInteger(Sdigit);
        if (str.compareTo(str2) == 0) {
            return true;
        } else {
            return false;
        }
    }


    // ВОЗВРАТ БОЛЬШЕГО
    public EDLargeInteger max(EDLargeInteger str2) {
        if (compareTo(str2) == 1)
            return delzero(this);
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


    @Override
    public int hashCode() {
        return super.hashCode();
    }


    public void delete(int number) {
        StringBuilder str = new StringBuilder(Sdigit);
        Sdigit = str.deleteCharAt(number).toString();
        IntArray.remove(number);

    }


    public Integer size() {
        return IntArray.size();

    }


    public String toString() {
        return Sdigit;
    }


    private String ArraytoString(ArrayList<Integer> massInt) {
        String string = "";
        for (int i = 0; i < massInt.size(); i++) {
            string += massInt.get(i);
        }
        return string;

    }


    private EDLargeInteger delzero(EDLargeInteger ed) {
        StringBuilder strBuilder = new StringBuilder(ed.toString());
        while ((strBuilder.charAt(0) == '0') && (strBuilder.length() > 1)) {
            strBuilder.deleteCharAt(0);
        }
        ed = new EDLargeInteger(strBuilder.toString());
        return ed;
    }


    private EDLargeInteger toEDLargeInteger(ArrayList<Integer> massInt) {
        String string = "";
        for (int i = 0; i < massInt.size(); i++) {
            string += massInt.get(i);
        }
        return delzero(new EDLargeInteger(string));
    }


    //СРАВНЕНИЕ С РАБОТОЙ BGI
    public static void main(String[] args) {
        EDLargeInteger a = new EDLargeInteger("99954395049043905");
        EDLargeInteger b = new EDLargeInteger("1111");
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
//        EDLargeInteger delimoe=new EDLargeInteger("437857389573909");
//        EDLargeInteger divisor=new EDLargeInteger("4378573895739");
//        EDLargeInteger chastnoe = new EDLargeInteger(delimoe.div(divisor).toString());
//        System.out.println(delimoe.subtraction(chastnoe.proizv(divisor)));
//        System.out.println(new EDLargeInteger("4378573895739").proizv(new EDLargeInteger("100")));


    }
}
