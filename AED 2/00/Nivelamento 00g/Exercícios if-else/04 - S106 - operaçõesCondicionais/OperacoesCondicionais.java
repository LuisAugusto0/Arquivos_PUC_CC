import java.util.Scanner;

public class OperacoesCondicionais {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int numero1 = read.nextInt();
        System.out.print("Digite o segundo número: ");
        int numero2 = read.nextInt();

        if (numero1 > 45 || numero2 > 45) {
            int soma = numero1 + numero2;
            System.out.println("Soma: " + soma);
        } else if (numero1 > 20 && numero2 > 20) {
            int subtracao = Math.max(numero1, numero2) - Math.min(numero1, numero2);
            System.out.println("Subtração: " + subtracao);
        } else if ((numero1 < 10 && numero2 != 0) || (numero2 < 10 && numero1 != 0)) {
            double divisao = (double) Math.max(numero1, numero2) / Math.min(numero1, numero2);
            System.out.println("Divisão: " + divisao);
        } else {
            System.out.println("Luís Augusto");
        }

    }
}
