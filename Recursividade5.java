import java.util.Scanner;

public class Recursividade5 {
    public static void main(String[] args) {
        System.out.println("Digite o primeiro número: ");                
        Scanner entradaDados = new Scanner(System.in);
        int numero1 = entradaDados.nextInt();
        System.out.println("Digite o multiplicador: "); 
        Scanner entradaDados2 = new Scanner(System.in);
        int numero2 = entradaDados2.nextInt();
        entradaDados.close();
        entradaDados2.close();
        System.out.println("Resultado: " + MultiplicaValores(numero1, numero2, 0, 0));
        System.out.println("Método passou no teste: "+ TestarMultiplicaValores(numero1, numero2));
    }
    public static int MultiplicaValores(int numero, int multiplicador, int contador, int resultado){
        if (contador == multiplicador) {
            return resultado;
        }
        resultado += numero;
        contador++;
        return  MultiplicaValores(numero, multiplicador, contador, resultado);
    }
    public static String TestarMultiplicaValores(int numero1, int numero2){
        int resultado = numero1 * numero2;
        if (resultado == MultiplicaValores(numero1, numero2, 0, 0)) {
            return "Sim";
        }
        return "Não";
    }
}
