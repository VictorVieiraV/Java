import java.util.Arrays;
import java.util.Scanner;

public class Recursividade3 {
    public static void main(String[] args) {
        System.out.println("Digite o vetor: ");                
        Scanner entradaDados = new Scanner(System.in);
        int[] vetor = new int[7];
        int[] vetorInvertido = new int[7];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i]= entradaDados.nextInt();
        }
        entradaDados.close();
        System.out.println("Vetor invertido: " + Arrays.toString(InverterVetor(vetor, 0, vetorInvertido, vetorInvertido.length - 1)));
        System.out.println("Método passou no teste: " + TestarInverterVetor(vetor, vetorInvertido));
    }

    public static int[] InverterVetor(int[] vetor, int posicaoVetor, int[] vetorInvertido, int posicaoVetorInvertido){
        if (posicaoVetor == vetor.length) {
            return vetorInvertido;
        }
        vetorInvertido[posicaoVetorInvertido] = vetor[posicaoVetor];
        return InverterVetor(vetor, posicaoVetor + 1, vetorInvertido, posicaoVetorInvertido - 1);   
    }

    public static String TestarInverterVetor(int[] vetor, int[] vetorInvertido){
        int posicaoVetorInvertido = vetorInvertido.length - 1;
        for (int i = 0; i < vetor.length; i++) {
            vetorInvertido[posicaoVetorInvertido]  = vetor[i];
            posicaoVetorInvertido--;
        }
        if (vetorInvertido == InverterVetor(vetor, 0, vetorInvertido, vetorInvertido.length - 1)) {
            return "Sim";
        }
        return "Não";
    }
}
