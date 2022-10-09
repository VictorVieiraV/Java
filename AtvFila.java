
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AtvFila {

    public static class Cliente {
        public String nome;
        public Date horarioChegada;

        public Cliente(String nomeCliente, Date chegada) {
            nome = nomeCliente;
            horarioChegada = chegada;
        }
    }

    public static class Elemento {
        public Cliente cl;
        public Elemento proximo;

        public Elemento(Cliente cliente) {
            this.cl = cliente;
            this.proximo = null;
        }
    }

    public static class Fila {
        public Elemento frente;
        public Elemento tras;
        public int contadorFila;

        public Fila() {
            this.frente = new Elemento(null);
            this.tras = frente;
            this.contadorFila = 0;
        }

        public void Enfileirar(Cliente cidadao) {
            Elemento elemento = new Elemento(cidadao);
            this.tras.proximo = elemento;
            this.tras = elemento;
            this.contadorFila++;
        }

        public Cliente Desenfileirar() {
            if (FilaVazia()) {
                return null;
            }
            var aux = this.frente.proximo;
            this.frente.proximo = this.frente.proximo.proximo;
            this.contadorFila--;
            return aux.cl;
        }

        public Boolean FilaVazia() {
            if (this.frente == this.tras) {
                return true;
            }
            return false;
        }

        public Cliente ObterPrimeiro() {
            if (FilaVazia()) {
                return null;

            } else {
                return this.frente.proximo.cl;
            }
        }

        public int ObterNumeroClientes() {
            return contadorFila;
        }

        public void Imprimir() {
            var aux = this.frente.proximo;
            while (aux != null) {
                System.out.println(aux.cl.nome);
                aux = aux.proximo;
            }
        }

        public Fila Dividir() {
            Fila filaPar = new Fila();
            Fila filaImpar = new Fila();
            var cliente = this.frente.proximo;
            while (cliente != null) {
                filaImpar.Enfileirar(cliente.cl);
                filaPar.Enfileirar(cliente.proximo.cl);
                cliente.proximo = cliente.proximo.proximo;
                cliente = cliente.proximo;
            }
            return filaPar;
        }

        public Boolean VerificarExistencia(String nomeCliente) {
            var cliente = this.frente.proximo;
            while (cliente != null) {
                if (cliente.cl.nome.toUpperCase() == nomeCliente.toUpperCase()) {
                    return true;
                }
                cliente = cliente.proximo;
            }
            return false;
        }

        public int ObterNumClientesAFrente(String nomeCliente) {
            var cliente = this.frente.proximo;
            int auxContador = 0;
            while (cliente != null) {
                if (cliente.cl.nome.toUpperCase() == nomeCliente.toUpperCase()) {
                    return auxContador;
                }
                auxContador++;
                cliente = cliente.proximo;
            }
            return -1;
        }

        public Fila Copiar() {
            Fila copiaFila = new Fila();
            var cliente = this.frente.proximo;
            while (cliente != null) {
                copiaFila.Enfileirar(cliente.cl);
                cliente = cliente.proximo;
            }
            return copiaFila;
        }

        public long ObterTempoMedioEspera(Date dataAtual) {
            var cliente = this.frente.proximo;
            long tempoTotal = 0;
            long contador = 0;

            while (cliente != null) {
                long diff = dataAtual.getTime() - cliente.cl.horarioChegada.getTime();
                tempoTotal += diff / (60 * 1000) % 60;
                cliente = cliente.proximo;
                contador++;
            }
            long tempoMedio = tempoTotal / contador;

            return tempoMedio;
        }

        public int ObterNumClientesEsperando(Date dataAtual) {
            var cliente = this.frente.proximo;
            long diffMin = 0;
            int contador = 0;

            while (cliente != null) {
                long diff = dataAtual.getTime() - cliente.cl.horarioChegada.getTime();
                diffMin = diff / (60 * 1000) % 60;
                if (diffMin >= 15) {
                    contador++;
                }
                cliente = cliente.proximo;
            }
            return contador;
        }
    }

    public static void main(String[] args) {
        Fila fila = new Fila();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Date dtc1 = new Date(2022, 10, 8, 21, 10, 0);
        Cliente c1 = new Cliente("Joao", dtc1);
        fila.Enfileirar(c1);

        Date dtc2 = new Date(2022, 10, 8, 21, 30, 0);
        Cliente c2 = new Cliente("Maria", dtc2);
        fila.Enfileirar(c2);

        Date dtc3 = new Date(2022, 10, 8, 21, 40, 0);
        Cliente c3 = new Cliente("Lucas", dtc3);
        fila.Enfileirar(c3);

        // fila.desenfileirar();
        // fila.obterNumeroClientes();
        // fila.obterPrimeiro();
        // fila.imprimir();
        // fila.Dividir();
        // fila.VerificarExistencia("Lucas");
        // fila.ObterNumClientesAFrente("Veio");
        // fila.Copiar();
        // fila.obterTempoMedioEspera(new Date(2022, 10, 8, 21, 47, 21));
        //fila.ObterNumClientesEsperando(new Date(2022, 10, 8, 21, 50, 21));
    }
}