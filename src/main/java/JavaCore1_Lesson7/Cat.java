package JavaCore1_Lesson7;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() >= appetite){
            bowl.decreaseFood(appetite);
            satiety = true;
            System.out.printf("Cat %s has eaten %d food\n", name, appetite);
        } else {
            System.out.printf("Not enough food in bowl, %s stayed hungry\n", name);
        }

    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                '}';
    }
}
