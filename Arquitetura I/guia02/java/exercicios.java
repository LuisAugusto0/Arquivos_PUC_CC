import java.util.Scanner;
import java.lang.Math;

// Feito por Luís Augusto Lima de Oliveira e Mateus Fernandes Barbosa 

class Guia_02{
	public static Scanner leia = new Scanner(System.in);
	public static void Questao1(){
		String binario, inteiro = "";	
		System.out.println("Digite o valor em binário: ");
		binario = leia.next();
		int inicio = -1; //valor para indicar o início dos números fracionarios
		for(int i = 0; i < binario.length(); i++){
			if(binario.charAt(i) == '.' || binario.charAt(i) == ','){
				inicio = i;
			}
		}
		if(inicio == -1){
			inicio = binario.length();
		}
		float decimal = 0;
		int contador = 0, Inteiro;
		for(int i = inicio + 1; i < binario.length(); i++){
			if(binario.charAt(i) == '1'){
				decimal += 1/(Math.pow(2,i - inicio));
				contador++;
			}
		}
		if(inicio > 0){

			for(int i = 0; i < inicio; i++){
				inteiro += binario.charAt(i);
			}
		}
		Inteiro = Integer.parseInt(inteiro,2);
		decimal = decimal + Inteiro;
		System.out.println("\nResultado: " + decimal + "\n");
	}
	public static void Questao2(){
		float decimal;
		String binario = "", auy = "";
		int inteiro, aux = 0;
		System.out.println("Digite um valor: ");
		decimal = leia.nextFloat();
		inteiro = (int)decimal;
		decimal = decimal - inteiro;
	       	binario = Integer.toString(inteiro,2);
		for(int i = 0; i < 8; i++){
		       decimal = decimal * 2;
		       aux = (int)decimal;
		       decimal = decimal - aux;
		       auy += aux;
		
		}
		binario += ",";
		binario += auy;
		System.out.println("\nResultado: "+binario+"\n");
        }
	public static void Questao3(){
		//Início da conversão Bin2Base
		//Recebe um binário e converte ele para decimal, para então converter para outra base
		String binario, inteiro = "";
                System.out.println("Digite o valor em binário: ");
                binario = leia.next();
		int base;
		System.out.println("Digite o valor em que o número vai ser convertido: ");
		base = leia.nextInt();
                int inicio = -1; //valor para indicar o início dos números fracionarios
                for(int i = 0; i < binario.length(); i++){
                        if(binario.charAt(i) == '.' || binario.charAt(i) == ','){
                                inicio = i;
                        }
                }
                if(inicio == -1){
                        inicio = binario.length();
                }
                float decimal = 0;
                int contador = 0, Inteiro;
                for(int i = inicio + 1; i < binario.length(); i++){
                        if(binario.charAt(i) == '1'){
                                decimal += 1/(Math.pow(2,i - inicio));
                                contador++;
                        }
                }
                if(inicio > 0){

                        for(int i = 0; i < inicio; i++){
                                inteiro += binario.charAt(i);
                        }
                }
                Inteiro = Integer.parseInt(inteiro,2);
                decimal = decimal + Inteiro;
          	
		//Fim da conversão para decimal
		//Início da conversão para outra base
                String resultado = "", auy = "";
                int inteirodec, aux = 0;
                inteirodec = (int)decimal;
                decimal = decimal - inteirodec;
                resultado = Integer.toString(inteirodec,base);
                for(int i = 0; i < 16; i++){
                       decimal = decimal * base;
                       aux = (int)decimal;
                       decimal = decimal - aux;
                       if(base == 16){
                                if(aux == 10){
                                        auy += 'A';
                                }
                                else if(aux == 11){
                                        auy += 'B';
                                }
                                else if(aux == 12){
                                        auy += 'C';
                                }
                                else if(aux == 13){
                                        auy += 'D';
                                }
                                else if(aux == 14){
                                        auy += 'E';
                                }
                                else if(aux == 15){
                                        auy += 'F';
                                }
                                else if(aux < 10 && aux >= 0){
                                auy += aux;
                                }
                        }
                        else{
                                auy += aux;
                        }
                }
                if(inicio > 0){
                        for(int i = 0 ; i < inicio; i++){
                                inteiro +=  binario.charAt(i);
                        }
                }
                resultado += ",";
                resultado += auy;
		resultado = resultado.toUpperCase();
                System.out.println("\nResultado: "+resultado+"\n");
}
	public static void Questao4(){
		//Início da conversão Base2Base
                //Recebe um valor em uma base e converte ele para decimal, para então converter para outra base
                String valorNaoConvertido, fracao = "";
                int base, base2;
                System.out.println("\nDigite o valor de qual base será o valor a ser convertido: ");
		base = leia.nextInt();
		System.out.println("\nDigite o valor a ser convertido: ");
		valorNaoConvertido = leia.next();
		valorNaoConvertido = valorNaoConvertido.toUpperCase();
		System.out.println("\nDigite a base para qual o valor vai ser convetido: ");
		base2 = leia.nextInt();
                int inicio = -1; //valor para indicar o início dos números fracionarios
                for(int i = 0; i < valorNaoConvertido.length(); i++){
                        if( valorNaoConvertido.charAt(i) == '.' || valorNaoConvertido.charAt(i) == ','){
                                inicio = i;
				i = valorNaoConvertido.length();
                        }
                }
                if(inicio  == -1){
                        inicio = valorNaoConvertido.length();
                }
                float decimal = 0, auz = 0;
                int contador = 0, inteiro;
                for(int i = inicio; i < valorNaoConvertido.length(); i++){
                        if(valorNaoConvertido.charAt(i) != '0' && valorNaoConvertido.charAt(i) != ',' || valorNaoConvertido.charAt(i) != '.'){
			if(base == 16 && (valorNaoConvertido.charAt(i) == 'A'
                                                || valorNaoConvertido.charAt(i) == 'B'
                                                || valorNaoConvertido.charAt(i) == 'C'
                                                || valorNaoConvertido.charAt(i) == 'D'
                                                || valorNaoConvertido.charAt(i) == 'E'
                                                || valorNaoConvertido.charAt(i) == 'F')){

                                                if(valorNaoConvertido.charAt(i) == 'A' || valorNaoConvertido.charAt(i) == 'a'){
                                                        decimal += 10/Math.pow(base,(i - inicio));
                                                }
                                                else if(valorNaoConvertido.charAt(i) == 'B' || valorNaoConvertido.charAt(i) == 'b'){
                                                        decimal += 11/Math.pow(base,(i - inicio));
                                                }
                                                else if(valorNaoConvertido.charAt(i) == 'C' || valorNaoConvertido.charAt(i) == 'c'){
                                                        decimal += 12/Math.pow(base,(i - inicio));
                                                }
                                                else if(valorNaoConvertido.charAt(i) == 'D' || valorNaoConvertido.charAt(i) == 'd'){
                                                        decimal += 13/Math.pow(base, (i - inicio));
                                                }
                                                else if(valorNaoConvertido.charAt(i) == 'E' || valorNaoConvertido.charAt(i) == 'e'){
                                                        decimal += 14/Math.pow(base,(i - inicio));
                                                }
                                                else if(valorNaoConvertido.charAt(i) == 'F' || valorNaoConvertido.charAt(i) == 'f'){
                                                        decimal += 15/Math.pow(base, (i - inicio));
                                                }
                                        }
                                        else if(base == 16 && valorNaoConvertido.charAt(i) >= '0' && valorNaoConvertido.charAt(i) <= '9'){                                                                                   auz = Character.digit(valorNaoConvertido.charAt(i),10);
						
                                                decimal += auz/Math.pow(base, (i - inicio));

                                        }
                                        else if(base != 16){
                                                auz = Character.digit(valorNaoConvertido.charAt(i),10);
						auz *= -1;
                                                decimal += auz/Math.pow(base, (i - inicio));
                                         }

                                }
                }
                if(inicio > 0){
                        for(int i = 0 ; i < inicio; i++){
                                fracao +=  valorNaoConvertido.charAt(i);
                        }
                }
                inteiro = Integer.parseInt(fracao,base);
                decimal = decimal + inteiro;
                //Fim da conversão para decimal
		//Início da conversão para outra base
		String resultado = "", auy = "";
                int inteirodec, aux = 0;
                inteirodec = (int)decimal;
                decimal = decimal - inteirodec;
                resultado = Integer.toString(inteirodec,base2);
                for(int i = 0; i < 16; i++){
                       decimal = decimal * base2;
                       aux = (int)decimal;
                       decimal = decimal - aux;
		       if(base2 == 16){
                                if(aux == 10){
                                	auy += 'A';
                                }
                                else if(aux == 11){
					auy += 'B';
                                }
                                else if(aux == 12){
					auy += 'C';					
   				}
                                else if(aux == 13){
                                        auy += 'D';
                                }
                                else if(aux == 14){
					auy += 'E';
                                }
                                else if(aux == 15){
                                        auy += 'F';
                                }
				else if(aux < 10 && aux >= 0){
				auy += aux;
				}
                        }
			else{
                       		auy += aux;
			}
                }
                resultado += ",";
                resultado += auy;
		resultado = resultado.toUpperCase();
                System.out.println("\nResultado: "+resultado+"\n");

        }
	public static void Questao5() {
		int base;
		System.out.println("Digite o valor da base correspondente aos valores: ");
		base = leia.nextInt();
		String valor1, valor2;
		System.out.println("Digite o primeiro valor: ");
		valor1 = leia.next();
		System.out.println("Digite o segundo valor: ");
		valor2 = leia.next();
		int opcao;
		float decimal1, decimal2, resultado = 0;
		decimal1 = ConversorBase2Decimal(valor1, base);
		decimal2 = ConversorBase2Decimal(valor2, base);
		System.out.println("Decimal1: "+decimal1+"\n");
		System.out.println("Decimal2: "+decimal2+"\n");
		System.out.println("Selecione a operação:" 
				+"\n[1] Soma"
				+"\n[2] Subtração"
				+"\n[3] Divisão"
				+"\n[4] Multiplicação"
				+"\n[5] Mod"
				+"\nDigite aqui: ");
		opcao = leia.nextInt();
		switch(opcao){
			case 1:
				resultado = decimal1 + decimal2;
				break;
			case 2:
				resultado = decimal1 - decimal2;
				break;
			case 3:
				resultado = decimal1 / decimal2;
				break;
			case 4:
				resultado = decimal1 * decimal2;
				break;
			case 5:
				resultado = decimal1 % decimal2;
				break;
		}
		ConversorDecimal2Base(resultado, base);
	}
	public static void ConversorDecimal2Base(float decimal, int base2){
		                String resultado = "", auy = "";
                int inteirodec, aux = 0;
                inteirodec = (int)decimal;
                decimal = decimal - inteirodec;
                resultado = Integer.toString(inteirodec,base2);
                for(int i = 0; i < 16; i++){
                       decimal = decimal * base2;
                       aux = (int)decimal;
                       decimal = decimal - aux;
                       if(base2 == 16){
                                if(aux == 10){
                                        auy += 'A';
                                }
                                else if(aux == 11){
                                        auy += 'B';
                                }
                                else if(aux == 12){
                                        auy += 'C';
                                }
                                else if(aux == 13){
                                        auy += 'D';
                                }
                                else if(aux == 14){
                                        auy += 'E';
                                }
                                else if(aux == 15){
                                        auy += 'F';
                                }
				else if(aux < 10 && aux >= 0){
                                auy += aux;
                                }

                        }
                        else{
                                auy += aux;
                        }
                }
                resultado += ",";
                resultado += auy;
                resultado = resultado.toUpperCase();
                System.out.println("\nResultado: "+resultado+"\n");
        }
	public static float ConversorBase2Decimal(String binario, int base){
		String inteiro = "";
                int inicio = -1; //valor para indicar o início dos números fracionarios
                for(int i = 0; i < binario.length(); i++){
                        if(binario.charAt(i) == '.' || binario.charAt(i) == ','){
                                inicio = i;
                        }
                }
                if(inicio == -1){
                        inicio = binario.length();
                }
                float decimal = 0;
                int contador = 0, Inteiro;
                for(int i = inicio + 1; i < binario.length(); i++){
                        if(binario.charAt(i) == '1'){
                                decimal += 1/(Math.pow(2,i - inicio));
                                contador++;
                        }
                }
                if(inicio > 0){

                        for(int i = 0; i < inicio; i++){
                                inteiro += binario.charAt(i);
                        }
                }
                Inteiro = Integer.parseInt(inteiro,2);
                decimal = decimal + Inteiro;
                return decimal;
        }
	public static int menu(){
	       int opcao;
	       System.out.println("Selecione uma das opções:\n[0] Sair\n[1] Questao1\n[2] Questao2\n[3] Questao3\n[4] Questao4\n[5] Questao5\nDigite aqui: ");
	       opcao = leia.nextInt();
	       return opcao;
	}
	public static void main(String [] args){
		int opcao; 
		do{
			opcao = menu();
			switch(opcao){
				case 0:
					System.out.println("Obrigado por utilizar o programa!");
					break;
				case 1:
					Questao1();
					break;
				case 2:
					Questao2();
					break;
				case 3:
					Questao3();
					break;
				case 4:
					Questao4();
					break;
				case 5:
					Questao5();
					break;
			}
		}while(opcao != 0);
	}
}

       			       

