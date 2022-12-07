import java.text.SimpleDateFormat;
import java.util.Date;

public class FilaPrioridade {

    public static class Paciente implements Comparable<Paciente> {
        public String senha;
        public int prioridade;
        public Date horarioChegada;

        public Paciente(String senha, int prioridade, Date horarioChegada) {
            this.senha = senha;
            this.prioridade = prioridade;
            this.horarioChegada = horarioChegada;
        }

        @Override
        public int compareTo(Paciente o) {

            if (this.prioridade > o.prioridade) {
                return 1;
            } else if (this.prioridade < o.prioridade) {
                return -1;
            }
            return 0;
        }
    }

    public static class Elemento {
        public Paciente pac;
        public Elemento prox;
        public Elemento anterior;

        public Elemento(Paciente novoValor) {
            this.pac = novoValor;
            this.prox = null;
            this.anterior = null;
        }
    }

    public static class Fila {
        public Paciente[] elementos;
        public Elemento atual;
        public Elemento proximo;
        public int tamanhoFila;

        public Fila() {
            this.atual = new Elemento(null);
            this.proximo = atual;
            this.tamanhoFila = 0;
        }

        public void AdicionarElementoFimFila(Paciente elm) {
            Elemento elemento = new Elemento(elm);
            this.proximo.prox = elemento;
            this.proximo = elemento;
            this.tamanhoFila++;
        }

        public void Enfileirar(Paciente elemento) {

            Comparable<Paciente> chave = (Comparable<Paciente>) elemento;
            int i;
            for (i = 0; i < this.tamanhoFila; i++) {
                if (chave.compareTo(this.atual.prox.pac) < 0) {
                    break;
                }
            }
            this.Adiciona(i, elemento);
        }

        private void aumentaCapacidade() {
            if (this.tamanhoFila == this.elementos.length) {
                Paciente[] elementosNovos = (Paciente[]) new Object[this.elementos.length * 2];
                for (int i = 0; i < this.elementos.length; i++) {
                    elementosNovos[i] = this.elementos[i];
                }
                this.elementos = elementosNovos;
            }
        }

        protected boolean Adiciona(int posicao, Paciente elemento) {

            if (posicao < 0 || posicao > tamanhoFila) {
                throw new IllegalArgumentException("Posição inválida");
            }

            this.aumentaCapacidade();

            for (int i = this.tamanhoFila - 1; i >= posicao; i--) {
                this.elementos[i + 1] = this.elementos[i];
            }
            this.elementos[posicao] = elemento;
            this.tamanhoFila++;

            return true;
        }

        public void RemoverElementoInicioFila() {
            if (this.tamanhoFila != 0) {
                this.atual.prox = this.atual.prox.prox;
                this.tamanhoFila--;
            }
        }

    }

    public static void main(String[] args) {
        Fila fila = new Fila();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Date chegada1 = new Date(2022, 10, 8, 21, 10, 0);
        Paciente c1 = new Paciente("A", 3, chegada1);
        fila.Enfileirar(c1);

        Date chegada2 = new Date(2022, 10, 8, 21, 20, 0);
        Paciente c2 = new Paciente("B", 2, chegada2);
        fila.Enfileirar(c2);

        Date chegada3 = new Date(2022, 10, 8, 21, 20, 0);
        Paciente c3 = new Paciente("C", 1, chegada3);
        fila.Enfileirar(c3);

        System.out.println();
    }
}
