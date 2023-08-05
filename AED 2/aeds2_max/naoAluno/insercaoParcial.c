/**
 * Algoritmo de ordenacao por insercao
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>

#define n   10000
#define k   100

int array[n];
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

   for (i = 0; i < k; i++) {
      printf("%d ", array[i]);
   }

   printf("] \n");
}


// Algoritmo de ordenacao
void partialInsertionSort() {
   for (i = 1; i < n; i++) {
      int tmp = array[i];
      j = i - 1;

      if(i > k && array[k-1] > tmp){
         array[i] = array[k-1];
         j = k - 1;
      }
      while ((j >= 0) && (array[j] > tmp)) {
         array[j + 1] = array[j];
         j--;
      }
      array[j + 1] = tmp;
   }
}

int main() {
   srand(time(NULL));
   decrescente();
   //mostrar();		
   clock_t comeco = clock();
   partialInsertionSort();
   clock_t fim = clock();
   int total = (clock() - comeco) / CLOCKS_PER_SEC / 1000;

   mostrar();
   printf("Tempo para ordenar: %d ms.", total);
}
