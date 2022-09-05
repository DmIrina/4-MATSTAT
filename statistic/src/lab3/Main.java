package lab3;

import java.util.TreeMap;

public class Main {


    public static void main(String[] args) {
        TreeMap<Integer, Integer> distribution;

        distribution = Data.setDistributionTask1();

        Helper h = new Helper(0.999, distribution);
        h.printTask1();
//
//        System.out.println("------------------7.2------------------");
//        h = new Helper(0.99218, 3, distribution);
//        System.out.println("Інтервальний статистичний розподіл вибірки");
//        System.out.println(h.distribution);
//        System.out.println("---------------------------------");
//        System.out.println("Дискретний статистичний розподіл");
//        System.out.println(h.discreteDiv);
//        System.out.println("---------------------------------");
//        System.out.println("n = " + h.n);
//        System.out.println("Вибіркове середнє: " + h.findSelectedMean());
//        System.out.println("Вибіркова дисперсія: " + h.findSelectedDisperse());
//        System.out.println("Виправлена вибіркова дисперсія: " + h.findFixedSelectedDisperse());
//        System.out.println("Виправлене вибіркове середнє квадратичне відхилення: " + h.findFixedSelectedMeanSquareDeviation());
//        System.out.println("Функція Лапласа: " + h.findF());
//        System.out.println("Початок інтервалу: " + h.findStart(2.66, 6));
//        System.out.println("Кінець інтервалу: " + h.findEnd(2.66, 6));
//        System.out.println("------------------7.3------------------");
//        h = new Helper(0.99, distribution);
//        System.out.println("Статистичний розподіл вибірки");
//        System.out.println(h.distribution);
//        System.out.println("---------------------------------");
//        System.out.println("n = " + h.n);
//        System.out.println("q = " + 0.73);
//        System.out.println("Вибіркове середнє: " + h.findSelectedMean());
//        System.out.println("Вибіркова дисперсія: " + h.findSelectedDisperse());
//        System.out.println("Виправлена вибіркова дисперсія: " + h.findFixedSelectedDisperse());
//        System.out.println("Виправлене вибіркове середнє квадратичне відхилення: " + h.findFixedSelectedMeanSquareDeviation());
//        System.out.println("Початок інтервалу: " + h.findStartQ(0.73));
//        System.out.println("Кінець інтервалу: " + h.findEndQ(0.73));
    }
}
