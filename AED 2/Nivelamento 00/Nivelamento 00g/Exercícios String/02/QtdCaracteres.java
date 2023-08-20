import java.util.Scanner;


class QtdCaracteres{
	static Scanner scan = new Scanner(System.in);
	static int calcularNumMai(String frase, int numChr){
		int num = 0;

		for(int i=0; i<numChr; i++){
			if( ( (int)frase.charAt(i) ) > 64 && ( (int)frase.charAt(i) )<91){
				num++;
			} 
		}
		return num;
	}
	public static void main(String[] args){
		String frase;
		int numChar, numMaiusculos;
		System.out.print("Escreva a palavra que você deseja verificar os caracteres: ");
		frase = scan.nextLine();
		
		numChar = frase.length();
		numMaiusculos = calcularNumMai(frase, numChar);

		System.out.println("A quantidade de caracteres é " + numChar + " e a quantidade de caracteres maiúsculos é " + numMaiusculos);
	}
}
