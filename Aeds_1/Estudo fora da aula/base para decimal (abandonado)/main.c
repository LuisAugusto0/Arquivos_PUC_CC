#include <stdio.h>
#include <math.h>

void menu();
void BaseDecimal(int);
void DecimalBase();
long int entrada(char);
long long int calculo(int*, long long int*);

int main(void) 
{
  menu();
  return 0;
}

void menu(){
  int opcao;
  printf("Digite qual tipo de cálculo que deseja fazer:"
          "\n\t1 - Número decimal para binário (Não está funcionando)"
          "\n\t2 - Número binário para decimal"
          "\n\t3 - Número na base 6 para decimal"
          "\n\t4 - Número em octal para decimal");

  opcao = entrada('m');
  switch (opcao){
    case 1:
      DecimalBase();
      menu();
      break;
    case 2:
      BaseDecimal(2);
      menu();
      break;
    case 3:
      BaseDecimal(6);
      menu();
      break;
    case 4:
      BaseDecimal(8);
      menu();
      break;
  }
  
}

void DecimalBase(){
  
}
void BaseDecimal(int Vbase){
  long long int base, decimal;
  base = entrada('b');
  
  decimal = calculo(&Vbase, &base);
  

  printf("\n%lli\n", decimal);
  
  
}

long int entrada(char tipo){
  long int entrada;
    switch (tipo){
      case 'm':
        do{
          printf("\nEscreva qual parte do menu deseja acessar: ");
          scanf(" %li", &entrada);
        } while (entrada < 0 || entrada>4);
        break;
      case 'b':
        do{
          printf("\nEscreva o valor (respeite a regra da base): ");
          scanf(" %li", &entrada);
        } while (entrada < 0);
        break;
    }
  return entrada;
}

long long int calculo(int* Vbase, long long int* base){
  long long int decimal=0;
  int resto, numInicial=-1, controle, expoenteBase=0;

  do{
    if(*base > 10){
      do{
        numInicial++;
        controle = (*base - numInicial);
        resto = controle%10;
      }while (resto !=0);
    } else {
      numInicial = *base;
    }
    decimal += numInicial * powl(*Vbase, expoenteBase);
    
    *base = (*base-numInicial)/10;
    numInicial = -1;
    expoenteBase++;
  }while (*base!=0);

  return decimal;
}