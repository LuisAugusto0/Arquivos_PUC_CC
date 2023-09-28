#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

#define TAM 100

struct Jogador{
    int id;
    char nome[TAM];
    int peso;
    char universidade[TAM];
    int anoNascimento;
    char cidadeNascimento[TAM];
    char estadoNascimento[TAM];
};
typedef struct Jogador Jogador;

void setId(int id, Jogador jogadorLido){
    jogadorLido.id = id;
}
void setNome(char nome[], Jogador jogadorLido){
    if(strcmp(nome, "")){
        strcpy(jogadorLido.nome, "nao informado");
    } else {
        strcpy(jogadorLido.nome, nome);
    }
}
void setPeso(int peso, Jogador jogadorLido){
    jogadorLido.peso = peso; 
}
void setUniversidade(char universidade[], Jogador jogadorLido){
    if(strcmp(universidade, "")){
           strcpy(jogadorLido.universidade, "nao informado");
    } else {
           strcpy(jogadorLido.universidade, universidade);
    }
}
void setAnoNasciemnto(int anoNascimento, Jogador jogadorLido){
    jogadorLido.anoNascimento = anoNascimento;
}
void setCidadeNascimento(char cidadeNascimento[], Jogador jogadorLido){
    if(strcmp(cidadeNascimento, "")){
        strcpy(jogadorLido.cidadeNascimento, "nao informado");
    } else {
        strcpy(jogadorLido.cidadeNascimento, cidadeNascimento);
    }
}
void setEstadoNascimento(char estadoNascimento[], Jogador jogadorLido){
    if(strcmp(estadoNascimento, "")){
        strcpy(jogadorLido.estadoNascimento, "nao informado");
    } else {
        strcpy(jogadorLido.nome, nome);
    }
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
        valorFinal += (valor[tam--] - (int)'0') * pow(10, expoente++);
    }    
    return valorFinal;
}

void 
void lerJogador(){

}

int main() {
    char id[5];
    scanf("%s", id);
    while(!strcmp(id, "FIM")){ 
        scanf("%s", id);

    }
}
