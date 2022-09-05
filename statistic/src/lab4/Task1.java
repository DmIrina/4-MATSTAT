package lab4;

import java.util.TreeMap;

public class Task1 {
    public TreeMap<Integer, Integer> xI = new TreeMap<>();
    public TreeMap<Integer, Integer> yI = new TreeMap<>();
    public TreeMap<Integer, Integer> x2I = new TreeMap<>();
    public TreeMap<Integer, Integer> xIyI = new TreeMap<>();
    public Integer sumXI;
    public Integer sumYI;
    public Integer sumX2I;
    public Integer sumXIYI;
    public Integer n = 10;

    public Task1() {
        fillXI();
        fillYI();
        fillX2I();
        fillXIYI();
        sumXI = findSum(xI);
        sumYI = findSum(yI);
        sumX2I = findSum(x2I);
        sumXIYI = findSum(xIyI);
    }

    private void fillXI() {
        xI.put(1, 21);
        xI.put(2,24);
        xI.put(3, 27);
        xI.put(4, 32);
        xI.put(5, 35);
        xI.put(6, 36);
        xI.put(7, 38);
        xI.put(8, 42);
        xI.put(9, 44);
        xI.put(10, 45);
    }

    private void fillYI() {
        yI.put(1, 18);
        yI.put(2, 17);
        yI.put(3, 14);
        yI.put(4, 12);
        yI.put(5, 11);
        yI.put(6, 9);
        yI.put(7, 7);
        yI.put(8, 6);
        yI.put(9, 4);
        yI.put(10, 3);
    }

    private void fillX2I() {
        for (int i = 1; i < n + 1; i++) {
            x2I.put(i, (int) Math.pow(xI.get(i), 2));
        }
    }

    private void fillXIYI() {
        for (int i = 1; i < n + 1; i++) {
            xIyI.put(i, xI.get(i) * yI.get(i));
        }
    }

    public Integer findSum(TreeMap<Integer, Integer> treeMap) {
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += treeMap.get(i);
        }
        return sum;
    }

    public double getK(){
        return (double) (sumYI * sumXI - sumXIYI * n) / (sumXI * sumXI - sumX2I * n);
    }

    public double getB(){
        return (sumXIYI * n - sumX2I * n * getK()) / (sumXI * n);
    }
}
