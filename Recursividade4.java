import java.util.Scanner;

public class Recursividade4 {
    public static void main(String[] args) {
        System.out.println("Digite um termo da sequência de Fibonacci: ");                
        Scanner entradaDados = new Scanner(System.in);
        int termo = entradaDados.nextInt();
        entradaDados.close();
        System.out.println("Numero da sequência de Fibonacci: "+ Fibonacci(termo, 0, 1, 0));
        System.out.println("Método passou no teste: "+ TestarFibonacci(termo));
    }
    public static int Fibonacci(int termo, int numeroAtual , int numeroAnterior, int contador){
        if (contador == termo) {
            return numeroAtual;
        }      
        int soma = numeroAtual + numeroAnterior;
        numeroAnterior = numeroAtual;
        numeroAtual = soma;
        contador++;
        return Fibonacci(termo, numeroAtual, numeroAnterior, contador);
    }
    public static String TestarFibonacci(int termo){
        int resultado = 0, nAtual = 0, nAnterior = 0;
        
        for (int i = 0; i <= termo; i++) {
            if (i == 1) {
                nAtual = 1;
                nAnterior = 0;
            } else {
                nAtual += nAnterior;
                nAnterior = nAtual - nAnterior;
            }
        }
        resultado =  nAtual;
        if (resultado == Fibonacci(termo, 0, 1, 0)) {
            return "Sim";
        }
        return "Não";
    }
}