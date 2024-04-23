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
    boolean cor;
    //construtores
    No(){
        this(null);
    }
    No(Jogador thisJ){
        this(null, thisJ, null, true);
    }
    No(Jogador thisJ, boolean cor){
        this(null, thisJ, null, cor);
    }
    No(No esq, Jogador thisJ, No dir){
        this(null, thisJ, null, true);
    }
    No(No esq, Jogador thisJ, No dir, boolean cor){
        this.esq = esq;
        this.thisJ = thisJ;
        this.dir = dir;
        this.cor = cor;
    }


    //metodo clone
    public No clone(){
        return new No(esq, thisJ, dir, cor);
    }
}

class ArvoreAN{
    No raiz;
    
    //construtor
    ArvoreAN(){
        raiz = null;
    }

    //insert
    No rotacaoEsq(No no){
        No tmpDirEsq = no.dir.esq;
        no.dir.esq = no;
        no = no.dir;
        no.esq.dir = tmpDirEsq;
        return no;
    }
    No rotacaoDir(No no){
        No tmpEsqDir = no.esq.dir;
        no.esq.dir = no;
        no = no.esq;
        no.dir.esq = tmpEsqDir;
        return no;
    }
   
    /*
    void caminhar(String caminho, No no){
        if(no != null){
            caminhar(caminho+" esq", no.esq);
            System.out.println("\tPosicao: " + caminho + "\n\tJogador: " + no.thisJ.nome + "\n\tCor: " + no.cor);
            System.out.println("\n------------------//--------------");
            caminhar(caminho+" dir", no.dir);

        }
    }
    */

