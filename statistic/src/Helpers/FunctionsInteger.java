package Helpers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeMap;

public class FunctionsInteger extends Functions<Integer> {
    private final DecimalFormat df = new DecimalFormat("#.####");

    @Override
    public Integer findMin(ArrayList<Integer> arr){
        int min = Integer.MAX_VALUE;
        for (Integer i: arr) {
            min = Math.min(min, i);
        }
        return min;
    }


    @Override
    public Integer findMax(ArrayList<Integer> arr){
        int max = -1;
        for (Integer i: arr) {
            max = Math.max(max, i);
        }
        return max;
    }


    @Override
    public int findH(ArrayList<Integer> nums){
        return (int) Math.round(((double) findMax(nums) - (double) findMin(nums))/ (double) findK(nums));
    }


    @Override
    public TreeMap<Integer, Integer> findIntervalDistribution(ArrayList<Integer> nums){
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        int cur = findMin(nums);
        int h = findH(nums);
        for (int i = 0; i < h; i++) {
            if (i != 0){
                cur += h;
            }
            for (int j: nums){
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
    public ArrayList<Integer> findInterval(ArrayList<Integer> nums, Integer xI, Integer xI1){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i: nums) {
            if (i >= xI && i < xI1){
                arrayList.add(i);
            }
        }
        return arrayList;
    }


    @Override
    public TreeMap<Double, Integer> findDiscreteDistribution(ArrayList<Integer> nums){
        int h = findH(nums);
        TreeMap<Integer, Integer> isd = findIntervalDistribution(nums);
        TreeMap<Double, Integer> dsd = new TreeMap<>();
        Set<Integer> keys = isd.keySet();
        for (Integer key: keys) {
            dsd.put((2 * (double) key + (double) h) / 2, isd.get(key));
        }
        return dsd;
    }


    @Override
    public double findScope(ArrayList<Integer> nums){
        TreeMap<Double, Integer> treeMap = findDiscreteDistribution(nums);
        Set<Double> set = treeMap.keySet();
        ArrayList<Double> keys = new ArrayList<>(set);
        return new FunctionsDouble().findMax(keys) - new FunctionsDouble().findMin(keys);
    }


    @Override
    public Double findMode(ArrayList<Integer> nums){
        TreeMap<Integer, Integer> treeMap = findIntervalDistribution(nums);
        Set<Integer> set = treeMap.keySet();
        ArrayList<Integer> keys = new ArrayList<>(set);
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

        return  Double.parseDouble(df.format((keys.get(nI) + h * (n - nP) / (2 * n - nP - nN))));
    }


    @Override
    public Double findMedian(ArrayList<Integer> nums){
        double mean = ((double) findMax(nums) + (double) findMin(nums) ) / 2;
        TreeMap<Integer, Integer> treeMap = findIntervalDistribution(nums);
        Set<Integer> set = treeMap.keySet();
        ArrayList<Integer> keys = new ArrayList<>(set);
        int h = findH(nums);
        int lowerBorder = 0;
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
