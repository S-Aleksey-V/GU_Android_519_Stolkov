package lesson3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson3 {

    protected static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int userCount = 3;
        int randomNamber = (int) (Math.random() * 10);
        System.out.println("Здравствуйте мы загадали вам число, попробуйте отгодать.");


        while (true) {
            System.out.println("Отгадайте число от 0 до 10 .Осталось попыток : " + userCount + "\nВведите число : ");
            try {

                int userNumber = sc.nextInt();


                if (randomNamber == userNumber) {
                    System.out.println("Поздравляю вы победили!\nПовторить игру еще раз? 1 - да/ 0 - нет");
                    if (sc.nextInt() == 1) {
                        userCount = 3;
                        randomNamber = (int) (Math.random() * 10);
                        continue;

                    } else
                        break;


                } else if (userCount == 1) {
                    System.out.println("Ваши попотки кончились\nПовторить игру еще раз? 1 - да/ 0 - нет"); // когда при повторе игры почему то если жмёшь 0 и пытаешься выйти не сразу срабатывает приходиться несколько раз вводить 0 так и не понял почему.

                    if (sc.nextInt() == 1) {
                        userCount = 3;
                        randomNamber = (int) (Math.random() * 10);
                        continue;

                    } else
                        break;


                }
                if (userNumber > randomNamber) {
                    System.out.println("Ваше число больше загаданого");
                    userCount--;
                }
                if (userNumber < randomNamber) {
                    System.out.println("Ваше число меньше загаданого");
                    userCount--;
                }

            } catch (InputMismatchException e) {
                System.out.println("вы вводите не число, программа заканчивается!");

                break;  // попытался тут прописать continue; но он у меня крутится начинает бесконечно и не запрашивает заного ввести число. как можно исправить ?
                //хотел так обработать вариант когда пользователь вводит строковое значение.
                // или можно было как то проще )? вообщем я попытался сделать что бы если ловиться ошибка продолжить цикл но что то не понимаю)

            }

        }
    }
}
