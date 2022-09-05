package lab2;

import Helpers.FunctionsInteger;

import java.util.*;
public class Printer {
    private final FunctionsInteger fInt = new FunctionsInteger();

    public void printTask(ArrayList<Integer> nums){

        System.out.println("k = " + fInt.findK(nums));
        System.out.println("min:" + fInt.findMin(nums));
        System.out.println("max:" + fInt.findMax(nums));
        System.out.println("h = " + fInt.findH(nums));
        System.out.println("-------------------------------------------------------------");
        System.out.println("Інтервальний статистичний розподіл вибірки");
        System.out.println(fInt.findIntervalDistribution(nums));
        System.out.println("-------------------------------------------------------------");
        System.out.println("Дискретний статистичний розподіл");
        System.out.println(fInt.findDiscreteDistribution(nums));
        System.out.println("-------------------------------------------------------------");
        System.out.println("Вибіркове середнє: " + fInt.findSampleMean(nums));
        System.out.println("Вибіркова дисперсія: " + fInt.findSampleVariance(nums));
        System.out.println("Вибіркове середнє квадратичне відхилення: " + fInt.findSelectedMeanSquareDeviation(nums));
        System.out.println("Виправлена вибіркова дисперсія: " + fInt.findCorrectedSampleVariance(nums));
        System.out.println("Виправлене вибіркове середнє квадратичне відхилення: " + fInt.findCorrectedSampleMeanSquareDeviation(nums));
        System.out.println("Розмах: " + fInt.findScope(nums));
        System.out.println("Коефіцієнт варіації: " + fInt.findVariationCoefficient(nums) + "%");
        System.out.println("Мода: " + fInt.findMode(nums));
        System.out.println("Медіана: " + fInt.findMedian(nums));
    }
}

