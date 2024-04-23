#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
    
#define TAM 60
#define DIR "/tmp/players.csv"

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

//--------------------Funcoes-Jogador------------------//
  //----funções set---//
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

  //----funcao clone----//
  Jogador* clone(Jogador *j){
      Jogador* jClone = (Jogador*) malloc(sizeof(Jogador));
      setAll(j->id, j->nome, j->altura, j->peso, j->universidade, j->anoNascimento, j->cidadeNascimento, j->estadoNascimento, jClone);
      return jClone;
  }

  //----funcao split----//
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


  //----funcao de leitura----//
  Jogador* lerJogador(int id){
      Jogador* jogador = NULL;

      FILE* arq = fopen(DIR, "r");
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

//-----------------Fim-funcoes-Jogador----------------/

struct No{
    struct No *prox;
    Jogador *thisJ;
};
typedef struct No No;

//----------------Funcoes-No------------------------//

No* newNo(Jogador* add){
    No* new = (No*) malloc(sizeof(No));
    new->thisJ = add;
    return new;
}

//---------------Fim-funcoes-No-------------------//

struct Lista{
    No* primeiro;
    No* ultimo;
};
typedef struct Lista Lista;

//--------------------Funcoes-Lista-----------------//

Lista* newLista(){
    Lista *lista = (Lista*) malloc(sizeof(Lista));
    lista->primeiro = lista->ultimo = (No*) malloc(sizeof(No));
    return lista;
}

void insertLista(Jogador* add, Lista* lista){
    lista->ultimo->prox = newNo(add);
    lista->ultimo = lista->ultimo->prox;
}

bool searchLista(char *nome, Lista *lista){
    bool resultado = false;
    No* i = lista->primeiro->prox;
    while(i != lista->ultimo){
        if(strcmp(nome, i->thisJ->nome) == 0){
            resultado = true;
            i = lista->ultimo;
        } else {
            i = i->prox;
        }
    }
    if(strcmp(nome, i->thisJ->nome) == 0)
            resultado = true;

    return resultado;
}

//----------------Fim-funcoes-Lista---------------//

struct Hash{
    Lista **vetor;
}; 
typedef struct Hash Hash;

//------------------funcoes-Hash---------------------//
static int tamTab = 25;

Hash* newHash(){
    Hash *hash = (Hash*) malloc(sizeof(Hash));
    hash->vetor = (Lista**) malloc(tamTab*sizeof(Lista*));
    return hash;
}

void insertHash(Jogador *add, Hash *hash){
    if(hash->vetor[add->altura % tamTab] == NULL)
        hash->vetor[add->altura % tamTab] = newLista();
    insertLista(add, hash->vetor[add->altura % tamTab]);
}

bool searchHash(char* nome, Hash *hash){
    bool resultado = false;
    for(int i=0; i<tamTab; i++){
        if(hash->vetor[i] != NULL){
            //printf("%b\n", searchLista(nome, hash->vetor[i]));
            if(searchLista(nome, hash->vetor[i])){
                resultado = true;
                i = tamTab;
            }
        }
    }
    return resultado;
}


int main() {
    Hash* hash = newHash();
    char in[50];
    char charProblematico[2] = {'\r'};

    scanf("%[^\n]\n", in);
    in[strcspn(in, charProblematico)] = '\0';
    while(strcmp(in, "FIM")){
        Jogador* tmp = lerJogador(atoi(in));
        if(tmp != NULL){
            insertHash(tmp, hash);
        } else {
	    	printf("Erro: id invalido");
		}
        scanf("%[^\n]\n", in);
        in[strcspn(in, charProblematico)] = '\0';
    }
   
    scanf("%[^\n]\n", in);
    in[strcspn(in, charProblematico)] = '\0';
    while(strcmp(in, "FIM") && in[0] != 4 ){ 
        printf("%s ", in);
        if(searchHash(in, hash)){
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
        scanf("%[^\n]\n", in);
        in[strcspn(in, charProblematico)] = '\0';
    }

    return 0;
}
