public class ExLista {
    public static class Elemento {
        public int valor;
        public Elemento prox;

        public Elemento(int novoValor) {
            this.valor = novoValor;
            this.prox = null;
        }
    }

    public static class ListaEncadeada {
        public Elemento atual;
        public Elemento proximo;
        public int tamanhoLista;

        public ListaEncadeada() {
            this.tamanhoLista = 0;
        }

        public void AdicionarElemento(int elm) {
            Elemento novoElemento = new Elemento(elm);
            if (this.atual == null && this.proximo == null) {
                this.atual = novoElemento;
                this.proximo = novoElemento;
            } else {
                this.proximo.prox = novoElemento;
                this.proximo = novoElemento;
            }
            this.tamanhoLista++;
        }

        public void RemoverElemento(int valorParaRemover) {
            Elemento elementoAnterior = null;
            Elemento elementoAtual = this.atual;
            for (int i = 0; i < this.tamanhoLista; i++) {
                if (elementoAtual.valor == valorParaRemover) {
                    if (this.tamanhoLista == 1) {
                        this.atual = null;
                        this.proximo = null;

                    } else if (elementoAtual == atual) {
                        this.atual = elementoAtual.prox;
                        elementoAtual.prox = null;

                    } else if (elementoAtual == proximo) {
                        this.proximo = elementoAnterior;
                        elementoAnterior.prox = null;

                    } else {
                        elementoAnterior.prox = elementoAtual.prox;

                    }
                    this.tamanhoLista--;
                    break;
                }
                elementoAnterior = elementoAtual;
                elementoAtual = elementoAtual.prox;
            }
        }

        public Elemento BuscarElemento(int posicao) {
            Elemento elementoAtual = this.atual;

            for (int i = 0; i < posicao; i++) {
                if (elementoAtual.prox != null) {
                    return elementoAtual.prox;
                }
            }
            return elementoAtual;
        }
    }
    public static void main(String[] args) {
        ListaEncadeada listaX = new ListaEncadeada();
        listaX.AdicionarElemento(2);
        listaX.AdicionarElemento(4);

        ListaEncadeada listaY = new ListaEncadeada();
        listaY.AdicionarElemento(1);
        listaY.AdicionarElemento(2);

        ListaEncadeada listaZ = new ListaEncadeada();
        int tamanhoListas = listaX.tamanhoLista + listaY.tamanhoLista;

        for (int i = 0; i < tamanhoListas; i++) {
            if (listaX.atual != null && listaY.atual != null) {
                if (listaX.atual.valor <= listaY.atual.valor) {
                    listaZ.AdicionarElemento(listaX.atual.valor);
                    listaX.RemoverElemento(listaX.atual.valor);
                } else {
                    listaZ.AdicionarElemento(listaY.atual.valor);
                    listaY.RemoverElemento(listaY.atual.valor);
                }
            } else if (listaX.atual == null) {
                listaZ.AdicionarElemento(listaY.atual.valor);
                listaY.RemoverElemento(listaY.atual.valor);
            } else {
                listaZ.AdicionarElemento(listaX.atual.valor);
                listaX.RemoverElemento(listaX.atual.valor);
            }
        }
    }
}