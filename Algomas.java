
/*@author Juan Pablo Sanchez Rubio
  @07/12/2023
*/
import java.io.*;
import java.util.*;

public class Algomas {
    private int opc = 0;
    private int opcMatrices = 0;
    private int nfilasArchivo = 0;
    private int nColumnasArchivo = 0;

    private int nFilasUsuario = 0;
    private int nColumnasUsuario = 0;

    private int nFilasCero = 0;
    private int nColumnasCero = 0;

    private int nFilasTransp = 0;
    private int nColumnasTransp = 0;

    private int nFilasMat1 = 0;
    private int nColumnasMat1 = 0;

    private int nFilasMat2 = 0;
    private int nColumnasMat2 = 0;

    private int opcEstadistica = 0;
    private float nElementosMedia = 0F;

    private int nFilasMediana = 0;
    private int nColsMediana = 0;

    private String elementosModa;

    private int nDatos = 0;

    public void menu() {
        do {
            System.out.println();
            System.out.println();
            System.out.println("***************************");
            System.out.println("** 1. Matrices    *********");
            System.out.println("** 2. Estadistica *********");
            System.out.println("** 3. Salir       *********");
            System.out.print("Su opcion : ");
            // System.out.print("\033[H\033[2J");
            // System.out.flush();

            opc = Leer.datoInt();
            switch (opc) {
                case 1:
                    mostrarMenuMatrices();
                    break;
                case 2:
                    mostrarMenuEstadistica();
                    break;

                default:
                    System.out.println("HAS SALIDO DEL PROGRAMA, ADIOS!");
                    break;

            }

        } while (opc != 3);

    }

    public void mostrarMenuMatrices() {
        do {
            System.out.println();
            System.out.println();
            System.out.println("*********************************");
            System.out.println("** 1. Matrices en archivo txt****");
            System.out.println("** 2. Matrices por el usuario****");
            System.out.println("** 3. Matrices en cero **********");
            System.out.println("** 4. Matrices transpuestas *****");
            System.out.println("** 5. Operaciones con matrices **");
            System.out.println("** 6. Volver menu principal *****");
            System.out.print("Su opcion : ");
            // System.out.print("\033[H\033[2J");
            // System.out.flush();

            opcMatrices = Leer.datoInt();
            switch (opcMatrices) {
                case 1:
                    generarMatricesEnArchivo();
                    break;
                case 2:
                    generarMatricesPorUsuario();
                    break;
                case 3:
                    generarMatrizCero();
                    break;
                case 4:
                    generarMatricesTranspuestas();
                    break;
                case 5:
                    generarOperacionesMatrices();
                    break;
                default:
                    System.out.println("VOLVERA AL INICIO");
                    break;

            }
        } while (opcMatrices != 6);
    }

    public void mostrarMenuEstadistica() {

        do {
            System.out.println("**********************************");
            System.out.println("*** 1. Media             *********");
            System.out.println("*** 2. Mediana           *********");
            System.out.println("*** 3. Moda              *********");
            System.out.println("*** 4. Cuartiles, etc    *********");
            System.out.println("*** 5. Volver menu principal *****");
            System.out.print("Su opcion: ");
            // System.out.print("\033[H\033[2J");
            // System.out.flush();
            opcEstadistica = Leer.datoInt();
            switch (opcEstadistica) {
                case 1:
                    calcularMedia();
                    break;
                case 2:
                    calcularMediana();
                    break;
                case 3:
                    calcularModa();
                    break;
                case 4:
                    calcularCuartilesEtc();
                    break;
                default:
                    System.out.println("VOLVERA AL INICIO");
                    break;
            }
        } while (opcEstadistica != 5);
    }

