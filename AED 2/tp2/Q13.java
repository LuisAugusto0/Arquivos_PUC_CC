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

class Q13 {
    private static Jogador[] aJogador;
    private static int qtdeComp = 0, qtdeTroca = 0;

    private static Jogador[] aumentarArray(Jogador[] escolha, int tam) {
        Jogador[] temp = new Jogador[tam + 1];
        for (int i = 0; i < tam; i++) {
            temp[i] = escolha[i];
        }
        temp[tam] = new Jogador();
        return temp;
    }

    private static int comp(Jogador A, Jogador B) {
        int comp = A.getUniversidade().compareTo(B.getUniversidade());
        if (comp == 0) {
            comp = A.getNome().compareTo(B.getNome());
        }
        return comp;
    }

    private static void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Jogador[] L = new Jogador[n1];
        Jogador[] R = new Jogador[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = aJogador[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = aJogador[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (comp(L[i], R[j]) <= 0) {
                aJogador[k] = L[i];
                i++;
                qtdeComp++;
                qtdeTroca++;
            } else {
                aJogador[k] = R[j];
                j++;
                qtdeComp++;
                qtdeTroca++;
            }
            k++;
            qtdeComp+=2;
        }

        while (i < n1) {
            aJogador[k] = L[i];
            i++;
            k++;
            qtdeComp++;
            qtdeTroca++;

        }

        while (j < n2) {
            aJogador[k] = R[j];
            j++;
            k++;
            qtdeComp++;
            qtdeTroca++;
        }
    }

    private static void mergeSort(int left, int right) {
        if (left < right) {
            qtdeComp++;
            int mid = (left + right) / 2;

            mergeSort(left, mid);
            mergeSort(mid + 1, right);

            merge(left, mid, right);
        }
    }

    public static void main(String[] args) {
        try {
            int tam = 0;
            aJogador = new Jogador[0];
            String id;

            // ler id's e armazenar quantidade lida (tam) e Jogadores correspondentes
            id = MyIO.readLine();
            while (!id.equals("FIM")) {
                aJogador = aumentarArray(aJogador, tam);
                aJogador[tam++].ler(Integer.valueOf(id));
                id = MyIO.readLine();
            }

            // Q13 - Organizar com selecao
            long inicio = new Date().getTime();
            mergeSort(0, tam - 1);
            long fim = new Date().getTime();
            for (int i = 0; i < tam; i++) {
                aJogador[i].imprimir();
            }

            File arq = new File("matricula_mergesort.txt");


            FileWriter fw = new FileWriter(arq);
            fw.write("805413\t" + "\t" + qtdeComp+ "\t" + qtdeTroca + "\t" + (fim-inicio)/1000.0);
            fw.close();
            

        } catch (NumberFormatException e) {
            MyIO.println("Id invalido");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
