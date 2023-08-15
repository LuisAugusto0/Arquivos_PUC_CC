import java.util.Scanner;
class somaNumeros{
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args){
		int n;
		int[] vet;
		System.out.print("Escreva a quantidade de numeros para serem lidos: ");
		n = scan.nextInt();
		vet = new int[n];

		for(int i=0; i<n; i++){
			System.out.print("\nEscreva o "+ (i+1) + "º num do vetor: ");
			vet[i] = scan.nextInt();
		}

		for(int i=0; (2*i+1)<n; i++){
			System.out.println("A soma do " + (i+1) + "º termo ("+ vet[i] + ") com o " + (2*i+2) + "º termo (" + vet[2*i+1] + ") é igual a " + ( vet[i] + vet[2*i+1]) );
		}
	}
}
