public class ArvoreBinaria {
    public static class Elemento {
        public int valor;
        public Elemento esquerda;
        public Elemento direita;

        public Elemento(int novoValor) {
            this.valor = novoValor;
            this.esquerda = null;
            this.direita = null;
        }
    }

    public static class Arvore {
        public Elemento raiz;

        public Arvore() {
            this.raiz = null;
        }

        public void Adicionar(int valor) {
            Elemento novoElemento = new Elemento(valor);
            if (raiz == null) {
                this.raiz = novoElemento;
            } else {
                Elemento atual = this.raiz;
                while (true) {
                    if (novoElemento.valor < atual.valor) {
                        if (atual.esquerda != null) {
                            atual = atual.esquerda;
                        } else {
                            atual.esquerda = novoElemento;
                            break;
                        }
                    } else {
                        if (atual.direita != null) {
                            atual = atual.direita;
                        } else {
                            atual.direita = novoElemento;
                            break;
                        }
                    }
                }
            }
        }

        public int CountFolhas(){
            
            return 0;
        }
    }

    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.Adicionar(10);
        arvore.Adicionar(5);

        System.out.println(arvore);
    }
}
