
/**
 * Created by 801674 on 24.02.2017.
 */
public class Proekt {
    String digit;

    public Proekt(String strDigit) {
        this.digit = strDigit;
    }

    public Proekt(int digit) {
        this(String.valueOf(digit));
    }


    public String sum(Proekt str) {
        // Создание чисел чисел которые будут взаимодействовать

        String str3 = "";
        StringBuilder strBuilder = new StringBuilder(str.digit);
        StringBuilder strBuilder2 = new StringBuilder(digit);

        strBuilder.reverse();
        strBuilder2.reverse();
        //Подведение чисел под общий знаменатель
        StringBuilder stringBuilderResultsum = new StringBuilder(str3);

        /*С
        * Л
        * О
        * Ж
        * Е
        * Н
        * И
        * Е*/

        /*Создание массивов massInt[] massChar[] massInt2[] и massChar2[]
        * чтобы переводить и поразрядно складывать цифры чисел*/
        int[] massInt = new int[strBuilder.length()];
        char[] massChar = new char[strBuilder.length()];
        int[] massInt2 = new int[strBuilder.length()];
        char[] massChar2 = new char[strBuilder.length()];
        int ost = 0;
/*Сложение массивов     sum-сложение чисел,ost-хранит число переходящее в следующий разряд*/
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
            stringBuilderResultsum.append(a);


        }
        if (ost != 0) {
            String a = Integer.toString(ost);
            stringBuilderResultsum.append(a);
        }
        stringBuilderResultsum.reverse();
        return stringBuilderResultsum.toString();
        /*С
        * Л
        * О
        * Ж
        * Е
        * Н
        * И
        * Е*/


    }

//    public String proizv(String str, String str2) {
//        StringBuilder strBuilder = new StringBuilder((str));
//        String massStringsum2[] = new String[strBuilder.length()];
//        for (int i = 0; i < strBuilder.length(); i++) {
//            massStringsum2[i] = "";
//        }
//    }

//Получаем составные части произведения которые потом нужно сложить
//        int proizv = 0;
//        for (int i = 0; i < (strBuilder.length()); i++) {
//            for (int j = 0; j < (strBuilder.length()); j++) {
//                massChar[i] = strBuilder.charAt(i);
//                massInt[i] = Character.getNumericValue(massChar[i]);
//                massChar2[j] = strBuilder2.charAt(j);
//                massInt2[j] = Character.getNumericValue(massChar2[j]);
////                System.out.println("massInt[" + i + "] = " + massInt[i]);       //можно откоментить если хуйня начнется
////                System.out.println("massInt2[" + j + "] = " + massInt2[j]);
//                if (ost == 0) {
//                    proizv = massInt[i] * massInt2[j];
//                    ost = proizv / 10;
//                    proizv = proizv % 10;
//                } else {
//                    proizv = massInt[i] * massInt2[j] + ost;
//                    ost = proizv / 10;
//                    proizv = proizv % 10;
//                }
//
//
//                massStringsum2[i] = massStringsum2[i] + proizv;
//
//
//            }
//            //Дописываем нули справа
//            String b = "0";
//            for (int k = 0; k < i; k++) {
//                massStringsum2[i] += b;
//            }
//
//            System.out.println("слагаемое" + (i + 1) + " = " + massStringsum2[i]);
//        }
//
////Получили составные части произведения
//
//        StringBuilder[] stringBuilderslog = new StringBuilder[strBuilder.length()];
//        for (int i = 0; i < strBuilder.length(); i++) {
//            stringBuilderslog[i] = new StringBuilder(massStringsum2[i]);
//            System.out.println((i + 1) + "слагаемое в StringBuilder= " + stringBuilderslog[i]);
//
//        }
//        //  Подведение чисел под общий знаменатель
//        int max = 0;
//        for (int i = 0; i < strBuilder.length(); i++) {
//            if (max < stringBuilderslog[i].length())
//                max = stringBuilderslog[i].length();
//        }
//
//        for (int i = 0; i < strBuilder.length(); i++) {
//            if (stringBuilderslog[i].length() < max) {
//                while (stringBuilderslog[i].length() < max) {
//                    stringBuilderslog[i].reverse();
//                    stringBuilderslog[i].append(0);
//                    stringBuilderslog[i].reverse();
//                }
//            }
//            System.out.println((i + 1) + "слогаемое в StringBuilder после уравнивания= " + stringBuilderslog[i]);
//        }


    }









