package lesson1;



public class Lesson1 {

    byte byteNumber = 120;
    short shortNumber = -1500;
    int intNumber = 30000;
    long longNumber = 600000000L;
    float floatNumber = 20.40f;
    double doubleNumber = 150.230;
    char charNumber = '£';
    boolean val = false;        //д.з 2рой пункт

    public static int calculate(float a,float b,float c,float d){
        float resultCalculate = a * (int)(b + (c / d));
        int endResult = (int)resultCalculate;             //вот тут вопрос, всегда так делать или это считается не очень правильно ?)
        return endResult;
    }
    public static boolean task10and20(int x1,int x2){
        int summ = x1 +x2;
        if(summ>=10 && summ <=20){
            return true;
        } else
            return false;
    }

    public static void isPositiveOrNegative(int x){
        if(x >=0){
            System.out.println("Число " + x + " положительное.");
        } else
            System.out.println("Число " + x + " отрицательное.");
    }

    public static boolean isNegative(int x){
        if(x <0){
            return true;
        } else
            return false;
    }

    public static void greetings(String name){
        System.out.println("Привет, " + name + "!");
    }

    public static void leapYear(int year){
        if(year%4==0 || year%400==0 && year%100!=0){
            System.out.println("Высокосный год");
        } else
            System.out.println("Не высокосный год");
    }
    public static void main(String[] args) {   //д.з 1вый пункт
        System.out.println(calculate(2.20f,2.20f,2.20f,2.20f));  // д.з 3тий пункт(тут я не понял так как в методичке написано a, b, c, d – аргументы этого метода, имеющие тип float. а на сайте geekbrains написано просто входные параметры_)
        System.out.println(task10and20(10,5)); //д.з 4тый пункт (если сумма в пределе от 10 до 20 включительно я понял как включительно и 10 _)
        isPositiveOrNegative(-32);          //д.з 5тый пункт
        System.out.println(isNegative(-5)); //д.з 6той пункт
        greetings("Тимофей");            //д.з 7мой пункт
        leapYear(2020);                        //*д.з 8мой пункт (вроде работает скажите если не так считаю_)

    }
}
