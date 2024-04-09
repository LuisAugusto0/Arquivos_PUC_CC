#include <stdio.h>
#include <stdbool.h>
#include <string.h>
bool ehPalindromo(char frase[], int pos, int tam){
	bool palindromo;
	
	//para testar se possui caractere especial e tratar se tiver
    if((int)frase[pos] == -17){
         palindromo = frase[pos+2] == frase[tam-pos-1];
         pos+=2;

    } else if((int)frase[pos] == -61){
        palindromo = frase[pos+1] == frase[tam-pos-1];
        pos++;
	} else {
		palindromo = frase[pos] == frase[tam-pos-1];
	}

    if(palindromo && pos < tam/2){
        palindromo = palindromo && ehPalindromo(frase, pos+1, tam);        
    }

	return palindromo;
}

int main (void) {
	//declaração de variáveis
	int tam=0;
        char frase[400];	

	//leitura de dados e verificar tam do array	
	fgets(frase, 400, stdin);
	
	while(frase[tam] !='\0'){
        tam++;
    }  
    tam--;
    //executar enquanto a variável frase não tiver um tamanho de 3 caracteres e que seja diferente de FIM.
	while(tam != 3 || frase[0]!='F' || frase[1]!='I' || frase[2]!='M'){
		bool palindromo = ehPalindromo(frase, 0, tam);
		if(palindromo){
			printf("SIM\n");
		} else {
			printf("NAO\n");
		}

		//leitura de dados e verificar tam do array 
		fgets(frase, 400, stdin); 
	    
        tam=0;
        while(frase[tam] !='\0'){
            tam++;
        }
        tam--;

    }
	return 0;
}

