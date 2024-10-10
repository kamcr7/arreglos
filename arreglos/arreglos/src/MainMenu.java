import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Operaciones con vectores");
            System.out.println("2. Operaciones con matrices");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    OperacionesVector operacionesVector = new OperacionesVector();
                    operacionesVector.menuVector();
                    break;
                case 2:
                    OperacionesMatriz operacionesMatriz = new OperacionesMatriz();
                    operacionesMatriz.menuMatriz();
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

    private Scanner scanner = new Scanner(System.in);

    public void menuVector() {
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una operación con vectores:");
            System.out.println("1. Suma de vectores");
            System.out.println("2. Producto escalar");
            System.out.println("3. Vector inverso");
            System.out.println("4. Multiplicación escalar");
            System.out.println("5. Valor máximo y mínimo");
            System.out.println("6. Vector sin duplicados");
            System.out.println("7. Intercambio de vectores");
            System.out.println("8. Números primos");
            System.out.println("9. Pares e impares");
            System.out.println("10. Volver al menú principal");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    sumaVectores();
                    break;
                case 2:
                    productoEscalar();
                    break;
                case 3:
                    vectorInverso();
                    break;
                case 4:
                    multiplicacionEscalar();
                    break;
                case 5:
                    valorMaxMin();
                    break;
                case 6:
                    vectorSinDuplicados();
                    break;
                case 7:
                    intercambioVectores();
                    break;
                case 8:
                    encontrarPrimos();
                    break;
                case 9:
                    encontrarParesImpares();
                    break;
                case 10:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // Métodos para operaciones con vectores

    public void sumaVectores() {
        System.out.println("Ingrese el tamaño de los vectores:");
        int n = scanner.nextInt();
        int[] vector1 = new int[n];
        int[] vector2 = new int[n];
        int[] suma = new int[n];

        System.out.println("Ingrese los elementos del vector 1:");
        for (int i = 0; i < n; i++) {
            vector1[i] = scanner.nextInt();
        }

        System.out.println("Ingrese los elementos del vector 2:");
        for (int i = 0; i < n; i++) {
            vector2[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            suma[i] = vector1[i] + vector2[i];
        }

        System.out.println("Suma de los vectores: " + Arrays.toString(suma));
    }

    public void productoEscalar() {
        System.out.println("Ingrese el tamaño de los vectores:");
        int n = scanner.nextInt();
        int[] vector1 = new int[n];
        int[] vector2 = new int[n];
        int producto = 0;

        System.out.println("Ingrese los elementos del vector 1:");
        for (int i = 0; i < n; i++) {
            vector1[i] = scanner.nextInt();
        }

        System.out.println("Ingrese los elementos del vector 2:");
        for (int i = 0; i < n; i++) {
            vector2[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            producto += vector1[i] * vector2[i];
        }

        System.out.println("Producto escalar de los vectores: " + producto);
    }

    public void vectorInverso() {
        System.out.println("Ingrese el tamaño del vector:");
        int n = scanner.nextInt();
        int[] vector = new int[n];

        System.out.println("Ingrese los elementos del vector:");
        for (int i = 0; i < n; i++) {
            vector[i] = scanner.nextInt();
        }

        int[] inverso = new int[n];
        for (int i = 0; i < n; i++) {
            inverso[i] = vector[n - 1 - i];
        }

        System.out.println("Vector inverso: " + Arrays.toString(inverso));
    }

    public void multiplicacionEscalar() {
        System.out.println("Ingrese el tamaño del vector:");
        int n = scanner.nextInt();
        int[] vector = new int[n];

        System.out.println("Ingrese los elementos del vector:");
        for (int i = 0; i < n; i++) {
            vector[i] = scanner.nextInt();
        }

        System.out.println("Ingrese el escalar:");
        int escalar = scanner.nextInt();

        int[] producto = new int[n];
        for (int i = 0; i < n; i++) {
            producto[i] = vector[i] * escalar;
        }

        System.out.println("Multiplicación escalar del vector: " + Arrays.toString(producto));
    }

    public void valorMaxMin() {
        System.out.println("Ingrese el tamaño del vector:");
        int n = scanner.nextInt();
        int[] vector = new int[n];

        System.out.println("Ingrese los elementos del vector:");
        for (int i = 0; i < n; i++) {
            vector[i] = scanner.nextInt();
        }

        int max = Arrays.stream(vector).max().getAsInt();
        int min = Arrays.stream(vector).min().getAsInt();

        System.out.println("Valor máximo: " + max);
        System.out.println("Valor mínimo: " + min);
    }

    public void vectorSinDuplicados() {
        System.out.println("Ingrese el tamaño del vector:");
        int n = scanner.nextInt();
        int[] vector = new int[n];

        System.out.println("Ingrese los elementos del vector:");
        for (int i = 0; i < n; i++) {
            vector[i] = scanner.nextInt();
        }

        Set<Integer> sinDuplicados = new HashSet<>();
        for (int num : vector) {
            sinDuplicados.add(num);
        }

        System.out.println("Vector sin duplicados: " + sinDuplicados);
    }

    public void intercambioVectores() {
        System.out.println("Ingrese el tamaño de los vectores:");
        int n = scanner.nextInt();
        int[] vector1 = new int[n];
        int[] vector2 = new int[n];

        System.out.println("Ingrese los elementos del vector 1:");
        for (int i = 0; i < n; i++) {
            vector1[i] = scanner.nextInt();
        }

        System.out.println("Ingrese los elementos del vector 2:");
        for (int i = 0; i < n; i++) {
            vector2[i] = scanner.nextInt();
        }

        int[] temp = Arrays.copyOf(vector1, n);
        vector1 = Arrays.copyOf(vector2, n);
        vector2 = Arrays.copyOf(temp, n);

        System.out.println("Vector 1 después del intercambio: " + Arrays.toString(vector1));
        System.out.println("Vector 2 después del intercambio: " + Arrays.toString(vector2));
    }

    public void encontrarPrimos() {
        System.out.println("Ingrese el tamaño del vector:");
        int n = scanner.nextInt();
        int[] vector = new int[n];

        System.out.println("Ingrese los elementos del vector:");
        for (int i = 0; i < n; i++) {
            vector[i] = scanner.nextInt();
        }

        System.out.println("Números primos en el vector:");
        for (int num : vector) {
            if (esPrimo(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    private boolean esPrimo(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void encontrarParesImpares() {
        System.out.println("Ingrese el tamaño del vector:");
        int n = scanner.nextInt();
        int[] vector = new int[n];

        System.out.println("Ingrese los elementos del vector:");
        for (int i = 0; i < n; i++) {
            vector[i] = scanner.nextInt();
        }

        System.out.println("Números pares:");
        for (int num : vector) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }

        System.out.println("\nNúmeros impares:");
        for (int num : vector) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}


class OperacionesMatriz {
    private Scanner scanner = new Scanner(System.in);

    public void menuMatriz() {
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una operación con matrices:");
            System.out.println("1. Matriz identidad");
            System.out.println("2. Suma de matrices");
            System.out.println("3. Resta de matrices");
            System.out.println("4. Multiplicación de matrices");
            System.out.println("5. Matriz transpuesta");
            System.out.println("6. Suma de la diagonal principal");
            System.out.println("7. Suma de la diagonal inversa");
            System.out.println("8. Volver al menú principal");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    matrizIdentidad();
                    break;
                case 2:
                    sumaMatrices();
                    break;
                case 3:
                    restaMatrices();
                    break;
                case 4:
                    multiplicacionMatrices();
                    break;
                case 5:
                    matrizTranspuesta();
                    break;
                case 6:
                    sumaDiagonalPrincipal();
                    break;
                case 7:
                    sumaDiagonalInversa();
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public void matrizIdentidad() {
        System.out.println("Ingrese el tamaño de la matriz identidad (n x n):");
        int n = scanner.nextInt();
        int[][] identidad = new int[n][n];

        for (int i = 0; i < n; i++) {
            identidad[i][i] = 1;
        }

        System.out.println("Matriz identidad:");
        imprimirMatriz(identidad);
    }

    public void sumaMatrices() {
        int[][] matriz1 = ingresarMatriz("Matriz 1");
        int[][] matriz2 = ingresarMatriz("Matriz 2");

        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] suma = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        System.out.println("Suma de las matrices:");
        imprimirMatriz(suma);
    }

    public void restaMatrices() {
        int[][] matriz1 = ingresarMatriz("Matriz 1");
        int[][] matriz2 = ingresarMatriz("Matriz 2");

        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] resta = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resta[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }

        System.out.println("Resta de las matrices:");
        imprimirMatriz(resta);
    }

    public void multiplicacionMatrices() {
        int[][] matriz1 = ingresarMatriz("Matriz 1");
        int[][] matriz2 = ingresarMatriz("Matriz 2");

        int filas1 = matriz1.length;
        int columnas1 = matriz1[0].length;
        int filas2 = matriz2.length;
        int columnas2 = matriz2[0].length;

        if (columnas1 != filas2) {
            System.out.println("Las matrices no se pueden multiplicar. El número de columnas de la primera debe ser igual al número de filas de la segunda.");
            return;
        }

        int[][] producto = new int[filas1][columnas2];

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
                for (int k = 0; k < columnas1; k++) {
                    producto[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        System.out.println("Producto de las matrices:");
        imprimirMatriz(producto);
    }

    public void matrizTranspuesta() {
        int[][] matriz = ingresarMatriz("Matriz");

        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] transpuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }

        System.out.println("Matriz transpuesta:");
        imprimirMatriz(transpuesta);
    }

    public void sumaDiagonalPrincipal() {
        int[][] matriz = ingresarMatriz("Matriz cuadrada");

        if (matriz.length != matriz[0].length) {
            System.out.println("La matriz debe ser cuadrada para calcular la diagonal principal.");
            return;
        }

        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][i];
        }

        System.out.println("Suma de la diagonal principal: " + suma);
    }

    public void sumaDiagonalInversa() {
        int[][] matriz = ingresarMatriz("Matriz cuadrada");

        if (matriz.length != matriz[0].length) {
            System.out.println("La matriz debe ser cuadrada para calcular la diagonal inversa.");
            return;
        }

        int suma = 0;
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            suma += matriz[i][n - 1 - i];
        }

        System.out.println("Suma de la diagonal inversa: " + suma);
    }

    private int[][] ingresarMatriz(String nombre) {
        System.out.println("Ingrese el número de filas de la " + nombre + ":");
        int filas = scanner.nextInt();
        System.out.println("Ingrese el número de columnas de la " + nombre + ":");
        int columnas = scanner.nextInt();

        int[][] matriz = new int[filas][columnas];
        System.out.println("Ingrese los elementos de la " + nombre + ":");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        return matriz;
    }

    private void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }
    }
}
