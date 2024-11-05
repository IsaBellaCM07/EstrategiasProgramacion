package Programacion_Dinamica;

import java.util.HashMap;
import java.util.Map;

public class SucesionLucasMemorizacion {

    public static void main(String[] args) {
        int n = 7;  // Se asigna el valor que se desea encontrar en la sucesion
        Map<Integer, Long> memo = new HashMap<>();  // Diccionario para almacenar los resultados
        System.out.println("El término " + n + " de la sucesión de Lucas es: " + lucas(n, memo));
    }
    // Método recursivo con memorización para calcular el término n de la sucesión de Lucas
    public static long lucas(int n, Map<Integer, Long> memo) {
        // Casos base
        if (n == 0) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }

        // Si el valor ya está almacenado en memo, lo devolvemos
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Calculamos el valor recursivamente y lo guardamos en memo
        long result = lucas(n - 1, memo) + lucas(n - 2, memo);
        memo.put(n, result);

        return result;
    }
}