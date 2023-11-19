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
        setAll(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
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

    //metodo para set de todos elementos
    public void setAll(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento){
        this.id = id;
        this.nome = tratarString(nome);
        this.altura = altura;
        this.peso = peso;
        this.universidade = tratarString(universidade);
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = tratarString(cidadeNascimento);
        this.estadoNascimento = tratarString(estadoNascimento);
    }
}

class CellLista{
    public CellLista ant;
    public Jogador thisJ;
    public CellLista prox;

    //construtores
    CellLista(){
        this(null, new Jogador(), null);
    }
    CellLista(Jogador centro){
        this(null, centro, null);
    }
    CellLista(CellLista ant, Jogador thisJ, CellLista prox){
        this.ant = ant;
        this.thisJ = thisJ;
        this.prox = prox;
    }

    //metodo que retorna um clone da celula atual
    public CellLista clone(){
        return new CellLista(ant, thisJ, prox);
    }
    
    //metodo para refazer a conexao entre as estruturas
    public void relink(CellLista ant, CellLista prox){
        this.ant = ant;
        if(ant != null) ant.prox = this;
        this.prox = prox;
        if(prox != null) prox.ant = this;
    }
}

class ListaJogador{
    CellLista primeiro;
    CellLista ultimo;
    int tam;

    //construtor
    ListaJogador(){
        tam = 0;
        primeiro = ultimo = new CellLista();
    }
    
    //metodos de insersao
    public void inserirInicio(CellLista add){
        add.relink(primeiro, primeiro.prox);
        if(primeiro == ultimo)
            ultimo = primeiro.prox;
        add = null;
        tam++;
    }
    public void inserirFim(CellLista add){
        add.prox = null;
        add.ant = ultimo;
        ultimo.prox = add;
        ultimo = add;

        tam++;
    }
    public void inserir(CellLista add, int pos) throws Exception{
        if(pos > tam)
            throw new Exception("Posicao invalida");
        else if(tam == 0)
            ultimo = add;
        CellLista posIns = primeiro;
        for(int i=0; i<pos; i++)
            posIns = posIns.prox;
        add.relink(posIns, posIns.prox);
        
        tam++;
    }

    //metodos de remocao
    public Jogador removerInicio() throws Exception{
        if(primeiro == ultimo)
            throw new Exception("Lista Vazia");
        CellLista tmp = primeiro;
        primeiro = primeiro.prox;
        primeiro.ant = null;
        tmp.prox = null;
        tmp = null;
        tam--;
        return primeiro.thisJ;
    }
    public Jogador removerFim() throws Exception{
        if(primeiro == ultimo)
            throw new Exception("Lista Vazia");
        CellLista tmp = ultimo;
        ultimo = ultimo.ant;
        ultimo.prox = null;
        tmp.ant = null;
        tam--;
        return tmp.thisJ;
    }
    public Jogador remover(int pos) throws Exception{
        if(primeiro == ultimo)
            throw new Exception("Lista Vazia");
        else if(pos >= tam)
            throw new Exception("Posicao invalida");
        else if(primeiro.prox == ultimo){
            ultimo = primeiro;
        }
        CellLista posRem = primeiro;
        for(int i=0; i<pos; i++)
            posRem = posRem.prox;
        CellLista rem = posRem.prox;
        posRem.relink(posRem.ant, posRem.prox.prox);
        rem.prox = rem.ant = null;
        tam--;
        return rem.thisJ;
    }

    //metodo para mostrar na tela
    public void print(){
        int pos = 0;
        for(CellLista i = primeiro.prox; i != null; i = i.prox, pos++){
            Jogador j = i.thisJ;
            MyIO.println("[" + pos + "]"
                    + " ## " + j.nome
                    + " ## " + j.altura
                    + " ## " + j.peso
                    + " ## " + j.anoNascimento
                    + " ## " + j.universidade
                    + " ## " + j.cidadeNascimento
                    + " ## " + j.estadoNascimento + " ##" );
        }
    }
    public void printI(){
         int pos = 0;
         for(CellLista i = ultimo; i.ant != null; i = i.ant, pos++){
             Jogador j = i.thisJ;
             MyIO.println("[" + pos + "]"
                     + " ## " + j.nome
                     + " ## " + j.altura
                     + " ## " + j.peso
                     + " ## " + j.anoNascimento
                     + " ## " + j.universidade
                     + " ## " + j.cidadeNascimento
                     + " ## " + j.estadoNascimento + " ##" );
         }
     }

    // Metodo para ordenar a fila dupla usando QuickSort
    void swap(CellLista a, CellLista b){
        Jogador tmp = a.thisJ.clone();
        a.thisJ = b.thisJ;
        b.thisJ = tmp;
    }
    int compValores(Jogador a, Jogador b){
        int resultado = a.estadoNascimento.compareTo(b.estadoNascimento);
        if( resultado == 0 ){
            resultado = a.nome.compareTo(b.nome);
        }
        return resultado;
    }

    void quickSort(CellLista esq, CellLista dir){
        CellLista pivo = esq;
        CellLista i = esq.prox, j = dir; //atributos que irão modificar na execucao
        while(i.ant != j && i.ant != j.prox){
            while(compValores(i.thisJ, pivo.thisJ) < 0){
                i = i.prox;
            }
            while(compValores(j.thisJ, pivo.thisJ) > 0){
                j = j.ant;
            }
            
            if(i.ant != j){
                swap(i, j);            
                i = i.prox;
                j = j.ant;
            }
        }
        swap(pivo, j);
        if(j != esq) quickSort(esq, j);
        if(i != dir) quickSort(i, dir);
    }

    public void ordenaFilaDupla() {
        if(primeiro.prox != null && primeiro.prox != ultimo)
            quickSort(primeiro.prox, ultimo);
    }
}

class Q11{
    public static ListaJogador ls = new ListaJogador();

    public static CellLista ler(int id) throws Exception{
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

        return new CellLista(leitura);
    }
    
    public static void main(String[] args){
        String entrada = MyIO.readLine();
        try{
            while(!entrada.equals("FIM")){
                CellLista tmp = ler(Integer.valueOf(entrada));
                ls.inserirInicio(tmp);
                tmp = null;
                entrada = MyIO.readLine();
            }
            
            ls.ordenaFilaDupla();

            ls.print();

        } catch (Exception e){
            MyIO.println("Um erro ocorreu: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
