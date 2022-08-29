public class CenarioTres {
    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            if (i==0) {
                System.out.println("\n");
            } 
            CalcularTempoFibonacciIterativa();
            if (i==39) {
                System.out.println("\n");
            } 
        }
        long milesec = 0;
        int termo = 10, qtdExec = 0;
        
        while ( milesec != 60) {
            termo += 3;
            if(milesec == 1){
                System.out.println("pasous aq");
            }else{
                milesec += CalcularFibonacciRecursiva(termo)/1000;
                qtdExec++;
            }
            
        }
        System.out.println(qtdExec);
    }

    public static void CalcularTempoFibonacciIterativa(){
        System.out.println("Tempo Execução Iterativo: "+CalcularFibonacciIterativa20()+"|"+CalcularFibonacciIterativa10()
        +"|"+CalcularFibonacciIterativa500()+"|"+CalcularFibonacciIterativa2500()+" milisegundos");
    }
    
    //#region
    public static long CalcularFibonacciIterativa20() {
        long millis_startTime = System.nanoTime();
        FibonacciIterativa(20);
        long millis_endTime = System.nanoTime();
        return millis_endTime - millis_startTime;
    }

    public static long CalcularFibonacciIterativa10() {
        long millis_startTime = System.nanoTime();
        FibonacciIterativa(10);
        long millis_endTime = System.nanoTime();
        return millis_endTime - millis_startTime;
    }

    public static long CalcularFibonacciIterativa500() {
        long millis_startTime = System.nanoTime();
        FibonacciIterativa(500);
        long millis_endTime = System.nanoTime();
        return millis_endTime - millis_startTime;
    }

    public static long CalcularFibonacciIterativa2500() {
        long millis_startTime = System.nanoTime();
        FibonacciIterativa(2500);
        long millis_endTime = System.nanoTime();
        return millis_endTime - millis_startTime;
    }

    public static int FibonacciIterativa(int elemento) {
        int numeroAnterior  = 1, proximoNumero = 1, soma = 0;
        for(int i = 0; i < elemento; i++){
            proximoNumero = soma + numeroAnterior;
            numeroAnterior = soma;
            soma = proximoNumero;
        }
        return proximoNumero;
    }
    //#endregion

    //#region
    public static long CalcularFibonacciRecursiva(int termo) {
        long millis_startTime = System.nanoTime();
        FibonacciRecursiva(termo, 0, 1, 0);
        long millis_endTime = System.nanoTime();
        return (millis_endTime - millis_startTime)/1000000;
    }

    public static int FibonacciRecursiva(int termo, int numeroAtual , int numeroAnterior, int contador){
        if (contador == termo) {
            return numeroAtual;
        }      
        int soma = numeroAtual + numeroAnterior;
        numeroAnterior = numeroAtual;
        numeroAtual = soma;
        contador++;
        return FibonacciRecursiva(termo, numeroAtual, numeroAnterior, contador);
    }
    //#endregion
}
