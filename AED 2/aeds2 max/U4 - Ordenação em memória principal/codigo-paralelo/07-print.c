#include<stdio.h>
#include<omp.h>

void print1();
void print2();
void print3();

int main(){
   print1();
   printf("==============\n");
   print2();
   printf("==============\n");
   print3();
}

void print1(){
	for(int i = 0; i < 3; i ++)
      printf("(P1) -- I = %d -- %d\n", i, omp_get_thread_num());
}

void print2(){
	#pragma omp parallel
	for(int i = 0; i < 3; i ++)
      printf("(P2) -- I = %d -- %d\n", i, omp_get_thread_num());
}

void print3(){
	#pragma omp parallel for
      for(int i = 0; i < 3; i ++)
         printf("(P3) -- I = %d -- %d\n", i, omp_get_thread_num());
}


