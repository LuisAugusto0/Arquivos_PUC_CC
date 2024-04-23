#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>
#include <time.h> 

#define TAM 60
#define k 10

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


//função para transformar de string para int
int toInt(char valor[]){
    int pos = 0, expoente = 0, valorFinal = 0;
    pos = strlen(valor)-1;
    
    while(pos >=0){
        valorFinal += (valor[pos--] - (int)'0') * pow(10, expoente++);
    }    
    return valorFinal;
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

void lerJogador(Jogador* jogador, int id){
    FILE* arq = fopen("/tmp/players.csv", "r");
    char idChar[TAM];
    char nome[TAM];
    char altura[TAM];
    char peso[TAM];
    char universidade[TAM];
    char nascimento[TAM];
    char cidade[TAM];
    char estado[TAM];
    char line[8*TAM];

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
    } while (toInt(idChar) != id);
    
    setId(toInt(idChar), jogador);

    split(line, nome, 1);
    setNome(nome, jogador);

    split(line, altura, 2);
    setAltura(toInt(altura), jogador);

    split(line, peso, 3);
    setPeso(toInt(peso), jogador);

    split(line, universidade, 4);
    setUniversidade(universidade, jogador);

    split(line, nascimento, 5);
    setAnoNascimento(toInt(nascimento), jogador);
    
    split(line, cidade, 6);
    setCidadeNascimento(cidade, jogador);

    split(line, estado, 7);
    setEstadoNascimento(estado, jogador);
    fclose(arq);
}
void imprimirJogador(Jogador* jogador){
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
}

void swap(Jogador* jogador[], int i, int j) {
    Jogador* tmp = jogador[i];
    jogador[i] = jogador[j];
    jogador[j] = tmp;
}

int comp(Jogador* A, Jogador* B) {
    int compare = A->altura > B->altura;
    if (A->altura == B->altura) {
        compare = strcmp(A->nome, B->nome) > 0;
    }
    return compare;
}

void construir(Jogador* jogador[], int tamHeap) {
    for (int i = tamHeap; i > 1 && comp(jogador[i], jogador[i / 2]); i /= 2) {
        swap(jogador, i, i / 2);
    }
}

int getMaiorFilho(Jogador* jogador[], int i, int tamHeap) {
    int filho;
    if (2 * i == tamHeap || comp(jogador[2 * i], jogador[2 * i + 1])) {
        filho = 2 * i;
    } else {
        filho = 2 * i + 1;
    }
    return filho;
}

void reconstruir(Jogador* jogador[], int tamHeap) {
    int i = 1;
    while (i <= (tamHeap / 2)) {
        int filho = getMaiorFilho(jogador, i, tamHeap);
        if (comp(jogador[filho], jogador[i])) {
            swap(jogador, i, filho);
            i = filho;
        } else {
            i = tamHeap;
        }
    }
}

void heapSort(Jogador* jogador[], int tam) {
    // Alterar o vetor ignorando a posição zero
    Jogador** tmp = (Jogador**)malloc((tam + 1) * sizeof(Jogador*));
    for (int i = 0; i < tam; i++) {
        tmp[i + 1] = jogador[i];
    }
    jogador = tmp;

    // Construção do heap
    for (int tamHeap = 2; tamHeap <= tam; tamHeap++) {
        construir(jogador, tamHeap);
    }

    // Ordenação propriamente dita
    int tamTmp = tam;
    while (tamTmp > 1) {
        swap(jogador, 1, tamTmp--);
        reconstruir(jogador, tamTmp);
    }

    // Alterar o vetor para voltar à posição zero
    tmp = jogador;
    jogador = (Jogador**)malloc(tam * sizeof(Jogador*));
    for (int i = 0; i < tam; i++) {
        jogador[i] = tmp[i + 1];
    }
}

int main() {
    int qtdeJogadores = 0;
    Jogador* jogador[8000];

    char id[10];
    scanf("%s", id);
    while(strcmp(id, "FIM")){
        jogador[qtdeJogadores] = (Jogador*) malloc(sizeof(Jogador));
        lerJogador(jogador[qtdeJogadores++], toInt(id));  
        scanf("%s", id);
    }

    heapSort(jogador, qtdeJogadores);
    
    for(int i=0; i<k; i++){
        imprimirJogador(jogador[i]);
    }
    return 0;
}
