package lab6;

import java.text.DecimalFormat;
import java.util.*;

public class Helper {
    public int k; // величина інтервалів
    public double h;
    public int n;
    public TreeMap<Integer, Integer> bigTable;
    public TreeMap<Integer, Integer> smallTable = new TreeMap<>();
    public TreeMap<Double, Integer> discreteTable;
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
    private final DecimalFormat df = new DecimalFormat("#.####");


    private void solveTask1(ArrayList<Integer> list, int n, int k) {
        this.bigTable = findTable(list);
        this.k = k;
        this.n = n;
        this.h = findH(list);
        fillSmallTableTask1();
        this.discreteTable = findDiscreteTable(smallTable);
        findNTable(discreteTable);
        findAdditionalTable(discreteTable);
        findAdditionalTable2(discreteTable);
    }

    public void printTask1(ArrayList<Integer> list, int n, int k) {
        solveTask1(list, n, k);
        System.out.println(bigTable);
        System.out.println("i = " + getI(bigTable));
        System.out.println("n = " + n);
        System.out.println("min:" + findMin(list));
        System.out.println("max:" + findMax(list));
        System.out.println("k = " + k);
        System.out.println("h = " + h);
        System.out.println("Інтервали:");
        System.out.println(smallTable);
        System.out.println("Дискретний розподіл з рівновіддаленими варіантами");
        System.out.println(discreteTable);
        System.out.println("Вибіркове середнє: " + findSelectedMean(discreteTable));
        System.out.println("Вибіркова дисперсія: " + findSelectedDisperse(discreteTable));
        System.out.println("Виправлене вибіркове середнє квадратичне відхилення: " + findSigma(discreteTable));
        System.out.println(getNHS(discreteTable));
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
        System.out.println("res sum = " + findValuesSumDouble(res));
        System.out.println("n sum = " + findValuesSumInt(nTable));
        System.out.println("ni sum = " + findValuesSumDouble(nITable));
    }

    private void solveTask2(ArrayList<Integer> list, int n) {
        this.n = n;
        this.bigTable = findTable(list);
        this.k = 7;
        this.h = 7;
        this.smallTable = findSmallTable(bigTable);
        this.discreteTable = findDiscreteTable(smallTable);
        fillFTableTask2();
        fillF1TableTask2();
        findNTable(discreteTable);
        findAdditionalTableInterval(discreteTable, smallTable);
        findAdditionalTable2(discreteTable);
    }

    public void printTask2(ArrayList<Integer> list, int n) {
        solveTask2(list, n);
        System.out.println(bigTable);
        System.out.println("i = " + getI(bigTable));
        System.out.println("n = " + n);
        System.out.println("min:" + findMin(list));
        System.out.println("max:" + findMax(list));
        System.out.println("k = " + k);
        System.out.println("h = " + h);
        System.out.println("Інтервали:");
        System.out.println(smallTable);
        System.out.println(findValuesSumInt(smallTable));
        System.out.println(discreteTable);
        System.out.println(findValuesSumDoubleInt(discreteTable));
        System.out.println("Вибіркове середнє: " + findSelectedMean(discreteTable));
        System.out.println("Вибіркова дисперсія: " + findSelectedDisperse(discreteTable));
        System.out.println("Виправлене вибіркове середнє квадратичне відхилення: " + findSigma(discreteTable));
        System.out.println("----------------------------uI----------------------------");
        System.out.println(uTable);
        System.out.println("----------------------------uI+1----------------------------");
        System.out.println(u1Table);
        System.out.println("----------------------------Fui----------------------------");
        System.out.println(FTable);
        System.out.println("----------------------------FuI+1----------------------------");
        System.out.println(F1Table);
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
        System.out.println(findValuesSumInt(nTable));
        System.out.println(findValuesSumDouble(nITable));
        System.out.println(findValuesSumDouble(res));
    }

    private void solveTask3() {
        this.h = 1;
        fillSmallTableTask3();
        this.discreteTable = findDiscreteTable(smallTable);
        this.n = findValuesSumInt(smallTable);
        findNTable(discreteTable);
        findAdditionalTableIntervalE(smallTable);
        // findAdditionalTableIntervalP(discreteTable);
    }

