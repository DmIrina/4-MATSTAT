package Helpers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeMap;

public class FunctionsDouble extends Functions<Double> {
    private final DecimalFormat df = new DecimalFormat("#.####");

    @Override
    public Double findMin(ArrayList<Double> arr){
        double min = Double.MAX_VALUE;
        for (Double d: arr) {
            min = Math.min(min, d);
        }
        return min;
    }


    @Override
    public Double findMax(ArrayList<Double> arr){
        double max = -1;
        for (Double d: arr) {
            max = Math.max(max, d);
        }
        return max;
    }

    @Override
    public int findH(ArrayList<Double> nums){
        return (int) Math.round((findMax(nums) - findMin(nums))/ findK(nums));
    }


    @Override
    public TreeMap<Double, Integer> findIntervalDistribution(ArrayList<Double> nums){
        Hashtable<Double, Integer> hashtable = new Hashtable<>();
        Double cur = findMin(nums);
        int h = findH(nums);
        for (int i = 0; i < h; i++) {
            if (i != 0){
                cur += Double.parseDouble(String.valueOf(h));
            }
            for (Double j: nums){
                if (hashtable.isEmpty() || !hashtable.containsKey(cur)){
                    hashtable.put(cur, 0);
                }
                if (j >= cur && j < cur + h){
                    hashtable.replace(cur, hashtable.get(cur), hashtable.get(cur) + 1);
                }
            }
        }
        return new TreeMap<>(hashtable);
    }


    @Override
    public ArrayList<Double> findInterval(ArrayList<Double> nums, Double xI, Double xI1) {
        ArrayList<Double> arrayList = new ArrayList<>();
        for (Double i: nums) {
            if (i >= xI && i < xI1){
                arrayList.add(i);
            }
        }
        return arrayList;
    }


    @Override
    public TreeMap<Double, Integer> findDiscreteDistribution(ArrayList<Double> nums){
        int h = findH(nums);
        TreeMap<Double, Integer> isd = findIntervalDistribution(nums);
        TreeMap<Double, Integer> dsd = new TreeMap<>();
        Set<Double> keys = isd.keySet();
        for (Double key: keys) {
            dsd.put((2 * key + h) / 2, isd.get(key));
        }
        return dsd;
    }


    @Override
    public double findScope(ArrayList<Double> nums){
        TreeMap<Double, Integer> treeMap = findDiscreteDistribution(nums);
        Set<Double> set = treeMap.keySet();
        ArrayList<Double> keys = new ArrayList<>(set);
        return findMax(keys) - findMin(keys);
    }


    @Override
    public Double findMode(ArrayList<Double> nums){
        TreeMap<Double, Integer> treeMap = findIntervalDistribution(nums);
        Set<Double> set = treeMap.keySet();
        ArrayList<Double> keys = new ArrayList<>(set);
        int h = findH(nums);
        int n = 0;
        int nI = 0;
        double nN = 0;
        double nP = 0;

        for (int j = 0; j < keys.size(); j++){
            int cur = treeMap.get(keys.get(j));
            if (cur > n){
                n = cur;
                nI = j;
            }
        }

        if (nI + 1 < keys.size()){
            nN = treeMap.get(keys.get(nI + 1));
        }

        if (nI - 1 >= 0){
            nP = treeMap.get(keys.get(nI - 1));
        }

        return  Double.parseDouble(df.format(keys.get(nI) + h * (n - nP) / (2 * n - nP - nN)));
    }


    @Override
    public Double findMedian(ArrayList<Double> nums){
        double mean = (findMax(nums) + findMin(nums) ) / 2;
        TreeMap<Double, Integer> treeMap = findIntervalDistribution(nums);
        Set<Double> set = treeMap.keySet();
        ArrayList<Double> keys = new ArrayList<>(set);
        int h = findH(nums);
        Double lowerBorder = (double) 0;
        int nI = 0;
        for (int j = 0; j < keys.size(); j++){
            lowerBorder = keys.get(j);
            if (mean < lowerBorder + h){
                nI = j;
                break;
            }
        }
        int n = treeMap.get(lowerBorder);
        int sum = 0;
        for (int i = 0; i < nI; i++){
            sum += treeMap.get(keys.get(i));
        }
        return  Double.parseDouble(df.format(lowerBorder + (double )h * ((double) nums.size() / 2 - sum) / n));
    }
}
