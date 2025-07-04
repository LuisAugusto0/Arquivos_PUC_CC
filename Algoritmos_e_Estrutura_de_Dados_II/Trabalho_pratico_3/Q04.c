#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

#define TAM 60
#define TamFila 6

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
Jogador* jogador[TamFila];



//variaveis globais
int inicio = 0;
int fim = 0;

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
    setAltura(altura, jogadorLido);
    setPeso(peso, jogadorLido);
    setUniversidade(universidade, jogadorLido);
    setAnoNascimento(anoNascimento, jogadorLido);
    setCidadeNascimento(cidadeNascimento, jogadorLido);
    setEstadoNascimento(estadoNascimento, jogadorLido);
}

//funcao clone
Jogador* clone(Jogador *j){
    Jogador* jClone = (Jogador*) malloc(sizeof(Jogador));
    setAll(j->id, j->nome, j->altura, j->peso, j->universidade, j->anoNascimento, j->cidadeNascimento, j->estadoNascimento, jClone);
    return jClone;
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
    Jogador* jogador = NULL;

    FILE* arq = fopen("/tmp/players.csv", "r");
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

        //pular primeira linha
        while(fgetc(arq) != '\n');
        do{
            int tam = 0;
            char c;
            do{
                c = fgetc(arq);
                line[tam++] = c;
            }while ( c != '\n'  && c != EOF);
            splitJogador(line, idChar, 0);
        } while (atoi(idChar) != id && line[0] != EOF);
        
        if(line[0] == EOF){
            printf("Id inexistente");
        } else {
            jogador = (Jogador*) malloc(sizeof(Jogador));

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
    }
    fclose(arq);
    return jogador;
}

//funcoes para remocao
Jogador* remover(){
    Jogador* rem = NULL;
    if(inicio != fim){
        rem = clone(jogador[inicio]);
        free(jogador[inicio]);
        inicio = (inicio+1) % TamFila;
    } else {
        puts("Lista vazia, nao possivel remover\n");
    }

    return rem;
}

//funcoes para insercao
void inserir(Jogador* add){
    if (add != NULL){
        if((fim + 1) % TamFila == inicio)
            remover();
        jogador[fim] = add;
        fim = (fim+1) % TamFila;
        int soma = 0;
        int qtdeElementos = 0;
        for(int i = inicio; i != fim; i = (i+1) % TamFila){
            soma += jogador[i] -> altura;
            qtdeElementos++;
        }
        //mostrar media
        printf("%.0f\n", (float)soma/qtdeElementos);
    } else {
        puts("Erro - jogador inexistente\n");
    }
 }


//imprimir na tela
void printJogador(Jogador* jogador, int pos){
    //printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
    printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", pos, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);

}

void menuFila(char in){
    int param1;
    if(in == 'I'){
        scanf("%d", &param1);
        inserir(lerJogador(param1));
    } else if(in == 'R'){
        Jogador* rem = NULL;
            rem = remover();
        if(rem != NULL){
            printf("(R) %s\n", rem->nome);
        }
    }
}

int main() {
    char in[20]; 
    int qtdeOperacoes;

    scanf("%s", in);
    while(strcmp(in, "FIM")){
        Jogador* tmp = lerJogador(atoi(in));
        if(tmp != NULL){
            inserir(tmp);
        }
        scanf("%s", in);
    }
    
    scanf("%d", &qtdeOperacoes);
    qtdeOperacoes--;
    while(qtdeOperacoes-- > 0){
        scanf("%s", in);
        menuFila(in[0]);
    }
    menuFila(in[0]);
    for(int i = inicio; i != fim; i = (i+1) % TamFila){
         printJogador(jogador[i], (i-inicio) % TamFila);
    }
    return 0;
}
