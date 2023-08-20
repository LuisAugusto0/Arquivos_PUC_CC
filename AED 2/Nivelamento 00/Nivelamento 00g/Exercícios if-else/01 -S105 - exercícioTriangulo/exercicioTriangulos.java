import java.util.Scanner;

class exercicioTriangulos{
	static Scanner read = new Scanner(System.in);

	static boolean testeTriangulo(double a, double b, double c){
		double subtracao = a - b;
		double soma = a + b;
		boolean existe = true;
                
		if(c>=soma){
	                existe = false;
		}

		return existe;
	}

	public static void main(String[] args){
		double[] lados = {0.0, 0.0, 0.0};
		boolean existe;

		//leitura de dados
		for(int i=0; i<3; i++){
			System.out.print("Escreva o " + i+1 + "º lado do triângulo ");
			lados[i] = read.nextDouble();
		}

		//teste se o triângulo existe
		existe = testeTriangulo(lados[0], lados[1], lados[2]);
		if(existe) existe = testeTriangulo(lados[1], lados[2], lados[0]);
		if(existe) existe = testeTriangulo(lados[2], lados[0], lados[1]);

		if(existe){
			if(lados[0] == lados[1] && lados[1] == lados[2]){
				System.out.println("O triângulo informado é equilátero");
			} else if(lados[0] != lados[1] && lados[1] != lados[2]){
				System.out.println("O triângulo informado é escaleno");
			} else {
				System.out.println("O triângulo informado é isósceles");
			}
		}else System.out.println("Triângulo inválido");
	}
}
