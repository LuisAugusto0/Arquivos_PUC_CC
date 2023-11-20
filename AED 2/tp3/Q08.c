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

struct CellLista{
    struct CellLista *ant;
    Jogador *thisJ;
    struct CellLista *prox;
};
typedef struct CellLista CellLista;

struct Lista{
    CellLista *primeiro;
    CellLista *ultimo;
    int tam;
};
typedef struct Lista Lista;

//--------------------------------Funcoes Jogador--------------------------//

//---funções set---//

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
//----Fim set----//

//---funcao clone---//
Jogador* clone(Jogador *j){
    Jogador* jClone = (Jogador*) malloc(sizeof(Jogador));
    setAll(j->id, j->nome, j->altura, j->peso, j->universidade, j->anoNascimento, j->cidadeNascimento, j->estadoNascimento, jClone);
    return jClone;
}

//---Split utilizado na leitura---//
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


//---Funcao de leitura---//
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

//imprimir na tela
void printJogador(Jogador* jogador, int pos){
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);

}


//-----------------------------Fim funcoes Jogador--------------------------//


//-----------------------------Funcoes CellLista--------------------------//

CellLista* newCell(Jogador* thisJ){
    CellLista *new = (CellLista*)malloc(sizeof(CellLista));
    new->thisJ = thisJ;
    new->prox = new->ant = NULL;
    return new;
}

void relink(CellLista *atual, CellLista* prox, CellLista* ant){
    atual->prox = prox;
    if(prox != NULL) prox->ant = atual;
    atual->ant = ant;
    if(ant != NULL) ant->prox = atual;
}

//---------------------------Fim funcoes CellJogador------------------------//


//--------------------------------Funcoes Lista------------------------------//

//---Criar celula cabeca---//
Lista* newLista(){
       Lista* new = (Lista*) malloc(sizeof(Lista));
       new->primeiro = (CellLista*) malloc(sizeof(CellLista));
       new->ultimo = new->primeiro;
       return new;
}


//---Remocao---//
Jogador* removerInicio(Lista *lista){
    Jogador* rem = NULL;
    if(lista->tam > 0){
        CellLista *tmp = lista->primeiro;
        lista->primeiro = lista->primeiro->prox;
        lista->primeiro->ant = NULL;
        rem = clone(lista->primeiro->thisJ);
        tmp->prox = NULL;
        free(tmp);
        lista->tam--;
    } else {
        puts("Erro - lista vazia\n");
    }
    return rem;
}
Jogador* removerFim(Lista *lista){
    Jogador *rem = NULL;
    if(lista->tam > 0){
        CellLista *tmp = lista->ultimo;
        lista->ultimo = lista->ultimo->ant;
        lista->ultimo->prox = NULL;
        tmp->ant = NULL;
        rem = clone(tmp->thisJ);
        free(tmp);
        lista->tam--;
    } else {
        puts("Erro - lista vazia\n");
    }
    return rem;
}
Jogador* remover(Lista *lista, int pos){
    Jogador *rem = NULL;
    if(lista->tam == 0){
        puts("Erro - Lista vazia\n");
    } else if(pos >= lista->tam){
        puts("Erro - Posicao invalida\n"); 
    } else {
        CellLista *posRem = lista->primeiro->prox;
        for(int i=0; i<pos; i++){
            posRem = posRem->prox;
        }
        CellLista *tmp = posRem->prox;
        relink(posRem, posRem->ant, posRem->prox->prox);
        tmp->prox = tmp->ant = NULL;
        rem = clone(tmp->thisJ);
        free(tmp);
    }
    return rem;
}

//---insercao---//
void inserirInicio(Lista *lista, CellLista *add){
    if (add->thisJ != NULL){
        relink(add, lista->primeiro->prox, lista->primeiro);
        lista->tam++;
    } else {
        puts("Erro - jogador inexistente\n");
    }
}
void inserirFim(Lista *lista, CellLista *add){
    if(add->thisJ != NULL){
        add->ant = lista->ultimo;
        add->prox = NULL;
        lista->ultimo->prox = add;
        lista->ultimo = add;
        lista->tam++;
    } else {
        puts("Erro - jogador inexistente\n");
    }
}
void inserir(Lista *lista, CellLista *add, int pos){
    if(pos > lista->tam){
        puts("Erro - Posicao invalida\n");
    } else if(add->thisJ == NULL){
        puts("Erro - jogador inexistente\n");
    } else {
        CellLista *posIns= lista->primeiro->prox;
        for(int i=0; i<pos; i++){
            posIns = posIns->prox;
        }
        relink(add, posIns->prox, posIns);
        lista->tam++;
    }
}

void printLista(Lista* lista){
    CellLista *j = lista->primeiro->prox;
    int tam = lista->tam;
    for(int i = 0; i < tam; i++, j = j->prox){
        printJogador(j->thisJ, i);
    }
}

void printListaI(Lista* lista){
    CellLista *j = lista->ultimo;
    int tam = lista->tam;
    for(int i = 0; i < tam; i++, j = j->ant){
        printJogador(j->thisJ, i);
    }
}


//---funcoes quickSort---//
int compValores(Jogador* A, Jogador* B){
    int cmp = strcmp(A->estadoNascimento, B->estadoNascimento);
    if(cmp == 0){
        cmp = strcmp(A->nome, B->nome);
    }
    return cmp;
}

void swap(CellLista* a, CellLista* b){
    Jogador* tmp = clone(a->thisJ);
    a->thisJ = clone(b->thisJ);
    b->thisJ = tmp;
}

void quickSort(CellLista *esq, CellLista *dir){
    CellLista *pivo = esq;
    CellLista *i = esq->prox;
    CellLista *j = dir;

    while(i->ant != j && i->ant != j->prox){
        while(i != NULL && compValores(i->thisJ, pivo->thisJ) > 0){
            i = i-> prox;
        }        
        while(compValores(j->thisJ, pivo->thisJ) < 0){
            j = j->ant;
        }

        if(i->ant != j){
            swap(i, j);
            i = i->prox;
            j = j->prox;
        }
    }
    swap(pivo, j);
    if(esq != j) quickSort(esq, j);
    if(j != dir) quickSort(i, dir);
}

void ordenar(Lista* lista){
    quickSort(lista->primeiro->prox, lista->ultimo);
}

//-------------------------------Fim funcoes Lista-----------------------------//

void menuLista(char in[], Lista* lista){
    int param1;
    int param2;
    if(in[0] == 'I'){
        if(in[1] == 'I'){
            scanf("%d", &param1);
            inserirInicio(lista, newCell(lerJogador(param1)));
        } else if(in[1] == 'F'){
            scanf("%d", &param1);
            inserirFim(lista, newCell(lerJogador(param1)));
        } else if(in[1] == '*'){
            scanf("%d %d", &param1, &param2);
            inserir(lista, newCell(lerJogador(param2)), param1);
        }
    } else if(in[0] == 'R'){
        Jogador* rem = NULL;
        if(in[1] == 'I'){
            rem = removerInicio(lista);
        } else if(in[1] == 'F'){
            rem = removerFim(lista);
        } else if(in[1] == '*'){
            scanf("%d", &param1);
            rem = remover(lista, param1);
        }

        if(rem != NULL){
            printf("(R) %s\n", rem->nome);
        }
    }
}

int main() {
    char in[20]; 
    Lista *lista = newLista();

    scanf("%s", in);
    while(strcmp(in, "FIM")){
        inserirFim(lista, newCell(lerJogador(atoi(in))));
        scanf("%s", in);
    }
    ordenar(lista); 
    printLista(lista);
    return 0;
}