    public void printTask3() {
        solveTask3();
        System.out.println("h = " + h);
        System.out.println("n = " + n);
        System.out.println("Інтервали:");
        System.out.println(smallTable);
        System.out.println(discreteTable);
        System.out.println("Вибіркове середнє: " + findSelectedMean(discreteTable));
        System.out.println("Lambda = " + findLambdaP());
        System.out.println("----------------------------pI----------------------------");
        System.out.println(pITable);
        System.out.println("----------------------------nI----------------------------");
        System.out.println(nITable);
        System.out.println("-----------------------------n----------------------------");
        System.out.println(nTable);
    }

    public int findK() {
        return (int) (1 + 3.322 * Math.log10(n));
    }

    private int findMin(ArrayList<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for (Integer i : arr) {
            min = Math.min(min, i);
        }
        return min;
    }

    private int findMax(ArrayList<Integer> arr) {
        int max = -1;
        for (Integer i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

    private double findLambdaE(){
        return Double.parseDouble(df.format(1 / findSelectedMean(discreteTable)));
    }

    private double findLambdaP(){
        return findSelectedMean(discreteTable);
    }

    private double findPiE(int z, int z1){
        return Double.parseDouble(df.format(Math.pow(Math.E, - findLambdaE() * z) - Math.pow(Math.E, - findLambdaE() * z1)));
    }

    private double findPiP(double z){
        double lambda = findLambdaP();
        return Double.parseDouble(df.format(Math.pow(lambda, z) * Math.pow(Math.E, -lambda) / factorial(z)));
    }

    private double factorial(double n) {
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    private double findH(ArrayList<Integer> list) {
        return Math.round(((double) findMax(list) - (double) findMin(list)) / (double) k);
    }

    private TreeMap<Integer, Integer> findTable(ArrayList<Integer> table) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int item : table) {
            if (hashtable.isEmpty()) {
                hashtable.put(item, 0);
            }
            if (hashtable.containsKey(item)) {
                hashtable.replace(item, hashtable.get(item), hashtable.get(item) + 1);
            } else {
                hashtable.put(item, 1);
            }
        }
        return new TreeMap<>(hashtable);
    }

    public TreeMap<Integer, Integer> findSmallTable(TreeMap<Integer, Integer> table) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        int cur = table.firstKey();
        Set<Integer> keys = table.keySet();
        for (int key : keys) {
            if ((key >= cur + h) && hashtable.size() < k) {
                cur += h;
            }
            if (hashtable.isEmpty() || !hashtable.containsKey(cur)) {
                hashtable.put(cur, 0);
            }
            if (key >= cur) {
                hashtable.replace(cur, hashtable.get(cur), hashtable.get(cur) + table.get(key));
            }
        }
        return new TreeMap<>(hashtable);
    }

    private void fillSmallTableTask1() {
        smallTable.put(36, 15);
        smallTable.put(44, 11);
        smallTable.put(52, 23);
        smallTable.put(60, 13);
        smallTable.put(68, 14);
        smallTable.put(76, 12);
        smallTable.put(84, 12);
    }

    private void fillSmallTableTask3() {
        smallTable.put(1, 52);
        smallTable.put(2, 45);
        smallTable.put(3, 29);
        smallTable.put(4, 26);
        smallTable.put(5, 24);
        smallTable.put(6, 20);
        smallTable.put(7, 16);
        smallTable.put(8, 13);
        smallTable.put(9, 11);
        smallTable.put(10, 8);
    }

    private TreeMap<Double, Integer> findDiscreteTable(TreeMap<Integer, Integer> table) {
        TreeMap<Double, Integer> discreteTable = new TreeMap<>();
        Set<Integer> keys = table.keySet();
        for (Integer key : keys) {
            discreteTable.put((2 * (double) key + h) / 2, table.get(key));
        }
        return discreteTable;
    }

    private int getI(TreeMap<Integer, Integer> table) {
        return table.keySet().size();
    }


    private double findSelectedMean(TreeMap<Double, Integer> table) {                           // xB
        Set<Double> keys = table.keySet();
        double m = 0;
        for (double key : keys) {
            m += key * table.get(key);
        }
        return Double.parseDouble(df.format(m / n));
    }

