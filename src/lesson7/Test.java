package lesson7;

public class Test {


    public static void main(String[] args) {

        Cat[] cats = createCats(4);

        Plate plate = new Plate(5);

        plate.info();
        System.out.println();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            plate.info();
        }

    }

    public static Cat[] createCats(int namber) {
        Cat[] cats = new Cat[namber];
        for (int i = 0; i < namber; i++) {
            cats[i] = new Cat("Мартин" + i, 1 + i);
        }
        return cats;
    }

}





