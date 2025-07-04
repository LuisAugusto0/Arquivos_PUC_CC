/**
 * @path TP02Q02 - Classe em C/Player.c
 * @description C file that implements the Player class.
 * @author Pedro Lopes - github.com/httpspedroh
 * @version 1.0
 * @update 2023-09-27
 */

// ---------------------------------------------------------------------------------------------------- //

// Includes
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// ---------------------------------------------------------------------------------------------------- //

// Constants
#define MAX_PLAYERS 4000
#define FILE_PATH "tmp/players.csv"

#define MAX_NAME_SIZE 40
#define MAX_COLLEGE_SIZE 60
#define MAX_BIRTH_CITY_SIZE 40
#define MAX_BIRTH_STATE_SIZE 40

#define MAX_LINE_SIZE 300
#define MAX_ATTRIBUTE_SIZE 100

// ---------------------------------------------------------------------------------------------------- //

// Structs
typedef struct Player {
    int id;
    char *name;
    int height;
    int weight;
    int birthYear;
    char *birthCity;
    char *birthState;
    char *college;
} Player;

// ---------------------------------------------------------------------------------------------------- //

// Global variables
Player players[MAX_PLAYERS];
int playersLength = 0;

// ---------------------------------------------------------------------------------------------------- //

// Functions 
bool isEnd(char* line) { return line[0] == 'F' && line[1] == 'I' && line[2] == 'M'; }

void substring(char *string, char *stringStart, int length) {

    strncpy(string, stringStart, length);
    string[length] = '\0';
}

void proccess_attribute(char *attribute, char **substringStart, char **substringEnd, bool isFirstAttribute) {

    // Skip first comma
    if(!isFirstAttribute) {
        
        if(*substringEnd != NULL) *substringStart = *substringEnd + 1;
        else *substringStart = *substringEnd;
    }

    // Get next comma
    *substringEnd = strchr(*substringStart, ',');
    
    // Get substring
    if(*substringEnd) substring(attribute, *substringStart, *substringEnd - *substringStart);
    else strcpy(attribute, *substringStart);

    // Set default value if attribute is empty
    if(strcmp(attribute, "") == 0 || attribute[0] == '\n' || attribute[0] == '\r' || attribute[0] == '\0') strcpy(attribute, "nao informado");
    
    // Clean \n from the end of the string
    if(attribute[strlen(attribute) - 1] == '\n') attribute[strlen(attribute) - 1] = '\0';
}

// ---------------------------------------------------------------------------------------------------- //

// Methods signatures

// Class
Player player_newBlank();
Player player_new(int id, char *name, int height, int weight, int birthYear, char *birthCity, char *birthState, char *college);
Player *player_clone(Player *player);
void player_print(Player player);
Player player_read(char *line);
Player player_searchById(int id);

// Gets
int player_getId(Player *player);
char *player_getName(Player player);
int player_getHeight(Player player);
int player_getWeight(Player player);
char *player_getCollege(Player player);
int player_getBirthYear(Player player);
char *player_getBirthCity(Player player);
char *player_getBirthState(Player player);

// Sets
void player_setId(Player *player, int id);
void player_setName(Player *player, char *name);
void player_setHeight(Player *player, int height);
void player_setWeight(Player *player, int weight);
void player_setCollege(Player *player, char *college);
void player_setBirthYear(Player *player, int birthYear);
void player_setBirthCity(Player *player, char *birthCity);
void player_setBirthState(Player *player, char *birthState);

// General
void startPlayers();

// ---------------------------------------------------------------------------------------------------- //

// Methods implementations

// Class
Player player_newBlank() {

    Player player;

    player.id = -1;
    player.height = -1;
    player.weight = -1;
    player.birthYear = -1;

    player.name = (char *) calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(player.name, "");

    player.birthCity = (char *) calloc(MAX_BIRTH_CITY_SIZE, sizeof(char));
    strcpy(player.birthCity, "");

    player.birthState = (char *) calloc(MAX_BIRTH_STATE_SIZE, sizeof(char));
    strcpy(player.birthState, "");

    player.college = (char *) calloc(MAX_COLLEGE_SIZE, sizeof(char));
    strcpy(player.college, "");

    return player;
}

