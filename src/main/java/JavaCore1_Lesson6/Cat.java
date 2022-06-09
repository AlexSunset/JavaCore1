package JavaCore1_Lesson6;

public class Cat extends Animal{

    private static int count_cat = 0;

    public Cat(String name) {
        super(name);
        count_cat++;
    }

    public static int getCount_cat() {
        return count_cat;
    }

    @Override
    protected void run(int distance) {
        if(distance <= 200){
            super.run(distance);
        }
        else {
            System.out.println("Кот может пробежать только 200 метров, снизьте ему нагрузку");
        }
    }

    @Override
    protected void swim(int distance) {
        System.out.println("К сожалению, кот не умеет плавать");
    }
}
