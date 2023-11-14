#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

#define TAM 60

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
Jogador* jogador[8000];

//variaveis globais
int qtdeJogadores = 0;

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
void setAll(int id, char nome[], int altura, int peso, char universidade[], int anoNascimento, char cidadeNascimento[], char estadoNascimento[], Jogador* jogadorLido){
    setId(id, jogadorLido);
    setNome(nome, jogadorLido);
}

//funcao clone
Jogador clone(Jogador *j){

}

//funcoes split
void splitJogador (char valLido[], char valFinal[], int virgulasPuladas){
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

//funcao de leitura
Jogador* lerJogador(int id){
    Jogador* jogador = (Jogador*) malloc(sizeof(Jogador));

    FILE* arq = fopen("tmp/players.csv", "r");
    if(arq == NULL)
        printf("Arquivo nao aberto");
    else{
        char idChar[TAM];
        char nome[TAM];
        char altura[TAM];
        char peso[TAM];
        char universidade[TAM];
        char nascimento[TAM];
        char cidade[TAM];
        char estado[TAM];
        char line[8*TAM];

        do{
            char line[8*TAM];
            int tam = 0;
            char c;
            do{
                fscanf(arq, "%c", &c);
                line[tam++] = c; 
            }while ( c != '\n');
            splitJogador(line, idChar, 0);
        } while (atoi(idChar) != id);
        
        setId(atoi(idChar), jogador);

        splitJogador(line, nome, 1);
        setNome(nome, jogador);

        splitJogador(line, altura, 2);
        setAltura(atoi(altura), jogador);

        splitJogador(line, peso, 3);
        setPeso(atoi(peso), jogador);

        splitJogador(line, universidade, 4);
        setUniversidade(universidade, jogador);

        splitJogador(line, nascimento, 5);
        setAnoNascimento(atoi(nascimento), jogador);
        
        splitJogador(line, cidade, 6);
        setCidadeNascimento(cidade, jogador);

        splitJogador(line, estado, 7);
        setEstadoNascimento(estado, jogador);
    }
    fclose(arq);
    return jogador;
}

//funcoes para insercao
void inserirInicio(Jogador add){
    for(int i = qtdeJogadores--; i>=0; i--){
        jogador[i] = jogador[i-1];
    }
}
void inserirFim(Jogador add){
    jogador[qtdeJogadores++] = &add;
}
void inserir(Jogador add, int pos){
    if(qtdeJogadores < pos)
        printf("Posicao invalida");
    else{
        for(int i = qtdeJogadores--; i>pos; i--){
            jogador[i] = jogador[i-1];
        }
        jogador[pos] = &add;
    }
}

//funcoes para remocao
Jogador* removerInicio(){
    Jogador* rem = NULL;
    if(qtdeJogadores != 0){
       rem = jogador[0];
       for(int i=0; i<qtdeJogadores-1; i++){
           jogador[i] = jogador[i+1];
       }
    }
    return rem;
}

//imprimir na tela
void printJogador(Jogador* jogador){
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
}

int main() {
    char in[30]; 
    int qtdeOperacoes;

    scanf("%s", in);
    while(strcmp(in, "FIM")){
        jogador[qtdeJogadores] = (Jogador*) malloc(sizeof(Jogador));
        jogador[qtdeJogadores++] = lerJogador(atoi(in));  
        printJogador(jogador[qtdeJogadores-1]);
        scanf("%s", in);
    }
    
    scanf("%d", &qtdeOperacoes);
    while(qtdeOperacoes-- > 0){
        scanf("%[^\n]", in);
        
    }


    return 0;
}
