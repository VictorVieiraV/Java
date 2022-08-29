import java.util.Scanner;

public class Exercicio4{

    static class ViagemDeOnibus{
        public double distancia;
        public double tempo;
        public double qtdCombustivel;
    }

    public static double CalcularVelocidadeMedia(ViagemDeOnibus viagem){
        return viagem.distancia / viagem.tempo;
    }

    public static double CalcularConsumoMedio(ViagemDeOnibus viagem){
        return viagem.distancia / viagem.qtdCombustivel;
    }
    public static void main(String[] args) {
        ViagemDeOnibus viagem = new ViagemDeOnibus();

        System.out.println("Digite a distancia percorida em KM: ");
        Scanner entradaDados = new Scanner(System.in);
        viagem.distancia = entradaDados.nextDouble();
        
        System.out.println("Digite o tempo gasto em horas: ");
        Scanner entradaDados2 = new Scanner(System.in);
        viagem.tempo = entradaDados2.nextDouble();
        
        System.out.println("Digite a quantos litros de combustível gasto: ");
        Scanner entradaDados3 = new Scanner(System.in);
        viagem.qtdCombustivel = entradaDados3.nextDouble();

        System.out.println("Velocidade média da viagem: " + String.format("%.2f", CalcularVelocidadeMedia(viagem)) + " Km/h");
        System.out.println("Consumo médio por litro da viagem: " + String.format("%.2f", CalcularConsumoMedio(viagem)) + " Km/L");

        entradaDados.close();
        entradaDados2.close();
        entradaDados3.close();
    }
}
