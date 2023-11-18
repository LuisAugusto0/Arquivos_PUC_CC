import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.util.Scanner;
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
        this(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento, null);
    }

    Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento, Jogador prox){
        this.id = id;
        this.nome = tratarString(nome);
        this.altura = altura;
        this.peso = peso;
        this.universidade = tratarString(universidade);
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = tratarString(cidadeNascimento);
        this.estadoNascimento = tratarString(estadoNascimento);
        this.prox = prox;
    } 

    //metodo que retorna uma copia do Jogador
    public Jogador clone(){
        return new Jogador(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
    }

    //metodo para retornar a String tratada
    public String tratarString(String entrada){
        if(entrada.length() == 0)
            entrada = "nao informado";
        return entrada;
    }
}

class PilhaJogador extends Jogador{
    Jogador primeiro;

    //construtor
    PilhaJogador(){
        primeiro = null;
    }
    
    //metodos de insersao
    public void inserir(Jogador jogador){
        if(primeiro != null){
            jogador.prox = primeiro;
        }
        primeiro = jogador;
        jogador = null;
    }

    //metodos de remocao
    public Jogador remover() throws Exception{
        if(primeiro == null)
            throw new Exception("Lista Vazia");
        Jogador tmp = primeiro;
        primeiro = primeiro.prox;
        tmp.prox = null;
        return tmp;
    }

    //metodo para mostrar na tela
    public void print(){
        int pos = 0;
        PilhaJogador pj = new PilhaJogador();
        for(Jogador i = primeiro; i != null; i = i.prox){
            pj.inserir(i.clone());
        }
        for(Jogador i = pj.primeiro; i != null; i = i.prox, pos++){
            MyIO.println("[" + pos + "]"
                    + " ## " + i.nome
                    + " ## " + i.altura
                    + " ## " + i.peso
                    + " ## " + i.anoNascimento
                    + " ## " + i.universidade
                    + " ## " + i.cidadeNascimento
                    + " ## " + i.estadoNascimento + " ##" );
        }
    }
}

class Q06{
    public static PilhaJogador ps = new PilhaJogador();

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
    
    public static void selecao(String[] entrada){
        try{
            if(entrada[0].toUpperCase().equals("I")){
                ps.inserir( ler(Integer.valueOf(entrada[1])) );         
            }
            else if(entrada[0].toUpperCase().equals("R")){
                Jogador rem;
                rem = ps.remover();
                MyIO.println("(R) " + rem.nome);
            } 
        }catch (Exception e){
            MyIO.println("Um erro ocorreu: " + e.getMessage());
        }

    }
    public static void main(String[] args){
        String entrada = MyIO.readLine();
        try{
            while(!entrada.equals("FIM")){
                Jogador tmp = ler(Integer.valueOf(entrada));
                ps.inserir(tmp);
                tmp = null;
                entrada = MyIO.readLine();
            }
            
            int qtdeMudancas = MyIO.readInt() -1;
            while(qtdeMudancas-- > 0)
                selecao(MyIO.readLine().split(" "));
            selecao("R".split(" "));

            ps.print();

        } catch (Exception e){
            MyIO.println("Um erro ocorreu: " + e.getMessage());
            e.printStackTrace();
        }
        
        
    }

}
