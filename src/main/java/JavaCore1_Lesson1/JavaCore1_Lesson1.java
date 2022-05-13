package JavaCore1_Lesson1;

public class JavaCore1_Lesson1 {

    public static void main(String[] args) {

        printThreeWords();

        checkSumSign();

        printColor();

        compareNumbers();
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(){
        int a = 10;
        int b = -10;
        int result = a + b;
        if (result >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    public static void printColor(){
        int value = (int)(Math.random() * 200) - (int)(Math.random() * 100);
        if      (value <= 0)                System.out.println("Красный");
        else if (value <= 100)              System.out.println("Желтый");
        else                                System.out.println("Зеленый");
    }

    public static void compareNumbers(){
        int a = (int)(Math.random() * 100);
        int b = (int)(Math.random() * 100);
        if (a >= b) System.out.println("a >= b");
        else        System.out.println("a < b");
    }
}
