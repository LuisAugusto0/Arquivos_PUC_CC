#include <stdio.h>
#include <omp.h>

int main(){
   omp_set_num_threads(4);
	#pragma omp parallel
	{
		printf("Thread %d\n", omp_get_thread_num());
		#pragma omp barrier
		#pragma omp master
		{
			printf("Master %d\n", omp_get_thread_num());
		}
	}
}



