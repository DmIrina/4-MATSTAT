package Helpers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public abstract class Functions <E> {
    private final DecimalFormat df = new DecimalFormat("#.####");

    // ArrayList<E> arr - дана вибірка
    // TreeMap<E, Integer> distribution - даний статистичний розподіл


    // найменше значення вибірки
    public abstract E findMin(ArrayList<E> arr);


    // найбільше значення вибірки
    public abstract E findMax(ArrayList<E> arr);


    // кількість інтервалів
    public int findK(ArrayList<E> nums){
        return (int) (1 + 3.322 * Math.log10(nums.size()));
    }


    // величина інтервалів
    public abstract int findH(ArrayList<E> nums);


    // інтервальний статистичний розподіл
    public abstract TreeMap<E, Integer> findIntervalDistribution(ArrayList<E> nums);


    // усі значення вибірки у конкретному інтервалі
    public abstract ArrayList<E> findInterval(ArrayList<E> nums, E xI, E xI1);


    // дискретний статистичний розподіл
    public abstract TreeMap<Double, Integer> findDiscreteDistribution(ArrayList<E> nums);


    // вибіркове середнє (з вибірки)
    public double findSampleMean(ArrayList<E> nums){
        TreeMap<Double, Integer> treeMap = findDiscreteDistribution(nums);
        Set<Double> keys = treeMap.keySet();
        double m = Double.MIN_VALUE;
        for (double key: keys) {
            m += key * treeMap.get(key);
        }
        return Double.parseDouble(df.format(m / nums.size()));
    }


    // вибіркове середнє (з розподілу)
    public double findSampleMean(TreeMap<Integer, Integer> distribution) {
        Set<Integer> keys = distribution.keySet();
        double m = Double.MIN_VALUE;
        for (int key: keys) {
            m += key * distribution.get(key);
        }
        return Double.parseDouble(df.format(m / findN(distribution)));
    }


    // вибіркова дисперсія (з вибірки)
    public double findSampleVariance(ArrayList<E> nums){
        TreeMap<Double, Integer> treeMap = findDiscreteDistribution(nums);
        Set<Double> keys = treeMap.keySet();
        double d = Double.MIN_VALUE;
        for (double key: keys) {
            d += Math.pow(key, 2) * treeMap.get(key);
        }
        return Double.parseDouble(df.format(d / nums.size() - Math.pow(findSampleMean(nums), 2)));
    }


    // вибіркова дисперсія (з розподілу)
    public double findSampleVariance(TreeMap<Integer, Integer> distribution){
        Set<Integer> keys = distribution.keySet();
        double d = Double.MIN_VALUE;
        for (int key: keys) {
            d += Math.pow(key, 2) * distribution.get(key);
        }
        return Double.parseDouble(df.format(d / findN(distribution) - Math.pow(findSampleMean(distribution), 2)));
    }


    // вибіркове середнє квадратичне відхилення
    public double findSelectedMeanSquareDeviation(ArrayList<E> nums){
        return Double.parseDouble(df.format(Math.sqrt(findSampleVariance(nums))));
    }


    // виправлена вибіркова дисперсія (з вибірки)
    public double findCorrectedSampleVariance(ArrayList<E> nums){
        double s2;
        int n = nums.size();
        double d = findSampleVariance(nums);
        s2 = n * d / (n - 1);
        return Double.parseDouble(df.format(s2));
    }


    // виправлена вибіркова дисперсія (з розподілу)
    public double findCorrectedSampleVariance(TreeMap<Integer, Integer> distribution){
        double s2;
        int n = findN(distribution);
        double d = findSampleVariance(distribution);
        s2 = n * d / (n - 1);
        return Double.parseDouble(df.format(s2));
    }


    // виправлене вибіркове середнє квадратичне відхилення (з вибірки)
    public double findCorrectedSampleMeanSquareDeviation(ArrayList<E> nums){
        return Double.parseDouble(df.format(Math.sqrt(findCorrectedSampleVariance(nums))));
    }


    // виправлене вибіркове середнє квадратичне відхилення (з розподілу)
    public double findCorrectedSampleMeanSquareDeviation(TreeMap<Integer, Integer> distribution){
        return Double.parseDouble(df.format(Math.sqrt(findCorrectedSampleVariance(distribution))));
    }


    // розмах
    public abstract double findScope(ArrayList<E> nums);


    // коефіцієнт варіації
    public double findVariationCoefficient(ArrayList<E> nums){
        return Double.parseDouble(df.format(findSelectedMeanSquareDeviation(nums) / findSampleMean(nums) * 100));
    }


    // мода
    public abstract Double findMode(ArrayList<E> nums);


    // медіана
    public abstract Double findMedian(ArrayList<E> nums);


    // n усіх варіант
    public Integer findN(TreeMap<Integer, Integer> distribution) {
        int n = 0;
        Set<Integer> keys = distribution.keySet();
        for (Integer key : keys) {
            n += distribution.get(key);
        }
        return n;
    }


    // знайти початок довірчого інтервалу для математичного сподівання при n < 30
    public double findStart(double t, TreeMap<Integer, Integer> distribution){
        double xB = findSampleMean(distribution);
        double s = findCorrectedSampleMeanSquareDeviation(distribution);
        return xB - t * s / Math.sqrt(findN(distribution));
    }


    // знайти кінець довірчого інтервалу для математичного сподівання при n < 30
    public double findEnd(double t, TreeMap<Integer, Integer> distribution){
        double xB = findSampleMean(distribution);
        double s = findCorrectedSampleMeanSquareDeviation(distribution);
        return xB + t * s / Math.sqrt(findN(distribution));
    }


}
