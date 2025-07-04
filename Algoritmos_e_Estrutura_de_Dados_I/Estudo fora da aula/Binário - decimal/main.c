#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
  int binario[1000], resto, control=-1, milesimos=0;
  long int decimal, entrada;

    printf("\t\nDigite um numero em binario para transformar em decimal:\n");
    scanf("%li", &entrada);
    
  do{ //armazenar dado da entrada na variavel binario
    control++; 
    resto = (long int) entrada%2;
    binario[control] = resto;

    //passar pra proxima casa a ser analizada
    if(resto == 1){
            entrada--;
            entrada = entrada/10;
    } else {
            entrada = entrada/10;
    }  
  } while(entrada != 0);

  //transformar e armazenar o valor em decimal
  for(control; control>=0; control--){
    
    decimal = decimal + (binario[control]*pow(2,control));
    
   
  }
  
  printf("%li", decimal);
    return 0;
}