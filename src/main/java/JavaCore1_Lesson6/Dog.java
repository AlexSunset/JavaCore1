package JavaCore1_Lesson6;

public class Dog extends Animal{

    private static int count_dog = 0;

    public Dog(String name) {
        super(name);
        count_dog++;
    }

    public static int getCount_dog() {
        return count_dog;
    }

    @Override
    protected void run(int distance) {
        if(distance <= 500){
            super.run(distance);
        }
        else {
            System.out.println("Собака может пробежать только 500 метров, снизьте ей нагрузку");
        }
    }

    @Override
    protected void swim(int distance) {
        if(distance <= 10){
            super.swim(distance);
        }
        else {
            System.out.println("Собака может проплыть только 10 метров, снизьте ей нагрузку");
        }
    }
}
