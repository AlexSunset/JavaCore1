package JavaCore1_Lesson3;

import java.util.Arrays;
import java.util.Random;

public class JavaCore1_Lesson3 {

    public static void main(String[] args) {
        // Первое задание
        int[] onesAndZeros = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < onesAndZeros.length; i++) {
            if (onesAndZeros[i] == 0) onesAndZeros[i] = 1;
            else onesAndZeros[i] = 0;
        }
        System.out.println(Arrays.toString(onesAndZeros));

        // Второе задание
        int[] hundred = new int[100];
        for (int i = 0; i < hundred.length; i++) {
            hundred[i] = i+1;
        }
        System.out.println(Arrays.toString(hundred));

        //Третье задание
        int[] someArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < someArr.length; i++) {
            if(someArr[i] < 6) someArr[i] = someArr[i] * 2;
        }
        System.out.println(Arrays.toString(someArr));

        //Четвертое задание
        int [][] diagonalFillArr = new int[13][13];
        for (int x = 0; x < diagonalFillArr.length; x++) {
            for (int y = 0; y < diagonalFillArr[x].length; y++) {
                if (x == y){
                    diagonalFillArr[x][y] = 1;
                    diagonalFillArr[diagonalFillArr.length - y - 1][x] = 1;
                }
            }
        }
        for (int x = 0; x < diagonalFillArr.length; x++) {
            for (int y = 0; y < diagonalFillArr[x].length; y++) {
                System.out.print(diagonalFillArr[x][y] + "\t");
            }
            System.out.println();
        }

        //Вызов метода из пятого задания
        int[] checkArrFor5thTask = arrFillWithInitialValue( 10, 7);
        System.out.println(Arrays.toString(checkArrFor5thTask));

        //Шестое задание
        Random random = new Random();
        int[] randomIntArr = new int[100];
        for (int i = 0; i < randomIntArr.length; i++) {
            randomIntArr[i] = random.nextInt();
        }
        Arrays.sort(randomIntArr);
        int minRandomIntArr = randomIntArr[0];
        int maxRandomIntArr = randomIntArr[randomIntArr.length - 1];
        System.out.println("Минимальное значение в массиве: " + minRandomIntArr);
        System.out.println("Максимальное значение в массиве: " + maxRandomIntArr);

        //Вызов метода из седьмого задания
        int[] check7thTaskArr = {1, 1, 1, 2, 1};
        boolean result7thTask = checkBalanceInArray(check7thTaskArr);
        System.out.println(result7thTask);

        //Вызов метода восьмого задания
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(array));
        int[] resultArray = shiftArrValuesOnPosition(array, 2);
        System.out.println(Arrays.toString(resultArray));
    }

    //Пятое задание
    public static int[] arrFillWithInitialValue (int length, int initialValue){
        int[] returnArr = new int[length];
        for (int i = 0; i < length; i++) {
            returnArr[i] = initialValue;
        }
        return returnArr;
    }

    //Седьмое задание
    public static boolean checkBalanceInArray(int[] arr){

        //Пройдемся циклом по длине массива
        for (int i = 0; i < arr.length; i++) {
            int leftSideSum = 0;
            int rightSideSum = 0;
            //Во внутреннем цикле вычислим сумму левой стороны в зависимости от позиции внешнего цикла
            for (int a = 0; a <= i; a++) {
                leftSideSum = leftSideSum + arr[a];
            }
            //Во внутреннем цикле вычислим сумму правой стороны в зависимости от позиции внешнего цикла
            for (int b = arr.length - 1; b > i; b--) {
                rightSideSum = rightSideSum + arr[b];
            }
            if (leftSideSum == rightSideSum) return true;
        }
        return false;
    }

    //Восьмое задание
    public static int[] shiftArrValuesOnPosition(int[] array, int n){
        int shift = (array.length + n % array.length) % array.length;
        int count = 0;
        for(int i = 0; count < array.length; i++){
            int currentIndex = i;
            int prevElement = array[i];
            do {
                int nextElement = (currentIndex + shift) % array.length;
                int temp = array[nextElement];
                array[nextElement] = prevElement;
                prevElement = temp;
                currentIndex = nextElement;
                count++;
            } while (i != currentIndex);
        }
        return array;
    }
}
