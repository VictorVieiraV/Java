import java.util.Scanner;

public class Recursividade1{
    public static void main(String[] args) {
        System.out.println("Digite os numeros");                
        Scanner entradaDados = new Scanner(System.in);
        int[] vetor = new int[5];
        

        for (int i = 0; i < vetor.length; i++) {
            vetor[i]= entradaDados.nextInt();
        }
        entradaDados.close();

        System.out.println("Soma dos valores: " + SomaValores(vetor, 0, 0));
        System.out.println("Método passou no teste: "+ TestarSomaValores(vetor));
    }

    public static int SomaValores(int[] vetor, int posicaoVetor, int soma) {
        if (posicaoVetor == vetor.length) {
            return soma;       
        }
        soma += vetor[posicaoVetor];
      return SomaValores(vetor, posicaoVetor + 1, soma);
    }

    public static String TestarSomaValores(int[] vetor){
        int resultado = 0;
        for (int i : vetor) {
            resultado +=  vetor[i];
        }
        if (resultado == SomaValores(vetor, 0, 0)) {
            return "Sim";
        }
        return "Não";
    }
}

