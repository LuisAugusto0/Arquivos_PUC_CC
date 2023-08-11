import java.util.Scanner;

public class Fibonacci {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        
        System.out.print("Digite um número inteiro n: ");
        n = read.nextInt();

        int termoAnterior = 0;
        int termoAtual = 1;
        int contador = 2; 

        while (contador <= n) {
            int proximoTermo = termoAnterior + termoAtual;
            termoAnterior = termoAtual;
            termoAtual = proximoTermo;
            contador++;
        }

        System.out.println("O " + n + "-ésimo termo da sequência de Fibonacci é: " + termoAtual);
    }
}

