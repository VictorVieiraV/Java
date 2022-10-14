import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AED {

    static class ContaBancaria {
        private int Numero;
        private String Cpf;
        private float SaldoInicial;
    }

    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("D:/Users/1394612/Desktop/ContaBanco.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        List<ContaBancaria> listaContas = new ArrayList<ContaBancaria>();

        while (linha != null) {
            ContaBancaria conta = new ContaBancaria();
            conta.Numero = Integer.parseInt(linha.split(";")[0]);
            conta.Cpf = linha.split(";")[1];
            conta.SaldoInicial = Float.parseFloat(linha.split(";")[2]);
            listaContas.add(conta);
            linha = br.readLine();
        }
        for (ContaBancaria contaBancaria : listaContas) {
            System.out.println("Conta: " + contaBancaria.Numero +
                    "      CPF: " + contaBancaria.Cpf +
                    "      Saldo: " + contaBancaria.SaldoInicial);
        }
    }

}