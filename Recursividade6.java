import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class Recursividade6 {
    public static void main(String[] args) {
        System.out.println("Digite a quantidade elementos: ");                
        Scanner entradaDados = new Scanner(System.in);
        int numero = entradaDados.nextInt();
        entradaDados.close();
        String[] vetor = new String[numero];
        
        System.out.println("Elementos: " + Arrays.toString(ImprimirElementos(vetor, 0, 1)));
        System.out.println("Soma dos valores: " + String.format("%.3f", SomarFracoes(numero)) );
        System.out.println("Método passou no teste: "+ TestarSomarFracoes(numero));
    }

    public static double SomarFracoes(int numero){
        if (numero == 1) {
            return numero;
        }
        return 1.00/numero + SomarFracoes(numero - 1);
    }

    public static String[] ImprimirElementos(String[] vetor, int posicao, int contador){
        if (posicao == vetor.length) {
            return vetor;
        }
        vetor[posicao] = "1/"+ contador;
        contador++;

        return ImprimirElementos(vetor, posicao + 1, contador);
    }

    public static String TestarSomarFracoes(int numero){
        double resultado = 0;
        double resultadoMetodoRecursivo = SomarFracoes(numero);
        
        while(numero != 0){
            resultado += 1.00/numero;
            numero -= 1;
        }

        BigDecimal rst = new BigDecimal(resultado).setScale(3, RoundingMode.HALF_EVEN);
        BigDecimal rstMet = new BigDecimal(resultadoMetodoRecursivo).setScale(3, RoundingMode.HALF_EVEN);

        if (rst.doubleValue() == rstMet.doubleValue()) {
            return "Sim";
        }else{
            return "Não";
        }
    }
}
