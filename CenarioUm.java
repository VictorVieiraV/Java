import java.util.Random;

public class CenarioUm {
    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            vetor15000();
            vetor75000();
            vetor300000();
            vetor1500000();
        }
    }
    
    public static void vetor15000() {
        Random rd = new Random(); 
        int[] vetor = new int[15000];//15000 
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rd.nextInt(15000 + 0);
        }
        long millis_startTime = System.nanoTime();
        MenorValorIterativo(vetor);
        long millis_endTime = System.nanoTime();

        long millis_startTime2 = System.nanoTime();
        MenorValorRecursivo(vetor, 0, vetor[0]);
        long millis_endTime2 = System.nanoTime();;

        System.out.println("\nTE vet[15000] MenorValorIterativo: "+(millis_endTime - millis_startTime)+" milisegundos / MenorValorRecursivo: "+(millis_endTime2 - millis_startTime2)+" milisegundos");
    }

    public static void vetor75000() {
        Random rd = new Random(); 
        int[] vetor = new int[75000];//75000 
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rd.nextInt(75000 + 0);
        }
        long millis_startTime = System.nanoTime();
        MenorValorIterativo(vetor);
        long millis_endTime = System.nanoTime();
        
        long millis_startTime2 = System.nanoTime();
        //MenorValorRecursivo(vetor, 0, vetor[0]);
        long millis_endTime2 = System.nanoTime();;
    
        System.out.println("TE vet[75000] MenorValorIterativo: "+(millis_endTime - millis_startTime)+" milisegundos / MenorValorRecursivo: "+(millis_endTime2 - millis_startTime2)+" milisegundos");
    }

    public static void vetor300000() {
        Random rd = new Random(); 
        int[] vetor = new int[300000];//300000 
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rd.nextInt(300000 + 0);
        }
        long millis_startTime = System.nanoTime();
        MenorValorIterativo(vetor);
        long millis_endTime = System.nanoTime();
        
        long millis_startTime2 = System.nanoTime();
        //MenorValorRecursivo(vetor, 0, vetor[0]);
        long millis_endTime2 = System.nanoTime();;
    
        System.out.println("TE vet[300000] MenorValorIterativo: "+(millis_endTime - millis_startTime)+" milisegundos / MenorValorRecursivo: "+(millis_endTime2 - millis_startTime2)+" milisegundos");
    }

    public static void vetor1500000() {
        Random rd = new Random(); 
        int[] vetor = new int[1500000];//1500000 
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rd.nextInt(1500000 + 0);
        }
        long millis_startTime = System.nanoTime();
        MenorValorIterativo(vetor);
        long millis_endTime = System.nanoTime();
        
        long millis_startTime2 = System.nanoTime();
        //MenorValorRecursivo(vetor, 0, vetor[0]);
        long millis_endTime2 = System.nanoTime();;
    
        System.out.println("TE vet[1500000] MenorValorIterativo: "+(millis_endTime - millis_startTime)+" milisegundos / MenorValorRecursivo: "+(millis_endTime2 - millis_startTime2)+" milisegundos\n");
    }
    // A
    public static int MenorValorIterativo(int[] vetor) {
        int minValue = vetor[0];
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] <= minValue) {
                minValue = vetor[i];
            }
        }
        return minValue;
    }
    // B
    public static int MenorValorRecursivo(int[] vetor, int posicaoVetor, int minValue){
        if (posicaoVetor == vetor.length -1) {
            return minValue;
        }
        if (vetor[posicaoVetor] <= minValue) {
            minValue = vetor[posicaoVetor];
        }
        return MenorValorRecursivo(vetor, posicaoVetor + 1, minValue);
    }
  
}