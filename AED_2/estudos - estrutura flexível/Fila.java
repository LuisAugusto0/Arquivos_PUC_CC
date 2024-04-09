class Celula{
    public int elemento;
    public Celula prox;
    
    Celula(){
        this(0);
    }
    Celula(int elemento){
        this.elemento = elemento;
        this.prox = null;
    }
    Celula(int elemento, Celula prox){
        this.elemento = elemento;
        this.prox = prox;
    }
}

class Fila{
    public Celula inicio;
    public Celula fim;

    Fila(){
        inicio = fim = new Celula();
    }

    //metodo para inserir
    void insert(int x){
       Celula tmp = new Celula(x);
       fim.prox = tmp;
       fim = tmp;
       tmp = null;
    }

    //metodo para remover permanecendo a celula cabeca
    int remove() throws Exception{
        if(inicio == fim){
            throw new Exception("Nao existe elemento na fila");
        } else if(inicio.prox == fim){
            fim = inicio;
        }
        Celula tmp = inicio.prox;
        inicio.prox = inicio.prox.prox;
        int valRemovido = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        return valRemovido;
    }

    //metodo para remover com a celula cabeca 
    int removeL() throws Exception{
        if(inicio == fim){
            throw new Exception("Nao existe elemento na fila");
        }
        Celula tmp = inicio;
        inicio = inicio.prox;
        int valRemovido = inicio.elemento;
        tmp.prox = null;
        tmp = null;
        return valRemovido;
    }
    
    //metodo para inverter fila
    void invert(){
        Celula fim = null;
        Celula i = inicio.prox;
        Celula j = null;
        while(i != j){    
            for(Celula tmp = i; tmp!= fim; tmp = tmp.prox)
                j = tmp;
            fim = j;
            int iTmp = i.elemento;
            i.elemento = j.elemento;
            j.elemento = iTmp;
            if(i != j){
                i=i.prox;
            }
        }
    }

    void toFila(Celula topo){
        Pilha invert = new Pilha();
        for(Celula i = topo; i!=null; i=i.prox){
            invert.insert(i.elemento);
        }
        inicio = fim = new Celula();
        
        for(Celula j = invert.topo; j!=null; j=j.prox){
            insert(j.elemento);
        }

    }

    void print(){
        for(Celula i = inicio.prox; i != null; i=i.prox){
            System.out.println(i.elemento);
        }
    }

    public static void main(String[] args){
        Fila fila = new Fila();
        Pilha pilha = new Pilha();

        pilha.insert(1);
        pilha.insert(2);
        pilha.insert(3);
        pilha.insert(4);
        pilha.print();

        fila.toFila(pilha.topo);
        fila.print();
    }
}
