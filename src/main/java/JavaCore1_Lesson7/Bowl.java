package JavaCore1_Lesson7;

public class Bowl {

    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void putFood(int amount) {
        this.foodAmount += amount;
        System.out.printf("Food increased by %d pts, there is now %d\n", amount, foodAmount);
    }

    public void decreaseFood(int amount) {
        this.foodAmount -= amount;
        if (foodAmount < 0){
            foodAmount = 0;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
