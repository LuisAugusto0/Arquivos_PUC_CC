import java.util.Scanner;

class SomarDoisNumeros{
	static Scanner read = new Scanner(System.in);
	public static void main(String[] args){
		//declaração de variáveis
		int x, y, resultado;
		
		//leituras
		System.out.println("Escreva dois numeros a serem somados");
		x = read.nextInt();
		y = read.nextInt();
		
		//soma
		resultado = x+y;
		
		//saída na tela
		System.out.println("A soma de " + x + " + " + y + " = " + resultado);

	} 
}
