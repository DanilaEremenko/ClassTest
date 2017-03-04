/**
 * Created by 801674 on 24.02.2017.
 */
import com.sun.org.apache.regexp.internal.RE;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by danil on 17.02.2017.
 */

public class Proekt {
    public static void main(String[] args) {

        String str = "896745788945";
        String str2 = "769905689706065";
        String RezultSum=suma(str, str2);
        System.out.println("Сумма равна = "+RezultSum);
        String RezultProizv=proizv(str,str2);
        System.out.println("Произведение равно = "+RezultProizv);

    }


    static String suma(String str, String str2) {
        // Создание strBuilder и strBuilder2
        StringBuilder strBuilder = new StringBuilder(str);
        StringBuilder strBuilder2 = new StringBuilder(str2);
        if(str2.length()>str.length()){strBuilder = new StringBuilder(str2);
            strBuilder2 = new StringBuilder(str);}

        strBuilder.reverse();
        strBuilder2.reverse();
        StringBuilder RezultSumbuilder=new StringBuilder("");
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
        int max;
        if (strBuilder.length() > strBuilder2.length()) {
            max = strBuilder.length();
        } else {
            max = strBuilder2.length();
        }
        int[] massInt = new int[max];
        char[] massChar = new char[max];
        int[] massInt2 = new int[max];
        char[] massChar2 = new char[max];
        int ost = 0;
//Сложение массивов
        for (int i = 0; i < (max); i++) {
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
        String RezultSum=RezultSumbuilder.toString();
        BigInteger b1 = new BigInteger("999");
        BigInteger b2 = new BigInteger("1");
        /*System.out.println("Подсчет через BigInteger = " + b1.add(b2));*/
        return RezultSum;
    }






    static String proizv(String str,String str2)
    { /*П
        Р
        О
        И
        З
        В
        Е
        Д
        Е
        Н
        И
        Е
         */
        /*
        System.out.println("Первый множитель"+str);
        System.out.println("Второй множитель"+str2);
        */
        StringBuilder strBuilder = new StringBuilder(str);
        StringBuilder strBuilder2 = new StringBuilder(str2);

        if (strBuilder.length() > strBuilder2.length()) {

            while (strBuilder.length() > strBuilder2.length()) {
                strBuilder2.reverse();
                strBuilder2.append(0);
                strBuilder2.reverse();
            }
        }
        if(strBuilder2.length()>strBuilder.length()){

            while (strBuilder2.length() > strBuilder.length()) {
                strBuilder.reverse();
                strBuilder.append(0);
                strBuilder.reverse();
            }
        }
/*
        System.out.println("Первый множитель после уравнивания"+strBuilder);
        System.out.println("Второй множитель после уравнивания"+strBuilder2);
*/
        //Подведение чисел под общий знаменатель

        StringBuilder[] stringBuilderslog = new StringBuilder[strBuilder.length()];
        for (int i = 0; i < strBuilder.length(); i++) {
            stringBuilderslog[i] = new StringBuilder("");
        }


//Получаем составные части произведения которые потом нужно сложить
        char massChar[]=new char[strBuilder.length()];
        char massChar2[]=new char[strBuilder.length()];
        int massInt[]=new int[strBuilder.length()];
        int massInt2[]=new int[strBuilder.length()];
        int proizv = 0;
        int ost=0;








        for (int i = strBuilder.length()-1; i>=0; i--) {

            for (int j= strBuilder.length()-1; j >=0; j--) {
                massChar[j] = strBuilder.charAt(j);
                massInt[j] = Character.getNumericValue(massChar[j]);
                massChar2[i] = strBuilder2.charAt(i);
                massInt2[i] = Character.getNumericValue(massChar2[i]);

                if (ost == 0) {

                    proizv = massInt[j] * massInt2[i];
                    ost = proizv / 10;
                    proizv = proizv % 10;

                } else {

                    proizv = massInt[j] * massInt2[i] + ost;
                    ost = proizv / 10;
                    proizv = proizv % 10;

                }

                String a=Integer.toString(proizv);
                stringBuilderslog[i].append(a);


            }


            int k=i;
            if(ost==0) {
                stringBuilderslog[i].reverse();
                while(k<(strBuilder.length()-1)) {
                    k++;
                    stringBuilderslog[i].append("0");
                }
            }

            else{
                stringBuilderslog[i].append(ost);
                stringBuilderslog[i].reverse();
                while(k<(strBuilder.length()-1)) {
                    k++;
                    stringBuilderslog[i].append("0");
                }

            }
            ost=0;










        }
//Получили составные части произведения


/*
        for(int i=strBuilder.length()-1;i>=0;i--){
            System.out.println((strBuilder.length() - i) +"stringBuilderslog перед уравнением = "+stringBuilderslog[i]);
        }
*/

        //  Подведение чисел под общий знаменатель
        int max = 0;
        for (int i = 0; i < strBuilder.length(); i++) {
            if (max < stringBuilderslog[i].length())
                max = stringBuilderslog[i].length();
        }

        for (int i = 0; i < strBuilder.length(); i++) {
            if (stringBuilderslog[i].length() < max) {
                while (stringBuilderslog[i].length() < max) {
                    stringBuilderslog[i].reverse();
                    stringBuilderslog[i].append(0);
                    stringBuilderslog[i].reverse();
                }
            }

        }
        String stringslog[]=new String[strBuilder.length()];


        for(int i=strBuilder.length()-1;i>=0;i--)
        {
            stringslog[i]=stringBuilderslog[i].toString();
            /*System.out.println((strBuilder.length() - i) + " Слогаемое = " + stringslog[i]);*/
        }

        String RezultProizv="0";
        String zero2;
        for (int i=0;i<strBuilder.length();i++){
            zero2=suma(RezultProizv,stringslog[i]);
            RezultProizv=zero2;
        }
        return RezultProizv;




    }


}





