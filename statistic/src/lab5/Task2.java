package lab5;

import java.util.Set;
import java.util.TreeMap;

public class Task2 {
    public TreeMap<Double, Integer> table = new TreeMap<>();
    public int n;
    public double sigma2;
    public double alpha;

    public Task2(int n, double sigma2, double alpha){
        this.alpha = alpha;
        this.sigma2 = sigma2;
        this.n = n;
        fillTable();
    }

    private void fillTable(){
        table.put(3.0, 2);
        table.put(3.5, 6);
        table.put(3.8, 9);
        table.put(4.4, 7);
        table.put(4.5, 1);
    }

    public double findSelectedMean(){                           // xB
        Set<Double> keys = table.keySet();
        double m = 0;
        for (double key: keys) {
            m += key * table.get(key);
        }
        return m / n;
    }

    public double findSelectedDisperse(){                      // DB
        double selectedMean = findSelectedMean();
        Set<Double> keys = table.keySet();
        double d = 0;
        for (double key: keys) {
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

    public double getX2SP(){
        return (n - 1) * findFixedSelectedDisperse() / sigma2;
    }

    public int getK(){
        return n - 1;
    }


}
