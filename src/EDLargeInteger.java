import java.math.BigInteger;


public class EDLargeInteger {
    Integer Idigit;
    String Sdigit;


    public EDLargeInteger(String strDigit) {
        this.Sdigit = strDigit;

    }

    public EDLargeInteger(Integer intDigit) {
        this.Idigit = intDigit;

    }


    //СЛОЖЕНИЕ переделано
    public String suma(EDLargeInteger str2) {
        String RezultSum;
        StringBuilder strBuilder = new StringBuilder(Sdigit);
        StringBuilder strBuilder2 = new StringBuilder(str2.Sdigit);
            /*Если второе число отрицательно,
            то убираем знак "-" у второго числа и
            вызываем метод вычитания для строк
            */
        if (strBuilder2.charAt(0) == '-') {
            strBuilder2.deleteCharAt(0);
            RezultSum = subtraction(strBuilder.toString(), strBuilder2.toString());
        }
        //Иначе складываем числа
        else {

            if (strBuilder2.length() > strBuilder.length()) {
                strBuilder = new StringBuilder(str2.Sdigit);
                strBuilder2 = new StringBuilder(Sdigit);
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
            RezultSum = RezultSumbuilder.toString();
            RezultSum = RezultSum.replaceFirst("^0*", "");
        }
        return RezultSum;
    }

    //ДЕЛЕНИЕ переделано(проверить на деление на отрицательное число
    public String divide(EDLargeInteger divisor) {
        StringBuilder strBuilder = new StringBuilder(Sdigit);
        StringBuilder RezultDiv = new StringBuilder("");
        int divisor2 = divisor.Idigit;
        String znak;
        if (divisor2 < 0) {
            znak = "-";
            divisor2 = divisor2 * (-1);
        } else {
            znak = "";
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


//        if (ost == 0) {
//
//
//            String a = Integer.toString(proizv);
//            stringBuilderslog[i].append(a);
//
//
//        }

        RezultDiv.reverse().append(znak).reverse();
        String Rezultdivide= RezultDiv.toString();;
        return Rezultdivide;
    }

    //УМНОЖЕНИЕ переделано
    public String proizv(EDLargeInteger str2) {


        StringBuilder strBuilder = new StringBuilder(Sdigit);
        StringBuilder strBuilder2 = new StringBuilder(str2.Sdigit);
        String znak;
        if ((strBuilder.charAt(0) == strBuilder2.charAt(0))) {
            znak = "";
        } else {
            znak = "-";
            strBuilder2.deleteCharAt(0);
        }
        if (strBuilder.length() > strBuilder2.length()) {

            while (strBuilder.length() > strBuilder2.length()) {
                strBuilder2.reverse();
                strBuilder2.append(0);
                strBuilder2.reverse();
            }
        }
        if (strBuilder2.length() > strBuilder.length()) {

            while (strBuilder2.length() > strBuilder.length()) {
                strBuilder.reverse();
                strBuilder.append(0);
                strBuilder.reverse();
            }
        }


        StringBuilder[] stringBuilderslog = new StringBuilder[strBuilder.length()];
        for (int i = 0; i < strBuilder.length(); i++) {
            stringBuilderslog[i] = new StringBuilder("");
        }


//Получаем составные части произведения которые потом нужно сложить
        char massChar[] = new char[strBuilder.length()];
        char massChar2[] = new char[strBuilder.length()];
        int massInt[] = new int[strBuilder.length()];
        int massInt2[] = new int[strBuilder.length()];
        int proizv = 0;
        int ost = 0;


        for (int i = strBuilder.length() - 1; i >= 0; i--) {

            for (int j = strBuilder.length() - 1; j >= 0; j--) {
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

                String a = Integer.toString(proizv);
                stringBuilderslog[i].append(a);


            }


            int k = i;
            if (ost == 0) {
                stringBuilderslog[i].reverse();
                while (k < (strBuilder.length() - 1)) {
                    k++;
                    stringBuilderslog[i].append("0");
                }
            } else {
                stringBuilderslog[i].append(ost);
                stringBuilderslog[i].reverse();
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
                    stringBuilderslog[i].reverse();
                    stringBuilderslog[i].append(0);
                    stringBuilderslog[i].reverse();
                }
            }

        }
        String stringslog[] = new String[strBuilder.length()];


        for (int i = strBuilder.length() - 1; i >= 0; i--) {
            stringslog[i] = stringBuilderslog[i].toString();
        }

        String RezultProizv = "0";
        String zero2;
        for (int i = 0; i < strBuilder.length(); i++) {
            zero2 = suma(RezultProizv, stringslog[i]);
            RezultProizv = zero2;
        }
        RezultProizv = RezultProizv.replaceFirst("^0*", "");
        StringBuilder RezultBuilder = new StringBuilder(RezultProizv);
        RezultBuilder.reverse().append(znak).reverse();
        RezultProizv = RezultBuilder.toString();
        return RezultProizv;


    }

    //ВЫЧИТАНИЕ переделано
    public String subtraction(EDLargeInteger str2) {
        StringBuilder strBuilder = new StringBuilder(Sdigit);
        StringBuilder strBuilder2 = new StringBuilder(str2.Sdigit);
        String RezultSum;
        StringBuilder RezultSumbuilder = new StringBuilder("");

        if (strBuilder2.charAt(0) == '-') {
            strBuilder2.deleteCharAt(0);
            RezultSum = suma(strBuilder.toString(), strBuilder2.toString());
        } else {


            if (strBuilder2.length() > strBuilder.length()) {
                strBuilder = new StringBuilder(str2.Sdigit);
                strBuilder2 = new StringBuilder(Sdigit);
            }

            strBuilder.reverse();
            strBuilder2.reverse();

            //Подведение чисел под общий знаменатель
            if (strBuilder.length() != strBuilder2.length()) {

                while (strBuilder.length() > strBuilder2.length()) {
                    strBuilder2.append(0);
                }

                while (strBuilder2.length() > strBuilder.length()) {
                    strBuilder.append(0);
                }

            }

            int[] massInt = new int[strBuilder.length()];
            char[] massChar = new char[strBuilder.length()];
            int[] massInt2 = new int[strBuilder.length()];
            char[] massChar2 = new char[strBuilder.length()];
            int ost = 0;

            for (int i = 0; i < (strBuilder.length()); i++) {
                massChar[i] = strBuilder.charAt(i);
                massInt[i] = Character.getNumericValue(massChar[i]);
                massChar2[i] = strBuilder2.charAt(i);
                massInt2[i] = Character.getNumericValue(massChar2[i]);
            }
            for (int i = 0; i < (strBuilder.length()); i++) {
                int sum = 0;
                if (massInt[i] > massInt2[i]) {
                    sum = massInt[i] - massInt2[i];
                }
                if (massInt[i] < massInt2[i]) {
                    massInt[i + 1] = massInt[i + 1] - 1;
                    sum = massInt[i] + 10 - massInt2[i];
                }

                String a = Integer.toString(sum);
                RezultSumbuilder.append(a);


            }


            RezultSumbuilder.reverse();
            RezultSum = RezultSumbuilder.toString();
            RezultSum = RezultSum.replaceFirst("^0*", "");
        }

        return RezultSum;

    }

    //ВОЗВРАТ БОЛЬШЕГО
    public String max(EDLargeInteger str, EDLargeInteger str2) {
        StringBuilder strBuilder = new StringBuilder(str.Sdigit);
        StringBuilder strBuilder2 = new StringBuilder(str2.Sdigit);
        String RezultComparemore = "equal";
        if (strBuilder2.charAt(0) == '-') {
            RezultComparemore = strBuilder.toString();
        } else {
            if (strBuilder.length() > strBuilder2.length()) {
                RezultComparemore = strBuilder.toString();
            }
            if (strBuilder2.length() > strBuilder.length()) {
                RezultComparemore = strBuilder2.toString();
            }
            if (strBuilder.length() == strBuilder2.length()) {


                for (int i = strBuilder.length() - 1; i >= 0; ) {
                    char massChar = strBuilder.charAt(i);
                    int massInt = Character.getNumericValue(massChar);
                    char massChar2 = strBuilder2.charAt(i);
                    int massInt2 = Character.getNumericValue(massChar2);
                    if (massInt == massInt2) {
                        i--;
                    } else {
                        if (massInt > massInt2) {
                            RezultComparemore = strBuilder.toString();
                            i = -1;
                        } else if (massInt2 > massInt) {
                            RezultComparemore = strBuilder2.toString();
                            i = -1;
                        }
                    }


                }

            }
        }

        return RezultComparemore;
    }

    //ВОЗВРАТ МЕНЬШЕГО
    public String min(EDLargeInteger str, EDLargeInteger str2) {
        StringBuilder strBuilder = new StringBuilder(str.Sdigit);
        String RezultComparemore = "equal";
        StringBuilder strBuilder2 = new StringBuilder(str2.Sdigit);
        if (strBuilder2.charAt(0) == '-') {
            RezultComparemore = strBuilder2.toString();
        } else {
            if (strBuilder.length() > strBuilder2.length()) {
                RezultComparemore = strBuilder2.toString();
            }
            if (strBuilder2.length() > strBuilder.length()) {
                RezultComparemore = strBuilder.toString();
            }
            if (strBuilder.length() == strBuilder2.length()) {
                for (int i = strBuilder.length() - 1; i >= 0; i--) {
                    char massChar = strBuilder.charAt(i);
                    int massInt = Character.getNumericValue(massChar);
                    char massChar2 = strBuilder2.charAt(i);
                    int massInt2 = Character.getNumericValue(massChar2);
                    if (massInt == massInt2) {
                        i--;
                    } else {
                        if (massInt < massInt2) {
                            RezultComparemore = strBuilder.toString();
                            i = -1;
                        } else if (massInt2 < massInt) {
                            RezultComparemore = strBuilder2.toString();
                            i = -1;
                        }
                    }


                }
            }
        }
        return RezultComparemore;
    }

    public String Bg(EDLargeInteger str, EDLargeInteger str2) {
        BigInteger a = new BigInteger(str.Sdigit);
        BigInteger b = new BigInteger(str2.Sdigit);
        BigInteger Rezult = a.subtract(b);
        return Rezult.toString();
    }


    //НЕ ДЛЯ ТЕСТОВ

    //СЛОЖЕНИЕ
    public String suma(String str, String str2) {
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

    //ВЫЧИТАНИЕ
    public String subtraction(String str, String str2) {
        StringBuilder strBuilder = new StringBuilder(str);
        StringBuilder strBuilder2 = new StringBuilder(str2);
        StringBuilder RezultSumbuilder = new StringBuilder("");


        if (strBuilder2.length() > strBuilder.length()) {
            strBuilder = new StringBuilder(str2);
            strBuilder2 = new StringBuilder(str);
        }

        strBuilder.reverse();
        strBuilder2.reverse();

        //Подведение чисел под общий знаменатель
        if (strBuilder.length() != strBuilder2.length()) {

            while (strBuilder.length() > strBuilder2.length()) {
                strBuilder2.append(0);
            }

            while (strBuilder2.length() > strBuilder.length()) {
                strBuilder.append(0);
            }

        }

        int[] massInt = new int[strBuilder.length()];
        char[] massChar = new char[strBuilder.length()];
        int[] massInt2 = new int[strBuilder.length()];
        char[] massChar2 = new char[strBuilder.length()];
        int ost = 0;

        for (int i = 0; i < (strBuilder.length()); i++) {
            massChar[i] = strBuilder.charAt(i);
            massInt[i] = Character.getNumericValue(massChar[i]);
            massChar2[i] = strBuilder2.charAt(i);
            massInt2[i] = Character.getNumericValue(massChar2[i]);
        }
        for (int i = 0; i < (strBuilder.length()); i++) {
            int sum = 0;
            if (massInt[i] > massInt2[i]) {
                sum = massInt[i] - massInt2[i];
            }
            if (massInt[i] < massInt2[i]) {
                massInt[i + 1] = massInt[i + 1] - 1;
                sum = massInt[i] + 10 - massInt2[i];
            }

            String a = Integer.toString(sum);
            RezultSumbuilder.append(a);


        }


        RezultSumbuilder.reverse();
        String RezultSum = RezultSumbuilder.toString();
        RezultSum = RezultSum.replaceFirst("^0*", "");
        return RezultSum;

    }

    //ДВА НИЖНИХ МОЖНО ПОПРОБОВАТЬ ДОВЕСТИ ДО УМА
    public String comparemore(String str, String str2) {
        StringBuilder strBuilder = new StringBuilder(str);
        StringBuilder strBuilder2 = new StringBuilder(str2);
        StringBuilder RezultComparemoreBuilder;
        String RezultComparemore = "";

        if (strBuilder.length() > strBuilder2.length()) {
            RezultComparemore = strBuilder.toString();
        }
        if (strBuilder2.length() > strBuilder.length()) {
            RezultComparemore = strBuilder2.toString();
        }
        if (strBuilder.length() == strBuilder2.length()) {
            RezultComparemore = "надо доделать";
        }

        return RezultComparemore;
    }

    public boolean compareequal(String str, String str2) {
        // Создание strBuilder и strBuilder2
        StringBuilder strBuilder = new StringBuilder(str);
        StringBuilder strBuilder2 = new StringBuilder(str2);
        if (strBuilder2.length() > strBuilder.length()) {
            strBuilder = new StringBuilder(str2);
            strBuilder2 = new StringBuilder(str);
        }


        boolean a = true;
        return a;

    }


}



