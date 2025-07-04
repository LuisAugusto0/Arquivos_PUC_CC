import java.util.Scanner;

public class AnaliseEmprestimo {
	Scanner scanner = new Scanner(System.in);

    	public static void main(String[] args) {
    	    Scanner scanner = new Scanner(System.in);

        	System.out.print("Digite o salário bruto: ");
        	double salarioBruto = scanner.nextDouble();

        	System.out.print("Digite o valor da prestação: ");
        	double valorPrestacao = scanner.nextDouble();

        	double limitePrestacao = salarioBruto * 0.4; // 40% do salário bruto

        	if (valorPrestacao <= limitePrestacao) {
        	    	System.out.println("Empréstimo concedido!");
        	} else {
        	    System.out.println("Empréstimo não concedido.");
        	}

    }
}
