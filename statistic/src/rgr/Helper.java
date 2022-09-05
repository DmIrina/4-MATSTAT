package rgr;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeMap;

public class Helper {
    public int k; // величина інтервалів
    public double h;
    public int n;
    public TreeMap<Integer, Integer> bigTable;
    public TreeMap<Integer, Integer> smallTable = new TreeMap<>();
    public TreeMap<Double, Integer> discreteTable;
    private final DecimalFormat df = new DecimalFormat("#.####");
    public TreeMap<Integer, Double> fiTable = new TreeMap<>();
    public TreeMap<Integer, Double> uTable = new TreeMap<>();
    public TreeMap<Integer, Double> u1Table = new TreeMap<>();
    public TreeMap<Integer, Double> nITable = new TreeMap<>();
    public TreeMap<Integer, Double> pITable = new TreeMap<>();
    public TreeMap<Integer, Integer> nTable = new TreeMap<>();
    public TreeMap<Integer, Double> nMinusTable = new TreeMap<>();
    public TreeMap<Integer, Double> nMinusTable2 = new TreeMap<>();
    public TreeMap<Integer, Double> FTable = new TreeMap<>();
    public TreeMap<Integer, Double> F1Table = new TreeMap<>();
    public TreeMap<Integer, Double> res = new TreeMap<>();

    public void solveTask1(){
        fillTable1();
        this.n = 500;
        this.h = 4;
        findNTable(smallTable);
        findAdditionalTable(smallTable);
        findAdditionalTable2(smallTable);
    }

    public void solveTask2(){
        fillTable1();
        this.n = 500;
        this.h = 4;
    }

    public void solveTask3(){
        fillTable1();
        this.n = 18;
    }

    public void printTask1(){
        solveTask1();
        System.out.println(smallTable);
        System.out.println("Вибіркове середнє: " + findSelectedMean(smallTable));
        System.out.println("Вибіркова дисперсія: " + findSelectedDisperse(smallTable));
        System.out.println("Вибіркове середнє квадратичне відхилення: " + findSigma(smallTable));
        System.out.println("nhs = " + getNHS(smallTable));
        System.out.println("----------------------------uI----------------------------");
        System.out.println(uTable);
        System.out.println("----------------------------FI----------------------------");
        System.out.println(fiTable);
        System.out.println("----------------------------nI----------------------------");
        System.out.println(nITable);
        System.out.println("-----------------------------n----------------------------");
        System.out.println(nTable);
        System.out.println("-----------------------------n-n'----------------------------");
        System.out.println(nMinusTable);
        System.out.println("-----------------------------(n-n')^2----------------------------");
        System.out.println(nMinusTable2);
        System.out.println("-----------------------------(n-n')^2 / n'----------------------------");
        System.out.println(res);
        System.out.println(findValuesSumDouble(res));
        System.out.println(findValuesSumInt(nTable));

    }

    public void printTask2(){
        solveTask2();
        System.out.println("Вибіркове середнє: " + findSelectedMean(smallTable));
        System.out.println("Вибіркова дисперсія: " + findSelectedDisperse(smallTable));
        System.out.println("Виправлена вибіркова дисперсія: " + findFixedSelectedDisperse());
        System.out.println("Виправлене вибіркове середнє квадратичне відхилення: " + findFixedSelectedMeanSquareDeviation());
    }

    public void printTask3(){
        solveTask3();
        System.out.println("Вибіркове середнє: " + findSelectedMean(smallTable));
        System.out.println("Вибіркова дисперсія: " + findSelectedDisperse(smallTable));
        System.out.println("Виправлена вибіркова дисперсія: " + findFixedSelectedDisperse());
        System.out.println("Виправлене вибіркове середнє квадратичне відхилення: " + findFixedSelectedMeanSquareDeviation());

    }

    private void fillTable1(){
/*        smallTable.put(17, 45);
        smallTable.put(21, 125);
        smallTable.put(25, 175);
        smallTable.put(29, 115);
        smallTable.put(33, 40);*/

        smallTable.put(6, 3);
        smallTable.put(12, 4);
        smallTable.put(14, 6);
        smallTable.put(18, 3);
        smallTable.put(21, 2);
    }

    private double findSelectedMean(TreeMap<Integer, Integer> table) {                           // xB
        Set<Integer> keys = table.keySet();
        double m = 0;
        for (int key : keys) {
            m += key * table.get(key);
        }
        return Double.parseDouble(df.format(m / n));
    }

    private double findSelectedDisperse(TreeMap<Integer, Integer> table) {                      // DB
        double selectedMean = findSelectedMean(table);
        Set<Integer> keys = table.keySet();
        double d = 0;
        for (int key : keys) {
            d += Math.pow(key, 2) * table.get(key);
        }
        return Double.parseDouble(df.format(d / n - Math.pow(selectedMean, 2)));
    }

    private double findSigma(TreeMap<Integer, Integer> table) {
        return Double.parseDouble(df.format(Math.sqrt(findSelectedDisperse(table))));
    }

    private void findNTable(TreeMap<Integer, Integer> table) {
        Set<Integer> keys = table.keySet();
        int i = 1;
        for (int key : keys) {
            nTable.put(i, table.get(key));
            i++;
        }
    }

    private double getNHS(TreeMap<Integer, Integer> table) {
        double sigma = findSigma(table);
        return Double.parseDouble(df.format(n * h / sigma));
    }

    private void fillFiTableTask1() {
        fiTable.put(1, 0.0761);
        fiTable.put(2, 0.2685);
        fiTable.put(3, 0.3986);
        fiTable.put(4, 0.2492);
        fiTable.put(5, 0.0656);
    }

    private void findAdditionalTable(TreeMap<Integer, Integer> table) {
        fillFiTableTask1();
        Set<Integer> keys = table.keySet();
        double u;
        double nI;
        double xB = findSelectedMean(table);
        double sigma = findSigma(table);
        double nhs = getNHS(table);
        int i = 1;
        for (double key : keys) {
            u = (key - xB) / sigma;
            nI = nhs * fiTable.get(i);
            uTable.put(i, Double.parseDouble(df.format(u)));
            nITable.put(i, Double.parseDouble(df.format(nI)));
            i++;
        }
    }

    private void findAdditionalTable2(TreeMap<Integer, Integer> table) {
        Set<Integer> keys = table.keySet();
        double temp;
        for (int i = 1; i < keys.size() + 1; i++) {
            temp = nTable.get(i) - nITable.get(i);
            nMinusTable.put(i, Double.parseDouble(df.format((temp))));
            temp = Math.pow(temp, 2);
            nMinusTable2.put(i, Double.parseDouble(df.format((temp))));
            res.put(i, Double.parseDouble(df.format(temp / nITable.get(i))));
        }
    }

    private double findValuesSumDouble(TreeMap<Integer, Double> table) {
        double sum = 0;
        for (int i = 1; i < table.size() + 1; i++) {
            sum += table.get(i);
        }
        return Double.parseDouble(df.format(sum));
    }

    private int findValuesSumInt(TreeMap<Integer, Integer> table) {
        int sum = 0;
        Set<Integer> keys = table.keySet();
        for (int key : keys) {
            sum += table.get(key);
        }
        return sum;
    }

    public double findFixedSelectedDisperse(){                  // s^2
        double d = findSelectedDisperse(smallTable);
        return n * d / (n - 1);
    }

    public double findFixedSelectedMeanSquareDeviation(){       // s
        return Math.sqrt(findFixedSelectedDisperse());
    }

}
