import java.util.Scanner;

public class ResultadoPartidaFutebol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de gols do time mandante: ");
        int golsMandante = scanner.nextInt();

        System.out.print("Digite o número de gols do time visitante: ");
        int golsVisitante = scanner.nextInt();

        if (golsMandante > golsVisitante) {
            System.out.println("Vitória do time mandante!");
        } else if (golsVisitante > golsMandante) {
            System.out.println("Vitória do time visitante!");
        } else {
            System.out.println("Empate!");
        }
    }
}
