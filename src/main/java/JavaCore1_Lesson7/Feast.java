package JavaCore1_Lesson7;

public class Feast {

    public static void main(String[] args) {
        Cat[] cats = new Cat[5];

        for (int i = 0; i < 5; i++) {
            cats[i] = new Cat("Котик" + (i + 1), (int)(Math.random()*20 + 10));
        }

        Bowl bowl = new Bowl(50);

        for (Cat cat: cats) {
            cat.eat(bowl);
        }
    }
}
