import java.util.Arrays;
import java.util.Random;

public class CenarioDois {
    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            vetor10000();
            vetor50000();
            vetor250000();
            vetor1250000();
        }
    }

    public static void vetor10000() {
        Random rd = new Random(); 
        int numeroAleatorio = 0;
        //#region10000
        int[] vetorOrdenado10000 = new int[10000];// 10000
        int[] vetorNaoOrdenado10000 = new int[10000];
        for (int i = 0; i < vetorOrdenado10000.length; i++) {
            vetorOrdenado10000[i] = rd.nextInt(10000 + 0);
            vetorNaoOrdenado10000[i] = rd.nextInt(10000 + 0);
        }
        numeroAleatorio = rd.nextInt(10000 + 0);
        Arrays.sort(vetorOrdenado10000);
        System.out.println("\nTE vet[10000]   ordenado: " + CalcularNumeroRepeticoesVetorOrdenado(vetorOrdenado10000, numeroAleatorio) + " milisegundos / " +
        "não ordenado: " + CalcularNumeroRepeticoesVetorNaoOrdenado(vetorNaoOrdenado10000, numeroAleatorio)  + " milisegundos");
        //#endregion
    }

    public static void vetor50000() {
        Random rd = new Random(); 
        int numeroAleatorio = 0;
        //#region50000
        int[] vetorOrdenado50000 = new int[50000];// 50000
        int[] vetorNaoOrdenado50000 = new int[50000];
        for (int i = 0; i < vetorOrdenado50000.length; i++) {
            vetorOrdenado50000[i] = rd.nextInt(50000 + 0);
            vetorNaoOrdenado50000[i] = rd.nextInt(50000 + 0);
        }
        numeroAleatorio = rd.nextInt(50000 + 0);
        Arrays.sort(vetorOrdenado50000);
        System.out.println("TE vet[50000]   ordenado: " + CalcularNumeroRepeticoesVetorOrdenado(vetorOrdenado50000, numeroAleatorio) + " milisegundos / " +
        "não ordenado: " + CalcularNumeroRepeticoesVetorNaoOrdenado(vetorNaoOrdenado50000, numeroAleatorio)  + " milisegundos");
        //#endregion
    }

    public static void vetor250000() {
        Random rd = new Random(); 
        int numeroAleatorio = 0;
        //#region250000
        int[] vetorOrdenado250000 = new int[250000];// 250000
        int[] vetorNaoOrdenado250000 = new int[250000];
        for (int i = 0; i < vetorOrdenado250000.length; i++) {
            vetorOrdenado250000[i] = rd.nextInt(250000 + 0);
            vetorNaoOrdenado250000[i] = rd.nextInt(250000 + 0);
        }
        numeroAleatorio = rd.nextInt(250000 + 0);
        Arrays.sort(vetorOrdenado250000);
        System.out.println("TE vet[250000]  ordenado: " + CalcularNumeroRepeticoesVetorOrdenado(vetorOrdenado250000, numeroAleatorio) + " milisegundos / " 
        + "não ordenado: " + CalcularNumeroRepeticoesVetorNaoOrdenado(vetorNaoOrdenado250000, numeroAleatorio)  + " milisegundos");
        //#endregion
    }
    
    public static void vetor1250000() {
        Random rd = new Random(); 
        int numeroAleatorio = 0;
        //#region1250000
        int[] vetorOrdenado1250000 = new int[1250000];// 1250000
        int[] vetorNaoOrdenado1250000 = new int[1250000];
        for (int i = 0; i < vetorOrdenado1250000.length; i++) {
           vetorOrdenado1250000[i] = rd.nextInt(1250000 + 0);
           vetorNaoOrdenado1250000[i] = rd.nextInt(1250000 + 0);
        }
        numeroAleatorio = rd.nextInt(1250000 + 0);
        Arrays.sort(vetorOrdenado1250000);
        System.out.println("TE vet[1250000] ordenado: " + CalcularNumeroRepeticoesVetorOrdenado(vetorOrdenado1250000, numeroAleatorio) + " milisegundos / "+
         "não ordenado: " + CalcularNumeroRepeticoesVetorNaoOrdenado(vetorNaoOrdenado1250000, numeroAleatorio)  + " milisegundos\n");
        //#endregion
    }
    // A
    public static long CalcularNumeroRepeticoesVetorOrdenado(int[] vetor, int numero) {
        long millis_startTime = System.nanoTime();
        int contador = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) {
                contador++;
            }
        }
        long millis_endTime = System.nanoTime();
        return millis_endTime - millis_startTime;
    }
    // B
    public static long CalcularNumeroRepeticoesVetorNaoOrdenado(int[] vetor, int numero) {
        long millis_startTime = System.nanoTime();
        int contador = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) {
                contador++;
            }
        }
        long millis_endTime = System.nanoTime();
        return millis_endTime - millis_startTime;
    }
  }