import java.util.Scanner;

public class Main {

    static double N_appr_error_exp(double[] y, int N, double h){
        double sum = 0;
        for (int k = 0; k < N; k++){
            sum += Math.abs(Math.exp(k * h) - y[k]) * h;
        }
        return sum;
    }

    static double N2_appr_error_exp(double[] y, int N2, double h2){
        double sum = 0;
        for (int k = 0; k<(N2-10); k++){
            System.out.println(N2 + ">" + 2 * k + " " + y.length);
            sum += Math.abs(Math.exp(2 * k * h2) - y[2 * k]) * h2;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        int N = scanner.nextInt();
        int N2 = N*2;
        double h = (b-a)/N;
        double h2 = (b-a)/N2;

        double[] y = new double[N + 1];
        double[] y2 = new double[N2 + 1];
        double[] g1 = new double[N + 1];
        double[] g1_2 = new double[N2 + 1];
        double[] g2 = new double[N + 1];
        double[] g2_2 = new double[N2 + 1];

        for (int i = 0; i < N + 1; i++){
            g1[i] = Math.exp(i * h);
            g2[i] = Math.sin(i * h);
        }

        for (int i = 0; i < N2 + 1; i++){
            g1_2[i] = Math.exp(i * h2);
            g2_2[i] = Math.sin(i * h2);
        }

        //System.out.println(y.length);
        System.out.println("1 poryadok");
        y[0] = 1;
        for (int i = 0; i < N; i++){
            //System.out.println(i);
            y[i + 1] = y[i] + h * g1[i];
        }

        double approx_error = N_appr_error_exp(y, N, h);
        System.out.println("N = " + N + "  appr1_error = " + approx_error);

        y2[0] = 1;
        for (int i = 0; i < N2 ; i++){
            y2[i + 1] = y2[i] + h2 * g1_2[i];
        }

        approx_error = N2_appr_error_exp(y2, N2, h2);
        System.out.println("N2 = " + N2 + "  appr1_error = " + approx_error);


        System.out.println("2 poryadok");
        //Второй порядок
        y[1] = y[0] + h * g1[1];
        for(int i = 2; i < N; i++){
            y[i] = y[i - 2]  + h * (g1[i - 2] + g1[i]);
        }
        approx_error = N_appr_error_exp(y, N, h);
        System.out.println("N = " + N + "  appr2_error = " + approx_error);


        y2[1] = y2[0] + h2 * g1_2[1];
        for (int i = 2; i < N2; i++){
            y2[i] = y2[i-2] + h2 * (g1_2[i-2] + g1_2[i]);
        }
        approx_error = N2_appr_error_exp(y2, N, h2);
        System.out.println(" N = " + N2 + "appr2_error = " + approx_error);

        System.out.println("4 poryadok");
        y[1] = (g1[0] + g1[1] + Math.exp(h)) * h / 3 + y[0];
        for (int j = 2; j < N; j++) {
            y[j] = y[j - 2] + h * (g1[j - 2] + 4 * g1[j - 1] + g1[j]) / 3;
        }
        approx_error = N_appr_error_exp(y, N, h);
        System.out.println("N = " + N + "appr4_error = " + approx_error);

        y2[1] = (g1_2[0] + g1_2[1] + Math.exp(h2)) * h2 / 3 + y2[0];
        for (int j = 2; j < N2; j++) {
            y2[j] = y2[j - 2] + h2 * (g1_2[j - 2] + 4 * g1_2[j - 1] + g1_2[j]) / 3;
        }
        approx_error = N2_appr_error_exp(y, N2, h2);
        System.out.println("N = " + N2 + "appr4_error = " + approx_error);



    }
}
