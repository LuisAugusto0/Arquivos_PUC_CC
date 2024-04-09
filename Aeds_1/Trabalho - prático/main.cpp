#include <iostream>
#include <stdbool.h>
#include <string.h>

using namespace std;

// declaração de constantes globais
const int MaxAlunos = 10;
const int MaxProfessores = 10;
const int MaxString = 30;

class Data { // início classe Data
private:
  int dia;
  int mes;
  int ano;

public:
  // funções set //
  void setDia(int dia, int mes, int ano) {
      switch (mes){ //Tratamento de excessão para cada mês (já que os dias alteram dependendo do mês)

        case 1: //janeiro
        case 3: //março
        case 5: //maio
        case 7: //julho
        case 8: //agosto
        case 10: //outubro
        case 12: //dezembro
            if (dia>31 || dia<0) throw runtime_error("Valor de dia incorreto");
            break;


        case 4: //Abril
        case 6: // Junho
        case 9: //Setembro
        case 11: //Novembro
            if (dia>30 || dia<0) throw runtime_error("Valor de dia incorreto");
            break;


        case 2: //fevereiro
            bool EhBissexto;
            if (ano%400 == 0){
                EhBissexto = true;
            } else{
                EhBissexto = ano%4==0  &&  ano%100==0;
            }

            if (EhBissexto){
                if (dia>29 || dia<0) throw runtime_error("Valor de dia incorreto");
            } else{
                if (dia>28 || dia<0) throw runtime_error("Valor de dia incorreto");
            }
            break;
      }//fim switch case

      this->dia = dia;
  }//fim setDia

  void setMes(int mes) {
      mes = mes;
      if(mes<0 || mes>12) throw runtime_error("Valor de mês incorreto");
      this->mes = mes;
    }//fim setMes

  void setAno(int ano) {
      if(ano<1930 || ano>2023) throw runtime_error("Valor do ano incorreto (intervalo entre 1930 e 2023 apenas aceito)");
      this->ano = ano;
    }//fim setAno

    void setData(int dia, int mes, int ano) {
        setDia(dia, mes, ano);
        setMes(mes);
        setAno(ano);
    }//fim setData


  // funções get //
  int getDia() { return this->dia; }
  int getMes() { return this->mes; }
  int getAno() { return this->ano; }


  // função para imprimir na tela //
  void printData() {
    printf("Data: %i/%i/%i, ", getDia(), getMes(), getAno());
  }

  // função para ler data //
  void lerData() {
    int dia, mes, ano;
    scanf("%i/%i/%i", &dia, &mes, &ano);
    setData(dia, mes, ano);
  }
  // Verificar se o mes é igual //
  bool mesIgual(int mes) {
    bool iguais = false;
    if (this->mes == mes) {
      iguais = true;
    }
    return iguais;
  }
}; // Fim classe Data

class Pessoa { // início classe Pessoa
private:
  char nome[MaxString];
  Data nascimento;

public:
  // construtor //
  Pessoa() {
    readNome();
    readNascimento();
  }
  // funções set //
  void setNome(char nome[]) {
    int c;
    strcpy(this->nome, nome);
  }
  // funções get //
  char getNome(int pos){
    return this->nome[pos];
  }

  // função para ler parâmetros //
  void readNome() {
    char nome[MaxString];
    cin.ignore();
    cout << endl << "Digite o nome: ";
    fgets(nome, MaxString, stdin);
    setNome(nome);
  } //fim readNome

  void readNascimento() {
    cout << endl << "Escreva a data de nascimento [dd/mm/aa]: ";
    nascimento.lerData();
  }//fim readNascimento

  // função para imprimir na tela //
  virtual void printPessoa() {
    char nome[MaxString];
    strcpy(nome, this->nome);

    cout << "\nNome: " << nome;
    nascimento.printData();
  }

  // função para testar se é aniversariante //
  bool aniversariante(int mes){
    return nascimento.mesIgual(mes);
  }
}; // Fim classe Pessoa

class Aluno : public Pessoa {
private:
  int matricula;
  int classe;
public:
  static int pos;

  // construtor //
  Aluno():Pessoa(){
    if (pos == MaxAlunos) throw runtime_error("Quantidade de alunos chegou ao limite, não é possível criar novo aluno");
    readMatricula();
    readClasse();
    pos++;
  }
  // funções set //
  void setMatricula(int matricula){
    if (matricula/100000 == 0 || matricula/1000000 != 0) throw runtime_error("Matrícula incorreta, deve ser um número de 6 dígitos.");
    this->matricula = matricula;
  }//fim setMatricula
  void setClasse(int classe){
    if(classe<0 || classe>1000) throw runtime_error("Classe informada incorretamente");
    this->classe = classe;
  }//fim setClasse

  // funções get //
  int getMatricula(){
    return this->matricula;
  }
  int getClasse(){
    return this->classe;
  }

  // funções de leitura //
  void readMatricula(){
    int matricula;
    cout << endl << "Escreva o numero da matricula (Sequência de 6 numeros): ";
    scanf("%i", &matricula);
    setMatricula(matricula);
  }
  void readClasse(){
    int Classe;
    cout << endl << "Escreva o numero da classe (valor menor que 1000): ";
    scanf("%i", &Classe);
    setClasse(Classe);
  }
  // função para imprimir na tela //
  void printPessoa(){
    Pessoa::printPessoa();
    cout <<endl<< "Matricula: " << getMatricula();
    cout <<endl<< "Classe :" << getClasse();
  }
};
class Professor : public Pessoa {
private:
  char titulacao[MaxString];
public:
  static int pos;
  Professor():Pessoa(){
    if (pos == MaxProfessores) throw runtime_error("Quantidade de professores chegou ao limite, não é possível criar novo professor");
    readTitulo();
    pos++;
  }
  // funções set //
  void setTitulo(char titulacao[]){
    char especialista[] = "especialista";
    char mestre[] = "mestre";
    char doutor[] = "doutor";

    for (int c=0; c < strlen(titulacao)-1; c++){
        if(mestre[c]!=titulacao[c] && doutor[c]!=titulacao[c] && especialista[c]!=titulacao[c]) throw runtime_error("Valor de titulação incorreto");
    }
    for (int c=0; c < strlen(titulacao); c++) {
      this->titulacao[c] = titulacao[c];
    }
  }//fim setTitulo

