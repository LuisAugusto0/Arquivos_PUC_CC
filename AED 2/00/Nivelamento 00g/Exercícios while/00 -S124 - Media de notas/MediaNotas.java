import java.util.Scanner;

public class MediaNotas {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        double soma = 0;
        int numAlunos = 5; // Número de alunos

        for (int i = 1; i <= numAlunos; i++) {
            System.out.print("Digite a nota do aluno " + i + ": ");
            double nota = read.nextDouble();
            soma += nota; // Acumula a nota na variável "soma"
        }

        double media = soma / numAlunos;

        System.out.println("A média das notas é: " + media);
    }
}
