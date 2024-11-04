package Algoritmos_Voraces;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

class Objeto{

    int peso;
    int valor;

    public Objeto(int peso, int valor){
        this.peso = peso;
        this.valor = valor;
    }

    public double valorPorPeso(){
        return (double) valor/peso;
    }

}


public class ContenedorMochila {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Ingrese el valor máximo que soporta el contenedor: ");
        int capacidad = scn.nextInt();

        Objeto[] objetos = {
                new Objeto(10, 20),
                new Objeto(20, 30),
                new Objeto(30, 66),
                new Objeto(40, 40),
                new Objeto(50, 60)
        };
        System.out.println("Heurística 1 - Maximizando el valor \n");
        double valorFinalH1 = resolverContainerH1(objetos, capacidad);
        System.out.println("Valor de la carga total con la heurística 1: " + valorFinalH1);

        System.out.println("\n");

        System.out.println("Heurística 2 - Minimizando el peso \n");
        double valorFinalH2 = resolverContainerH2(objetos, capacidad);
        System.out.println("Valor de la carga total con la heurística 2: " + valorFinalH2);

        System.out.println("\n");

        System.out.println("Heurística 3 - Valor/peso es mayor \n");
        double valorFinalH3 = resolverContainerH3(objetos, capacidad);
        System.out.println("Valor de la carga total con la heurística 3: " + valorFinalH3);


    }

    //Maximizando el valor
    private static double resolverContainerH1(Objeto[] objetos, int capacidad) {

        Arrays.sort(objetos, Comparator.comparingInt((Objeto objeto) -> objeto.valor).reversed());

        double valorTotal = 0;
        double pesoActual = 0;

        System.out.println("Objetos seleccionados");
        for(Objeto objeto: objetos){
            if(pesoActual + objeto.peso <= capacidad){
                pesoActual += objeto.peso;
                valorTotal += objeto.valor;
                System.out.println(objeto.peso + "\t" + objeto.valor);
            }else{
                double pesoDisponible = capacidad - pesoActual;
                valorTotal += objeto.valorPorPeso() * pesoDisponible;
                System.out.println(objeto.peso + "\t" + objeto.valor);
                break;
            }

        }
        return valorTotal;
    }

    //Minimizando el peso
    private static double resolverContainerH2(Objeto[] objetos, int capacidad) {

        Arrays.sort(objetos, Comparator.comparingInt((Objeto objeto) -> objeto.peso));

        double valorTotal = 0;
        double pesoActual = 0;

        System.out.println("Objetos seleccionados");
        for(Objeto objeto: objetos){

            if(pesoActual + objeto.peso <= capacidad){
                pesoActual += objeto.peso;
                valorTotal += objeto.valor;
                System.out.println(objeto.peso + "\t" + objeto.valor);
            }else{
                double pesoDisponible = capacidad - pesoActual;
                valorTotal += objeto.valorPorPeso() * pesoDisponible;
                System.out.println(objeto.peso + "\t" + objeto.valor);
                break;
            }

        }
        return valorTotal;
    }

    //Maximizando el valor/peso
    private static double resolverContainerH3(Objeto[] objetos, int capacidad) {

        Arrays.sort(objetos, Comparator.comparingDouble(Objeto::valorPorPeso).reversed());

        double valorTotal = 0;
        double pesoActual = 0;

        System.out.println("Objetos seleccionados");
        for(Objeto objeto: objetos){
            if(pesoActual + objeto.peso <= capacidad){
                pesoActual += objeto.peso;
                valorTotal += objeto.valor;
                System.out.println(objeto.peso + "\t" + objeto.valor);
            }else{
                double pesoDisponible = capacidad - pesoActual;
                valorTotal += objeto.valorPorPeso() * pesoDisponible;
                System.out.println(objeto.peso + "\t" + objeto.valor);
                break;
            }
        }
        return valorTotal;
    }
}