    boolean isNoTipoQuatro(No no){
        return (no.esq != null && no.esq.cor == true && no.dir != null && no.dir.cor == true );
    }
    
    
    public void insert(Jogador add) throws Exception{
        //System.out.println("==============================================\nInsert: " + add.id);
        //se não existir elemento na raiz
        if(raiz == null){
            raiz = new No(add);
        //se existir apenas um elemento na estrutura
        } else if(raiz.esq == null && raiz.dir == null){
            int comp = add.nome.compareTo(raiz.thisJ.nome);
            if(comp < 0){
                raiz.esq = new No(add, false);
            } else if (comp > 0){
                raiz.dir = new No(add, false); 
            } else {
                throw new Exception ("Erro: jogador existente");
            }
        //se existir um elemento na raiz e um à direita
        } else if(raiz.esq == null){
            int comp = add.nome.compareTo(raiz.thisJ.nome);
            if(comp < 0){
                raiz.esq = new No(add, false);
            } else if(comp > 0){
                int compFilho = add.nome.compareTo(raiz.dir.thisJ.nome);
                No tmp;
                
                if(compFilho < 0)
                    tmp = new No(raiz, add, raiz.dir, false);
                else if (compFilho > 0)
                    tmp = new No(raiz, raiz.dir.thisJ, new No (add), false);
                else 
                    throw new Exception ("Erro: jogador existente");
                
                raiz = tmp;
                tmp = null;
                raiz.esq.esq = raiz.esq.dir = raiz.dir.esq = raiz.dir.dir = null;
            } else {
                throw new Exception ("Erro: jogador existente");
            }
        //se existir um elemento na raiz e um à esquerda
        } else if(raiz.dir == null){
            int comp = add.nome.compareTo(raiz.thisJ.nome);
            if(comp > 0){
                raiz.dir = new No(add, false);
            } else if(comp < 0){
                int compFilho = add.nome.compareTo(raiz.esq.thisJ.nome);
                No tmp;
                if(compFilho < 0)
                    tmp = new No(new No (add), raiz.esq.thisJ, raiz, false);
                else if (compFilho > 0)
                    tmp = new No(raiz.esq, add, raiz, false);
                else 
                    throw new Exception ("Erro: jogador existente");

                raiz = tmp;
                tmp = null;
                raiz.esq.esq = raiz.esq.dir = raiz.dir.esq = raiz.dir.dir = null;
            } else {
                throw new Exception ("Erro: jogador existente");
            }

        //se existir 3 ou mais elementos
        } else {
           insert(null, null, null, raiz, add);
        }
        raiz.cor = false;
        
        //teste
        //caminhar("raiz", raiz);
    }
    private void balancear(No bisavo, No avo, No pai, No filho){
        if(pai.cor == true){
            //Mais elementos à direita
            if(pai.thisJ.nome.compareTo(avo.thisJ.nome) > 0){ //rotacao esquerda ou direitaEsq
                if(filho.thisJ.nome.compareTo(pai.thisJ.nome) > 0){
                    avo = rotacaoEsq(avo);
                } else {
                    avo.dir = rotacaoDir(avo.dir); 
                    avo = rotacaoEsq(avo);
                } 
            //Mais elementos à esquerda
            } else { //rotacao direita ou esquerdaDir
                if(filho.thisJ.nome.compareTo(pai.thisJ.nome) < 0){
                    avo = rotacaoDir(avo);
                } else {
                    avo.esq = rotacaoEsq(avo.esq);
                    avo = rotacaoDir(avo);
                }
            } 

            if(bisavo == null)
                raiz = avo;
            else if (avo.thisJ.nome.compareTo(bisavo.thisJ.nome) < 0)
                bisavo.esq = avo;
            else
                bisavo.dir = avo;
        

            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        }
    }
    private void insert(No bisavo, No avo, No pai, No filho, Jogador add) throws Exception{
        if(filho == null){
            int comp = add.nome.compareTo(pai.thisJ.nome);
            if(comp < 0)
                filho = pai.esq = new No (add, true);
            else if (comp > 0)
                filho = pai.dir = new No (add, true);
            else 
                throw new Exception("Erro: jogador existente");
            
            //System.out.printf("\nFilho %s: %s \npai: %s \navo: %s \nbisavo: %s ", (pai.esq == filho ? "Esquerda" : "Direita"), (filho == null ? "nulo" : filho.thisJ.nome), (pai == null ? "nulo" : pai.thisJ.nome), (avo == null ? "nulo" : avo.thisJ.nome),      (bisavo == null ? "nulo" : bisavo.thisJ.nome));
            if(pai.cor == true){
                balancear(bisavo, avo, pai, filho);
            }
        } else {
            if(isNoTipoQuatro(filho)){
                filho.cor = true;
                filho.esq.cor = filho.dir.cor = false;
                if(filho == raiz){
                    filho.cor = false;
                } else if (pai.cor == true){
                    balancear(bisavo, avo, pai, filho);
                }
            } 
            int comp = add.nome.compareTo(filho.thisJ.nome);
            if(comp < 0){
                insert(avo, pai, filho, filho.esq, add);
            } else if (comp > 0){
                insert(avo, pai, filho, filho.dir, add);
            } else {
                throw new Exception("Erro: jogador existente");
            }
        }
    }

    public boolean search(String nome){
        No pesquisa = raiz;
        boolean resultado = false;
        
        System.out.print("raiz ");
        while(pesquisa != null){
            int comp = nome.compareTo(pesquisa.thisJ.nome);
            if(comp < 0){
                System.out.print("esq ");
                pesquisa = pesquisa.esq;
            } else if (comp > 0){
                System.out.print("dir ");
                pesquisa = pesquisa.dir;
            } else {
                pesquisa = null;
                resultado = true;
            }
        } 

        return resultado;
    } 


}

class Q04{

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
            ArvoreAN arv = new ArvoreAN();
            while(!entrada.equals("FIM")){
                arv.insert(ler(Integer.valueOf(entrada)));
                entrada = MyIO.readLine();
            }
            
            entrada = MyIO.readLine();
            while(!entrada.equals("FIM")){
                System.out.print(entrada + " ");
                if(arv.search(entrada) == true){
                    System.out.print("SIM\n");
                } else {
                    System.out.print("NAO\n");
                }
                entrada = MyIO.readLine();
            }

        } catch (Exception e){
            System.out.println("Um erro ocorreu: " + e.getMessage() + "\n");
            e.printStackTrace();
        }        
    }

}
