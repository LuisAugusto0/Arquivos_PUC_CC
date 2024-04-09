class Celula{
    public int elemento;
    public Celula esq;
    public Celula dir;
    public Celula sup;
    public Celula inf;
    
    Celula(){
        elemento = 0;
        esq = dir = sup = inf = null;
    }

    Celula (Celula esq, Celula dir, Celula sup, Celula inf){
         this.elemento = 0;
         this.esq = esq;
         this.dir = dir;
         this.sup = sup;
         this.inf = inf;
    }


    Celula (int elemento, Celula esq, Celula dir, Celula sup, Celula inf){
         this.elemento = elemento;
         this.esq = esq;
         this.dir = dir;
         this.sup = sup;
         this.inf = inf;
    }
}

class Matriz{
    public Celula inicio;
    public int lin, col;

    //construtores
    Matriz(){
        this(3,3);
    }

    Matriz(int lin, int col){
        this.lin = lin;
        this.col = col;
        inicio = new Celula();
        Celula i = inicio;
        
        //criacao primeira coluna
        for(int l=1; l<lin; l++){
            i.inf = new Celula(null, null, i, null);
            i = i.inf;
        }

        i = inicio;

        //criacao proximas coluna
        for (int c=1; c<col; c++){
            Celula iTmp = i;
            i.dir = new Celula(i, null, null, null);
            Celula jTmp = i.dir;
            for(int l=1; l<lin; l++){
                iTmp = iTmp.inf;
                jTmp.inf = new Celula(iTmp, null, jTmp, null);
                jTmp = jTmp.inf;
                iTmp.dir = jTmp;
            }
            i = i.dir;
        }
    }
    
    //Operacoes entre matrizes
    public Matriz soma(Matriz mat) throws Exception{
        if(mat.lin != this.lin || mat.col != this.col)
            throw new Exception("Matriz incompativel (linha ou coluna diferente)");
        Matriz resultado = new Matriz(lin, col);
        for(Celula i1 = inicio, i2 = mat.inicio, iF = resultado.inicio; i1 != null; i1 = i1.dir, i2 = i2.dir, iF = iF.dir){
            for(Celula j1 = i1, j2 = i2, jF = iF; j1 != null; j1 = j1.inf, j2 = j2.inf, jF = jF.inf){
                jF.elemento = j1.elemento + j2.elemento;
            }
        }
        return resultado;
    }
    public Matriz multiplicacao(Matriz mat) throws Exception{
        if(mat.lin != this.col || mat.col != this.lin)
            throw new Exception("Matriz incompativel (linha ou coluna diferente)");
        Matriz resultado = new Matriz(lin, lin);
        for(Celula i1 = inicio, iF = resultado.inicio; i1 != null; i1 = i1.inf, iF = iF.inf){
            Celula i2 = mat.inicio;
            Celula iFtemp = iF;
            while(i2 != null){
                for(Celula j1 = i1, j2 = i2; j1 != null; j1 = j1.dir, j2 = j2.inf){
                    iFtemp.elemento += j1.elemento * j2.elemento;
                }
                i2 = i2.dir;
                iFtemp = iFtemp.dir;
            }
        }
        return resultado;
    }

    //Mostrar na tela
    public void print(){
        for(Celula l = inicio; l != null; l = l.inf){
            for(Celula c = l; c != null; c = c.dir){
                MyIO.print(c.elemento + " ");
            }
            MyIO.print("\n");
        }
    }
    public void printDiagonalPrincipal(){
        Celula i = inicio;
        while(i != null){
            MyIO.print(i.elemento + " ");
            if(i.dir != null){
                i = i.dir;
                i = i.inf;
            } else {
                i = null;
            }
        }
        MyIO.print("\n");
    }
    public void printDiagonalSecundaria(){
        Celula i = inicio;
        for(i = i; i.dir != null; i = i.dir);
        while(i != null){
            MyIO.print(i.elemento + " ");
            if(i.esq != null){
                i = i.esq;
                i = i.inf;
            } else {
                i = null;
            }
        }
        MyIO.print("\n");

    }

    //Guardar valores na matriz
    public int modificar(int x, int lin, int col) throws Exception{
        if(lin<this.lin || col<this.col)
            throw new Exception("Posicao invalida");
        int rem;
        Celula i = inicio;

        while(lin > 0){
            i = i.inf;
            lin--;
        }
        while(col > 0){
            i = i.dir;
            col--;
        }
        rem = i.elemento;
        i.elemento = x;
        return rem;
    }
    public void read(){
        for(Celula l = inicio; l != null; l = l.inf){
            for(Celula c = l; c != null; c = c.dir){
                c.elemento = MyIO.readInt();
            }
        }
    }
}

class Q09{
    public static void main(String[] args){
        int qtdeTestes = MyIO.readInt();
        try{
            while(qtdeTestes-- > 0){
                //leitura das matrizes
                Matriz matA = new Matriz(MyIO.readInt(), MyIO.readInt());
                matA.read();
                Matriz matB = new Matriz(MyIO.readInt(), MyIO.readInt());            
                matB.read();

                //print testes
                matA.printDiagonalPrincipal();
                matA.printDiagonalSecundaria();
                (matA.soma(matB)).print();
                (matA.multiplicacao(matB)).print();
            }
        } catch (Exception e){
            MyIO.println("Um erro ocorreu: "+ e.getMessage());
            e.printStackTrace();
        }
    }
}
