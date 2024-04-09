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

//funcoes para insercao
void inserirInicio(Jogador* add){
    if(add == NULL){
        puts("Erro - jogador inexistente");
    } else {
        for(int i = qtdeJogadores; i>0; i--){
            jogador[i] = jogador[i-1];
        }
        jogador[0] = add; 
        qtdeJogadores++;
    }
}
void inserirFim(Jogador* add){
    if(add == NULL){
        puts("Erro - jogador inexistente");
    } else {
        jogador[qtdeJogadores++] = add;
    }
}
void inserir(Jogador* add, int pos){
    if (pos <= qtdeJogadores && add != NULL){
        for(int i = qtdeJogadores; i > pos; i--){
            jogador[i] = jogador[i-1];
        }
        jogador[pos] = add;
        qtdeJogadores++;
    } else if(pos > qtdeJogadores){
         printf("Posicao invalida\n");
    } else {
        puts("Erro - jogador inexistente");
    }
}

//funcoes para remocao
Jogador* removerInicio(){
    Jogador* rem = NULL;
    if(qtdeJogadores != 0){
       rem = clone(jogador[0]);
       for(int i=0; i<qtdeJogadores-1; i++){
           jogador[i] = jogador[i+1];
       }
       //free(jogador[qtdeJogadores-1]);
    } else {
        puts("Lista vazia, nao possivel remover\n");
    }

    qtdeJogadores--;
    return rem;
}
Jogador* removerFim(){
    Jogador* rem = NULL;
    if(qtdeJogadores != 0){
        rem = clone(jogador[qtdeJogadores-1]);
        //free(jogador[qtdeJogadores-1]);
        qtdeJogadores--;
    } else {
        puts("Lista vazia, nao possivel remover\n");
    }
    return rem;
}
Jogador* remover(int pos){
    Jogador* rem = NULL;
    if(pos < qtdeJogadores){
        rem = (Jogador*) malloc(sizeof(Jogador));
        rem = clone(jogador[pos]);
        for(int i = pos; i < qtdeJogadores-1; i++){
            jogador[i] = jogador[i+1];
        }
        //free(jogador[qtdeJogadores-1]);
    } else {
        puts("Lista vazia, nao possivel remover\n");
    }

    qtdeJogadores--;
    return rem;
}

//imprimir na tela
void printJogador(Jogador* jogador, int pos){
    //printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
    printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", pos, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);

}

void menuLista(char in[]){
    int param1;
    int param2;
    if(in[0] == 'I'){
        if(in[1] == 'I'){
            scanf("%d", &param1);
            inserirInicio(lerJogador(param1));
        } else if(in[1] == 'F'){
            scanf("%d", &param1);
            inserirFim(lerJogador(param1));
        } else if(in[1] == '*'){
            scanf("%d %d", &param1, &param2);
            inserir(lerJogador(param2), param1);
        }
    } else if(in[0] == 'R'){
        Jogador* rem = NULL;
        if(in[1] == 'I'){
            rem = removerInicio();
        } else if(in[1] == 'F'){
            rem = removerFim();
        } else if(in[1] == '*'){
            scanf("%d", &param1);
            rem = remover(param1);
        }

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
            //jogador[qtdeJogadores] = (Jogador*) malloc(sizeof(Jogador));
            //jogador[qtdeJogadores++] = lerJogador(atoi(in));  
            inserirFim(tmp);
            //printJogador(jogador[qtdeJogadores-1], tmp->id);
        }
        scanf("%s", in);
    }
    
    scanf("%d", &qtdeOperacoes);
    while(qtdeOperacoes-- > 0){
        scanf("%s", in);
        menuLista(in);
    }

    for(int i = 0; i<qtdeJogadores; i++){
        printJogador(jogador[i], i);
    }

    return 0;
}
