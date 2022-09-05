package lab4;

public class Task2 {
    public int genSum = 100;
    public int C1 = 10;
    public int h1 = 2;
    public int C2 = 11;
    public int h2 = 4;
    public int[] row = new int[]{-2, -1, 0, 1, 2};
    public int[] rowSum = new int[]{18, 19, 32, 23, 8};
    public int[] col = new int[]{-4, -3, -2, -1, 0, 1, 2, 3};
    public int[] colSum = new int[]{16, 18, 16, 18, 8, 13, 7, 4};
    public int[][] table = new int[][]{{7, 11, 0, 0, 0, 0, 0, 0},
                                       {5, 4, 10, 0, 0, 0, 0, 0},
                                       {4, 3, 6, 14, 5, 0, 0, 0},
                                       {0, 0, 0, 4, 3, 10, 3, 3},
                                       {0, 0, 0, 0, 0, 3, 4, 1}};

    public double getUB() {
        return count(col, colSum);
    }

    public double getVB() {
        return count(row, rowSum);
    }

    public double getU2B() {
        return count2(col, colSum);
    }

    public double getV2B() {
        return count2(row, rowSum);
    }

    public double getSigmaU() {
        return getSigma(getUB(), getU2B());
    }

    public double getSigmaV() {
        return getSigma(getVB(), getV2B());
    }

    public int getUVNSum() {
        int result = 0;
        for (int i = 0; i < row.length; i++){
            for (int j = 0; j < col.length; j++){
                result += row[i] * col [j] * table[i][j];
            }
        }
        return result;
    }

    public double getRB(){
        return (getUVNSum() - genSum * getUB() * getVB()) / (genSum * getSigmaU() * getSigmaV());
    }

    public double getXB(){
        return getSelectedMean(getUB(), h1, C1);
    }

    public double getYB(){
        return getSelectedMean(getVB(), h2, C2);
    }

    public double getSigmaX(){
        return getSigmaU() * h1;
    }

    public double getSigmaY(){
        return getSigmaV() * h2;
    }

    public double getK(){
        return getRB() * getSigmaY() / getSigmaX();
    }

    public double getB(){
        return getYB() - getRB() * getSigmaY() * getXB() / getSigmaX();
    }

    private double count(int[] arr, int[] arrSum) {
        double result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] * arrSum[i];
        }
        return result / genSum;
    }

    private double count2(int[] arr, int[] arrSum) {
        double result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += Math.pow(arr[i], 2) * arrSum[i];
        }
        return result / genSum;
    }

    private double getSigma(double x, double x2) {
        return Math.sqrt(x2 - Math.pow(x, 2));
    }

    private double getSelectedMean(double deviation, int h, int C){
        return deviation * h + C;
    }

}
