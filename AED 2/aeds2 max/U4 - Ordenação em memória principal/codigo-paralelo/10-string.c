#include<stdlib.h>
#include<time.h>
#include<stdio.h>
#include<omp.h>
#include<string.h>

#define SIZE   50000
#define bool   int
#define true   1
#define false  0

bool compareTo(char* s1, char* s2){
   bool resp = true, sair = false;

   for(int i = 0; sair == false; i++){
      if(s1[i] == '\0'){
         sair = true;
         resp = (s2[i] == '\0');
      } else if(s1[i] != s2[i]){
         sair = true;
         resp = false;
      }
   }

   return resp;
}

int main(){
   //METRICAS A SEREM AVALIADAS =======================================
   double speedup = 0, eficiencia, tempoSequencial, tempoParalelo;
   int numProc = 4;

   //DECLARACAO DA STRING A SER PROCURADA ==============================
   char* str = (char*) malloc(100 * sizeof(char));
   strcpy(str, "Página");


   //DECLARACAO E ALOCACAO DO VETOR =====================================
   char **palavra = malloc (SIZE * sizeof(char*));
   for (int i = 0; i < SIZE; ++i){
      palavra[i] = malloc (100 * sizeof(char));
   }


   //LEITURA DAS FRASES =================================================
   int numPalavra = 0;
   while(numPalavra < SIZE && strcmp(palavra[numPalavra++], "</html>")){
      scanf("%s", palavra[numPalavra]);
      printf("(%i): %s\n", numPalavra, palavra[numPalavra]);
   }


   //ALGORITMO SEQUENCIAL ==============================================
   clock_t comeco = clock();
   int soma = 0;
	for(int i = 0; i < numPalavra; i++){
      if(compareTo(palavra[i], str)){
         soma++;
      }
   }

   tempoSequencial = (clock() - comeco) / (double)CLOCKS_PER_SEC;
   printf("Tempo (seq): %f s e encontrei(%d).\n", tempoSequencial, soma);

   //ALGORITMO PARALELO ==============================================
   soma = 0;
   omp_set_num_threads(numProc);
   comeco = clock();

	#pragma omp parallel for 
		//int numPalavraLocal = numPalavra / omp_get_num_threads();
		//int deslocamento = omp_get_thread_num()*numPalavraLocal;
		//for(int i = deslocamento; i < (deslocamento + numPalavraLocal); i++){
		for(int i = 0; i < numPalavra; i++){
         if(compareTo(palavra[i], str)){
            soma++;
         }
      }

   tempoParalelo = (clock() - comeco) / (double)CLOCKS_PER_SEC;
   printf("Tempo (par): %f s e encontrei(%d).\n", tempoParalelo, soma);

   //SPEEDUP E EFICIENCIA
   speedup = tempoSequencial / tempoParalelo;
   eficiencia = speedup / numProc;

   printf("Speedup: %f\n", speedup);
   printf("Eficiencia: %f\n\n", eficiencia);

}
