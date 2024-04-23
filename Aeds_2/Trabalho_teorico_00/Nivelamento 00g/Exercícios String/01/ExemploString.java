import java.util.Scanner;

class ExemploString{
	static Scanner read = new Scanner(System.in);
	public static void main(String[] args){
		String frase;
		System.out.print("\n Escreva algo para ser imprimido na tela: ");
		frase = read.nextLine();
		System.out.println(frase);
	}
}
