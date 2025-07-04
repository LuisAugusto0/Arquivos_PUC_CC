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

    //construtores
    Jogador(){
        this(0, "", 0, 0, "", 0, "", "");
    }

    Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento){
        this.id = id;
        this.nome = tratarString(nome);
        this.altura = altura;
        this.peso = peso;
        this.universidade = tratarString(universidade);
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = tratarString(cidadeNascimento);
        this.estadoNascimento = tratarString(estadoNascimento);
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

class ListaJogador{
    Jogador[] lista;
    int tam;

    //construtor
    ListaJogador(){
        tam = 0;
        lista = new Jogador[5000];
    }
    
    //metodos de insersao
    public void inserirInicio(Jogador jogador){
        for(int i=tam-1; i>=0; i--){
            lista[i+1] = lista[i].clone();
        } 
        lista[0] = jogador;

        tam++;
    }
    public void inserirFim(Jogador jogador){
        lista[tam] = jogador;

        tam++;
    }
    public void inserir(Jogador jogador, int pos) throws Exception{
        if(pos > tam)
            throw new Exception("Posicao invalida");
        for(int i=tam; i>pos; i--)
            lista[i] = lista[i-1];
        lista[pos] = jogador;
        
        tam++;
    }

    //metodos de remocao
    public Jogador removerInicio() throws Exception{
        if(tam == 0)
            throw new Exception("Lista Vazia");
        Jogador rem = lista[0].clone();
        for(int i = 0; i<tam-1; i++){
            lista[i] = lista[i+1];
        }
        tam--;
        return rem;
    }
    public Jogador removerFim() throws Exception{
        if(tam == 0)
            throw new Exception("Lista Vazia");
        Jogador rem = lista[tam-1].clone();
        tam--;
        return rem;
    }
    public Jogador remover(int pos) throws Exception{
        if(tam == 0)
            throw new Exception("Lista Vazia");
        else if(pos >= tam)
            throw new Exception("Posicao invalida");
        
        Jogador rem = lista[pos].clone();
        for(int i = pos; i < tam-1; i++){
            lista[i] = lista[i+1];
        }

        tam--;
        return rem;
    }

    //metodo para mostrar na tela
    public void print(){
        for(int pos = 0; pos < tam; pos++){
            Jogador i = lista[pos];
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

class Q01{
    public static ListaJogador ls = new ListaJogador();

    public static Jogador ler(int id) throws Exception{
        Jogador leitura = null;
        try{
            BufferedReader bf = new BufferedReader( new FileReader( new File("tmp/players.csv") ) );
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
            if(entrada[0].equals("II")){
                ls.inserirInicio( ler(Integer.valueOf(entrada[1])) );         
            }
            else if(entrada[0].equals("IF")){
                ls.inserirFim( ler(Integer.valueOf(entrada[1])) );    
            }
            else if(entrada[0].equals("I*")){
                ls.inserir( ler(Integer.valueOf(entrada[2])), Integer.valueOf(entrada[1]) );
            }
            else if(entrada[0].equals("RI")){
                Jogador rem;
                rem = ls.removerInicio();
                MyIO.println("(R) " + rem.nome);
            }
            else if(entrada[0].equals("RF")){
                Jogador rem;
                rem = ls.removerFim();
                MyIO.println("(R) " + rem.nome);
 
            } 
            else if(entrada[0].equals("R*")){
                Jogador rem;
                rem = ls.remover(Integer.valueOf(entrada[1]));
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
                ls.inserirFim(tmp);
                tmp = null;
                entrada = MyIO.readLine();
            }
            
            int qtdeMudancas = Integer.valueOf(MyIO.readLine());
            for(int i=0; i < qtdeMudancas; i++)
                selecao(MyIO.readLine().split(" "));
            

            ls.print();

        } catch (Exception e){
            MyIO.println("Um erro ocorreu: " + e.getMessage()); 
        }
        
        
    }

}
