import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
class Jogador{
    public int id;
    public String nome;
    public int altura;
    public int peso;
    public String universidade;
    public int anoNascimento;
    public String cidadeNascimento;
    public String estadoNascimento;
    Jogador prox;

    //construtores
    Jogador(){
        this(0, "", 0, 0, "", 0, "", "");
    }
    Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento){
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
        this.prox = null;
    }
    Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento, Jogador prox){
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
        this.prox = prox;
    } 

    //metodo que retorna uma copia do Jogador
    public Jogador clone(){
        return new Jogador(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
    }
}

class ListaJogador{
    Jogador primeiro;
    Jogador ultimo;
    int tam;

    //construtor
    ListaJogador(){
        primeiro = ultimo = new Jogador();
    }
    
    //metodos de insersao
    public void inserirprimeiro(Jogador jogador){
        if(ultimo == primeiro)
             primeiro.prox = jogador;
        jogador.prox = primeiro.prox;
        primeiro.prox = jogador;
        jogador = null;

        tam++;
    }
    public void inserirultimo(Jogador jogador){
        jogador.prox = null;
        ultimo.prox = jogador;
        ultimo = jogador;

        tam++;
    }
    public void inserir(Jogador jogador, int pos) throws Exception{
        if(pos > tam)
            throw new Exception("Posicao invalida");
        Jogador posIns = primeiro;
        for(int i=0; i<pos; i++)
            posIns = posIns.prox;
        jogador.prox = posIns.prox;
        posIns.prox = jogador;
        jogador = null;

        tam++;
    }

    //metodos de remocao
    public Jogador removerInicio() throws Exception{
        if(primeiro == ultimo)
            throw new Exception("Lista Vazia");
        Jogador tmp = primeiro;
        primeiro = primeiro.prox;
        tmp.prox = null;
        tmp = null;
        tam--;
        return primeiro;
    }
    public Jogador removerFim() throws Exception{
        if(primeiro == ultimo)
            throw new Exception("Lista Vazia");
        Jogador i;
        for(i = primeiro; i.prox != ultimo; i = i.prox);
        ultimo = i;
        i = ultimo.prox;
        ultimo.prox = null;
        tam--;
        return i;
    }
    public Jogador remover(int pos) throws Exception{
        if(primeiro == ultimo)
            throw new Exception("Lista Vazia");
        else if(pos <= tam)
            throw new Exception("Posicao invalida");
        Jogador posRem = primeiro;
        for(int i=0; i<pos; i++)
            posRem = posRem.prox;
        Jogador rem = posRem.prox;
        posRem.prox = posRem.prox.prox;
        rem.prox = null;
        return rem;
    }
}

class Q01{
    public static Jogador ler(int id) throws Exception{
        Jogador leitura = null;
        try{
            BufferedReader bf = new BufferedReader( new FileReader( new File("/tmp/players.csv") ) );
            String l = null;
            String[] s = null;
            //Leitura inicial para pular primeira linha
            bf.readLine();
            while( (l = bf.readLine()) != null && Integer.valueOf((s = l.split(",", 8))[0]) != id);

            //Se l for nulo chegou no final do arquivo e nao encontrou o id buscado, sendo assim necessario interromper o fluxo
            if(l == null)
                throw new Exception("ID nao encontrado");
            
            //Criacao jogador
            leitura = new Jogador(Integer.valueOf(s[0]), s[1], Integer.valueOf(s[2]), Integer.valueOf(s[3]), s[4], Integer.valueOf(s[5]), s[6], s[7]);
            
            bf.close();
        } catch (FileNotFoundException e){
            MyIO.println("Arquivo nao aberto");
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return leitura;
    }

    public static void main(String[] args){
        
    }

}
