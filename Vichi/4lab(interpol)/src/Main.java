import java.util.Scanner;
import java.util.Vector;

//f = x^3 - e^x + 1
public class Main {

    static double function(double x){
        return (x*x*x - Math.exp(x) + 1);
    }

    static double polinom(Vector<Double> x_os, Vector<Double> y_os, double x){
        double result = 0;

        for (int i = 0; i < x_os.size(); ++i){
            double mult = 1;

            for (int j = 0; j < y_os.size(); ++j) {
                if (i != j) {
                    mult *= (x - x_os.get(j)) / (x_os.get(i) - x_os.get(j));
                }
            }
             result += mult*y_os.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double N = scanner.nextDouble();
        double x = scanner.nextDouble();
        double h = (b - a) / (N - 1);

        Vector<Double> x_os = new Vector<>();
        Vector<Double> y_os = new Vector<>();

        for(int i = 0; i < N; ++i){
            x_os.addElement(a + i*h);
            y_os.addElement(function(x_os.get(i)));
//            System.out.println(x_os.get(i) + "  " + y_os.get(i));

        }

        double result = polinom(x_os, y_os, x);
        System.out.println(result);
    }
}
