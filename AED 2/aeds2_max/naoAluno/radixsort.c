/**
 * Metodo de ordenacao heapsort
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>

#define n      100
#define bool   short
#define true   1
#define false  0

int array[n+1];
int i;
int j;

//Produz um arranjo ordenado de modo decrescente.
void decrescente() {
   for (i = 0; i < n; i++) {
      array[i] = n - 1 - i;
   }
}


//Produz um arranjo de numeros aleatorios.
void aleatorio() {
   for (i = 0; i < n; i++) {
      array[i] = rand() % 1000;
   }
}


//Mostrar os elemento de um arranjo.
void mostrar() {
   printf("[ ");

   for (i = 0; i < n; i++) {
      printf("%d ", array[i]);
   }

   printf("] \n");
}
   
void swap(int i, int j) {
   int temp = array[i];
   array[i] = array[j];
   array[j] = temp;
}

//Retorna o maior elemento do arranjo.
int getMaior() {
   int maior = array[0];

   for (i = 0; i < n; i++) {
      if(maior < array[i]){
         maior = array[i];
      }
   }
   return maior;
}


void radixsort() {
   int i;
   int *b = (int *)calloc(n, sizeof(int));
   int maior = getMaior();
   int exp = 1;

   while (maior/exp > 0) {
      int bucket[10] = { 0 };

      for (i = 0; i < n; i++)
         bucket[(array[i] / exp) % 10]++; 

      for (i = 1; i < 10; i++)
         bucket[i] += bucket[i - 1];

      for (i = n - 1; i >= 0; i--)
         b[--bucket[(array[i] / exp) % 10]] = array[i];
      for (i = 0; i < n; i++)
         array[i] = b[i];
      exp *= 10;
   }

   free(b);
}


int main() {
   srand(time(NULL));
   decrescente();
   //mostrar();		
   clock_t comeco = clock();
   radixsort();
   clock_t fim = clock();
   int total = (clock() - comeco) / CLOCKS_PER_SEC / 1000;

   mostrar();
   printf("Tempo para ordenar: %d ms.", total);
}