Player player_new(int id, char *name, int height, int weight, int birthYear, char *birthCity, char *birthState, char *college) {

    Player player;

    player.id = id;
    player.height = height;
    player.weight = weight;
    player.birthYear = birthYear;

    player.name = (char *) calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(player.name, name);

    player.birthCity = (char *) calloc(MAX_BIRTH_CITY_SIZE, sizeof(char));
    strcpy(player.birthCity, birthCity);

    player.birthState = (char *) calloc(MAX_BIRTH_STATE_SIZE, sizeof(char));
    strcpy(player.birthState, birthState);

    player.college = (char *) calloc(MAX_COLLEGE_SIZE, sizeof(char));
    strcpy(player.college, college);

    return player;
}

Player *player_clone(Player *player) {

    Player *clone = (Player *) malloc(sizeof(Player));

    clone -> id = player -> id;
    clone -> height = player -> height;
    clone -> weight = player -> weight;

    clone -> name = (char *) calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(clone -> name, player -> name);

    clone -> birthCity = (char *) calloc(MAX_BIRTH_CITY_SIZE, sizeof(char));
    strcpy(clone -> birthCity, player -> birthCity);

    clone -> birthState = (char *) calloc(MAX_BIRTH_STATE_SIZE, sizeof(char));
    strcpy(clone -> birthState, player -> birthState);

    clone -> college = (char *) calloc(MAX_COLLEGE_SIZE, sizeof(char));
    strcpy(clone -> college, player -> college);

    return clone;
}

void player_print(Player player) {

    printf(" ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n",
        player.name,
        player.height,
        player.weight,
        player.birthYear,
        player.college,
        player.birthCity,
        player.birthState
    );
}

Player player_read(char *line) {

    Player player = player_newBlank();

    char *substringStart = line;
    char *substringEnd = NULL;
    char attribute[MAX_ATTRIBUTE_SIZE];
   
    // Get id
    proccess_attribute(attribute, &substringStart, &substringEnd, true);
    player_setId(&player, atoi(attribute));
    
    // Get name
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setName(&player, attribute);

    // Get height
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setHeight(&player, atoi(attribute));

    // Get weight
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setWeight(&player, atoi(attribute));

    // Get college
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setCollege(&player, attribute);

    // Get birth year
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setBirthYear(&player, atoi(attribute));

    // Get birth city
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setBirthCity(&player, attribute);

    // Get birth state
    proccess_attribute(attribute, &substringStart, &substringEnd, false);
    player_setBirthState(&player, attribute);

    return player;
}

Player player_searchById(int id) {
    
    Player temp;

    for(int i = 0; i < playersLength; i++) {

        if(player_getId(&players[i]) == id) return players[i];
    }
    return temp;
}

// Gets
int player_getId(Player* player) { return player->id; }
char* player_getName(Player player) { return player.name; }
int player_getHeight(Player player) { return player.height; }
int player_getWeight(Player player) { return player.weight; }
char *player_getCollege(Player player) { return player.college; }
int player_getBirthYear(Player player) { return player.birthYear; }
char *player_getBirthCity(Player player) { return player.birthCity; }
char *player_getBirthState(Player player) { return player.birthState; }

// Sets
void player_setId(Player *player, int id) { player -> id = id; }
void player_setName(Player *player, char *name) { strcpy(player -> name, name); }
void player_setHeight(Player *player, int height) { player -> height = height; }
void player_setWeight(Player *player, int weight) { player -> weight = weight; }
void player_setBirthYear(Player *player, int birthYear) { player -> birthYear = birthYear; }
void player_setBirthCity(Player *player, char *birthCity) { strcpy(player -> birthCity, birthCity); }
void player_setBirthState(Player *player, char *birthState) { strcpy(player -> birthState, birthState); }
void player_setCollege(Player *player, char *college) { strcpy(player -> college, college); }

// General
void startPlayers() {

    // Open file
    FILE *fp;
    char *line = NULL;
    size_t len = 0;
    ssize_t read;

    fp = fopen(FILE_PATH, "r");

    if(fp == NULL) {

        perror("x Error opening file");
        exit(EXIT_FAILURE);
    }

    // Skip first line
    getline(&line, &len, fp);

    // Read all lines
    while((read = getline(&line, &len, fp)) != -1) {

        // Read player from line
        Player player = player_read(line);

        players[playersLength++] = player;

        if(playersLength >= MAX_PLAYERS) {

            perror("x Max players reached");
            exit(EXIT_FAILURE);
        }
    }

    // Close file and free memory
    fclose(fp);

    if(line) free(line);
}

// ---------------------------------------------------------------------------------------------------- //

// Célula

typedef struct{
  Player elemento;
  struct Celula* prox;
} Celula;

//Criando nova Célula

Celula* novaCelula(Player elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}

