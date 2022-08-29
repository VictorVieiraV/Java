import java.util.Scanner;
public class Exercicio3{
    public static void main(String[] args) {
        System.out.println("Digite a frase: ");
        Scanner entradaDados = new Scanner(System.in);

        String frase = entradaDados.nextLine();
        String[] array = {"a","e","i","o","u","A","E","I","O","U"};
        
        
        for (String item : array) {
            if (frase.contains(item)) {
                frase = frase.replace(item, "");                  
            }
        }

        entradaDados.close();
        System.out.println("Frase: " + frase);
    }
}