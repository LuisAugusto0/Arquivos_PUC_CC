import java.util.Scanner;

public class atividades00b{
	static Scanner read = new Scanner(System.in);
	static int flag = 0;

	//  inicio questão 1  //
	// Verificar se a chave informada está contida no array com ordem aleatoria //
	static boolean chaveContidaAleatorio(int key, int[] array){
		boolean pertence = false;
		
		for (int i=0; i<array.length; i++){
			if(array[i] == key){
				System.out.println(i);
				pertence = true;
				i = array.length;
			}
		}
		return pertence;
	}
	static void questao01(){
		int key;
		int[] array = {20, 3, 1, 2, 5, 6, 7, 9, 10, 12, 13, 15, 17, 21};
		boolean pertence;

		System.out.print("Escolha o valor da chave a ser procurada no array predefinido: ");
		key = read.nextInt();
		pertence = chaveContidaAleatorio(key, array);
		if 
		  (pertence==true) System.out.println("A chave "+key+" está contida no array");
		else 
		  System.out.println("A chave "+key+" <F12>não está contida no array");
		 
	}
	// fim questão 1 //
	

	// inicio questão 2 //
	// Verificar se a chave informada está contida no array com ordem crescente (visando menor quantidade de comparações //
		static boolean chaveContidaCrescente(int key, int[] array){
			boolean pertence = false;
			int pos, pontoDeParada;
			if(key<(array.length/2)){
				pos=0;
				pontoDeParada = array.length/2;
			}else{
				pos=array.length/2;
				pontoDeParada = array.length;
			}
			for(int i=pos; i<pontoDeParada; i++){
				if(array[i] == key){
					pertence = true;
					i = pontoDeParada;
				}
			}
			return pertence;
		}
		static void questao02(){
			int key;
			int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27};
			boolean pertence;

			System.out.print("Escolha o valor da chave a ser procurada no array predefinido: ");
                	key = read.nextInt();
			pertence = chaveContidaCrescente(key, array);
                	if
                  	  (pertence==true) System.out.println("A chave "+key+" está contida no array");
                	else
        	          System.out.println("A chave "+key+" não está contida no array");
		
		}
	// fim questão 2 //	
	
	// inicio questão 3 //
	// Mostrar na tela o maior e menor valor //
		static void printMaiorMenor(int[] array){
			int menor=array[0], maior=array[0];
			for(int i; i<array.length; i++){
				if(array[i]<menor){
					menor = array[i];
				}
			}
			for(int i; i<array.length; i++){
                                if(array[i]>maior){
                                        maior = array[i];
                                }
                        }
	
			System.out.print("O menor número do array é " + menor + ". O maior é " + maior);
		}
		static void questao03(){
			int[] array = {12, 2, 1, 9, 7, 3, 4, 6, 8};
			printMaiorMenor(array);
		}
	
	// fim questão 3 //

	// inicio questão 4 //
	// Mostrar na tela o maior e menor valor utilizando menor quantidade de comparações //
                static void maiorMenor(int[] array){
                	int menor=array[0], maior=array[0];
                	for(int i; i<array.length; i++){
                                if(array[i]<menor){
                                        menor = array[i];
                                } else if(array[i]>maior){
					maior=array[i];
				}
                        }

                        System.out.print("O menor número do array é " + menor + ". O maior é " + maior);
                }
                static void questao04(){
                        int[] array = {12, 2, 1, 9, 7, 3, 4, 6, 8};
                        printMaiorMenor(array);
                }
	
	// fim questão 4 //
	
	/*
	 	QUESTÃO 5:
		O que o código abaixo faz:

		boolean doidao (char c){
			boolean resp= false;
			int v = (int) c;
			if (v == 65 || v == 69 || v == 73 || v == 79 || v == 85 || v == 97 || v == 101 || v ==105 || v == 111 || v == 117){
				resp = true;
			}
			return resp;
		}

		R: O código verifica se o código ASCII do caracter da variavel c é igual a 65, 69, 73, 85, 97, 101, 105, 111 ou 117. Ele retorna true se uma dessas condições forem verdadeiras, se não retorna falso.

	*/
	
	/*
		QUESTÃO 6:
		Um aluno desenvolveu o código abaixo, corrija-o:

		R:
                boolean isConsoante(String s, int n){
                        boolean resp= true;
                        if (n != s.length){
                                if (s.charAt(n)<'0' || s.charAt(n)>'9'){
                                	if (isVogal(s.charAt(n)) == true){
                                        	resp= false;
                                	} else{
                                        	resp=isConsoante(s, n+1);
                                	}
                                } else {
                                        resp=false;
                                }
                        }
                        return resp
                }

	*/

	static int mainMenu(){
		System.out.print("\nDigite qual menu deseja acessar:" +
				"\n[0] - Encerrar o programa" +
				"\n[1] - Exercício 1" +
				"\n[2] - Exercício 2" +
				"\n[3] - Exercício 3" +
				"\n[4] - Exercício 4  ");
		return read.nextInt();
	}
	public static void main(String[] args){
		int opcao;
		opcao = mainMenu();
		while(opcao!=flag){
			switch (opcao){
				case 1:
					questao01();
					break;
				case 2:
					questao02();
					break;
				case 3:
					questao03();
					break;
				case 4:
					questao04();
					break;
				default:
					System.out.println("Opção incorreta, digite novamente");
					break;
			}
			opcao = mainMenu();
		}	
	} 
}
