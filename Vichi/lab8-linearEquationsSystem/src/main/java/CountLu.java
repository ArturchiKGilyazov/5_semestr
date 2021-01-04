import java.text.DecimalFormat;

public class CountLu {
    float[][] L;
    float[][] U;

    public void initLU(float[][] matrix, int n) {
        L = new float[n][n];
        U = new float[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                U[i][j] = 0;
                L[i][j] = 0;
            }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                U[i][0] = matrix[0][i];
                L[0][i] = matrix[i][0] / U[0][0];
                float sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += L[k][i] * U[j][k];
                }
                U[j][i] = matrix[i][j] - sum;
                if (i > j) {
                    L[i][j] = 0;
                } else {
                    sum = 0;
                    for (int k = 0; k < i; k++) {
                        sum += L[k][j] * U[i][k];
                    }
                    L[i][j] = (matrix[j][i] - sum) / U[i][i];
                }
            }
        }

    }

    public void show(float[][] matrix) {
        final String format = "#0.00";
        System.out.println("\n\n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                String formatted = new DecimalFormat(format).format(matrix[i][j]);
                System.out.print(formatted + " ");
            }
            System.out.println();
        }

    }

    public Float[] countY(int n, float[] b) {
        Float[] y = new Float[n];
        y[0] = b[0] / U[0][0];
        for (int i = 1; i < n; i++) {
            float sum = 0;
            for (int k = 0; k < i; k++)
                sum += U[i][k] * y[k];
            y[i] = (b[i] - sum) / U[i][i];
        }
        return y;
    }

    public Float[] countX(float[][] matrix, float[] b) {
        int n = b.length;
        initLU(matrix, n);
        Float[] y = countY(n, b);
        Float[] x = new Float[n];
        x[n - 1] = y[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            float sum = 0;
            for (int k = i + 1; k < n; k++)
                sum += L[i][k] * x[k];
            x[i] = y[i] - sum;
        }
        return x;
    }
}
