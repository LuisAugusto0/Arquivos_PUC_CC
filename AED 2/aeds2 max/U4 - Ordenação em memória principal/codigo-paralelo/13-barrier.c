#include <stdio.h>
#include <omp.h>

int main(){
   omp_set_num_threads(3);
	#pragma omp parallel
	{
		printf("Fase 1\n");
		printf("Fase 2\n");
	}

   printf("\n\n============================\n\n");

	#pragma omp parallel
	{
		printf("Fase 1\n");
		#pragma omp barrier
		printf("Fase 2\n");
	}

}



