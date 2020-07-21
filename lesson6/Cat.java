package lesson6;

import java.util.Random;

public class Cat extends Animal {

    private static int catCount;
    protected  int CAT_STOP_JUMP = 2;       // до последнего задания ограничения были static и final
    protected  int CAT_STOP_RUN = 200;

    Random random = new Random();

    public Cat(String name) {
        super(name);
        catCount++;
        CAT_STOP_RUN = 1 +  random.nextInt(1000);
        CAT_STOP_JUMP = 1 + random.nextInt(10);
    }

    @Override
    public boolean jump(int metrs) {
        if (metrs > 0 && CAT_STOP_JUMP > metrs) {
            System.out.println("Кот " + getName() + " jump: " + "true");
            return true;
        }
        System.out.println("Кот " + getName() + " jump: " + "false");
        return false;
    }

    @Override
    public boolean swim(int metrs) {
        System.out.println("Кот " + getName() + " не умеет плавать");
        return true;
    }

    @Override
    public boolean run(int metrs) {
        if (metrs > 0 && CAT_STOP_RUN > metrs) {
            System.out.println("Кот " + getName() + " run: " + "true");
            return true;
        }
        System.out.println("Кот " + getName() + " run: " + "false");
        return false;
    }

    public void ShowCatCaunt() {
        System.out.println("Всего котов " + catCount);
    }
}
