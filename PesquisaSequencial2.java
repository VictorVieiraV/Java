import java.util.Scanner;

public class PesquisaSequencial2 {
    public static void main(String[] args) {
        System.out.println("Digite o numero que deseja buscar no vetor: ");                
        Scanner entradaDados = new Scanner(System.in);
        int[] vetor = { 1, 6, 7, 10, 14, 20, 22, 28, 30, 35 };
        int numero = entradaDados.nextInt();
        entradaDados.close();

        System.out.println("Posição do vetor na Pesquisa Binária Iterativa: " + 
        PesquisaBinariaIterativa(vetor, numero));
        
        System.out.println("Posição do vetor na Pesquisa Binária Recursiva: " + 
        PesquisaBinariaRecursiva(vetor, numero, 0, vetor.length - 1));
    }

    public static int PesquisaBinariaIterativa(int[] vetor, int numero){
        int inicio = 0, meio = 0, fim = vetor.length - 1;

        while (inicio <= fim) {
            meio = (inicio + fim)/2;

            if (vetor[meio] == numero) {
                return meio;
            }else if (vetor[meio] > numero){
                fim = meio - 1;
            }else{
                inicio = meio + 1;
            }
        }
        return -1;
    }

    public static int PesquisaBinariaRecursiva(int[] vetor, int numero, int inicio, int fim ){
        int meio = (inicio + fim)/2;
        if (inicio <= fim) {
            if (vetor[meio] == numero) {
                return meio;
            }else if(vetor[meio] > numero){
                return PesquisaBinariaRecursiva(vetor, numero, 0, meio - 1);
            }else if (vetor[meio] < numero){
                return PesquisaBinariaRecursiva(vetor, numero, meio + 1, fim);
            }
        }
        return -1;
    } 
}
