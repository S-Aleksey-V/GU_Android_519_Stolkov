package lesson3;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3z2 {

    public static String paintingLetters(String truLetters) {

        int WORDS_LENGTH = 15;

        for (int i = 0; i < WORDS_LENGTH; i++) {
            truLetters += "#";

        }
        return truLetters;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String randomWord = words[random.nextInt(words.length)];
        System.out.println("Отгадайте загаданое слово из списка : " + Arrays.toString(words));

        System.out.println("Введите слово ");
        String userAnswer;


        while (true) {

            String truLetters = "";
            userAnswer = scanner.nextLine();
            if (userAnswer.equals(randomWord)) {
                System.out.println("Поздравляем вы угадали слово : " + randomWord);
                break;
            } else if (userAnswer.charAt(0) == randomWord.charAt(0)) {

                for (int i = 0; i < userAnswer.length(); i++) {
                    if (userAnswer.charAt(i) == randomWord.charAt(i)) {
                        truLetters += randomWord.charAt(i);
                    } else
                        break;

                }
                System.out.println(paintingLetters(truLetters));       // можно было бы если бы не правильное слово сразу помочь пользователю но тогда слишком легко получается )
                System.out.println("Слово начинается так же но не то, попробуйте снова");
            } else
                System.out.println("Попробуйте другое слово, слово начинается на другую букву");
        }

    }
}
