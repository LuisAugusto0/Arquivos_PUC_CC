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

class No {
    public char elemento;
    public final int TAM = 256;
    public No[] prox;
    public boolean folha;


    //construtores
    No(){
        this(' ');
    }
    No(char elemento){
        this.elemento = elemento;
        prox = new No[TAM]; 
        folha = false;
    }

    public No createLink(char elemento){
        prox[elemento] = new No(elemento);
        return prox[elemento];

    }

    public No search(char elemento){
        return prox[elemento];
    }

}

class ArvoreTrie{
    No raiz;
    
    //construtor
    ArvoreTrie(){
        raiz = new No();
    }

    //insert
    public void insert(String add) throws Exception{
        int pos = -1;
        int limite = add.length() - 1;
        No j = raiz;

        //executa tam-1 vezes
        while(++pos < limite){
            No prox = j.search(add.charAt(pos));
            if( prox != null ) {
                if( prox.folha == false)
                    j = prox;
                else 
                    throw new Exception("Erro ao inserir: folha encontrada no meio do caminho");
            } else {
                j = j.createLink(add.charAt(pos));
            }
            prox = null;
        }
        
        //ultimo caractere
        No prox = j.search(add.charAt(pos));
        if( prox != null ) {
            if( prox.folha == false)
                throw new Exception("Erro ao inserir: elemento com prefixo existente");
            else
                throw new Exception("Erro ao inserir: elemento existente");
        } else {
            j = j.createLink(add.charAt(pos));
            j.folha = true;
        }  
        prox = null;
    }

    //metodo de mesclar arvores
    public void merge(ArvoreTrie arv) throws Exception{
        merge(arv.raiz, "");
    }
    private void merge(No no, String nome) throws Exception{
            int pos = -1;
            while(++pos < no.TAM){
                No tmpProx = no.prox[pos];
                if(tmpProx != null){
                    if(tmpProx.folha)
                        insert(nome + tmpProx.elemento);
                    else
                        merge(no.prox[pos], nome + tmpProx.elemento);
                } 
            } 
    }
    //metodo de pesquisa
    public boolean search(String nome){
        boolean resultado = false;
        No i = raiz;
        int pos = 0;
        while(i != null){
            i = i.prox[nome.charAt(pos++)];
            if(pos == nome.length()){
                resultado = true;
                i = null;
            } 
        } 

        return resultado;
    } 


}

class Q06{
    public static ArvoreTrie arv = new ArvoreTrie();
    public static ArvoreTrie arvSec = new ArvoreTrie();
    public static String ler(int id) throws Exception{
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

        return leitura.nome;
    }
    
    public static void main(String[] args){
        String entrada = MyIO.readLine();
        try{
            //insert na primeira arvore
            while(!entrada.equals("FIM")){
                arv.insert(ler(Integer.valueOf(entrada)));
                entrada = MyIO.readLine();
            }
            
            //insert na segunda arvore
            entrada = MyIO.readLine();
            while(!entrada.equals("FIM")){
                arvSec.insert(ler(Integer.valueOf(entrada)));
                entrada = MyIO.readLine();
            }

            //merge das arvores
            arv.merge(arvSec);

            entrada = MyIO.readLine();
            while(!entrada.equals("FIM")){
                MyIO.print(entrada + " ");
                if(arv.search(entrada) == true){
                    MyIO.print("SIM\n");
                } else {
                    MyIO.print("NAO\n");
                }
                entrada = MyIO.readLine();
            }

        } catch (Exception e){
            MyIO.println("Um erro ocorreu: " + e.getMessage());
            e.printStackTrace();
        }        
    }

}