    public void generarMatricesEnArchivo() {
        do {
            System.out.print("Introduzca el numero de filas para la matriz : ");
            nfilasArchivo = Leer.datoInt();
        } while (nfilasArchivo < 1);

        do {
            System.out.print("Introduzca el numero de columnas para la matriz : ");
            nColumnasArchivo = Leer.datoInt();
        } while (nColumnasArchivo < 1);

        int matArchivo[][] = new int[nfilasArchivo][nColumnasArchivo]; // declaramos la matriz bidimensional o
                                                                       // multidimensional

        for (int i = 0; i < nfilasArchivo; i++) {
            for (int j = 0; j < nColumnasArchivo; j++) {
                System.out.print(" Ingresa los valores para la posicion  matArchivo> [" + i + "] [" + j + " ]  : ");
                matArchivo[i][j] = Leer.datoInt();
            }
        }

        // pedir al usuario el nombre que desea guardar
        System.out.println(
                "Ingrese el nombre del archivo de salida, o sea, con que nombre deseas guardar el archivo de salida (Por ejemplo> matriz.txt) :");
        String nombreArchivo = Leer.dato();

        guardarArchivo(nombreArchivo, matArchivo);

        System.out.println(" Matriz guardada en : " + nombreArchivo);

    }

    public void guardarArchivo(String nombreArchivo, int[][] matArchivo) { // metodo que se encarga de guardar la matriz
                                                                           // generada dentro del archivo txt
        try (FileWriter archivo = new FileWriter(nombreArchivo); PrintWriter escritor = new PrintWriter(archivo)) {
            escritor.println("Matriz : ");

            for (int i = 0; i < matArchivo.length; i++) {
                for (int j = 0; j < matArchivo[i].length; j++) {
                    escritor.print(matArchivo[i][j] + "\t");
                }
                escritor.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generarMatricesPorUsuario() {
        do {
            System.out.print("Ingresa el numero de filas para matriz : ");
            nFilasUsuario = Leer.datoInt();
        } while (nFilasUsuario < 1);

        do {
            System.out.print("Ingresa el numero de columnas para matriz : ");
            nColumnasUsuario = Leer.datoInt();
        } while (nColumnasUsuario < 1);

        // recorrer la matriz
        int[][] m = new int[nFilasUsuario][nColumnasUsuario]; // crear la matriz m

        // recorrer la matriz
        System.out.println("Introduce los valores de la matriz : ");
        for (int i = 0; i < nFilasUsuario; i++) {
            for (int j = 0; j < nColumnasUsuario; j++) {
                System.out.print(" Ingresa los valores para la posicion m > [ " + i + " ] [" + j + " ] :  ");
                m[i][j] = Leer.datoInt();
            }
        }

        // Imprimir las matrices
        System.out.println();
        System.out.println("Matriz generada : ");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");

            }
            System.out.println();
        }
    }

    public void generarMatrizCero() {
        do {
            System.out.print("Ingresa el numero de filas para matriz : ");
            nFilasCero = Leer.datoInt();
        } while (nFilasCero < 1);

        do {
            System.out.print("Ingresa el numero de columnas para matriz : ");
            nColumnasCero = Leer.datoInt();
        } while (nColumnasCero < 1);

        int[][] matCeros = new int[nFilasCero][nColumnasCero]; // matriz matCeros

        // genera la matriz de ceros
        for (int i = 0; i < nFilasCero; i++) {
            for (int j = 0; j < nColumnasCero; j++) {
                matCeros[i][j] = 0;
            }
        }

        // imprime la matriz de ceros
        System.out.println("Matriz de ceros: ");

        for (int i = 0; i < nFilasCero; i++) {
            for (int j = 0; j < nColumnasCero; j++) {
                System.out.print(matCeros[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void generarMatricesTranspuestas() {
        do {
            System.out.print("Ingresa el numero de filas para matriz : ");
            nFilasTransp = Leer.datoInt();
        } while (nFilasTransp < 1);

        do {
            System.out.print("Ingresa el numero de columnas  para matriz : ");
            nColumnasTransp = Leer.datoInt();
        } while (nColumnasTransp < 1);

        int matTransp[][] = new int[nFilasTransp][nColumnasTransp];

        for (int i = 0; i < nFilasTransp; i++) {
            for (int j = 0; j < nColumnasTransp; j++) {
                System.out.print(" Ingresa los valores para la posicion matTransp > [ " + i + " ] [" + j + " ] :  ");
                matTransp[i][j] = Leer.datoInt();
            }
        }

        // imprimir la matriz original o sea, no transpuesta
        System.out.println("Matriz original : ");
        for (int i = 0; i < matTransp.length; i++) {
            for (int j = 0; j < matTransp[0].length; j++) {
                System.out.print(matTransp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // transponer la matriz
        int aux; // <-- variable auxiliar
        System.out.println("Matriz transpuesta : ");
        for (int i = 0; i < nFilasTransp; i++) {
            for (int j = 0; j < nColumnasTransp; j++) {
                aux = matTransp[i][j];
                matTransp[i][j] = matTransp[j][i];
                matTransp[j][i] = aux;
            }
        }

        // imprimiendo la matriz transpuesta
        for (int i = 0; i < nFilasTransp; i++) {
            for (int j = 0; j < nColumnasTransp; j++) {
                System.out.print(matTransp[j][i] + " ");
            }
            System.out.println(" ");
        }

    }

    public void generarOperacionesMatrices() {

        System.out.println("Matriz 1: ");
        do {
            System.out.print("Ingresa el numero de filas para matriz 1 : ");
            nFilasMat1 = Leer.datoInt();
        } while (nFilasMat1 < 1);

        do {
            System.out.print("Ingresa el numero de columnas  para matriz 1 : ");
            nColumnasMat1 = Leer.datoInt();
        } while (nColumnasMat1 < 1);

        int matUno[][] = new int[nFilasMat1][nColumnasMat1];

        for (int i = 0; i < nFilasMat1; i++) {
            for (int j = 0; j < nColumnasMat1; j++) {
                System.out.print(" Ingresa los valores para la posicion matUno > [ " + i + " ] [" + j + " ] :  ");
                matUno[i][j] = Leer.datoInt();
            }
        }
        System.out.println();
        System.out.println("Matriz 2 ");
        do {
            System.out.print("Ingresa el numero de filas para la matriz 2: ");
            nFilasMat2 = Leer.datoInt();
        } while (nFilasMat2 < 1);

        do {
            System.out.print("Ingresa el numero de columnas para la matriz 2: ");
            nColumnasMat2 = Leer.datoInt();
        } while (nColumnasMat2 < 1);

        int matDos[][] = new int[nFilasMat2][nColumnasMat2];

        for (int i = 0; i < nFilasMat2; i++) {
            for (int y = 0; y < nColumnasMat2; y++) {
                System.out.print(" Ingresa los valores para la posicion matDos > [ " + i + " ] [" + y + " ] :  ");
                matDos[i][y] = Leer.datoInt();
            }
        }

        System.out.println();

        // visualizar la matriz Uno
        System.out.println("Matriz1");
        System.out.println();
        for (int i = 0; i < matUno.length; i++) {
            for (int j = 0; j < matUno[i].length; j++) {
                System.out.print(matUno[i][j] + " ");
            }
            System.out.println();
        }

        // visualizar la matriz dos
        System.out.println("Matriz2");
        System.out.println();
        for (int i = 0; i < matDos.length; i++) {
            for (int j = 0; j < matDos[i].length; j++) {
                System.out.print(matDos[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("REALIZANDO LAS OPERACIONES ARITMETICAS TRADICIONALES : ");
        System.out.println("Suma de las dos matrices: ");
        System.out.println("--------------------------");

        int resultado[][] = new int[nFilasMat1][nColumnasMat2];

        for (int i = 0; i < nFilasMat1; i++) {
            for (int j = 0; j < nColumnasMat2; j++) {
                resultado[i][j] = matUno[i][j] + matDos[i][j];
            }
        }

        // visualizar el resultado de las matrices
        for (int i = 0; i < nFilasMat1; i++) {
            for (int j = 0; j < nColumnasMat2; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Resta  de las dos matrices: ");
        System.out.println("--------------------------");

        for (int i = 0; i < nFilasMat1; i++) {
            for (int j = 0; j < nColumnasMat2; j++) {
                resultado[i][j] = matUno[i][j] - matDos[i][j];
            }
        }

        // visualizar el resultado de las matrices
        for (int i = 0; i < nFilasMat1; i++) {
            for (int j = 0; j < nColumnasMat2; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Multiplicacion  de las dos matrices: ");
        System.out.println("--------------------------");

        for (int i = 0; i < nFilasMat1; i++) {
            for (int j = 0; j < nColumnasMat2; j++) {
                resultado[i][j] = matUno[i][j] * matDos[i][j];
            }
        }

        // visualizar el resultado de las matrices
        for (int i = 0; i < nFilasMat1; i++) {
            for (int j = 0; j < nColumnasMat2; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Division  de las dos matrices: ");
        System.out.println("--------------------------");

        for (int i = 0; i < nFilasMat1; i++) {
            for (int j = 0; j < nColumnasMat2; j++) {
                resultado[i][j] = matUno[i][j] / matDos[i][j];
            }
        }

        // visualizar el resultado de las matrices
        for (int i = 0; i < nFilasMat1; i++) {
            for (int j = 0; j < nColumnasMat2; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }

    }
    // Metodos de la seccion de estadistica

    public void calcularMedia() {

        ArrayList<Float> nvalores = new ArrayList<Float>();
        int i = 0;
        System.out.println("Introducir valores. Finalizar con -1");
        System.out.printf("Valor numero %3d, valor medio : ", ++i);
        float valor = Leer.datoFloat();
        while (valor != -1) {
            nvalores.add(valor); // anadir un elemento
            System.out.printf("Valor numero %3d, valor medio : ", ++i);
            valor = Leer.datoFloat();

        }

        // realiza la suma y obtencion de la media
        int nValores = nvalores.size();
        float suma = 0; // suma total de los elementos introducidos por el usuario

        for (i = 0; i < nValores; i++) {
            suma += nvalores.get(i);
        }
        // imprimir los valores
        System.out.printf("Media obtenida por los valores introducidos : %5.2f\n", suma / nValores);
    }

    public void calcularMediana() {
        double[][] matriz = ingresarMatriz();
        double mediana = calcularMedianaMatriz(matriz);
        System.out.println();
        System.out.println("La mediana de la matriz es: " + mediana);
    }

    public void calcularModa() {
        System.out.print("Ingrese los valores separados por espacios: ");
        elementosModa = Leer.dato();

        // Dividir la entrada en un array de Strings
        String[] valores = elementosModa.split(" ");
        // Crear un mapa para almacenar la frecuencia de cada valor
        Map<String, Integer> frecuenciaValores = new HashMap<>();

        // Contar la frecuencia de cada valor
        for (String valor : valores) {
            // Verificar si el valor ya esta en el mapa
            if (frecuenciaValores.containsKey(valor)) {
                // Incrementar la frecuencia si ya existe
                frecuenciaValores.put(valor, frecuenciaValores.get(valor) + 1);
            } else {
                // Agregar el valor al mapa con una frecuencia inicial de 1
                frecuenciaValores.put(valor, 1);
            }
        }

        // Encontrar el valor con la mayor frecuencia (moda)
        String moda = null;
        int frecuenciaMaxima = 0;
        for (Map.Entry<String, Integer> entry : frecuenciaValores.entrySet()) {
            if (entry.getValue() > frecuenciaMaxima) {
                moda = entry.getKey();
                frecuenciaMaxima = entry.getValue();
            }

            // Mostrar la moda
            System.out.println("La moda es: " + moda + " con una frecuencia de :  " + frecuenciaMaxima);
        }
    }

    public void calcularCuartilesEtc() {

        do {
            System.out.print("Ingresa la cantidad de datos :");
            nDatos = Leer.datoInt();
        } while (nDatos < 1);

        // matriz unidimensional para manejar los datos
        double[] datos = new double[nDatos];

        System.out.println("Ingresa los datos uno por uno :");
        for (int i = 0; i < nDatos; i++) {
            System.out.print("Dato : " + (i + 1) + " : ");
            datos[i] = Leer.datoDouble();
        }

        // ordenas el Array
        Arrays.sort(datos);

        // calcular los cuartiles, percentiles y deciles

        double primerCuartil = calcularCuartil(datos, 0.25);
        double segundoCuartil = calcularCuartil(datos, 0.5);
        double tercerCuartil = calcularCuartil(datos, 0.75);

        double primerPercentil = calcularPercentil(datos, 0.10);
        double novenoPercentil = calcularPercentil(datos, 0.90);

        double primerDecil = calcularPercentil(datos, 0.10);
        double novenoDecil = calcularPercentil(datos, 0.90);

        // Imprimir resultados
        System.out.println("Primer cuartil: " + primerCuartil);
        System.out.println("Segundo cuartil (Mediana): " + segundoCuartil);
        System.out.println("Tercer cuartil: " + tercerCuartil);
        System.out.println("Primer percentil: " + primerPercentil);
        System.out.println("Noveno percentil: " + novenoPercentil);
        System.out.println("Primer decil: " + primerDecil);
        System.out.println("Noveno decil: " + novenoDecil);
    }

    public static double calcularMedianaMatriz(double[][] matrizMediana) {

        // realizar el calculo de la mediana, se declara una matriz o arreglo
        // unidimensional para aplanar los datos
        double[] aplanadorDatos = new double[matrizMediana.length * matrizMediana[0].length];
        int index = 0;

        for (int i = 0; i < matrizMediana.length; i++) {
            for (int j = 0; j < matrizMediana[0].length; j++) {
                aplanadorDatos[index++] = matrizMediana[i][j];
            }
        }

        // Ordenar la matriz aplanada
        Arrays.sort(aplanadorDatos);

        // Calcular la mediana de la matriz aplanada
        int n = aplanadorDatos.length;
        if (n % 2 == 0) {
            // Si el número de elementos es par, toma el promedio de los dos valores
            // centrales
            double medio1 = aplanadorDatos[(n / 2) - 1];
            double medio2 = aplanadorDatos[n / 2];
            return (medio1 + medio2) / 2;
        } else {
            // Si el número de elementos es impar, toma el valor central
            return aplanadorDatos[n / 2];
        }
    }

    public double[][] ingresarMatriz() {
        do {
            System.out.print("Ingresa el numero de filas : ");
            nFilasMediana = Leer.datoInt();
        } while (nFilasMediana < 1);

        do {
            System.out.print("Ingresa el numero de columnas : ");
            nColsMediana = Leer.datoInt();
        } while (nColsMediana < 1);

        // declaramos la matriz para almacenar los numeros
        double[][] matrizMediana = new double[nFilasMediana][nColsMediana];

        for (int i = 0; i < nFilasMediana; i++) {
            for (int j = 0; j < nColsMediana; j++) {
                System.out
                        .print(" Ingresa los valores para la posicion matrizMediana > [ " + i + " ] [" + j + " ] :  ");
                matrizMediana[i][j] = Leer.datoDouble();
            }
        }

        // realizar el calculo de la mediana, se declara una matriz o arreglo
        // unidimensional para aplanar los datos
        double[] aplanadorDatos = new double[matrizMediana.length * matrizMediana[0].length];
        int index = 0;

        for (int i = 0; i < matrizMediana.length; i++) {
            for (int j = 0; j < matrizMediana[0].length; j++) {
                aplanadorDatos[index++] = matrizMediana[i][j];
            }
        }

        return matrizMediana;
    }

    public static double calcularCuartil(double[] datos, double percentil) {
        int index = (int) Math.ceil(percentil * datos.length);
        return datos[index - 1];
    }

    public static double calcularPercentil(double[] datos, double percentil) {
        int index = (int) Math.ceil(percentil * datos.length);
        return datos[index - 1];
    }

}
