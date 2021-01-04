import java.util.Scanner;
import static java.lang.Math.*;

public class Main {
    static double h, l, e;


    static double func(double x){
        return l * sin(x) / h;
    }


    static double find(double del){
        double start = del;
        double x = func(del);

        while (abs(x - start) > e){
            start = x;
            x = func(start);
            //System.out.println(x);
        }
        return x;
    };

    public static void main(String[] args) {
        double del =  (Math.PI / 4);
        Scanner scanner = new Scanner(System.in);
        h = scanner.nextDouble();
        l = scanner.nextDouble();
        e = scanner.nextDouble();

        System.out.println("0");

        if (h >= l){
            System.out.println("Only 1 koren'");
        } else {
            double x1 = find(del);
            double x2 = find(-del);

            System.out.println(x1);
            System.out.println(x2);
        }
    }
}
