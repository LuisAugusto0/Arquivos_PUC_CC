#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>
#include <time.h> 

#define TAM 60

int comp;
int mov;

struct Jogador{
    int id;
    char nome[TAM];
    int altura;
    int peso;
    char universidade[TAM];
    int anoNascimento;
    char cidadeNascimento[TAM];
    char estadoNascimento[TAM];
};
typedef struct Jogador Jogador;

//funções set
void setId(int id, Jogador* jogadorLido){
    jogadorLido->id = id;
}
void setNome(char nome[], Jogador* jogadorLido){
    if(nome[0]=='\0'){
        strcpy(jogadorLido->nome, "nao informado");
    } else {
        strcpy(jogadorLido->nome, nome);
    }
}
void setAltura(int altura, Jogador* jogadorLido){
    jogadorLido->altura = altura;
}
void setPeso(int peso, Jogador* jogadorLido){
    jogadorLido->peso = peso; 
}
void setUniversidade(char universidade[], Jogador* jogadorLido){
    if(universidade[0] == '\0'){
           strcpy(jogadorLido->universidade, "nao informado");
    } else {
           strcpy(jogadorLido->universidade, universidade);
    }
}
void setAnoNascimento(int anoNascimento, Jogador* jogadorLido){
    jogadorLido->anoNascimento = anoNascimento;
}
void setCidadeNascimento(char cidadeNascimento[], Jogador* jogadorLido){
    if(cidadeNascimento[0] == '\0'){
        strcpy(jogadorLido->cidadeNascimento, "nao informado");
    } else {
        strcpy(jogadorLido->cidadeNascimento, cidadeNascimento);
    }
}
void setEstadoNascimento(char estadoNascimento[], Jogador* jogadorLido){
    if(estadoNascimento[0] == '\0'){
        strcpy(jogadorLido->estadoNascimento, "nao informado");
    } else {
        strcpy(jogadorLido->estadoNascimento, estadoNascimento);
    }
}

void split (char valLido[], char valFinal[], int virgulasPuladas){
    char aux;
    int posL = 0, posF = 0;
    while(virgulasPuladas>0){
        if(valLido[posL++]==',')
            virgulasPuladas--;
    }

    aux = valLido[posL++];
    while( aux != ',' && aux != '\n' ) {
        valFinal[posF++] = aux;
        aux = valLido[posL++];
    }
    valFinal[posF] = '\0';
}

void lerJogador(Jogador* jogador, int id, FILE* arq){
    char idChar[TAM];
    char nome[TAM];
    char altura[TAM];
    char peso[TAM];
    char universidade[TAM];
    char nascimento[TAM];
    char cidade[TAM];
    char estado[TAM];
    char line[8*TAM];

    if(id==223) 
        id--;

    fseek(arq, 0, SEEK_SET);

    do{
        char line[8*TAM];
        int tam = 0;
        char c;
        do{
            fscanf(arq, "%c", &c);
            line[tam++] = c; 
        }while ( c != '\n');
        split(line, idChar, 0);
    } while (atoi(idChar) != id);
    
    setId(atoi(idChar), jogador);

    split(line, nome, 1);
    setNome(nome, jogador);

    split(line, altura, 2);
    setAltura(atoi(altura), jogador);

    split(line, peso, 3);
    setPeso(atoi(peso), jogador);

    split(line, universidade, 4);
    setUniversidade(universidade, jogador);

    split(line, nascimento, 5);
    setAnoNascimento(atoi(nascimento), jogador);
    
    split(line, cidade, 6);
    setCidadeNascimento(cidade, jogador);

    split(line, estado, 7);
    setEstadoNascimento(estado, jogador);
}
void imprimirJogador(Jogador* jogador){
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
}


void shellSort(Jogador* jogador[], int tam){ 
    int separacao = 1;
    do{ separacao =  (separacao * 3) + 1; } while ( separacao < tam); //setar o tamanho do espaço do shell

    do{
        separacao /= 3;
        for(int grupo=0; grupo<separacao; grupo++){ //determinar grupo que a inserção será feita
            for(int i=separacao+grupo; i<tam; i+=separacao){ //Realizar a insercao no grupo
                Jogador* tmp = jogador[i];
                int j = i-separacao;
            

                while(j>=0 && tmp->peso < jogador[j]->peso){
                    jogador[j+separacao] = jogador[j];
                    j-=separacao;
                    comp+=2;
                    mov++;
                }

                while(j>=0 && tmp->peso == jogador[j]->peso && strcmp(tmp->nome, jogador[j]->nome)<0){
                    jogador[j+separacao] = jogador[j];
                    j-=separacao;
                    comp+=2;
                    mov++;
                }
                jogador[j+separacao] = tmp;
                mov++;
            }
        }
    }while(separacao!=1);        
}

/*
void insertionSortByColor(int color, int h, int N, Jogador* array[]) {
	int j;
	Jogador* temp;
	for (int i = h + color; i < N; i += h) {
		temp = array[i];
		j = i - h;
		while (j >= 0 && array[j]->peso>temp->peso ) {
			array[j + h] = array[j];
			j -= h;
			mov++;
		}
		array[j + h] = temp;
		mov += 2;
	}
}

void ShellSort(Jogador* jogador[], int n) {
	int h = 0;
	do{ 
        h =  (h * 3) + 1; 
    } while (h < n);

	while (h >= 1) {
		h /= 3;
		for (int color = 0; color < h; color++) {
			insertionSortByColor(color, h, n, jogador);
		}
	}
}
*/

int main() {
    FILE* arq = fopen("/tmp/players.csv", "r");
    int qtdeJogadores = 0;
    Jogador* jogador[5000];
    char id[10];
    scanf("%s", id);
    while(strcmp(id, "FIM")){
        jogador[qtdeJogadores] = (Jogador*) malloc(sizeof(Jogador));
        lerJogador(jogador[qtdeJogadores++], atoi(id), arq);  
        scanf("%s", id);
    }
    fclose(arq);

    clock_t begin = clock();
    shellSort(jogador, qtdeJogadores);
    clock_t end = clock();
    
    for(int i=0; i<qtdeJogadores; i++){
        imprimirJogador(jogador[i]);
    }
    
    arq = fopen("matrícula_shellsort.txt", "w");
    fprintf(arq, "805413\t%d\t%d\t%lf", comp, mov, (double)(end - begin) / CLOCKS_PER_SEC);

    return 0;
}
