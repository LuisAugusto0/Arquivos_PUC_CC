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
        this.universidade = universidade;
    }
    void setAnoNascimento(int ano){
        this.anoNascimento = ano;
    }
    void setCidadeNascimento(String cidade){
        this.cidadeNascimento = cidade;
    }
    void setEstadoNascimento(String estado){
        this.estadoNascimento = estado;
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
    void ler(){
        try{
            File file = new File("/tmp/players.csv");
            Scanner arq = new Scanner(file);
            arq.nextLine();
            while(arq.hasNextLine()){
                String aux = arq.nextLine();
                String[] splitted = aux.split(",");
                setId()
            }
        } catch(IOException e){
                
        } 
    }
}
