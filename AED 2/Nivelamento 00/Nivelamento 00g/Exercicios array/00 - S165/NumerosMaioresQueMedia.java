import java.util.Scanner;

public class NumerosMaioresQueMedia {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int n;

        System.out.print("Digite a quantidade de números a serem lidos: ");
        n = read.nextInt();

        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o " + (i + 1) + "º número inteiro: ");
            numeros[i] = read.nextInt();
        }

        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }

        double media = (double) soma / n;

        System.out.println("Números maiores que a média:");

        for (int numero : numeros) {
            if (numero > media) {
                System.out.println(numero);
            }
        }
    }
}

