package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public Plate() {
        this(0);
    }

    public void addFood(int food) {
        this.food += food;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int foodCount) {
        this.food -= foodCount;

        if (this.food <= 0) {
            this.food = 0;
            addFood(5);
            System.out.println("Еда закончилась и миска автоматически пополнилась на 5");
        }

    }

    public void setFood(int food) {
        this.food = food;
    }
}
