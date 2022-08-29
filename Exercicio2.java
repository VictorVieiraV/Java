import java.util.Scanner;
public class Exercicio2{
    public static void main(String[] args) {
        System.out.println("Digite número da série de Fibonacci: ");
        Scanner entradaDados = new Scanner(System.in);
        int numeroAnterior  = 1, proximoNumero = 1, soma = 0, qtd = 0;
            qtd =  entradaDados.nextInt();


        for(int i = 0; i < qtd; i++){
            proximoNumero = soma + numeroAnterior;
            numeroAnterior = soma;
            soma = proximoNumero;
        }
        
        entradaDados.close();
        System.out.println("Número da série: " + proximoNumero);
    }
}