  // funções get //
  char getTitulo(int pos){
    return this->titulacao[pos];
  }
  // funções gerais //
  void readTitulo(){
    char titulacao[MaxString];
    cout << endl << "Digite a titulacao correspondente (especialista, mestre ou doutor): ";
    cin.ignore();
    fgets(titulacao, MaxString, stdin);
    setTitulo(titulacao);
  }
  // função para imprimir na tela //
  void printPessoa(){
    char Titulo[MaxString];
    Pessoa::printPessoa();
    strcpy(Titulo, this->titulacao)
    cout << endl << "Titulacao: " << Titulo;
  }
};

// declaração variáveis estáticas //
int Aluno::pos = 0;
int Professor::pos = 0;

// protótipos das funções //
int menu();
void novoAluno(Aluno* alunos[]);
void novoProfessor(Professor* professores[]);
void listaAlunos(Aluno* alunos[]);
void listaProfessores(Professor* professores[]);
void listaAniversariantes(Aluno* alunos[], Professor* professores[]);

int main() {
  Aluno *alunos[MaxAlunos];
  Professor *professores[MaxProfessores];
  int opcao;


  do {
    try{
      opcao = menu();
      switch (opcao) {
      case 0:
        puts("Programa finalizado");
        break;
      case 1:
        novoAluno(alunos);
        break;
      case 2:
        novoProfessor(professores);
        break;
      case 3:
        listaAlunos(alunos);
        break;
      case 4:
        listaProfessores(professores);
        break;
      case 5:
        listaAniversariantes(alunos, professores);
        break;
      default:
        cout << "Valor Invalido" << endl;
      }
    }
    catch(runtime_error e){
        cout << endl << "Ocorreu um erro durante a execução do codigo. Codigo de erro: " <<e.what() << endl << endl;

    }
    catch(...){
        cout << "Ocorreu um erro indefinido durante a execução do codigo";
    }
  } while (opcao != 0);

  return 0;
}//fim main



int menu(){
  int escolha;
  cout << endl << "Digite o que deseja fazer:"
       << endl << endl << "[0] - Sair do programa"
       << endl << "[1] - Cadastrar aluno"
       << endl << "[2] - Cadastrar Professor"
       << endl << "[3] - Listar aluno"
       << endl << "[4] - Listar Professor"
       << endl << "[5] - Listar todos os aniversariantes desse mes"<<endl<<endl;
  scanf("%i", &escolha);
  return escolha;
}//fim menu

void novoAluno(Aluno* alunos[]){
  alunos[Aluno::pos-1] = new Aluno();
}//fim novoAluno

void novoProfessor(Professor* professores[]){
  professores[Professor::pos-1] = new Professor();
}//fim novoProfessor

void listaAlunos(Aluno* alunos[]){

  cout << endl <<"\tAlunos registrados:"<<endl;
  for(int i=0; i<Aluno::pos; i++){
    cout << endl <<"-----------------------------------------------"<<endl;
    alunos[i]->printPessoa();
    cout << endl <<"-----------------------------------------------"<<endl;
  }
  cout << endl<< endl;
}//fim listaAlunos

void listaProfessores(Professor* professores[]){

  cout << endl <<"\tProfessores registrados:"<<endl;
  for(int i=0; i<Professor::pos; i++){
    cout << endl <<"-----------------------------------------------"<<endl;
    professores[i]->printPessoa();
    cout << endl <<"-----------------------------------------------"<<endl;
  }
  cout << endl<< endl;
}//fim listaProfessores

void listaAniversariantes(Aluno* alunos[], Professor* professores[]){
  system("clear||cls"); //comando apenas estético para limpar o console

  Pessoa* pessoas[MaxAlunos+MaxProfessores];
  bool valorInvalido;
  int mes;

  // Armazenando os ponteiros de alunos e professores em *pessoas[] //
  for (int i=0; i < Aluno::pos; i++){
    pessoas[i] = alunos[i];
  }
  for (int i=Aluno::pos; i < (Aluno::pos + Professor::pos); i++){
     pessoas[i+Aluno::pos] =  professores[i];
  }
  do{
    try{
        cout<<"Digite o mes em que estamos (numero): ";
        scanf("%i", &mes);
        valorInvalido = mes<1 || mes>12;

        if(valorInvalido) throw runtime_error("Valor de mes invalido");
    }
    catch (runtime_error e){
        cout << "Erro: " << e.what();
    }
  }while (valorInvalido);

  cout << "Aniversariantes:" <<endl;

  cout << endl << "Alunos:";
  for(int i=0; i < (Aluno::pos + Professor::pos); i++){
    if(i==Aluno::pos) cout << endl << "Professores:";
    if(pessoas[i]->aniversariante(mes)){
      cout << endl <<"-----------------------------------------------"        <<endl;
      pessoas[i]->printPessoa();
      cout << endl <<"-----------------------------------------------"         <<endl;
    }
  }
  cout << endl<< endl;
}//fim listaAniversariante
