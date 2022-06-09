package JavaCore1_Lesson6;

public class Animal {

    private String name;
    private static int count_animal = 0;

    public Animal(String name) {
        this.name = name;
        count_animal++;
    }

    public static int getCount_animal() {
        return count_animal;
    }

    protected void run(int distance){
        System.out.println(this.name + " пробежал " + distance + " метров");
    }

    protected void swim(int distance) {
        System.out.println(this.name + " проплыл " + distance + " метров");
    }
}
