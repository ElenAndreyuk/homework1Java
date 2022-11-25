/**1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
* 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
* 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
* 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
*        Пункты реализовать в методе main
*        *Пункты реализовать в разных методах
 *        int i = new Random().nextInt(k); //это кидалка случайных чисел!)
*/

import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int i = getRandom();
        System.out.println(i);

        int n = olderBit(i);
        System.out.println(n);

        int arrLength1 = findArrMultiples(n, i);
        int[] m1= findMultiples(n, i, arrLength1);
        System.out.println("m1:");
        printArray(m1);

        System.out.println();
        System.out.println(Short.MIN_VALUE);

        int arrLength2 = findArrNoMultiples(n, i);
        int [] m2 = findNoMultiples(n, i, arrLength2);
        System.out.println("m2:");
        printArray(m2);


    }
    // 1
    static int getRandom(){
        return new Random().nextInt(-1000, 1000);
    }
    //2
    static int olderBit(int i) {
        if (i < 0){
            i = -i;
        }
        int n = 0;
        while (i != 1) {
            i >>= 1;
            n++;
        }
        return n;
    }
    //3
    static int findArrMultiples(int n, int i){
        int k = 0;
        for (int j = i; j <= Short.MAX_VALUE; j++ ){
            if (j % n == 0){
                k++;
            }
        }
        return k;
    }
        static int[] findMultiples(int n, int i, int arrLength1){
            int[] m1 = new int[arrLength1];
            int k = 0;
            for (int j = i; j <= Short.MAX_VALUE; j++ ){
                if (j % n == 0){
                    m1[k]= j;
                    k++;
                }
            }
            return m1;
        }

        static void printArray(int []arr){
            for (int i : arr) {
                System.out.printf("%d ", i);
            }
        }

    static int findArrNoMultiples(int n, int i) {
        int k = 0;
        for (int j = Short.MIN_VALUE; j <= i; j++) {
            if (j % n != 0) {
                k++;
            }
        }
        return k;
    }

    static int[] findNoMultiples(int n, int i, int arrLength2) {
        int[] m2 = new int [arrLength2];
        int k = 0;
        for (int j = Short.MIN_VALUE; j <= i; j++) {
            if (j % n != 0) {
                m2[k] = j;
                k++;
            }
        }
        return m2;
    }
}