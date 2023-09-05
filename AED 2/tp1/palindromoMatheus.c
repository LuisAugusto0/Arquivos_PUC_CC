#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
/*Nome: Mateus Fernandes Barbosa
 *Data: 29/08/2023
 Palíndromo em C*/
/*
                        //Enunciado//
    
Crie um método iterativo que recebe uma string como parâmetro e retorna true se essa é um palíndromo.


Na saída padrão, para cada linha de entrada, escreva uma linha de saída com SIM/NÃO indicando se a linha é um palíndromo.


Destaca-se que uma linha de entrada pode ter caracteres não letras


A entrada termina com a leitura de FIM*/

const int MAX = 400;

bool FraseEhPalindromo(char palavra[]){
  bool ehPalindromo = false;
  int tamanhoPalavra = strlen(palavra);
  int verificadorPalavra = 0;
//  printf("\n\nTamanho da Palavra: %i\n\n",tamanhoPalavra); verificação do tamanho da String
  for(int i = 0; i < tamanhoPalavra/2; i++){
    if(palavra[i] == palavra[tamanhoPalavra - 1 - i]){
      verificadorPalavra++;
    }
  }
  if(verificadorPalavra == (tamanhoPalavra / 2)){
    ehPalindromo = true;
  }
  return ehPalindromo;
}

char* LePalavra(char palavra[]){
  fgets(palavra, MAX, stdin);
  palavra[strcspn(palavra, "\n")] = '\0';
  return palavra;
}

int main(void){
  char palavra[MAX];
  //bool ehPalindromo;
    LePalavra(palavra);
  while(strcmp(palavra, "FIM") != 0){                        
      if(FraseEhPalindromo(palavra)){
        puts("SIM");
      }
      else{
        puts("NAO");
      }
    LePalavra(palavra);
  }
  return 0;
}
