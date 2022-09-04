import java.util.Arrays;

public class TipoAbstratoUm {
    public static class Estudante {
        private String Nome;
        private String Sobrenome;
        private double PontosGraduacao;

        Estudante(String _nome, String _sobrenome, double _pontosGraduacao) {
            this.Nome = _nome;
            this.Sobrenome = _sobrenome;
            this.PontosGraduacao = _pontosGraduacao;
        }
    }

    public static class Funcionario {
        private String Nome;
        private String Sobrenome;
        private double Salario;
        private Estudante Estudante;

        Funcionario(String _nome, String _sobrenome, double _salario, Estudante _estudante) {
            this.Nome = _nome;
            this.Sobrenome = _sobrenome;
            this.Salario = _salario;
            this.Estudante = _estudante;
        }
    }

    public static void main(String[] args) {
        Funcionario[] vetorFuncionario = new Funcionario[10];
        vetorFuncionario[0] = new Funcionario("Benício", "Gomes", 1000.00, new Estudante("Benício", "Gomes", 10.00));
        vetorFuncionario[1] = new Funcionario("Leonardo", "Melo", 900.00, new Estudante("Leonardo", "Melo", 9.00));
        vetorFuncionario[2] = new Funcionario("Igor", "Mota", 800.00, new Estudante("Igor", "Mota", 8.00));
        vetorFuncionario[3] = new Funcionario("Rafael", "Freitas", 700.00, new Estudante("Rafael", "Freitas", 7.00));
        vetorFuncionario[4] = new Funcionario("Nicole", "Cunha", 600.00, new Estudante("Nicole", "Cunha", 6.00));
        vetorFuncionario[5] = new Funcionario("Pedro", "Lucas", 500.00, new Estudante("Pedro", "Lucas", 5.00));
        vetorFuncionario[6] = new Funcionario("Giovanna", "Cardoso", 400.00, new Estudante("Giovanna", "Cardoso", 4.00));
        vetorFuncionario[7] = new Funcionario("Laura", "Mota", 300.00, new Estudante("Laura", "Mota", 3.00));
        vetorFuncionario[8] = new Funcionario("Pedro", "Michael", 200.00, new Estudante("Pedro", "Rezende", 2.00));
        vetorFuncionario[9] = new Funcionario("Maria", "Clara", 100.00, new Estudante("Maria", "Clara", 1.00));
        Arrays.sort(vetorFuncionario, (a, b) -> String.format(a.Nome + " " + a.Sobrenome)
                .compareTo(String.format(b.Nome + " " + b.Sobrenome)));
        ConcederAumento(vetorFuncionario);
    }

    public static void ConcederAumento(Funcionario[] vetorFuncionario) {
        for (int i = 0; i < vetorFuncionario.length; i++) {
            if (vetorFuncionario[i].Estudante.PontosGraduacao > 7.0) {
                vetorFuncionario[i].Salario += (vetorFuncionario[i].Salario * 0.10);
                System.out.println(vetorFuncionario[i].Nome + " " + vetorFuncionario[i].Sobrenome
                        + " Salário pós aumento: R$ " + vetorFuncionario[i].Salario);
            }
        }
    }
}