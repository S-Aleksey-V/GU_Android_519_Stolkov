package lesson6;

import java.util.Random;

public class Dog extends Animal {

    protected double DOG_STOP_JUMP = 0.5d;    // до последнего задания ограничения были static и final
    protected int DOG_STOP_SWIM = 10;
    protected int DOG_STOP_RUN = 500;
    private static int dogCount;

    Random random = new Random();

    public Dog(String name) {
        super(name);
        dogCount++;
        DOG_STOP_RUN = 1 +  random.nextInt(1000);
        DOG_STOP_SWIM = 1 + random.nextInt(10);
        DOG_STOP_JUMP = Math.random();
    }


    public boolean jump(float metr) {
        if (metr > 0 && DOG_STOP_JUMP >= metr) {
            System.out.println("Собака " + getName() + " jump:" + " true");
            return true;
        }
        System.out.println("Собака " + getName() + " jump:" + " false");
        return false;
    }

    @Override
    public boolean swim(int metrs) {
        if (metrs > 0 && DOG_STOP_SWIM > metrs) {
            System.out.println("Собака " + getName() + " swim:" + " true");
            return true;
        }
        System.out.println("Собака " + getName() + " swim:" + " false");
        return false;
    }

    @Override
    public boolean run(int metrs) {
        if (metrs > 0 && DOG_STOP_RUN > metrs) {
            System.out.println("Собака " + getName() + " run:" + " true");
            return true;
        }
        System.out.println("Собака " + getName() + " run:" + " false");
        return false;
    }

    public void showDogCount() {
        System.out.println("Всего собак " + dogCount);
    }
}
