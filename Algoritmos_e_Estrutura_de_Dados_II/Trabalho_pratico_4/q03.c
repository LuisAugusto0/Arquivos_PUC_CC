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

//-----------------Fim-funcoes-Jogador----------------//

struct No{
    struct No *esq;
    Jogador *thisJ;
    struct No *dir;
    int nivel;
};
typedef struct No No;

//---------------------Funções-No--------------------//

int getNivel(No *no){
    int resultado = 0;
    if(no != NULL){
        resultado = no->nivel;
    }
    return resultado;
}

void setNivel(No *no){
    int esq = getNivel(no->esq);
    int dir = getNivel(no->dir);
    if(esq > dir)
        no->nivel = 1 + esq;
    else
        no->nivel = 1 + dir;
}

No* newNo(Jogador *j){
    
    No *new = (No*) malloc(sizeof(No));
    new->thisJ = j;
    new->esq = new->dir = NULL;
    new->nivel = 1;
    return new;
}



//-------------------Fim-funções-No------------------//

struct ArvoreAvl{
    No *raiz;
};
typedef struct ArvoreAvl ArvoreAvl;

//----------------Funcoes-Arvore-AVL-----------------//

 //----Funcao-de-pesquisa----//
bool search(char *nome, ArvoreAvl *arv){
    No* pesquisa = arv->raiz;
    bool resultado = false;

    printf("raiz ");
    while(pesquisa != NULL){
        if( strcmp(nome, pesquisa->thisJ->nome) < 0){
	    printf("esq "); 
            pesquisa = pesquisa->esq;
        } else if ( strcmp(nome, pesquisa->thisJ->nome) > 0 ){
	    printf("dir ");
            pesquisa = pesquisa->dir;
        } else {
            pesquisa = NULL;
            resultado = true;
        }
    }
    return resultado;
}


//----Insercao/balanceamento----//

No* rotacionarDir(No *no){
    No *tmpEsqDir = no->esq->dir;
    no->esq->dir = no; //apontar o filho para o pai 
    no = no->esq; //atualizar o pai
    no->dir->esq = tmpEsqDir; //apontar corretamente a esquerda do novo filho

    //atualizar nivel (pai e filho)
    setNivel(no->dir);
    setNivel(no);
    return no;
}

No* rotacionarEsq(No *no){
    No *tmpDirEsq = no->dir->esq;
    no->dir->esq = no; //apontar o filho para o pai 
    no = no->dir; //atualizar o pai
    no->esq->dir = tmpDirEsq; //apontar corretamente a direita do novo filho

    //atualizar nivel (pai e filho)
    setNivel(no->esq);
    setNivel(no);
    return no;
}

No* balancear(No *no){
    if(no != NULL){
        int fator = getNivel(no->dir) - getNivel(no->esq);
        //Se balanceada atualizar nivel atual
        if(abs(fator) <= 1){
            setNivel(no);
        //se desbalanceada para direita testar o fator do filho para decidir como realizar a rotacao
        } else if (fator == 2) {
            int fatorFilho = getNivel(no->dir->dir) - getNivel(no->dir->esq);
            if(fatorFilho == -1){
               no->dir = rotacionarDir(no->dir); 
            }
            no = rotacionarEsq(no);
        //se desbalanceada para esquerda testar o fator do filho para decidir como realizar a rotacao
        } else if (fator == -2){
            int fatorFilho = getNivel(no->esq->dir) - getNivel(no->esq->esq);
            if(fatorFilho == 1){
                no->esq = rotacionarEsq(no->esq);
            }
            no = rotacionarDir(no);
        } else {
            printf("Erro no No (Jogador - %s) com fator de balanceamento %d invalido\n", no->thisJ->nome, fator);
        } 
    }
    
    return no;
}

No* insertJogador(Jogador *add, No *i){
    if(i == NULL){
        i = newNo(add);
    } else if( strcmp(add->nome, i->thisJ->nome ) < 0){
        i->esq = insertJogador(add, i->esq);
    } else if( strcmp(add->nome, i->thisJ->nome) > 0){
        i->dir = insertJogador(add, i->dir);
    } else {
        printf("Erro: valor existente\n");
    }
    return balancear(i);
}
void insert(Jogador *add, ArvoreAvl *arv){
    arv->raiz = insertJogador(add, arv->raiz);
} 


//--------------Fim-funcoes-Arvore-AVL---------------//


int main() {
    ArvoreAvl* arv = (ArvoreAvl*) malloc(sizeof(ArvoreAvl));
    char in[50];

    scanf("%s", in);
    while(strcmp(in, "FIM")){
        Jogador* tmp = lerJogador(atoi(in));
        if(tmp != NULL){
            insert(tmp, arv);
        } else {
	    	printf("Erro: id invalido");
		}
        scanf("%s", in);
    }

    fgetc(stdin);
    scanf("%[^\n]", in);
    while(strcmp(in, "FIM")){    
        printf("%s ", in);
        if(search(in, arv)){
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
        fgetc(stdin);
        scanf("%[^\n]", in);
    }


    return 0;
}
