public class TipoAbstratoTres {
    public static class Aluno {
        private String Nome;
        private int Matricula;
        private char Turma;
        private float P1;
        private float P2;
        private float P3;

        Aluno(String _nome, int _matricula, char _turma, float _p1, float _p2, float _p3) {
            this.Nome = _nome;
            this.Matricula = _matricula;
            this.Turma = _turma;
            this.P1 = _p1;
            this.P2 = _p2;
            this.P3 = _p3;
        }
    }

    public static void main(String[] args) {
        Aluno[] Alunos = new Aluno[6];
        Alunos[0] = new Aluno("Lucas", 1, 'A', 10.0f, 9.0f, 8.0f);
        Alunos[1] = new Aluno("Maria", 2, 'A', 7.0f, 6.0f, 5.0f);
        Alunos[2] = new Aluno("Tadeu", 3, 'B', 5.0f, 9.0f, 2.0f);
        Alunos[3] = new Aluno("Juliano", 3, 'B', 3.0f, 1.0f, 7.0f);
        Alunos[4] = new Aluno("Irineu", 4, 'C', 10.0f, 2.0f, 5.0f);
        Alunos[5] = new Aluno("Jose", 5, 'C', 1.0f, 6.0f, 8.0f);
        CalcularMediaTurma(Alunos);
        System.out.println("\n");
        for (int i = 0; i < Alunos.length; i++) {
            System.out.println("Média Aluno: " + Alunos[i].Nome + " Nota: " + String.format("%.02f", (Alunos[i].P1 + Alunos[i].P2 + Alunos[i].P3)/3));
        }
    }

    public static void CalcularMediaTurma(Aluno[] Alunos) {
        float NotasTurmaA = 0;
        int qtdAlunosTurmaA = 0;
        float NotasTurmaB = 0;
        int qtdAlunosTurmaB = 0;
        float NotasTurmaC = 0;
        int qtdAlunosTurmaC = 0;

        for (int i = 0; i < Alunos.length; i++) {
            if (Alunos[i].Turma == 'A') {
                NotasTurmaA += Alunos[i].P1 + Alunos[i].P2 + Alunos[i].P3;
                qtdAlunosTurmaA++;
            } else if (Alunos[i].Turma == 'B') {
                NotasTurmaB += Alunos[i].P1 + Alunos[i].P2 + Alunos[i].P3;
                qtdAlunosTurmaB++;
            } else {
                NotasTurmaC += Alunos[i].P1 + Alunos[i].P2 + Alunos[i].P3;
                qtdAlunosTurmaC++;
            }
        }
        System.out.println("Média da turma A: " + NotasTurmaA / qtdAlunosTurmaA);
        System.out.println("Média da turma B: " + NotasTurmaB / qtdAlunosTurmaB);
        System.out.println("Média da turma C: " + NotasTurmaC / qtdAlunosTurmaC);
    }
}
