package JavaCore1_Lesson6;

public class RunClass {

    public static void main(String[] args) {
        Dog firstDog = new Dog("Бобик");
        System.out.println("Количество собак: " + Dog.getCount_dog());

        Cat firstCat = new Cat("Васька");
        System.out.println("Количество котов: " + Cat.getCount_cat());
        System.out.println("Количество животных: " + Animal.getCount_animal());

        firstDog.run(550);
        firstCat.run(150);

        firstDog.swim(10);
        firstCat.swim(5);
    }
}
