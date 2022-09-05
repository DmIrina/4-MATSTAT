package lab5;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------7.1------------------");
        Task1 t1 = new Task1(40, 0.01, 8);
        System.out.println("Вибірка:");
        System.out.println(t1.table);
        System.out.println("---------------------------------");
        System.out.println("n = " + t1.n);
        System.out.println("a = " + t1.a);
        System.out.println("alpha = " + t1.alpha);
        System.out.println("Вибіркове середнє: " + t1.findSelectedMean());
        System.out.println("Вибіркова дисперсія: " + t1.findSelectedDisperse());
        System.out.println("Виправлена вибіркова дисперсія: " + t1.findFixedSelectedDisperse());
        System.out.println("Виправлене вибіркове середнє квадратичне відхилення: " + t1.findFixedSelectedMeanSquareDeviation());
        System.out.println("tSP = (xB - a) * sqrt(n) / s = " + t1.getTSP());
        System.out.println("k = " + t1.getK());
        System.out.println("tKR(" + t1.alpha + "; " + t1.getK() + ")");
        System.out.println("------------------7.2------------------");
        Task2 t2 = new Task2(25, 0.1, 0.05);
        System.out.println("Вибірка:");
        System.out.println(t2.table);
        System.out.println("---------------------------------");
        System.out.println("n = " + t2.n);
        System.out.println("sigma2 = " + t2.sigma2);
        System.out.println("alpha = " + t2.alpha);
        System.out.println("Вибіркове середнє: " + t2.findSelectedMean());
        System.out.println("Вибіркова дисперсія: " + t2.findSelectedDisperse());
        System.out.println("Виправлена вибіркова дисперсія: " + t2.findFixedSelectedDisperse());
        System.out.println("Виправлене вибіркове середнє квадратичне відхилення: " + t2.findFixedSelectedMeanSquareDeviation());
        System.out.println("tSP = (n - 1) * s^2 / sigma^2 = " + t2.getX2SP());
        System.out.println("k = " + t2.getK());
        System.out.println("X2KR(" + t2.alpha + "; " + t2.getK() + ")");

    }
}
