package lab5;

import java.util.Set;
import java.util.TreeMap;

public class Task1 {
    public TreeMap<Integer, Integer> table = new TreeMap<>();
    public int n;
    public int a;
    public double alpha;

    public Task1(int n, double alpha, int a){
        this.alpha = alpha;
        this.a = a;
        this.n = n;
        fillTable();
    }

    private void fillTable(){
        table.put(6, 1);
        table.put(7, 3);
        table.put(8, 6);
        table.put(9, 8);
        table.put(10, 6);
        table.put(11, 6);
        table.put(12, 5);
        table.put(13, 3);
        table.put(14, 2);
    }

    public double findSelectedMean(){                           // xB
        Set<Integer> keys = table.keySet();
        double m = 0;
        for (int key: keys) {
            m += key * table.get(key);
        }
        return m / n;
    }

    public double findSelectedDisperse(){                      // DB
        double selectedMean = findSelectedMean();
        Set<Integer> keys = table.keySet();
        double d = 0;
        for (int key: keys) {
            d += Math.pow(key, 2) * table.get(key);
        }
        return d / n - Math.pow(selectedMean, 2);
    }

    public double findFixedSelectedDisperse(){                  // s^2
        double d = findSelectedDisperse();
        return n * d / (n - 1);
    }

    public double findFixedSelectedMeanSquareDeviation(){       // s
        return Math.sqrt(findFixedSelectedDisperse());
    }

    public double getTSP(){
        return (findSelectedMean() - a) * Math.sqrt(n) / findFixedSelectedMeanSquareDeviation();
    }

    public int getK(){
        return n - 1;
    }

}
