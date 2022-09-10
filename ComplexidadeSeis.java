import java.util.Scanner;

public class ComplexidadeSeis {
    public static void main(String[] args) {
        int[] vetorOrdenado = { 1, 4, 7, 10 };
        Scanner entradaDados = new Scanner(System.in);
        System.out.println("Digite um numero para inserir no vetor");
        OrdenarVetor(vetorOrdenado, entradaDados.nextInt());
        entradaDados.close();
    }

    public static void OrdenarVetor(int[] vetor, int numero) {
        int[] novoVetor = new int[vetor.length + 1];

        for (int j = 0; j < vetor.length; j++) {
            if (vetor[j] >= numero) {
                int aux = vetor[j];
                novoVetor[j] = numero;
                novoVetor[j + 1] = aux;
                numero = aux;
            } else if (vetor[j] == vetor[vetor.length - 1] && vetor[j] <= numero) {
                novoVetor[j] = vetor[j];
                novoVetor[j + 1] = numero;
            } else {
                novoVetor[j] = vetor[j];
            }
        }
        System.out.println("--------------------------");
        for (int i = 0; i < novoVetor.length; i++) {
            System.out.println("" + novoVetor[i]);
        }
        System.out.println("--------------------------");
    }
}
