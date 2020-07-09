package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;

    public static final char DOT_EMPTY = '.';
    public static final char DOT_HUMAN = 'X';
    public static final char DOT_AI = 'O';
    public static final String EMPTY = " ";
    public static final String FIRST_EMPTY_CHAR = "  ";

    public static char[][] map = new char[SIZE][SIZE];
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        turnGame();


    }

    public static void turnGame() {
        init_Map();

        printMap();

        playGame();
    }

    public static void playGame() {
        while (true) {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN, "Вы Выйграли!")) {
                System.exit(0);
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI, "К сожалению вы проиграли....")) {
                System.exit(0);
            }
        }
    }


    public static void init_Map() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        print_Map_Header();

        printMapRows();
    }

    public static void printMapRows() {
        for (int i = 0; i < SIZE; i++) {
            printNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    public static void print_Map_Header() {
        System.out.print(FIRST_EMPTY_CHAR);
        for (int i = 0; i < SIZE; i++) {
            printNumber(i);
        }
        System.out.println();
    }

    private static void humanTurn() {
        int rowNumber, colNumber;
        do {
            System.out.println("Ход пользователя! Введите номера строки и столбца");
            System.out.println("Строка = ");
            rowNumber = scanner.nextInt();
            System.out.println("Столбец = ");
            colNumber = scanner.nextInt();
        } while (!isCellValid(rowNumber, colNumber, DOT_HUMAN));

        map[rowNumber - 1][colNumber - 1] = DOT_HUMAN;
    }

    private static boolean isCellValid(int rowNumber, int colNumber, char symbol) {

        if ((rowNumber < 1) || (rowNumber > SIZE) || (colNumber < 1 || colNumber > SIZE)) {
            System.out.println("Проверьте значение строки и столбца!");
            return false;
        }

        if (map[rowNumber - 1][colNumber - 1] != DOT_EMPTY && map[rowNumber - 1][colNumber - 1] != DOT_HUMAN || map[rowNumber - 1][colNumber - 1] != DOT_EMPTY && map[rowNumber - 1][colNumber - 1] != DOT_AI) {
            System.out.println("\nВы выбрали занятую ячейку");
            return false;
        }


        return true;
    }

    private static void aiTurn() {

        //block AI
        int x = 0, y = 0, countgorizontal = 0, countHNull = 0, countvertical = 0, countVNull = 0, countDiagonalA = 0, countDiagonalB = 0, countDANull = 0, countDBNull = 0;

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == DOT_HUMAN) countvertical++;
                else if (map[j][i] == DOT_EMPTY) countVNull++;
                if ((countvertical == SIZE - 1) && (countVNull == 1)) {

                    for (int k = 0; k < SIZE; k++) {
                        if (map[k][i] == DOT_EMPTY) {
                            map[k][i] = DOT_AI;
                            return;
                        }
                    }
                }

                if (map[i][j] == DOT_HUMAN) countgorizontal++;
                else if (map[i][j] == DOT_EMPTY) countHNull++;
                if ((countgorizontal == SIZE - 1) && (countHNull == 1)) {

                    for (int k = 0; k < SIZE; k++) {
                        if (map[i][k] == DOT_EMPTY) {
                            map[i][k] = DOT_AI;
                            return;
                        }
                    }
                }

            }


            if (map[i][i] == DOT_HUMAN) countDiagonalA++;
            else if (map[i][i] == DOT_EMPTY) countDANull++;
            if ((countDiagonalA == SIZE - 1) && (countDANull == 1)) {

                for (int j = 0; j < SIZE; j++) {
                    if (map[j][j] == DOT_EMPTY) {
                        map[j][j] = DOT_AI;
                        return;
                    }
                }
            }


            if (map[i][SIZE - 1 - i] == DOT_HUMAN) countDiagonalB++;
            else if (map[i][SIZE - 1 - i] == DOT_EMPTY) countDBNull++;
            if ((countDiagonalB == SIZE - 1) && (countDBNull == 1)) {

                for (int j = 0; j < SIZE; j++) {
                    if (map[j][SIZE - 1 - j] == DOT_EMPTY) {
                        map[j][SIZE - 1 - j] = DOT_AI;
                        return;
                    }
                }
            }
        }

        //random AI

        int rowNumber, colNumber;
        do {
            rowNumber = random.nextInt(SIZE) + 1;
            colNumber = random.nextInt(SIZE) + 1;

        } while (!isCellValid(rowNumber, colNumber, DOT_AI));

        map[rowNumber - 1][colNumber - 1] = DOT_AI;
    }

    private static boolean checkEnd(char symbol, String winMessage) {
        if (checkWin(symbol)) {
            System.out.println("Вы выйграли");
            return true;
        }

        if (isMapFull1()) {
            System.out.println("Ничья!");
            return true;
        }

        return false;
    }

    private static boolean checkWin(char symbol) {
        int countDiagonalA = 0;
        int countDiagonalB = 0;


        for (int i = 0; i < map.length; i++) {
            int countgorizontal = 0;
            int countvertical = 0;
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == symbol) {
                    countgorizontal++;
                    if (countgorizontal == DOTS_TO_WIN)
                        return true;
                }
                if (map[j][i] == symbol) {
                    countvertical++;
                    if (countvertical == DOTS_TO_WIN)
                        return true;
                }
            }
            if (map[i][i] == symbol) {
                countDiagonalA++;
                if (countDiagonalA == DOTS_TO_WIN)
                    return true;
            } else countDiagonalA = 0;


            if (map[i][map.length - 1 - i] == symbol) {
                countDiagonalB++;
                if (countDiagonalB == DOTS_TO_WIN)
                    return true;
            } else countDiagonalB = 0;
        }

        return false;
    }

    private static boolean isMapFull1() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                if (aChar == DOT_EMPTY)
                    return false;
            }
        }

        return true;
    }

}