import java.util.Scanner;

class scanPrintNum{
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args){
		int Tam;
		int[] vet;
		System.out.print("Escreva a quantidade de números que deseja armazenar: ");
		Tam = scan.nextInt();
		vet = new int[Tam];

		for(int i=0; i<Tam; i++){
			System.out.print("\nEscreva o "+ (i+1) + "º num do vetor: ");
			vet[i] = scan.nextInt();
		}

		System.out.println("O vetor final ficou da seguinte forma: ");
		
		System.out.print("{ ");
		for(int i=0; i<Tam-1; i++){
			System.out.print(vet[i] + ", ");
		}
		System.out.print(vet[Tam-1] + " }");
	}
}
