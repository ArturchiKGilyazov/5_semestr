import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        double del = scanner.nextDouble();

        MethodDichotomii methodDichotomii = new MethodDichotomii(a, b, c, d, e, del);
    }
}
