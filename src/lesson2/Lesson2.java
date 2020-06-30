package lesson2;

public class Lesson2 {

    public static void invertArray() {
        int[] arr = {1, 0, 1, 0, 0, 1, 1, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            System.out.print(arr[i] + ", ");
        }
    }

    public static void fillArray() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + i * 2;
            System.out.print(arr[i] + " ");
        }
    }

    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
            System.out.print(arr[i] + ", ");
        }
    }

    public static void fillDiagonal() {
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j || i == arr.length -j-1) {
                    arr[i][j] = 1;
                } else
                    arr[i][j] = 0;

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }
    }

    public static void maxAndMinArray() {
        int[] array = {4, 6, 20, 3, 54, 8, 2, 64, 1, 80,150,0,-20};
        int max = array[0];
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("Максимум : " + max);
        System.out.println("Минимум : " + min);
    }

    public static boolean chekBalance(int [] arr) {
        int summ = 0;
        int summFinish = 0;

        for (int i : arr){
            summFinish += i;
        }
        for(int i = 0; i < arr.length; i++){
            if(summ == summFinish){
                return true;
            }
            summ +=arr[i];
            summFinish -=arr[i];
        }
        return false;
    }

    public static void shiftElementsArray(int [] arr,int n) {


        if(n > 0) {
            for (int i = 0; i < n; i++) {
                int right = arr[arr.length - 1];
                for(int j = arr.length - 1; j > 0; j--){
                    arr[j] = arr[j - 1];
                }
                arr[0] = right;
            }
        }
        else if(n < 0) {
            for(int i = 0;i < n * (-1);i++){
                int left = arr[0];
                for(int j = 0; j < arr.length - 1;j++){
                    arr[j] = arr[j+1];
                }
                arr[arr.length -1] = left;
            }
        }
        for (int i: arr ) {
            System.out.print(i + " ");
       }
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("Задание 1:");
        invertArray();
        System.out.println("\nЗадание 2:");
        fillArray();
        System.out.println("\nЗадание 3:");
        changeArray();
        System.out.println("\nЗадание 4:");
        fillDiagonal();
        System.out.println("\nЗадание 5:");
        maxAndMinArray();
        System.out.println("\nЗадание 6:");
        System.out.println(chekBalance(new int [] {1, 2, 3, 4, 10}));
        System.out.println(chekBalance(new int [] {1, 1, 1, 1, 1}));
        System.out.println(chekBalance(new int [] {9, 4, 17, 2, 5}));
        System.out.println(chekBalance(new int [] {2, 2, 2, 2, 2,2}));
        System.out.println("\nЗадание 7:");
        shiftElementsArray(new int[] {1, 2, 3, 4, 5, 6, 7},2);
        shiftElementsArray(new int[] {1, 2, 3, 4, 5, 6, 7},-2);
    }
}
