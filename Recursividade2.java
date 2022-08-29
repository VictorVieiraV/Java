import java.util.Scanner;

public class Recursividade2 {
    public static void main(String[] args) {
        System.out.println("Digite os numeros: ");                
        Scanner entradaDados = new Scanner(System.in);
        int[] vetor = new int[5];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i]= entradaDados.nextInt();
        }
        entradaDados.close();
        System.out.println("Maior Valor do Vetor: " + MaiorValor(vetor, 0, 0));
        System.out.println("Método passou no teste: " + TestarMaiorValor(vetor));
    }

    public static int MaiorValor(int []vetor, int posicaoVetor, int numero) {
        if (posicaoVetor == vetor.length) {
            return numero;
        }

        if (numero < vetor[posicaoVetor] ) {
            numero = vetor[posicaoVetor];
        }
        return MaiorValor(vetor, posicaoVetor + 1, numero);
    };

    public static String TestarMaiorValor(int[] vetor){
        int resultado = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > resultado) {
                resultado =  vetor[i];
            } 
        }
        if (resultado == MaiorValor(vetor, 0, 0)) {
            return "Sim";
        }
        return "Não";
    }
}
