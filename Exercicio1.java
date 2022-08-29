import java.util.Scanner;

public class Exercicio1{
    public static void main(String[] args) {
        System.out.println("Digite um numero :");
        Scanner entradaDados = new Scanner(System.in);
        int numeroAnterior  = 0, numeroAtual = 0, sequencia = 0, sequenciaMaxima = 0;

        while (numeroAtual != -1) {
            numeroAtual = entradaDados.nextInt();
            
            if (numeroAnterior < numeroAtual) {
                sequencia += 1;
            }else {
                if (sequenciaMaxima < sequencia) {
                    sequenciaMaxima = sequencia;
                }
                sequencia = 1;
            }

            if (sequenciaMaxima <= sequencia) {
                sequenciaMaxima = sequencia;
            }
            numeroAnterior = numeroAtual;
        }
        entradaDados.close();
        System.out.println("Tamanho da maior sequência crescente: " + sequenciaMaxima);
    }
}