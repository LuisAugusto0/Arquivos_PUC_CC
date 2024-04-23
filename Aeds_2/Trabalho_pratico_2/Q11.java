import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

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
        setAll(0, "", 0, 0, "", 0, "", "");
    }

    Jogador(int id){
        ler(id);
    }
    Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento){
        setAll(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
    }

    //metodos set
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        if(nome == null){
             this.nome = "nao informado";
         } else {
             this.nome = nome;
         }
    }
    public void setAltura(int altura){
        this.altura = altura;
    }
    public void setPeso(int peso){
        this.peso = peso;
    }
    public void setUniversidade(String universidade){
       if(universidade == ""){
            this.universidade = "nao informado";
        } else {
            this.universidade = universidade;
        }
    }
    
    public void setAnoNascimento(int ano){
        this.anoNascimento = ano;
    }
    public void setCidadeNascimento(String cidade){
        if(cidade == ""){
            this.cidadeNascimento = "nao informado";
        } else {
            this.cidadeNascimento = cidade;
        }
    }
    public void setEstadoNascimento(String estado){
        if(estado == ""){
            this.estadoNascimento = "nao informado";
        } else {
            this.estadoNascimento = estado;
        }
    }

    public void setAll(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento){
        setId(id);
        setNome(nome);
        setAltura(altura);
        setPeso(peso);
        setUniversidade(universidade);
        setAnoNascimento(anoNascimento);
        setCidadeNascimento(cidadeNascimento);
        setEstadoNascimento(estadoNascimento);

    }

    //metodos get
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public int getAltura(){
        return altura;
    }
    public int getPeso(){
        return peso;
    }
    public String getUniversidade(){
        return universidade;
    }
    public int getAnoNascimento(){
        return anoNascimento;
    }
    public String getCidadeNascimento(){
        return cidadeNascimento;
    }
    public String getEstadoNascimento(){
        return estadoNascimento;
    }

    //split para a leitura
    private String[] split(String linha){
        String[] splitted = {"", "", "0", "0", "", "0", "", ""};
        int pos = 0;
        if(linha != null){
            for(int i=0; i<linha.length(); i++){
                String aux = "";
 
                while(i<linha.length() && linha.charAt(i) != ','){
                    aux += linha.charAt(i++);
                }
 
                splitted[pos] = aux;
                pos++;
            }
        } 
        return splitted;
    }
    //metodo de leitura
    public void ler(int id) throws NumberFormatException{
        try{
            File file = new File("/tmp/players.csv");
            BufferedReader arq = new BufferedReader( new FileReader(file) );
            arq.readLine(); //pular primeira linha das informacoes das colunas
            String[] splitted = split(arq.readLine());
            while( Integer.valueOf(splitted[0]) != id )
                splitted = split(arq.readLine());
            
            String nome = splitted[1];
            int altura = Integer.valueOf(splitted[2]);
            int peso = Integer.valueOf(splitted[3]);
            String universidade = splitted[4];
            int anoNascimento = Integer.valueOf(splitted[5]);
            String cidadeNascimento = splitted[6];
            String estadoNascimento = splitted[7];

            setAll(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento); 
        } catch(IOException e){
            MyIO.println("Um erro ocorreu.");
            e.printStackTrace();
        }
    }
    
    //metodo de escrita
    public void imprimir(){
        MyIO.println("["+ getId() + " ## " + getNome() + " ## " + getAltura() +  " ## " + getPeso() + " ## " + getAnoNascimento() + " ## " + getUniversidade() + " ## " + getCidadeNascimento() + " ## " + getEstadoNascimento() + "]");
    }

    //metodo de clone
 
    public Jogador clone() {
        return new Jogador(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
    }
}



class Q11{
    private static int comp = 0, troca = 0;
    private static Jogador[] aumentarArray(Jogador[] jogador, int tam){
        Jogador[] temp = new Jogador[tam+1];
        for(int i=0; i < (tam); i++){
            temp[i] = jogador[i];
        }
        temp[tam] = new Jogador();
        return temp;
    }

    private static int getMaiorAltura(Jogador[] jogador, int tam){
        int maiorAltura = jogador[0].getAltura();
        for(int i=1; i<tam; i++){
            if(jogador[i].getAltura() > maiorAltura){
                maiorAltura = jogador[i].getAltura(); 
            }
        }
        return maiorAltura;
    }
    
    private static Jogador[] reorganizarNomes(Jogador[] array, int tam){
        for(int i = 1; i < tam; i++){
            Jogador temp = array[i];
            int j = i - 1;
            if(array[j].getNome().charAt(0) > temp.getNome().charAt(0)){
                while((j >= 0) && (array[j].getAltura() == temp.getAltura()) && array[j].getNome().compareTo(temp.getNome()) > 0){
                array[j + 1] = array[j];
                j--;
                }
            }
            else if(array[j].getNome().compareTo(temp.getNome()) > 0){
                while((j >= 0) && (array[j].getAltura() == temp.getAltura()) && array[j].getNome().compareTo(temp.getNome()) > 0){
                    array[j + 1] = array[j];
                    j--;
                }
            }
          array[j + 1] = temp;
        }
        
        return array;
    }
    private static Jogador[] countingSort(Jogador[] jogador, int tam) {
        int[] count = new int[getMaiorAltura(jogador, tam) + 1];
        Jogador[] ordenado = new Jogador[tam];

        // Inicializando os elementos
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }

        // Preenchendo com as alturas do array
        for (int i = 0; i < tam; i++) {
            count[jogador[i].getAltura()]++;
        }

        // Somando os anteriores
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Preenchendo o array ordenado corretamente
        for (int i = tam - 1; i >= 0; i--) {
            ordenado[count[jogador[i].getAltura()] - 1] = jogador[i];
            count[jogador[i].getAltura()]--;
        }
        

        ordenado = reorganizarNomes(ordenado, tam);
        return ordenado;
    }


    public static void main(String[] args){
        try{
            int tam = 0;
            Jogador[] aJogador = new Jogador[0];
            String id;
            String nomeLido;
    
            //ler id's e armazenar quantidade lida (tam) e Jogadores correspondentes
            id = MyIO.readLine();
            while(!id.equals("FIM")){
                aJogador = aumentarArray(aJogador, tam);
                aJogador[tam++].ler(Integer.valueOf(id));
                id = MyIO.readLine();
            }
            
            long inicio = new Date().getTime();
            aJogador = countingSort(aJogador, tam);

            for(int i=0; i<tam; i++){
                aJogador[i].imprimir();
            }
            long fim = new Date().getTime();
            File arq = new File("matricula_insercao.txt");


            FileWriter fw = new FileWriter(arq);
            fw.write("805413\t" + "\t" + comp+ "\t" + troca + "\t" + (fim-inicio)/1000.0);
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }catch(NumberFormatException e){
            MyIO.println("Id invalido");
        }

    }
}
