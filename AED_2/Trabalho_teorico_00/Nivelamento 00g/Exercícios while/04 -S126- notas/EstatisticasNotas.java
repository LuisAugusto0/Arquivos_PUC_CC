import java.util.Scanner;

public class EstatisticasNotas {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int N;
        double nota, mediaTurma = 0;
        int totalAlunos = 20;
        int abaixoMedia = 0, conceitoA = 0;

        System.out.print("Digite a nota máxima em uma prova (N): ");
        N = read.nextInt();

        int i = 0;
        while (i < totalAlunos) {
            System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
            nota = read.nextDouble();

            mediaTurma += nota;

            if (nota < 0 || nota > N) {
                System.out.println("Nota inválida. Digite uma nota entre 0 e " + N);
                continue; // Volta ao início do loop sem contar essa iteração
            }

            if (nota < 0.6 * N) {
                abaixoMedia++;
            }

            if (nota > 0.9 * N) {
                conceitoA++;
            }

            i++;
        }

        mediaTurma /= totalAlunos;

        System.out.println("Média da turma: " + mediaTurma);
        System.out.println("Alunos abaixo da média da universidade: " + abaixoMedia);
        System.out.println("Alunos com conceito A: " + conceitoA);
    }
}

