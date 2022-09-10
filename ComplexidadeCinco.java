public class ComplexidadeCinco {
    public static void main(String[] args) {
        int[] vetor = { 1, 5, 8, 9, 6, 7, 3, 4, 2, 10 };
        int[] vetorOrdenado = { 1, 6, 7, 10, 14, 20, 22, 28, 30, 35 };
        VetorEhOrdenado(vetor);
        VetorEhOrdenado(vetorOrdenado);
    }

    public static void VetorEhOrdenado(int[] vetor) {
        int contadorCrescente = 0;
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] >= vetor[i - 1]) {
                contadorCrescente++;
            }
        }
        if (contadorCrescente == vetor.length - 1) {
            System.out.println("Vetor ORDENADO");
        } else {
            System.out.println("Vetor NÃO ORDENADO");
        }
    }
}
