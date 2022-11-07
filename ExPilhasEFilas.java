public class ExPilhasEFilas {

    public static class Elemento {
        public String valor;
        public Elemento prox;
        public Elemento anterior;

        public Elemento(String novoValor) {
            this.valor = novoValor;
            this.prox = null;
            this.anterior = null;
        }
    }

    public static class Fila {

        public Elemento atual;
        public Elemento proximo;
        public int tamanhoFila;

        public Fila() {
            this.atual = new Elemento(null);
            this.proximo = atual;
            this.tamanhoFila = 0;
        }

        public void AdicionarElementoFimFila(String elm) {
            Elemento elemento = new Elemento(elm);
            this.proximo.prox = elemento;
            this.proximo = elemento;
            this.tamanhoFila++;
        }

        public void RemoverElementoFimFila() {
            Elemento elementoAnterior = null;
            Elemento elementoAtual = this.atual;
            for (int i = 0; i <= this.tamanhoFila; i++) {
                if (elementoAtual.valor == this.proximo.valor) {
                    if (this.tamanhoFila == 1) {
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
                    this.tamanhoFila--;
                    break;
                }
                elementoAnterior = elementoAtual;
                elementoAtual = elementoAtual.prox;
            }
        }

        public void RemoverElementoInicioFila() {
            if (this.tamanhoFila != 0) {
                this.atual.prox = this.atual.prox.prox;
                this.tamanhoFila--;
            }
        }

        public void AdicionarElementoInicioFila(String elm) {
            Elemento novoElemento = new Elemento(elm);

            if (tamanhoFila == 0) {
                novoElemento.anterior = this.atual;
                this.atual.prox = novoElemento;
                proximo = novoElemento;
            } else {
                novoElemento.prox = this.atual.prox;
                novoElemento.anterior = this.atual;
                this.atual.prox.anterior = novoElemento;
                this.atual.prox = novoElemento;
            }
            this.tamanhoFila++;
        }
    }

    public static class Pilha {
        public Elemento atual;
        public Elemento proximo;
        public int tamanhoPilha;

        public Pilha() {
            this.atual = new Elemento(null);
            this.proximo = atual;
            this.tamanhoPilha = 0;
        }

        public void AdicionarElementoPilha(String novoValor) {
            Elemento novoElemento = new Elemento(novoValor);
            if (this.atual == null && this.proximo == null) {
                this.atual = novoElemento;
                this.proximo = novoElemento;
            } else {
                novoElemento.prox = this.proximo;
                this.proximo = novoElemento;
            }
            this.tamanhoPilha++;
        }

        public void RemoverElementoPilha() {
            this.proximo = this.proximo.prox;
            this.tamanhoPilha--;
        }
    }

    public static Fila InverterFilaComPilha(Fila fila) {
        Pilha pilha = new Pilha();
        Fila filaNova = new Fila();

        while (fila.tamanhoFila != 0) {
            pilha.AdicionarElementoPilha(fila.atual.prox.valor);
            fila.RemoverElementoInicioFila();
        }

        while (pilha.tamanhoPilha != 0) {
            filaNova.AdicionarElementoFimFila(pilha.proximo.valor);
            pilha.RemoverElementoPilha();
        }

        return filaNova;
    }

    public static void ImprimirPilha(Pilha pilha) {
        Pilha pilhaAux = new Pilha();
        while (pilha.tamanhoPilha != 0) {
            pilhaAux.AdicionarElementoPilha(pilha.proximo.valor);
            pilha.RemoverElementoPilha();
        }

        var aux = pilhaAux.proximo;
        while (aux != null && aux.valor != null) {
            System.out.println(aux.valor);
            aux = aux.prox;
        }
    }

    public static void main(String[] args) {
        Fila fila = new Fila();
        fila.AdicionarElementoFimFila("Jose");
        fila.AdicionarElementoFimFila("Lucas");
        fila.AdicionarElementoFimFila("Thiago");
        InverterFilaComPilha(fila);

        Pilha pilha = new Pilha();
        pilha.AdicionarElementoPilha("A");
        pilha.AdicionarElementoPilha("B");
        pilha.AdicionarElementoPilha("C");
        ImprimirPilha(pilha);

        fila.AdicionarElementoInicioFila("Prioridade1");
        fila.RemoverElementoFimFila();
    }
}