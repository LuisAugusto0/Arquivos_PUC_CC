#include <stdio.h>
#include <omp.h>

int main(){
   omp_set_num_threads(3);
	#pragma omp parallel sections
	{
		#pragma omp section
         for(int i = 1; i < 10; i++)
            printf("Thread(%d): %d\n", omp_get_thread_num(), i);
      
		#pragma omp section
         for(int i = 1; i < 10; i++)
            printf("Thread(%d): %d\n", omp_get_thread_num(), (i*10));
      
		#pragma omp section
         for(int i = 1; i < 10; i++)
            printf("Thread(%d): %d\n", omp_get_thread_num(), (i*100));
   }
}




