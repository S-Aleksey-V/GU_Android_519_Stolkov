package lesson6;


public class Animal {

    private String name;
    private int metrs;
    private static int animalCount;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }


    public boolean swim(int metrs) {
        System.out.println("Животное плывёт");
        return true;
    }

    public boolean run(int metrs) {
        System.out.println("Животное бежит");
        return true;
    }

    public boolean jump(int metrs) {
        System.out.println("Животное прыгает");
        return true;
    }

    public void showInfo() {
        System.out.println("Создано всего животных " + animalCount);
    }

    public String getName() {
        return name;
    }

    public int getMetrs() {
        return metrs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMetrs(int metrs) {
        this.metrs = metrs;
    }

    public static void main(String[] args) {

        Cat cat = new Cat("Vasya");
        Dog dog = new Dog("Pushka");
       Cat cat2 = new Cat("Puzo");
        Dog dog2 = new Dog("Zevs");

        dog.jump((float) 0.3);
        dog.run(200);
        dog2.run(100);
        dog.swim(8);
        System.out.println();

        cat.jump(1);
        cat.run(100);
        cat.swim(2);
        System.out.println();

        dog.showDogCount();
        cat2.ShowCatCaunt();
        cat.showInfo();

    }
}
