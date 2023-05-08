package gr.aueb.cf.projects;

import java.util.Arrays;

public class ShallowVsDeepCopyApp {

    public static void main(String[] args) {

        int[][] arr = {{12, 15, 17}, {14, 20, 40}};

        System.out.println("Before changes: ");
        System.out.println("shallow copy:");

        int[][] shallowArr = shallowCopy(arr);

        printArray(arr);

        printNewArray(shallowArr);

        System.out.println("deep copy:");

        int[][] deepArr = deepCopy(arr);

        printArray(arr);

        printSecArray(deepArr);

        arr[0][1] = 4;
        arr[1][0] = 1;

        System.out.println("After changes: ");
        System.out.println("shallow copy:");

        printArray(arr);

        printNewArray(shallowArr);

        System.out.println("deep copy:");

        printArray(arr);

        printSecArray(deepArr);
    }

    public static int[][] shallowCopy(int[][] arr) {
        int arr1[][] = Arrays.copyOf(arr, arr.length);
        return arr1;
    }

    public static int[][] deepCopy(int[][] arr) {

        int[][] tmp = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = new int[arr[i].length];
            for (int j = 0; j < arr[i].length; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    public static void printArray(int[][] arr) {
        System.out.println("Source array:");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }
        public static void printNewArray ( int[][] copy){
            System.out.println("Copy:");
            for (int[] ints : copy) {
                for (int anInt : ints) {
                    System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }

        public static void printSecArray(int[][] tmp){
            System.out.println("Copy:");
            for (int[] ints : tmp) {
                for (int anInt : ints) {
                    System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }
}
