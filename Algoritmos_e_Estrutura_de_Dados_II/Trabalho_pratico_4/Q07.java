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

class Hash{
    public Jogador[] vetor;
    public int qtdeReserva;
    public final int tamTab = 21;
    public final int tamReserva = 9;
    
    //construtor
    Hash(){
        vetor = new Jogador[tamTab + tamReserva];
        qtdeReserva = 0;
    }

    //insert
    public void insert(Jogador add) throws Exception{
        int pos = add.altura % tamTab;
        if(vetor[pos] == null){
            vetor[pos] = add;
        } else if(qtdeReserva < tamReserva){
            vetor[tamTab + qtdeReserva++] = add;
        }
    }

    //metodo de pesquisa
    public boolean search(String nome){
        boolean resultado = false;
        for(Jogador i : vetor){
            if(i != null && i.nome.equals(nome)){
                resultado = true;
            }
        }

        return resultado;
    } 


}

class Q07{
    public static Hash hash= new Hash();
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
                hash.insert(ler(Integer.valueOf(entrada)));
                entrada = MyIO.readLine();
            }
            
            entrada = MyIO.readLine();
            while(!entrada.equals("FIM")){
                MyIO.print(entrada + " ");
                if(hash.search(entrada) == true){
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
