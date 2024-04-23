import java.util.Scanner;

public class CalculosNumericos {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        double numero1, numero2, menorNumero, maiorNumero, raizCubicaMenor, logaritmoMenor;

        System.out.print("Digite o primeiro número real: ");
        numero1 = read.nextDouble();

        System.out.print("Digite o segundo número real: ");
        numero2 = read.nextDouble();

        menorNumero = Math.min(numero1, numero2);
        maiorNumero = Math.max(numero1, numero2);

        raizCubicaMenor = Math.cbrt(menorNumero);
        logaritmoMenor = Math.log(menorNumero) / Math.log(maiorNumero);

        System.out.println("Raiz cúbica do menor número: " + raizCubicaMenor);
        System.out.println("Logaritmo do menor na base do maior: " + logaritmoMenor);


    }
}
