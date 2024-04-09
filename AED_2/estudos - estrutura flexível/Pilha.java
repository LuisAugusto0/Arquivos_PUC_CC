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

class Pilha{
    public Celula topo;
    
    Pilha(){
        this.topo = null;
    }

    public void insert(int x){
        Celula tmp = new Celula(x, topo);
        topo = tmp;
        tmp = null;
    }

    public int remove(){
        int elemento = 0;
        if(topo != null){
            elemento = topo.elemento;
            topo = topo.prox;
        }
        return elemento;
    }

    public void print(){
        for(Celula i = topo; i != null; i = i.prox){
            System.out.println(i.elemento);
        }
    }

    public void printOrdemInversa(){
        Celula anterior = null;
        for(Celula i = topo; i != null; i = i.prox){
            Celula tmp = null;
            for(Celula j = topo; j != anterior; j=j.prox){
                tmp = j;
            }
            System.out.println(tmp.elemento);
            anterior = tmp;

        }
    }

    public static void main(String[] args){
        Pilha pilha = new Pilha();
        pilha.insert(1);
        pilha.insert(2);
        pilha.insert(3);
        pilha.insert(4);
        pilha.insert(5);
        System.out.println("Elemento removido: " + pilha.remove());
        System.out.println("Elemento removido: " + pilha.remove());
        pilha.printOrdemInversa();
    }
} 
