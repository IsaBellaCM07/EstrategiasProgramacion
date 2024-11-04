package Algoritmos_Voraces;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Arista implements Comparable<Arista> {
    int origen;
    int destino;
    int costo;

    public Arista(int origen, int destino, int costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    @Override
    public int compareTo(Arista otra) {
        return Integer.compare(this.costo, otra.costo);
    }
}

class Kruskal {
    private int[] padres;
    private int[] rangos;

    public Kruskal(int n) {
        padres = new int[n];
        rangos = new int[n];
        for (int i = 0; i < n; i++) {
            padres[i] = i; // Cada nodo es su propio padre
            rangos[i] = 0; // Rango inicial
        }
    }

    public int encontrar(int i) {
        if (padres[i] != i) {
            padres[i] = encontrar(padres[i]); // Compresión de caminos
        }
        return padres[i];
    }

    public void unir(int x, int y) {
        int raizX = encontrar(x);
        int raizY = encontrar(y);
        if (raizX != raizY) {
            if (rangos[raizX] > rangos[raizY]) {
                padres[raizY] = raizX;
            } else if (rangos[raizX] < rangos[raizY]) {
                padres[raizX] = raizY;
            } else {
                padres[raizY] = raizX;
                rangos[raizX]++;
            }
        }
    }

    public void kruskal(List<Arista> aristas, int n) {
        Collections.sort(aristas);
        List<Arista> resultado = new ArrayList<>();
        int costoTotal = 0;

        for (Arista arista : aristas) {
            int raizX = encontrar(arista.origen);
            int raizY = encontrar(arista.destino);
            if (raizX != raizY) {
                resultado.add(arista);
                costoTotal += arista.costo;
                unir(raizX, raizY);
            }
        }

        System.out.println("Costo total de instalación: " + costoTotal);
        System.out.println("Conexiones realizadas:");
        for (Arista arista : resultado) {
            System.out.println("Municipio " + arista.origen + " - Municipio " + arista.destino + ": Costo " + arista.costo);
        }
    }
}

public class ArbolRecubrimiento {
    public static void main(String[] args) {
        int n = 4; // Número de municipios
        List<Arista> aristas = new ArrayList<>();

        // Agregar conexiones posibles (origen, destino, costo)
        aristas.add(new Arista(0, 1, 10000));
        aristas.add(new Arista(0, 2, 6000));
        aristas.add(new Arista(0, 3, 5000));
        aristas.add(new Arista(1, 3, 15000));
        aristas.add(new Arista(2, 3, 4000));

        Kruskal kruskal = new Kruskal(n);
        kruskal.kruskal(aristas, n);
    }
}
