package JavaCore1_Lesson2;

public class JavaCore1_Lesson2 {
    public static void main(String[] args) {

        System.out.println(between10And20(10, 10));

        positiveOrNegative(-5);

        System.out.println(positiveOrNegativeWithReturn(10));

        printStringNTimes("Проверка", 4);

        System.out.println(isLeapYear(2022));

    }

    public static boolean between10And20(int a, int b){
        return a+b >=10 && a+b <= 20;
    }

    public static void positiveOrNegative(int number){
        if(number >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }

    public static boolean positiveOrNegativeWithReturn(int number){
        return number >= 0;
    }

    public static void printStringNTimes (String string, int n){
        for (int i = 0; i < n; i++){
            System.out.println(string);
        }
    }

    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
