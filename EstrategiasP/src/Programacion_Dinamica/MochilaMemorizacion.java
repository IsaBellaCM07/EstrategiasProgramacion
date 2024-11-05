package Programacion_Dinamica;

import java.util.HashMap;

public class MochilaMemorizacion {
    // Método recursivo con memorización
    public static int knapsack(int[] weights, int[] values, int capacity, int n, HashMap<String, Integer> memo) {
        // Caso base: si no hay capacidad o no hay artículos
        if (capacity == 0 || n == 0) {
            return 0;
        }

        // Clave para almacenar el resultado en el mapa de memorización
        String key = n + "|" + capacity;

        // Verificar si ya se ha calculado el resultado para este subproblema
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Si el peso del artículo actual es mayor que la capacidad, no se puede incluir
        if (weights[n - 1] > capacity) {
            memo.put(key, knapsack(weights, values, capacity, n - 1, memo));
        } else {
            // Tomar el máximo entre no incluir el artículo y incluirlo
            int include = values[n - 1] + knapsack(weights, values, capacity - weights[n - 1], n - 1, memo);
            int exclude = knapsack(weights, values, capacity, n - 1, memo);
            memo.put(key, Math.max(include, exclude));
        }

        return memo.get(key);
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5}; // Pesos de los artículos
        int[] values = {3, 4, 5, 6};  // Valores de los artículos
        int capacity = 5;             // Capacidad máxima de la mochila
        int n = weights.length;       // Número de artículos

        // Crear un mapa para memorización
        HashMap<String, Integer> memo = new HashMap<>();
        int maxValue = knapsack(weights, values, capacity, n, memo);
        System.out.println("El valor máximo que se puede obtener es: " + maxValue);
    }
}
