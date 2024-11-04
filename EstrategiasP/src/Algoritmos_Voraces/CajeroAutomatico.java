package Algoritmos_Voraces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definición de billetes y su cantidad disponible
        Map<Integer, Integer> billetes = new HashMap<>();
        billetes.put(100000, 50);
        billetes.put(50000, 100);
        billetes.put(20000, 200);
        billetes.put(10000, 300);

        // Solicitar la cantidad de dinero
        System.out.print("Ingrese la cantidad de dinero que desea retirar (debe ser divisible por 10,000): ");
        int cantidadSolicitada = scanner.nextInt();

        // Llamar al método para entregar billetes
        Map<Integer, Integer> resultado = entregarBilletes(billetes, cantidadSolicitada);

        // Mostrar el resultado
        if (resultado == null) {
            System.out.println("No hay suficientes billetes para entregar la cantidad solicitada.");
        } else {
            System.out.println("Billetes entregados:");
            for (Map.Entry<Integer, Integer> entry : resultado.entrySet()) {
                System.out.println("$" + entry.getKey() + ": " + entry.getValue() + " billetes");
            }
        }

        scanner.close();
    }

    public static Map<Integer, Integer> entregarBilletes(Map<Integer, Integer> billetes, int cantidadSolicitada) {
        // Comprobar si la cantidad solicitada es divisible por 10,000
        if (cantidadSolicitada % 10000 != 0) {
            System.out.println("La cantidad solicitada debe ser divisible por 10,000.");
            return null;
        }

        // Inicialización de la salida
        Map<Integer, Integer> resultado = new HashMap<>();
        for (Integer billete : billetes.keySet()) {
            resultado.put(billete, 0);
        }

        // Suministrar billetes comenzando por la mayor denominación
        for (Integer billete : billetes.keySet()) {
            int cantidadDisponible = billetes.get(billete);
            int cantidadAEntregar = Math.min(cantidadDisponible, cantidadSolicitada / billete);

            if (cantidadAEntregar > 0) {
                resultado.put(billete, cantidadAEntregar);
                cantidadSolicitada -= cantidadAEntregar * billete;
            }
        }

        // Comprobar si se logró cumplir la solicitud
        if (cantidadSolicitada > 0) {
            return null; // No hay suficientes billetes
        }

        return resultado;
    }
}

