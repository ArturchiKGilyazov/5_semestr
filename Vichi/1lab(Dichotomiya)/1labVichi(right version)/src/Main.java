import java.util.Scanner;

import static java.lang.Math.*;

public class Main {

    static double func(double x, double a, double b, double c){
        return x * x * x + a * x * x + b * x + c;
    }

    static double search(double right_part, double left_part, double a, double b, double c, double epsilon) {
        double answer = (right_part + left_part) / 2;
        double k = func(right_part, a, b, c) - func(left_part, a, b, c) > 0 ? 1 : -1;
        while (abs(left_part - right_part) >= epsilon) {
            if (func(answer, a, b, c) * k < 0) left_part = answer;
            else right_part = answer;
            answer = (right_part + left_part) / 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        double o, b, c, a, e, del, D;

        Scanner scanner = new Scanner(System.in);

        o = scanner.nextDouble();
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        e = scanner.nextDouble();

        a = a/o;
        b = b/o;
        c = c/o;

        D = 4 * (a*a - 3 * b);

        if (D > e * e) {
            double alpha = (2 * (-a) - sqrt(D)) / 6;
            double beta = (2 * (-a) + sqrt(D)) / 6;
            double x1 = func(alpha, a, b, c);
            double x2 = func(beta, a, b, c);

            if (x1 > e && x2 > e) {
                del = alpha;
                while (func(del, a, b, c) > 0) {
                    del--;
                }
                System.out.println(search(alpha, del, a, b, c, e));
            }

            if (x1 < -e && x2 < -e) {
                del = beta;
                while (func(del, a, b, c) < 0) {
                    del++;
                }
                System.out.println(search(del, beta, a, b, c, e));
            }

            if (x1 > e && abs(x2) < e) {
                System.out.println(beta);
                del = alpha;
                while (func(del, a, b, c) > 0) {
                    del--;
                }
                System.out.println(search(alpha, del, a, b, c, e));
            }

            if (abs(x1) < e && x2 < -e) {
                System.out.println(alpha);
                del = beta;
                while (func(del, a, b, c) < 0) {
                    del++;
                }
                System.out.println(search(del, beta, a, b, c, e));
            }

            if (x1 > e && x2 < -e) {
                del = alpha;
                while (func(del, a, b, c) > 0) {
                    del--;
                }
                System.out.println(search(alpha, del, a, b, c, e));
                System.out.println(search(beta, alpha, a, b, c, e));
                del = beta;
                while (func(del, a, b, c) < 0) {
                    del++;
                }
                System.out.println(search(del, beta, a, b, c, e));
            }

            if (abs(x1) < e && abs(x2) < e) {
                System.out.println((alpha + beta)/2);
            }

        } else if(D < e * e) {

            if (abs(func(0, a, b, c)) < e) {
                System.out.println(0);
            }

            if (func(0, a, b, c) < -e) {
                del = 0;
                while (func(del, a, b, c) < e) {
                    del++;
                }
                System.out.println(search(del, 0.0, a, b, c, e));
            }

            if (func(0, a, b, c) > e) {
                del = 0;
                while (func(del, a, b, c) > 0) {
                    del--;
                }
                System.out.println(search(0.0, del, a, b, c, e));
            }
        }
    }
}
