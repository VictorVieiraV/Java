import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class TipoAbstratoDois {
    public static class Produto {
        private int Codigo;
        private String Nome;
        private int Quantidade;
        private double Preco;

        Produto(int codigo, String nome, int quantidade, double preco) {
            this.Codigo = codigo;
            this.Nome = nome;
            this.Quantidade = quantidade;
            this.Preco = preco;
        }
    }

    public static void main(String[] args) {
        System.out.println("Deseja inserir um produto? S/N");
        Scanner scan = new Scanner(System.in);
        String question = scan.next();

        if (question.equals("S") || question.equals("s")) {
            InserirProduto(scan);
        } else {
            System.exit(0);
        }
        scan.close();
    }

    public static void InserirProduto(Scanner scan) {
        Produto[] vetorProduto = new Produto[1];
        vetorProduto[0] = new Produto(1, "Cebola", 12, 12.00);

        System.out.println("Informe o código do produto que deseja inserir: ");
        int codigo = scan.nextInt();

        System.out.println("Informe o nome do produto que deseja inserir: ");
        String nome = scan.next();

        System.out.println("Informe o quantidade do produto que deseja inserir: ");
        int quantidade = scan.nextInt();

        System.out.println("Informe o preço do produto que deseja inserir: ");
        double preco = scan.nextDouble();

        if (!ValidarTamanhoNome(nome)) {
            System.out.println("Nome do produto deve conter no máximo 50 caracteres!");
            System.exit(0);
        } else if (!ProdutoExiste(codigo, vetorProduto)) {
            vetorProduto = Arrays.copyOf(vetorProduto, vetorProduto.length + 1);
            for (int i = 0; i < vetorProduto.length; i++) {
                if (vetorProduto[i] == null) {
                    vetorProduto[i] = new Produto(codigo, nome, quantidade, preco);
                }
            }
            for (int i = 0; i < vetorProduto.length; i++) {
            System.out.println("Codigo: "+vetorProduto[i].Codigo+", Nome: "+vetorProduto[i].Nome+", Quantidade: "+vetorProduto[i].Quantidade+", Preço: "+vetorProduto[i].Preco);
            }
        } else {
            System.out.println("Produto já existente!");
        }
    }

    public static boolean ValidarTamanhoNome(String nome) {
        if (nome.length() <= 50) {
            return true;
        }
        return false;
    }

    public static boolean ProdutoExiste(int codigo, Produto[] vetorProdutos) {
        for (int i = 0; i < vetorProdutos.length; i++) {
            if (vetorProdutos[i].Codigo == codigo) {
                return true;
            }
        }
        return false;
    }
}