    private double findSelectedDisperse(TreeMap<Double, Integer> table) {                      // DB
        double selectedMean = findSelectedMean(table);
        Set<Double> keys = table.keySet();
        double d = 0;
        for (double key : keys) {
            d += Math.pow(key, 2) * table.get(key);
        }
        return Double.parseDouble(df.format(d / n - Math.pow(selectedMean, 2)));
    }

    private double findSigma(TreeMap<Double, Integer> table) {
        return Double.parseDouble(df.format(Math.sqrt(findSelectedDisperse(table))));
    }

    private void fillFiTableTask1() {
        fiTable.put(1, 0.1334);
        fiTable.put(2, 0.2516);
        fiTable.put(3, 0.3621);
        fiTable.put(4, 0.3977);
        fiTable.put(5, 0.3332);
        fiTable.put(6, 0.2131);
        fiTable.put(7, 0.104);
    }

    private void findAdditionalTableInterval(TreeMap<Double, Integer> discreteTable, TreeMap<Integer, Integer> intervalTable) {
        ArrayList<Integer> keys = new ArrayList<>(intervalTable.keySet());
        double u;
        double xB = findSelectedMean(discreteTable);
        double sigma = findSigma(discreteTable);
        uTable.put(1, Double.MIN_VALUE);
        u1Table.put(keys.size(), Double.MAX_VALUE);

        for (int i = 2; i < keys.size() + 1; i++) {
            u = Double.parseDouble(df.format((keys.get(i - 1) - xB) / sigma));
            uTable.put(i, u);
            u1Table.put(i - 1, u);
        }

        for (int i = 1; i < keys.size() + 1; i++){
            nITable.put(i, Double.parseDouble(df.format(n * (F1Table.get(i) - FTable.get(i)))));
        }
    }

    private void findAdditionalTableIntervalE(TreeMap<Integer, Integer> intervalTable) {
        ArrayList<Integer> keys = new ArrayList<>(intervalTable.keySet());
        for (int i = 1; i < keys.size() + 1; i++){
            pITable.put(i, Double.parseDouble(df.format(findPiE(keys.get(i-1), keys.get(i-1) + (int) h))));
            nITable.put(i, Double.parseDouble(df.format(n * pITable.get(i))));
        }
    }

    private void findAdditionalTableIntervalP(TreeMap<Double, Integer> table) {
        ArrayList<Double> keys = new ArrayList<>(table.keySet());
        for (int i = 1; i < keys.size(); i++){
            pITable.put(i, Double.parseDouble(df.format(findPiP(keys.get(i-1)))));
            nITable.put(i, Double.parseDouble(df.format(n * pITable.get(i))));
        }
    }

    private void findAdditionalTable(TreeMap<Double, Integer> table) {
        fillFiTableTask1();
        Set<Double> keys = table.keySet();
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

    private void fillFTableTask2() {
        FTable.put(1, -0.5);
        FTable.put(2, -0.39251);
        FTable.put(3, -0.27035);
        FTable.put(4, -0.09095);
        FTable.put(5, 0.11026);
        FTable.put(6, 0.2823);
        FTable.put(7, 0.40147);
    }

    private void fillF1TableTask2() {
        F1Table.put(1, -0.39251);
        F1Table.put(2, -0.27035);
        F1Table.put(3, -0.09095);
        F1Table.put(4, 0.11026);
        F1Table.put(5, 0.2823);
        F1Table.put(6, 0.40147);
        F1Table.put(7, 0.5);

    }

    private double getNHS(TreeMap<Double, Integer> table) {
        double sigma = findSigma(table);
        return Double.parseDouble(df.format(n * h / sigma));
    }

    private void findNTable(TreeMap<Double, Integer> table) {
        Set<Double> keys = table.keySet();
        int i = 1;
        for (double key : keys) {
            nTable.put(i, table.get(key));
            i++;
        }
    }

    private void findAdditionalTable2(TreeMap<Double, Integer> table) {
        Set<Double> keys = table.keySet();
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
        for (int i = 1; i < 8; i++) {
            sum += table.get(i);
        }
        return Double.parseDouble(df.format(sum));
    }

    private double findValuesSumDoubleInt(TreeMap<Double, Integer> table) {
        double sum = 0;
        Set<Double> keys = table.keySet();
        for (double key : keys) {
            sum += table.get(key);
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

}
