import java.util.Scanner;

public class MostrarNumerosArray {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int n;

        System.out.print("Digite a quantidade de números: ");
        n = read.nextInt();

        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            numeros[i] = read.nextInt();
        }

        System.out.println("Números digitados:");

        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
