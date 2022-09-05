package lab3;

import java.util.TreeMap;

public class Data {
    public static TreeMap<Integer, Integer> setDistributionTask1(){
        TreeMap<Integer, Integer> distribution = new TreeMap<>();
        distribution.put(5, 3);
        distribution.put(11, 4);
        distribution.put(13, 6);
        distribution.put(17, 3);
        distribution.put(20, 2);
        return distribution;
    }

    public static TreeMap<Integer, Integer> setDistributionTask2(){
        TreeMap<Integer, Integer> distribution = new TreeMap<>();
        distribution.put(3, 8);
        distribution.put(6, 15);
        distribution.put(9, 24);
        distribution.put(12, 20);
        distribution.put(15, 19);
        distribution.put(18, 10);
        distribution.put(21, 4);
        return distribution;
    }

    public static TreeMap<Integer, Integer> setDistributionTask3(){
        TreeMap<Integer, Integer> distribution = new TreeMap<>();
        distribution.put(1, 3);
        distribution.put(2, 4);
        distribution.put(5, 6);
        distribution.put(7, 3);
        distribution.put(8, 2);
        return distribution;
    }
}
