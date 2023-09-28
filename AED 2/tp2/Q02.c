#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

#define TAM 100

struct jogador{
    int id;
    char nome[TAM];
    int peso;
    char universidade[TAM];
    int anoNascimento;
    char cidadeNascimento[TAM];
    char estadoNascimento[TAM];
} jogadorLido;
typedef struct jogador jogador;

void setId(int id){
    jogadorLido.id = id;
}
void setNome(char nome[]){
    strcpy(jogadorLido.nome, nome);
}
void setPeso(int peso){
    jogadorLido.peso = peso; 
}
void setUniversidade(char universidade[]){
    strcpy(jogadorLido.universidade, universidade);
}
void setAnoNasciemnto(int anoNascimento){
    jogadorLido.anoNascimento = anoNascimento;
}
void setCidadeNascimento(char cidadeNascimento[]){
    strcpy(jogadorLido.cidadeNascimento, cidadeNascimento);
}
void setEstadoNascimento(char estadoNascimento[]){
    strcpy(jogadorLido.estadoNascimento, estadoNascimento);    
}

void corrigirArray(char array[]){
    int i = 0; 
    while(array[i] != '\0'){
         if(array[i] == '\n')
             array[i] = '\0';
         i++;
     }
}

int toInt(char valor[]){
    int tam = 0, expoente = 0, valorFinal = 0;
    tam = strlen(valor);
    
    while(tam >=0){
        valorFinal += valor[tam--] * pow(10, expoente++);
    }
    

    return tam;
}
int main() {
    char id[5];
    scanf("%s", id);
    while(!strcmp(id, "FIM")){
        
        scanf("%s", id);
    }
}
