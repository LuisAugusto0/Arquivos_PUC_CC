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
}
void imprimirJogador(Jogador* jogador){
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
}

int selecaoRecursiva(Jogador* jogador[], int tam, int pos, int posMenor){ 
    if(pos == 0){
        while(pos < tam){
            posMenor = pos;
            posMenor = selecaoRecursiva(jogador, tam, pos+1, posMenor);
            //swap
            Jogador* aux = jogador[pos];
            jogador[pos] = jogador[posMenor];
            jogador[posMenor] = aux;
            //fim swap
            
            mov+=3;
            comp++;
            pos++;
        }
        comp+=2;
    } else if(pos < tam){
        Jogador* aux = jogador[posMenor];
        Jogador* auxAtual = jogador[pos];
        if(strcmp(aux->nome, auxAtual->nome) > 0){  //se maior que 0, auxNext possui um nome menor
            posMenor = pos; 
        }
        
        posMenor = selecaoRecursiva(jogador, tam, pos+1, posMenor);

        comp+=3;
    } else {
        comp+=2;
    }
    
    return posMenor;
}

int main() {
    FILE* arq = fopen("/tmp/players.csv", "r");
    int qtdeJogadores = 0;
    Jogador* jogador[8000];

    char id[10];
    scanf("%s", id);
    while(strcmp(id, "FIM")){
        jogador[qtdeJogadores] = (Jogador*) malloc(sizeof(Jogador));
        lerJogador(jogador[qtdeJogadores++], toInt(id), arq);  
        scanf("%s", id);
    }
    fclose(arq);

    clock_t begin = clock();
    selecaoRecursiva(jogador, qtdeJogadores, 0, 0);
    clock_t end = clock();
    
    for(int i=0; i<qtdeJogadores; i++){
        imprimirJogador(jogador[i]);
    }
    
    arq = fopen("matrícula_selecaoRecursiva.txt", "w");
    fprintf(arq, "805413\t%d\t%d\t%lf", comp, mov, (double)(end - begin) / CLOCKS_PER_SEC);

    return 0;
}