Celula* primeiraCelula() {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = player_searchById(0);
   nova->prox = NULL;
   return nova;
}

void Inserir(Celula* primeiro, Player jogador){
  if(primeiro->prox != NULL){
  //printf("------------------------- 1 -------------------\n"); --> Verificação de atividade
    Celula* temp = primeiro;
    while(temp->prox != NULL) {
      temp = temp->prox;
    }
    Celula* temp2 = novaCelula(jogador);
    temp->prox = temp2;
    temp = NULL;
  }
  else{
   // printf("------------------------- 2 -------------------\n"); --> Verificação de atividade
    Celula* temp2 = novaCelula(jogador);
    primeiro->prox = temp2;
  }
}
  
 bool procuraNome(Celula* primeiro, Player jogador){
  bool resp = false;
  int teste, i = 0;
  Celula* temp = primeiro->prox;
  // printf("%s\nlaranja\n",jogador.name); --> Verificação de atividade
  while(temp != NULL && resp == false){
    teste = strcmp(jogador.name, temp->elemento.name);
    if(teste == 0){
      resp = true;
    }
    temp = temp->prox;
  }
  return resp; 
}

// ---------------------------------------------------------------------------------------------------- //

//Hash

typedef struct{
  Celula* primeiro;
} Hash;

//Lista de Hash

Hash lista[25];

//Funções de Hash
void inserirHash(Player jogador){
  int altura = jogador.height;
  int pos = altura % 25;
  Inserir(lista[pos].primeiro, jogador);
}

int verificaPos(Player jogador){
  int altura = jogador.height;
  int pos = altura % 25;
  return pos;
}

void verificaJogador(Player jogador){
  int pos = verificaPos(jogador);
  //printf("%i\n%s\nmaçã\n",pos,jogador.name); --> Verificação de atividade
  bool resp = procuraNome(lista[pos].primeiro, jogador);
  if(resp == true){
    printf(" SIM\n");
  }
  else{
    printf(" NAO\n");
  }
  //return resp;
}

void startHash(){
  for(int i = 0;i < 25; i++){
    lista[i].primeiro = primeiraCelula();
  }
}

//---------------------------------------------------------------------------------------------- //

//Funções Acessórias
Player procuraJogador(char* nome){
  Player temp;
  
    for(int i = 0; i < playersLength; i++) {
    
        if(strcmp(nome, players[i].name) == 0){
          temp = player_searchById(i);
        }
    
    }
    //printf("%s\n banana\n",temp.name); --> Verificação de atividade
    return temp;
}




// Main
int main() {

    // ----------------------------------------------------------------- //

    // #1 - Start - Read all players in CSV file
    startPlayers();
    startHash();

    // --------------------------------------------------------------- //
    char in[5];
    char charProblematico[2] = {13};
    scanf(" %[^\n]", in);
    for(int i = 0; !isEnd(in); i++){
      Player temp = player_searchById(atoi(in));
      inserirHash(temp);
      scanf("%s", in);
      in[strcspn(in, charProblematico)] = '\0';
    }
    char in2[20];
    scanf(" %[^\n]", in2);
    in2[strcspn(in2, charProblematico)] = '\0';
    for(int i = 0; !isEnd(in2); i++){
      Player temp = procuraJogador(in2);
      printf("%s",in2);

      verificaJogador(temp);
      scanf(" %[^\n]", in2);
      in2[strcspn(in2, charProblematico)] = '\0';
    }
    return 0;
}

/*int main(v// #2 - Read input and print players from pub.in id entries
    char in[5];
    scanf(" %[^\n]s", in);  
    for(int i = 0; !isEnd(in); i++){
      inserirFim(atoi(in));
    }
    int qtdComandos, cmd, num = -1, num2 = -1;
    scanf("%i",&qtdComandos);
    char *in2 = (char*) malloc(20 * sizeof(char));
    char *comando = (char*) malloc(2 * sizeof(char));
    for(int i = 0; i < qtdComandos; i++){
      printf("limao\n");
      scanf(" %[^\n]s", in2);
      sscanf(in2, "%s %i %i", comando, &num, &num2);
      printf("comando: %s",comando);
      cmd = verificaComando(comando);
      printf("cmd: %i",cmd);
      executaComando(cmd, num, num2);
    }oid){

char* palavra = "testando se funciona";
int i = indexOf(' ', palavra);
char* sub = subString(palavra, indexOf(' ', palavra), 20);
char* sub2 = subString(palavra, 1, 10);
printf("%s\n%i\n%s\n", palavra, i, sub2);
return 0;
}*/
