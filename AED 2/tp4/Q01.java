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
    public No esq;
    public Jogador thisJ;
    public No dir;

    //construtores
    No(){
        this(null);
    }
    No(Jogador thisJ){
        this.esq = this.dir = null;
        this.thisJ = thisJ;
    }
    No(No esq, Jogador thisJ, No dir){
        this.esq = esq;
        this.thisJ = thisJ;
        this.dir = dir;
    }

    //metodo clone
    public No clone(){
        return new No(esq, thisJ, dir);
    }
}

class ArvoreBinaria{
    No raiz;
    
    //construtor
    ArvoreBinaria(){
        raiz = null;
    }

    //insert
    public void insert(Jogador add) throws Exception{
        raiz = insert(raiz, add);
    }
    private No insert(No j, Jogador add) throws Exception{
        if(j == null){
            j = new No(add);
        } else if(add.nome.compareTo(j.thisJ.nome) < 0){
            j.esq = insert(j.esq, add);
        } else if(add.nome.compareTo(j.thisJ.nome) > 0){
            j.dir = insert(j.dir, add);
        } else {
            throw new Exception("Erro: nome existente.");
        }
        return j;
    }

    //metodo de remocao
    public String remove(String nome) throws Exception{
        No rem = search(nome);
        if(rem == null)
            throw new Exception("Jogador nao encontrado");
        String remS = rem.thisJ.nome;
        rem.esq = maiorEsq(rem, rem.esq);
        return remS;
    }
    private No maiorEsq(No i, No j){
        if(j.dir == null){
            i.thisJ = j.thisJ;
            j = j.esq;
        } else {
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }
    
    //metodo de pesquisa
    public No search(String nome){
        No resultado = null;
        No i = raiz;
        
        while(i != null){
            if(nome.compareTo(i.thisJ.nome) < 0){
                i = i.esq;
            } else if(nome.compareTo(i.thisJ.nome) > 0){
                i = i.dir;
            } else {
                resultado = i;
                i = null;
            }
        }
        return resultado;
    }
    public boolean searchBool(String nome){
        boolean resultado = false;
        No i = raiz;

        MyIO.print("raiz ");
        while(i != null){
            if(nome.compareTo(i.thisJ.nome) < 0){
                MyIO.print("esq "); 
                i = i.esq;
            } else if(nome.compareTo(i.thisJ.nome) > 0){
                MyIO.print("dir ");
                i = i.dir;
            } else { 
                resultado = true;
                i = null;
            } 
        } 

        return resultado;
    } 


}

class Q01{
    public static ArvoreBinaria arv = new ArvoreBinaria();

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
        String entrada = MyIO.readLine();
        try{
            while(!entrada.equals("FIM")){
                arv.insert(ler(Integer.valueOf(entrada)));
                entrada = MyIO.readLine();
            }
            
            entrada = MyIO.readLine();
            while(!entrada.equals("FIM")){
                MyIO.print(entrada + " ");
                if(arv.searchBool(entrada) == true){
                    MyIO.print("SIM\n");
                } else {
                    MyIO.print("NAO\n");
                }
                entrada = MyIO.readLine();
            }

        } catch (Exception e){
            MyIO.println("Um erro ocorreu: " + e.getMessage());
        }        
    }

}
