import java.util.Scanner;

public class NumerosImpares {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int N;
        
        System.out.print("Digite um número inteiro N: ");
        N = read.nextInt();

        int contador = 0;
        int numero = 1;

        System.out.println("Os primeiros " + N + " números ímpares são:");

        while (contador < N) {
            if (numero % 2 != 0) {
                System.out.println(numero);
                contador++;
            }
            numero++;
        }
    }
}
