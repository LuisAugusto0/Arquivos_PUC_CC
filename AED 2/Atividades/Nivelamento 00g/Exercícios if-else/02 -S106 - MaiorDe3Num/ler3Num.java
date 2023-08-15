import java.util.Scanner;

class ler3Num{
	static Scanner read = new Scanner(System.in);
	public static void main(String[] args){
		int menor, maior;
		
		System.out.println("Escreva 3 inteiros");
		
		//leitura e comparação
		menor = read.nextInt();
		maior = menor;
		for(int i=0; i<2; i++){
			int numero = read.nextInt();	
			if(numero>maior){
				maior = numero;
			} else if(numero<menor){
				menor = numero;
			}
		}
		System.out.println("O menor valor é " + menor + " e o maior é " + maior);
	}
}
