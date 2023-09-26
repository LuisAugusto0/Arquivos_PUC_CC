import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;


class Jogador{
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;
    
    Jogador(){
        
    }

    Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento){
        setId(id);
        setNome(nome);
        setAltura(altura);
    }

    //metodos set
    void setId(int id){
        this.id = id;
    }
    void setNome(String nome){
        this.nome = nome;
    }
    void setAltura(int altura){
        this.altura = altura;
    }
    void setPeso(int peso){
        this.peso = peso;
    }
    void setUniversidade(String universidade){
       if(universidade == ""){
            this.estadoNascimento = "nao informado";
        } else {
            this.universidade = universidade;
        }
    }
    
    void setAnoNascimento(int ano){
        this.anoNascimento = ano;
    }
    void setCidadeNascimento(String cidade){
        if(cidade == ""){
            this.estadoNascimento = "nao informado";
        } else {
            this.cidadeNascimento = cidade;
        }
    }
    void setEstadoNascimento(String estado){
        if(estado == ""){
            this.estadoNascimento = "nao informado";
        } else {
            this.estadoNascimento = estado;
        }
    }

    //metodos get
    int getId(){
        return id;
    }
    String getNome(){
        return nome;
    }
    int getAltura(){
        return altura;
    }
    int getPeso(){
        return peso;
    }
    String getUniversidade(){
        return universidade;
    }
    int getAnoNascimento(){
        return anoNascimento;
    }
    String getCidadeNascimento(){
        return cidadeNascimento;
    }
    String getEstadoNascimento(){
        return estadoNascimento;
    }

    //metodo de leitura
    Jogador[] ler(){
        try{
            File file = new File("/tmp/players.csv");
            Scanner arq = new Scanner(file);

            Jogador[] conjunto;
            int cont = 0;

            arq.nextLine(); //pular primeira linha das informações das colunas

            while(arq.hasNextLine()){
                String aux = arq.nextLine();
                String[] splitted = aux.split(",");
                for(int i=0; i<8; i++){
                    if(splitted[i] == ""){
                        splitted[i] = "nao informado";
                    }
                }
                
                conjunto[cont] = new Jogador()
            }
        } catch(IOException e){
                
        } 
    }
}
