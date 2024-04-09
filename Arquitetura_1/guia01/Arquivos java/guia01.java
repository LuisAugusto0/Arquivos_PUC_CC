// Luís Augusto Lima de Oliveira - 805413

import java.util.Scanner;  

public class guia01{
	static Scanner read = new Scanner(System.in); //Scanner
	static int flag = 0;
	
	static String dec2base(int dec, int base){
		String bin = Integer.toString(dec, base);
		return bin;
	}

	static int base2dec(String baseS, int base){
		int dec = Integer.parseInt(baseS, base);
		return dec;
	}

	static String hex2str(String hex){
		StringBuilder output = new StringBuilder("");
		for(int i=0; i<hex.length(); i+=2){
			String aux = hex.substring(i, i+2);
			output.append((char) Integer.parseInt(aux, 16)); 
		}
		return output.toString();
	}
	
	static String str2hex(String ASCII){
               char[] chars = ASCII.toCharArray();
               StringBuilder hex = new StringBuilder();
               for (char ch : chars) {
                        hex.append(" " + Integer.toHexString((int) ch));
               }
	       return hex.toString();

	}

	static void guia0101(){
                int decimal;
                String bin;

                System.out.print("\nEscreva o número em decimal que deseja transformar para binário, se quiser parar digite 0: ");
                decimal = read.nextInt();

                while(decimal>flag){
                        bin = dec2base(decimal,2);
                        System.out.println("O número "+decimal+" é "+bin+" em binário");
                        System.out.print("\nEscreva o número em decimal que deseja transformar para binário, se quiser parar digite 0: ");
                        decimal = read.nextInt();
                }

	}

	static void guia0102(){
		int decimal;
		String bin;
		
		System.out.print("\nEscreva o número em binário que deseja transformar em decimal, se quiser parar digite 0: ");
		bin = read.next();
		while(Double.parseDouble(bin)>flag){
			decimal = base2dec(bin, 2);
			System.out.println("O número "+bin+" em decimal é " + decimal);
	                System.out.print("\nEscreva o número em binário que deseja transformar em decimal, se quiser parar digite 0: ");
	                bin = read.next();
		}
	}
	
	static void guia0103(){
		int base, dec;
		String resultado;

		System.out.println("\tDecimal para qualquer base. Para sair digite 0.");
		System.out.print("\n\tEscreva a base que deseja converter (número inteiro): ");
		base = read.nextInt();
		System.out.print("\n\tEscreva o número em decimal para ser convertido: ");
		dec = read.nextInt();
		while(base>flag && dec>flag){
			resultado = dec2base(dec, base);
			System.out.print("O numero " + dec + " (10) = " + resultado + " (" + base + ")");
	                System.out.print("\n\tEscreva a base que deseja converter (número inteiro): ");
        	        base = read.nextInt();
                	System.out.print("\n\tEscreva o número em decimal para ser convertido: ");
                	dec = read.nextInt();

		}	
	}

	static void guia0104(){
		String bin, resultado;
		int base, dec;
		System.out.println("\tBinario para qualquer base. Para sair digite 0.");

                System.out.print("\n\tEscreva a base que deseja converter (número inteiro): ");
                base = read.nextInt();
		System.out.print("\n\tEscreva o número em binário: ");
		bin = read.next();
		while(base>flag && Double.parseDouble(bin)>flag){
			dec = base2dec(bin, 2);
		        resultado = dec2base( dec, base );	
			
			System.out.println("O numero " + bin + "(2) = " + resultado + " (" + base + ")");
	                System.out.print("\n\tEscreva a base que deseja converter (número inteiro): ");
        	        base = read.nextInt();
                	System.out.print("\n\tEscreva o número em binário: ");
                	bin = read.next();
		}
	}

	static int guia0105_Menu(){
		int escolha;
		System.out.print("Escolha o que deseja fazer:" +
				"\n[0] - Sair" +
				"\n[1] - 16_ASCII para String" +
				"\n[2] - String para 16_ASCII\n");
		escolha = read.nextInt();
		return escolha;
	}
	static void guia0105(){
		System.out.println("String para ASCII e ASCII para String. Para sair digite 0.");
		int escolha;
		do{
			escolha = guia0105_Menu();
			if(escolha == 1){
				String hex, resultado;
				System.out.println("Escreva o valor em hexadecimal a ser convertido (sem espaçamento):");
				hex = read.next();
				resultado = hex2str(hex);
				System.out.println("O resultado é: " + resultado);
			}
			else if(escolha == 2){
				String ASCII, resultado;
				System.out.println("Escreva a frase que deseja converter para hexadecimal");
				ASCII = read.next();
				resultado = str2hex(ASCII);
				System.out.println("O resultado é " + resultado);
			}
		}while(escolha>flag);	
	}

	static int escolhaMenu(){
		int escolha;
		System.out.print("\n\tEscolha o que deseja acessar:" + 
				"\n\t[0] - Encerrar programa" + 
				"\n\t[1] - Questão 1" + 
				"\n\t[2] - Questão 2" + 
				"\n\t[3] - Questão 3" +
				"\n\t[4] - Questão 4" + 
				"\n\t[5] - Questão 5" + 
				"\n\tOpção: ");
		
		escolha = read.nextInt();
		return escolha;
	}

	public static void main(String args[]){
		int escolha;
		do{
			escolha = escolhaMenu();
			switch (escolha){
			case 1:
				guia0101();
				break;
			case 2:
				guia0102();
				break;
			case 3:
				guia0103();
				break;
			case 4: 
				guia0104();
				break;
			case 5:
				guia0105();
				break;
			default:
				break;
			}
		}while(escolha != flag);
	}
}
