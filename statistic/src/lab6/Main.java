package lab6;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(
                78, 64, 44, 73, 58, 88, 56, 68, 81, 52, 41, 65, 54, 90, 40, 56, 39, 60,
                66, 58, 75, 60, 37, 78, 52, 59, 88, 80, 72, 69, 53, 57, 40, 62, 37, 62,
                57, 58, 38, 46, 74, 44, 76, 36, 42, 80, 57, 45, 47, 88, 67, 87, 56, 68,
                73, 72, 92, 68, 59, 71, 44, 76, 36, 49, 45, 38, 76, 66, 60, 78, 77, 42,
                87, 60, 43, 36, 48, 64, 46, 59, 59, 77, 54, 79, 53, 92, 59, 53, 67, 82,
                89, 76, 65, 89, 89, 75, 92, 72, 49, 59));

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(
                30, 43, 26, 19, 46, 31, 9, 24, 30, 30, 3, 45, 6, 39, 10, 31, 41, 37, 13,
                20, 41, 34, 6, 41, 35, 18, 1, 14, 50, 21, 40, 30, 14, 16, 49, 9, 47, 7,
                32, 27, 36, 35, 21, 41, 23, 30, 22, 13, 16, 35, 33, 7, 18, 39, 47, 3, 6,
                48, 17, 5, 18, 7, 35, 31, 23, 33, 39, 19, 39, 20, 45, 25, 4, 15, 15, 27,
                45, 37, 40, 11, 21, 22, 17, 39, 10, 14, 42, 16, 11, 8, 20, 29, 15, 4, 9,
                37, 37, 47, 6, 25, 17, 50, 49, 21, 15, 14, 47, 9, 50, 36, 19, 21, 8, 36, 9,
                17, 50, 50, 33, 10, 8, 2, 38, 22, 6, 47, 8, 42, 44, 13, 17, 10, 13, 16, 31,
                27, 29, 28, 36, 29, 14, 5, 49, 21, 40, 7, 38, 39, 7, 20, 49, 14, 22, 37, 35,
                28, 33, 43, 20, 26, 5, 36, 36, 18, 2, 17, 44, 31, 44, 30, 9, 7, 34, 7, 28,
                23, 14, 16, 12, 20, 36, 10, 34, 7, 47, 18, 35, 29, 10, 4, 5, 15, 40, 41,
                32, 41, 7, 26, 21, 1));



        Helper h = new Helper();
        // h.printTask1(list1, 100, 7);
        // h.printTask2(list2, 200);
        h.printTask3();

    }
}
