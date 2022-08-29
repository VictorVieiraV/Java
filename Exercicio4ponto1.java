import java.util.Scanner;

public class Exercicio4ponto1 {
    
    static class ViagemDeOnibus{
        public double distancia;
        public double tempo;
        public double qtdCombustivel;
    }

    public static void main(String[] args) {
        ViagemDeOnibus[] arrayViagens = new ViagemDeOnibus[2];
        Scanner entradaDados = new Scanner(System.in);
        Scanner entradaDados2 = new Scanner(System.in);
        Scanner entradaDados3 = new Scanner(System.in);
        double maiorDistancia = 0.00, tempoTotalGastao = 0.00, totalQuilometros = 0.00, mediaTotal = 0.00, totalCombustivel = 0.00;            

        for (int i = 0; i < arrayViagens.length; i++) {

            ViagemDeOnibus viagem = new ViagemDeOnibus();

            System.out.println("Digite a distancia percorida em KM: ");
            viagem.distancia = entradaDados.nextDouble();

            System.out.println("Digite o tempo gasto em horas: ");
            viagem.tempo = entradaDados2.nextDouble();
        
            System.out.println("Digite a quantos litros de combustível gasto: ");
            viagem.qtdCombustivel = entradaDados3.nextDouble();
            
            arrayViagens[i] = viagem;
            System.out.println(System.lineSeparator());
        }
            entradaDados.close();
            entradaDados2.close();
            entradaDados3.close();
        
        for (ViagemDeOnibus viagemDeOnibus : arrayViagens) {
            if (maiorDistancia < viagemDeOnibus.distancia) {
                maiorDistancia = viagemDeOnibus.distancia;
            }
            tempoTotalGastao += viagemDeOnibus.tempo;      
            totalQuilometros += viagemDeOnibus.distancia;
            totalCombustivel += viagemDeOnibus.qtdCombustivel;

            mediaTotal = totalQuilometros / totalCombustivel;
        }
        System.out.println("Qual é a viagem mais longa: " + String.format("%.2f", maiorDistancia) + " Km");
        System.out.println("Tempo total gasto em viagens: " + String.format("%.2f", tempoTotalGastao) + " Hrs");
        System.out.println("O total de quilômetros percorridos: " + String.format("%.2f", totalQuilometros) + " Km");
        System.out.println("Consumo médio de combustível considerando todas as viagens: " + String.format("%.2f", mediaTotal) + " Km/L");
    }
}
