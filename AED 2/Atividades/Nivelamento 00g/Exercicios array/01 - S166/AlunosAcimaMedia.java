import java.util.Scanner;

public class AlunosAcimaMedia {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int numAlunos = 5;
        String[] nomes = new String[numAlunos];
        double[] notas = new double[numAlunos];

        for (int i = 0; i < numAlunos; i++) {
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            nomes[i] = read.next();
            
            System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
            notas[i] = read.nextDouble();
        }

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }

        double media = soma / numAlunos;

        System.out.println("Alunos acima da média:");

        for (int i = 0; i < numAlunos; i++) {
            if (notas[i] > media) {
                System.out.println(nomes[i]);
            }
        }
    }
}

