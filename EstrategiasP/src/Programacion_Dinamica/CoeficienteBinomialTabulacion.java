package Programacion_Dinamica;

public class CoeficienteBinomialTabulacion {

    public static void main(String[] args) {
        int n = 5;  // Valor de n
        int k = 2;  // Valor de k
        System.out.println("El coeficiente binomial C(" + n + ", " + k + ") es: " + binomialCoeff(n, k));
    }
    // Método para calcular el coeficiente binomial usando tabulación
    public static int binomialCoeff(int n, int k) {
        // Tabla para almacenar los valores de los coeficientes binomiales
        int[][] dp = new int[n + 1][k + 1];

        // Llenar la tabla utilizando el enfoque de abajo hacia arriba
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                // Caso base: C(i, 0) = C(i, i) = 1
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    // Usar la recurrencia: C(n, k) = C(n-1, k-1) + C(n-1, k)
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        // El valor deseado estará en dp[n][k]
        return dp[n][k];
    }
}


