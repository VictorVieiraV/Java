public class PilhaTP {
    public static class Elemento {
        public String valor;
        public Elemento proximo;
    }

    public static class Pilha {
        Elemento topo;
        int tamanho;

        public Pilha() {
            this.tamanho = 0;
            this.topo = null;
        }

        public boolean vazia() {
            return topo == null;
        }

        public void inserir(String str) {
            Elemento elm = new Elemento();
            elm.valor = str;
            elm.proximo = topo;
            this.topo = elm;
            this.tamanho++;
        }

        public String retirar() {
            if (vazia()) {
                return null;
            }
            String info = topo.valor;
            topo = topo.proximo;
            tamanho--;
            return info;
        }
    }

    public static void main(String[] args) {
        String entradaDados = "asda[asdas]asda{sd(aasbfg)gfgdfgdf{gthgf}";
        ValidarString(entradaDados);
    }

    public static void ValidarString(String entradaDados) {
        Pilha pilha = new Pilha();
        for (int i = 0; i < entradaDados.length(); i++) {
            if (entradaDados.charAt(i) == '(') {
                pilha.inserir("(");
            } else if (entradaDados.charAt(i) == ')') {
                pilha.inserir(")");
            } else if (entradaDados.charAt(i) == '{') {
                pilha.inserir("{");
            } else if (entradaDados.charAt(i) == '}') {
                pilha.inserir("}");
            } else if (entradaDados.charAt(i) == '[') {
                pilha.inserir("[");
            } else if (entradaDados.charAt(i) == ']') {
                pilha.inserir("]");
            }
        }
        String erro = "";

        while (pilha.topo != null) {
            if (pilha.topo.proximo != null) {
                if (pilha.topo.proximo.valor == "(" && pilha.topo.valor == ")") {
                    pilha.retirar();
                    pilha.retirar();
                } else if (pilha.topo.proximo.valor == "{" && pilha.topo.valor == "}") {
                    pilha.retirar();
                    pilha.retirar();
                } else if (pilha.topo.proximo.valor == "[" && pilha.topo.valor == "]") {
                    pilha.retirar();
                    pilha.retirar();
                } else {
                    erro = "##### " + '"' + pilha.retirar() + '"' + " Linha: "
                            + new Throwable().getStackTrace()[0].getLineNumber();

                    if (erro.contains(")") || erro.contains("}") || erro.contains("]")) {
                        System.out.println("Delimitador não aberto de forma correta.\n ");
                    } else {
                        System.out.println("Delimitador não fechado de forma correta.\n ");
                    }
                    System.out.println(erro);
                }
            }
        }

        if (erro == "") {
            System.out.println("Código Válido!");
        }
    }
}
