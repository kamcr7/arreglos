package uttt.edu.mx.arreglos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Generar 30 números aleatorios y realizar operaciones");
            System.out.println("2. Clasificación de puntajes de estudiantes");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    OperacionesVector operaciones = new OperacionesVector();
                    operaciones.mostrarResultados();
                    break;
                case 2:
                    ClasificacionPuntajes puntajes = new ClasificacionPuntajes();
                    puntajes.mostrarClasificacion();
                    break;
                case 3:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }
}

class OperacionesVector {

    private int[] vector;
    private int tamanio = 30;

    public OperacionesVector() {
        vector = new int[tamanio];
        Random random = new Random();
        for (int i = 0; i < tamanio; i++) {
            vector[i] = random.nextInt(30) + 1;  // Números entre 1 y 30
        }
        Arrays.sort(vector);  // Ordenar el vector
    }

    public int obtenerMaximo() {
        return Arrays.stream(vector).max().getAsInt();
    }

    public int obtenerMinimo() {
        return Arrays.stream(vector).min().getAsInt();
    }

    public double calcularMedia() {
        return Arrays.stream(vector).average().orElse(0);
    }

    public int calcularModa() {
        Map<Integer, Integer> frecuencias = new HashMap<>();
        for (int num : vector) {
            frecuencias.put(num, frecuencias.getOrDefault(num, 0) + 1);
        }
        int moda = vector[0];
        int maxFrecuencia = 0;
        for (Map.Entry<Integer, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                moda = entry.getKey();
            }
        }
        return moda;
    }

    public double calcularMediana() {
        if (tamanio % 2 == 0) {
            return (vector[tamanio / 2 - 1] + vector[tamanio / 2]) / 2.0;
        } else {
            return vector[tamanio / 2];
        }
    }

    public void calcularFrecuencias() {
        Map<Integer, Integer> frecuencias = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            frecuencias.put(i, 0);
        }
        for (int num : vector) {
            if (num >= 1 && num <= 10) {
                frecuencias.put(num, frecuencias.get(num) + 1);
            }
        }
        System.out.println("Número | Cantidad | Porcentaje");
        for (int i = 1; i <= 10; i++) {
            int cantidad = frecuencias.get(i);
            double porcentaje = (double) cantidad / tamanio * 100;
            System.out.printf("%6d | %8d | %10.2f%%\n", i, cantidad, porcentaje);
        }
    }

    public void mostrarResultados() {
        System.out.println("Vector generado y ordenado: " + Arrays.toString(vector));
        System.out.println("Número más grande: " + obtenerMaximo());
        System.out.println("Número más pequeño: " + obtenerMinimo());
        System.out.println("Media: " + calcularMedia());
        System.out.println("Moda: " + calcularModa());
        System.out.println("Mediana: " + calcularMediana());
        calcularFrecuencias();
    }
}

class ClasificacionPuntajes {

    private int[] puntajes;
    private int numEstudiantes;

    public ClasificacionPuntajes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de estudiantes:");
        numEstudiantes = scanner.nextInt();
        puntajes = new int[numEstudiantes];
        Random random = new Random();
        for (int i = 0; i < numEstudiantes; i++) {
            puntajes[i] = random.nextInt(21);  // Puntajes entre 0 y 20
        }
    }

    public void mostrarClasificacion() {
        int deficientes = 0, regulares = 0, buenos = 0, excelentes = 0;

        for (int puntaje : puntajes) {
            if (puntaje >= 0 && puntaje <= 5) {
                deficientes++;
            } else if (puntaje >= 6 && puntaje <= 10) {
                regulares++;
            } else if (puntaje >= 11 && puntaje <= 15) {
                buenos++;
            } else if (puntaje >= 16 && puntaje <= 20) {
                excelentes++;
            }
        }

        System.out.println("Puntajes generados: " + Arrays.toString(puntajes));
        System.out.println("0-5 Deficientes: " + deficientes);
        System.out.println("6-10 Regulares: " + regulares);
        System.out.println("11-15 Buenos: " + buenos);
        System.out.println("16-20 Excelentes: " + excelentes);
    }
}

