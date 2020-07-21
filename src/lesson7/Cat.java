package lesson7;

import java.util.Random;

public class Cat {

    Random random = new Random();

    protected final String name;
    private int appetite;
    private boolean satiety = false;
    private int maxAppetite;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.maxAppetite = random.nextInt(5) * 2;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate plate) {
        while(true) {
            if (plate.getFood() >= appetite) {
                satiety = true;
                System.out.println("Кот " + this.name + " наелся" + " его сытость " + satiety);
                doEat(plate);
                break;
            } else if (plate.getFood() <= appetite) {
                System.out.println("Кот " + this.name + " съел = " + plate.getFood() + " его сытость " + satiety + " и его аппетит остался равен  " + getAppetite());
                doEat(plate);
                System.out.println();

            }
        }
    }


    public void doEat(Plate plate) {
        plate.decreaseFood(appetite);
    }


}


