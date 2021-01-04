import java.util.Scanner;

public class Main {

    static double a, b;
    static long number_of_segment;

    static double integr(double a, double b){
        double integ = Math.exp(b) - Math.exp(a);

        return integ;
    }


    static double func(double x){
        return (Math.exp(x));
    }

    static double integral(){
        double result = 0;
        double h = (b - a)/number_of_segment;
        double x_l = a, x_r = a + h;

        for(int i = 0; i < number_of_segment; i++){

            //Левая для функции
//            double y_l = func(x_l);
//            result += y_l * h;

            //Правая для функции
//            double y_r = func(x_r);
//            result += y_r * h;

            //Центральная для функции
//            double y_m = func((x_l+x_r)/2);
//            result += y_m * h;

            //Трапеция
//            double y_l = func(x_l);
//            double y_r = func(x_r);
//            result += ((y_l + y_r) * h) / 2;

            //Парабола
            double y_l = func(x_l);
            double y_r = func(x_r);
            double y_m = func((x_l+x_r)/2);
            result += ((y_l + y_r + 4*y_m) * h) / 6;


            x_l = a + (i+1) * h;
            x_r = a + (i+2) * h;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextDouble();
        b = scanner.nextDouble();
        number_of_segment = scanner.nextLong();

        double integral = integral();
        System.out.println(integral);
        double i = integr(a,b);
        System.out.println(i);
        System.out.println("DIFF = " + (integral - i));
    }
}
