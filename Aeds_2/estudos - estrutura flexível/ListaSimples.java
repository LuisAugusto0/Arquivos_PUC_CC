class Celula{
    public int elemento;
    public Celula prox;

    public Celula(){
        this(0);
    }
    public Celula(int i){
        this(i, null);
    }
    public Celula(int i, Celula prox){
        this.elemento = i;
        this.prox = prox;
    }
}

class ListaSimples{
    public Celula primeiro;
    public Celula ultimo;
    
    //construtor
    public ListaSimples(){
        primeiro = ultimo = new Celula();
    }
    
    //metodo para pegar tamanho da lista
    public int tamanho(){
        int tam = 0;
        for(Celula i = primeiro; i != ultimo; i=i.prox, tam++);
        return tam;
    }
    //metodos de insercao
    public void inserirInicio(int x){
        Celula tmp = new Celula(x, primeiro.prox);
        primeiro.prox = tmp;
        if(primeiro == ultimo){
            ultimo = tmp;
        }
        tmp = null;
    }
    public void inserirFinal(int x){
        Celula tmp = new Celula(x);
        ultimo.prox = tmp;
        ultimo = ultimo.prox;
        tmp = null;
    }
    public void inserir(int x, int pos) throws Exception{
        if(pos < 0 || pos > tamanho()-1){
            throw new Exception("Problema ao inserir, valor incorreto");
        } else if(pos == 0){
            inserirInicio(x);
        }
        Celula i = primeiro;
        for(int j=0; j<pos; j++, i = i.prox);
        Celula tmp = new Celula(x, i.prox);
        i.prox = tmp;
        tmp = null;
    }
    //metodos de remocao
    public int removerInicio() throws Exception{
        if(ultimo == primeiro){
            throw new Exception("Sem elementos na lista");
        } 

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int val = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        return val;
    }
    public int removerFinal() throws Exception{
        if(ultimo == primeiro){
            throw new Exception("Sem elementos na lista");
        }
        Celula i;
        for(i = primeiro; i.prox != ultimo; i = i.prox);
        int val = ultimo.elemento;
        ultimo = i;
        i = ultimo.prox = null;
        return val;
    }
    public int remover(int x, int pos) throws Exception{
        int val = 0;
        if(ultimo == primeiro){
            throw new Exception("Sem elementos na lista");
        } else if(x == 0) {
            val = removerInicio();
        } else if(x == tamanho()-1){
            val = removerFinal();
        } else {
            Celula i = primeiro;
            for(int j=0; j<x; i=i.prox, j++);
            Celula tmp = i.prox;
            i.prox = i.prox.prox;
            val = tmp.elemento;
            tmp.prox = null;
            tmp = null;
        }

        return val;
    }

}
