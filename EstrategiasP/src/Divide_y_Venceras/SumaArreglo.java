package Divide_y_Venceras;


public class SumaArreglo {

    public static int sumarElementosArr(int[] arr, int inf, int sup) {
        // Caso base: si solo hay un elemento
        if (inf == sup) {
            return arr[inf];
        }

        // Calcular el punto medio
        int mid = (inf + sup) / 2;

        // Dividir y sumar las dos mitades recursivamente
        int sumaIzquierda = sumarElementosArr(arr, inf, mid);
        int sumaDerecha = sumarElementosArr(arr, mid + 1, sup);

        // Retornar la suma de las dos mitades
        return sumaIzquierda + sumaDerecha;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 4, 1, 7};
        int resultado = sumarElementosArr(arr, 0, arr.length - 1);
        System.out.println("La suma de los elementos es: " + resultado);
    }

}
