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
        return searchBool(raiz, nome);
    }
    private boolean searchBool(No i, String nome){
        boolean resultado = false;

        if(i != null){
            resultado = nome.compareTo(i.thisJ.nome) == 0;
            if(resultado == false){
                System.out.print("ESQ ");
                resultado = searchBool(i.esq, nome);    
            }
            if(resultado == false){
                System.out.print("DIR ");
                resultado = searchBool(i.dir, nome);
            }
        } 

        return resultado;
    } 


}

class No2{
    public No2 esq;
    public int val;
    public ArvoreBinaria arv;
    public No2 dir;

    No2(){
        this(new ArvoreBinaria(), 0);
    }
    No2(int val){
        this(new ArvoreBinaria(), val);
    }
    No2(ArvoreBinaria arv, int val){
        esq = dir = null;
        this.arv = arv;
        this.val = val;
    }
}

class ArvoreBinaria2{
    No2 raiz;
    
    ArvoreBinaria2() throws Exception{
        raiz = null;
        int[] alturas = { 7, 3, 11, 1, 5, 9, 12, 0, 2, 4, 6, 8, 10, 13, 14 };
        insert(alturas);
    }

    //métodos insert
    public void insertJogador(Jogador add) throws Exception{
        No2 noInsercao = search(add.altura % 15);
        if(noInsercao == null)
            throw new Exception("Erro: posicao na arvore de idades nao encontrada");
        noInsercao.arv.insert(add);
    }

    public void insert(int[] val) throws Exception{
        for(int pos = 0; pos < val.length; pos++){
            raiz = insert(val[pos], raiz);
        }
    }
    private No2 insert(int val, No2 i) throws Exception{
        if(i == null){
            i = new No2(val);
        } else if (val<i.val){
            i.esq = insert(val, i.esq);
        } else if (val>i.val){
            i.dir = insert(val, i.dir);
        } else {
            throw new Exception ("Erro: valor já existente");
        }
        return i;
    }

    //método de pesquisa
    public No2 search (int val){
        No2 tmp = raiz;
        No2 resultado = null;
        while(tmp != null){
            if(val < tmp.val){
                tmp = tmp.esq;
            } else if(val > tmp.val){
                tmp = tmp.dir;
            } else {
                resultado = tmp;
                tmp = null;
            }
        }
        return resultado;
    }
    public boolean searchBool (String test){
        System.out.print("raiz ");
        return searchBool(raiz, test);
    }
    private boolean searchBool (No2 i, String test){
        boolean resultado = false;
        if(i != null){
            resultado = i.arv.searchBool(test);
            if(resultado == false){
                System.out.print("esq ");
                resultado = searchBool(i.esq, test);
            }
            if(resultado == false){
                System.out.print("dir ");
                resultado = searchBool(i.dir, test);
            }
        }
        return resultado;
    }
}

class Q02{

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
            System.out.println("Arquivo nao aberto");
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return leitura;
    }
    
    public static void main(String[] args){
        String entrada = MyIO.readLine();
        try{
            ArvoreBinaria2 arv = new ArvoreBinaria2();
            while(!entrada.equals("FIM")){
                arv.insertJogador(ler(Integer.valueOf(entrada)));
                entrada = MyIO.readLine();
            }
            
            entrada = MyIO.readLine();
            while(!entrada.equals("FIM")){
                System.out.print(entrada + " ");
                if(arv.searchBool(entrada) == true){
                    System.out.print("SIM\n");
                } else {
                    System.out.print("NAO\n");
                }
                entrada = MyIO.readLine();
            }

        } catch (Exception e){
            System.out.println("Um erro ocorreu: " + e.getMessage());
        }        
    }

}
