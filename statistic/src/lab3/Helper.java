package lab3;

import Helpers.FunctionsInteger;

import java.util.Set;
import java.util.TreeMap;

public class Helper {
    private TreeMap<Integer, Integer> distribution;
    private TreeMap<Double, Integer> discreteDiv  = new TreeMap<>();
    private double reliability;
    private boolean isInterval = false;
    private int step;
    private int n;
    private double t;
    private final FunctionsInteger fInt = new FunctionsInteger();


    public Helper(double reliability, TreeMap<Integer, Integer> distribution) {
        this.distribution = distribution;
        this.reliability = reliability;
        this.n = fInt.findN(distribution);
    }

    public Helper(double reliability, int step, TreeMap<Integer, Integer> distribution) {
        this.distribution = distribution;
        this.reliability = reliability;
        this.step = step;
        this.isInterval = true;
        this.n = fInt.findN(distribution);
        findDiscreteStatisticDividing();
    }

    public void printTask1(){
        System.out.println("------------------7.1------------------");
        System.out.println("Статистичний розподіл вибірки");
        System.out.println(distribution);
        System.out.println("---------------------------------------");
        System.out.println("n = " + n);
        System.out.println("Вибіркове середнє: " + fInt.findSampleMean(distribution));
        System.out.println("Вибіркова дисперсія: " + fInt.findSampleVariance(distribution));
        System.out.println("Виправлена вибіркова дисперсія: " + fInt.findCorrectedSampleVariance(distribution));
        System.out.println("Виправлене вибіркове середнє квадратичне відхилення: " + fInt.findCorrectedSampleMeanSquareDeviation(distribution));
        t = 3.97;
        System.out.println("n = " + n + " -> t = " + t + " (табличне значення)");
        System.out.println("Початок інтервалу: " + fInt.findStart(t, distribution));
        System.out.println("Кінець інтервалу: " + fInt.findEnd(t, distribution));
    }

    private void solveTask1(TreeMap<Integer, Integer> distribution){

    }

    public void findDiscreteStatisticDividing(){
        Set<Integer> keys = distribution.keySet();
        for (Integer key: keys) {
            discreteDiv.put((2 * (double) key + (double) step) / 2, distribution.get(key));
        }
    }

    public double findSelectedMean(){               // xB
        if (isInterval){
            return findSelectedMeanDouble();        // interval
        } else {
            return findSelectedMeanInt();           // not interval
        }
    }

    private double findSelectedMeanInt(){
        Set<Integer> keys = distribution.keySet();
        double m = 0;
        for (int key: keys) {
            m += key * distribution.get(key);
        }
        return m / n;
    }

    private double findSelectedMeanDouble(){
        Set<Double> keys = discreteDiv.keySet();
        double m = 0;
        for (double key: keys) {
            m += key * discreteDiv.get(key);
        }
        return m / n;
    }

    public double findSelectedDisperse(){            // DB
        double selectedMean = findSelectedMean();
        if (isInterval){
            return findDisperseDouble(selectedMean);
        } else {
            return findDisperseInt(selectedMean);
        }
    }

    private double findDisperseDouble(double selectedMean){
        Set<Double> keys = discreteDiv.keySet();
        double d = 0;
        for (double key: keys) {
            d += Math.pow(key, 2) * discreteDiv.get(key);
        }
        return d / n - Math.pow(selectedMean, 2);
    }

    private double findDisperseInt(double selectedMean){
        Set<Integer> keys = distribution.keySet();
        double d = Double.MIN_VALUE;
        for (int key: keys) {
            d += Math.pow(key, 2) * distribution.get(key);
        }
        return d / n - Math.pow(selectedMean, 2);
    }

    public double findSelectedMeanSquareDeviation(){
        return Math.sqrt(findSelectedDisperse());
    }

    public double findFixedSelectedDisperse(){                  // s^2
        double d = findSelectedDisperse();
        return n * d / (n - 1);
    }

    public double findFixedSelectedMeanSquareDeviation(){       // s
        return Math.sqrt(findFixedSelectedDisperse());
    }

    public double findF(){                                      // to find t if n > 30
        return reliability / 2;
    }

//    public double findStart(double t){
//        double xB = findSelectedMean();
//        double s = findFixedSelectedMeanSquareDeviation();
//        return xB - t * s / Math.sqrt(n);
//    }

//    public double findEnd(double t){
//        double xB = findSelectedMean();
//        double s = findFixedSelectedMeanSquareDeviation();
//        return xB + t * s / Math.sqrt(n);
//    }

    public double findStart(double t, int sigma){
        double xB = findSelectedMean();
        return xB - t * sigma / Math.sqrt(n);
    }

    public double findEnd(double t, int sigma){
        double xB = findSelectedMean();
        return xB + t * sigma / Math.sqrt(n);
    }

    public double findStartQ(double q){
        double s = findFixedSelectedMeanSquareDeviation();
        return s * (1 - q);
    }

    public double findEndQ(double q){
        double s = findFixedSelectedMeanSquareDeviation();
        return s * (1 + q);
    }
}

