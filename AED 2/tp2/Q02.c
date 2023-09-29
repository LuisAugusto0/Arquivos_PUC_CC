#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

#define TAM 100

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
void setId(int id, Jogador jogadorLido){
    jogadorLido.id = id;
}
void setNome(char nome[], Jogador jogadorLido){
    if(nome[0]=='\0'){
        strcpy(jogadorLido.nome, "nao informado");
    } else {
        strcpy(jogadorLido.nome, nome);
    }
}
void setAltura(int altura, Jogador jogadorLido){
    jogadorLido.altura = altura;
}
void setPeso(int peso, Jogador jogadorLido){
    jogadorLido.peso = peso; 
}
void setUniversidade(char universidade[], Jogador jogadorLido){
    if(universidade[0] == '\0'){
           strcpy(jogadorLido.universidade, "nao informado");
    } else {
           strcpy(jogadorLido.universidade, universidade);
    }
}
void setAnoNascimento(int anoNascimento, Jogador jogadorLido){
    jogadorLido.anoNascimento = anoNascimento;
}
void setCidadeNascimento(char cidadeNascimento[], Jogador jogadorLido){
    if(cidadeNascimento[0] == '\0'){
        strcpy(jogadorLido.cidadeNascimento, "nao informado");
    } else {
        strcpy(jogadorLido.cidadeNascimento, cidadeNascimento);
    }
}
void setEstadoNascimento(char estadoNascimento[], Jogador jogadorLido){
    if(estadoNascimento[0] == '\0'){
        strcpy(jogadorLido.estadoNascimento, "nao informado");
    } else {
        strcpy(jogadorLido.estadoNascimento, estadoNascimento);
    }
}

//função para tratar o \n se existente
/*
void corrigirArray(char array[]){
    int i = 0; 
    while(array[i] != '\0'){
         if(array[i] == '\n')
             array[i] = '\0';
         i++;
     }
}
*/

//função para transformar de string para int
int toInt(char valor[]){
    int pos = 0, expoente = 0, valorFinal = 0;
    pos = strlen(valor)-1;
    
    while(pos >=0){
        valorFinal += (valor[pos--] - (int)'0') * pow(10, expoente++);
    }    
    return valorFinal;
}

void leituraSeparada(char valLido[], FILE* arq){
    char aux;
    int pos;
    valLido[0] = '\0';
    pos=0;
    while( (aux=fgetc(arq)) != ',' && aux != '\n' && aux != EOF ) {
        valLido[pos++] = aux;
    }
}
void lerJogador(Jogador jogador, int id, FILE* arq){
    fseek(arq, 0, SEEK_SET);
    char valLido[TAM];

    while(fgetc(arq) != '\n');
    do{
        leituraSeparada(valLido, arq);
    }while(toInt(valLido), id);
    setId(toInt(valLido), jogador);

    leituraSeparada(valLido, arq);
    setNome(valLido, jogador);

    leituraSeparada(valLido, arq);
    setAltura(toInt(valLido), jogador);

    leituraSeparada(valLido, arq);
    setPeso(toInt(valLido), jogador);

    leituraSeparada(valLido, arq);
    setUniversidade(valLido, jogador);

    leituraSeparada(valLido, arq);
    setAnoNascimento(toInt(valLido), jogador);
    
    leituraSeparada(valLido, arq);
    setCidadeNascimento(valLido, jogador);

    leituraSeparada(valLido, arq);
    setEstadoNascimento(valLido, jogador);
}
void imprimirJogador(Jogador jogador){
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]", jogador.id, jogador.nome, jogador.altura, jogador.peso, jogador.anoNascimento, jogador.universidade, jogador.cidadeNascimento, jogador.estadoNascimento);
}

int main() {
    FILE* arq = fopen("tmp/jogadores.csv", "wr");
    
    Jogador jogador;
    char id[10];
    scanf("%s", id);
    //while(){
        printf("entrou no while");
        lerJogador(jogador, toInt(id), arq);
        //imprimirJogador(jogador);      
        //scanf("%s", id);
    //}
    //fclose(arq);

    return 0;
}
