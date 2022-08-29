import java.util.Scanner;

public class PesquisaSequencial1 {
    public static void main(String[] args) {
        System.out.println("Digite o numero que deseja buscar de 1 a 10: ");                
        Scanner entradaDados = new Scanner(System.in);
        int[] vetor = { 1, 5, 8, 9, 6, 7, 3, 4, 2, 10 };
        int numero = entradaDados.nextInt();
        entradaDados.close();

        System.out.println("Posição do vetor na Pesquisa Sequencial Iterativa: " + 
        PesquisaSequencialIterativa(vetor, numero));
        System.out.println("Posição do vetor na Pesquisa Sequencial Recursiva: " + 
        PesquisaSequencialRecursiva(vetor, numero, 0));
    }

    public static int PesquisaSequencialIterativa(int[] vetor, int numero){
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] == numero){
                return i;
            }
        }
        return -1;
    }

    public static int PesquisaSequencialRecursiva(int[] vetor, int numero, int posicaoVetor){
        if (vetor[posicaoVetor] == numero) {
            return posicaoVetor;
        }else if(posicaoVetor == vetor.length -1){
            return -1;
        }
        else{
            return PesquisaSequencialRecursiva(vetor, numero, posicaoVetor +1);
        }
    } 
}
