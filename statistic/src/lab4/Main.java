package lab4;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------7.1-----------------------------");
        Task1 t71 = new Task1();
        System.out.println("xI:     " + t71.xI + "              " + t71.sumXI);
        System.out.println("yI:     " + t71.yI + "            " + t71.sumYI);
        System.out.println("x2I:    " + t71.x2I + "      " + t71.sumX2I);
        System.out.println("xIyI:   " + t71.xIyI + "    " + t71.sumXIYI);
        System.out.println(t71.sumX2I + "k + " + t71.sumXI + "b = " + t71.sumXIYI);
        System.out.println(t71.sumXI + "k + " + t71.n + "b = " + t71.sumYI);
        System.out.println("k = " + t71.getK());
        System.out.println("b = " + t71.getB());
        // System.out.println(t71.sumX2I * t71.getK() + t71.sumXI * t71.getB());
        // System.out.println(t71.sumXI * t71.getK() + t71.n * t71.getB());
//        System.out.println("---------------------------7.2-----------------------------");
//        Task2 t72 = new Task2();
//        System.out.println("uB = " + t72.getUB());
//        System.out.println("vB = " + t72.getVB());
//        System.out.println("u2B = " + t72.getU2B());
//        System.out.println("v2B = " + t72.getV2B());
//        System.out.println("Sigma uB = " + t72.getSigmaU());
//        System.out.println("Sigma vB = " + t72.getSigmaV());
//        System.out.println("UVN = " + t72.getUVNSum());
//        System.out.println("Вибірковий коефіцієнт кореляції: " + t72.getRB());
//        System.out.println("xB = " + t72.getXB());
//        System.out.println("yB = " + t72.getYB());
//        System.out.println("Sigma x = " + t72.getSigmaX());
//        System.out.println("Sigma y = " + t72.getSigmaY());
//        System.out.println("y = " + t72.getK() + "x + " + t72.getB());
    }
}
