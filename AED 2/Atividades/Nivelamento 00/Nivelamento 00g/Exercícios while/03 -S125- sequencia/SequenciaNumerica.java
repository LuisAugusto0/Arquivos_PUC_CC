import java.util.Scanner;

public class SequenciaNumerica {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int N;
        int numero;

        System.out.print("Digite um número inteiro N: ");
        N = read.nextInt();
        numero = 1;

        System.out.println("Os primeiros " + N + " números da sequência são:");

        int i = 0;
        while (i < N) {
            System.out.println(numero);
            if (i % 2 == 0) {
                numero += 4;
            } else {
                numero += 3;
            }
            i++;
        }
    }
}
