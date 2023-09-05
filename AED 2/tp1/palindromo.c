#include <stdio.h>
#include <stdbool.h>
#include <string.h>
bool ehPalindromo(char frase[], int tam){
	bool palindromo=true;

	for(int pos=0; pos<=(tam-1)/2; pos++){
		//para testar se possui caractere especial e tratar se tiver
		if((int)frase[pos] == -61){
			if(frase[tam-pos-1] != frase[pos+1]){
				palindromo=false;
				pos=tam;
			}
			pos++;
		} else if(frase[pos] != frase[tam-pos-1]){
			palindromo = false;
			pos = tam;
		}
	}
	return palindromo;
}

int main (void) {
	//declaração de variáveis
	int tam=0;
        char frase[400];	

	//leitura de dados e verificar tam do array	
	fgets(frase, 400, stdin);
	
	tam = strlen(frase)-1;
	//executar enquanto a variável frase não tiver um tamanho de 3 caracteres e que seja diferente de FIM.
	while(tam != 3 || frase[0]!='F' || frase[1]!='I' || frase[2]!='M'){
		bool palindromo = ehPalindromo(frase, tam);
		if(palindromo){
			printf("SIM\n");
		} else {
			printf("NAO\n");
		}

		//leitura de dados e verificar tam do array 
		fgets(frase, 400, stdin); 
	        //while(frase[tam] != '\n') tam++;
		//frase[strcspn(frase, "\n\r")] = '\0';
		tam = strlen(frase)-1;
	}
	return 0;
}

