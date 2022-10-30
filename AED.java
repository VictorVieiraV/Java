import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AED {

    public static class ContaBancaria {
        public int Id;
        public String Cpf;
        public double Saldo;
    }

    public static class Elemento {
        public ContaBancaria conta;
        public Elemento proximo;

        public Elemento(ContaBancaria contaBancaria) {
            this.conta = contaBancaria;
            this.proximo = null;
        }
    }

    public static class Lista {
        public Elemento frente;
        public Elemento tras;
        public int contador;

        public Lista() {
            this.frente = new Elemento(null);
            this.tras = frente;
            this.contador = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        var dados = LerArquivo();
        Scanner sc = new Scanner(System.in);
        Painel();
        int opcao = sc.nextInt();
        String sep = "\";\"";
        String cpf = null;

        while (opcao != 0) {
            if (opcao == 1) {
                System.out.println("Informe CPF e Saldo separados por ponto e virgula " + sep + "\n");
                String valores = sc.next();
                cpf = valores.split(";")[0];
                Double saldo = Double.parseDouble(valores.split(";")[1]);
                var id = dados.contador + 1;
                IncluirContaBancaria(dados, cpf, id, saldo);
                System.out.println("Cadastro Realizado.\n");
            }
            if (opcao == 2) {
                System.out.println("Informe o cpf da conta que deseja pesquisa. ");
                cpf = sc.next();
                System.out.println(PesquisarCpfLista(dados, cpf));
            }
            if (opcao == 3) {
                System.out.println("Informe o cpf da conta que deseja excluir.");
                cpf = sc.next();
                if (RemoverContaBancaria(dados, cpf)) {
                    System.out.println("Conta removida com sucesso.\n");
                } else {
                    System.out.println("Cpf solicitado não encontrado.\n");
                }
            }
            Painel();
            opcao = sc.nextInt();
        }
        System.out.println("Fim do programa!");
    }

    public static void IncluirContaBancaria(Lista dados, String cpf, int id, Double saldo) {
        ContaBancaria conta = new ContaBancaria();
        conta.Cpf = cpf;
        conta.Id = id;
        conta.Saldo = saldo;

        Elemento elemento = new Elemento(conta);
        dados.tras.proximo = elemento;
        dados.tras = elemento;
        dados.contador++;
    }

    public static boolean RemoverContaBancaria(Lista dados, String cpf) {
        var atual = dados.frente;

        if (dados.contador > 0) {
            while (atual.proximo != null) {
                if (atual.proximo.conta.Cpf.equals(cpf)) {
                    atual.proximo = atual.proximo.proximo;
                }
                atual = atual.proximo;
            }
            dados.contador--;
            return true;
        }
        return false;
    }

    public static String PesquisarCpfLista(Lista dados, String cpf) {
        var aux = dados.frente.proximo;
        while (aux != null) {
            if (aux.conta.Cpf.equals(cpf)) {
                return "ID: " + aux.conta.Id + " CPF: " + aux.conta.Cpf + " SALDO: " + aux.conta.Saldo + "\n";
            }
            aux = aux.proximo;
        }
        return "CPF não encontrado.\n";
    }

    public static Lista LerArquivo() throws IOException {
        FileInputStream stream = new FileInputStream("C:/Users/vitin/OneDrive/Área de Trabalho/ContasBancarias.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        Lista listaContas = new Lista();

        while (linha != null) {
            ContaBancaria conta = new ContaBancaria();
            conta.Id = Integer.parseInt(linha.split(";")[0]);
            conta.Cpf = linha.split(";")[1];
            conta.Saldo = Float.parseFloat(linha.split(";")[2]);
            Elemento elemento = new Elemento(conta);
            listaContas.tras.proximo = elemento;
            listaContas.tras = elemento;
            listaContas.contador++;
            linha = br.readLine();
        }
        return listaContas;
    }

    public static void Painel() {
        System.out.println("CRUD - Contas Bancarias");
        System.out.println("Selecione uma das seguintes opções");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Pesquisar");
        System.out.println("3 - Excluir");
        System.out.println("0 - Sair");
    }
}