class Lista{
	private int tam;
	private int[] array;
	
	Lista(int tam){
		setTam(0);	
	}
	
	void setTam(int tam){
		if(tam>0){
			this.tam = tam;
		}
	}
	void setArray(int[] array){
		this.array = array;
	}

	void Inserir(int x, int pos){
		int[] aux = new int[this.tam+1];
		//cópia do array atual no aux
		for(int i=0; i<pos-1; i++){
			aux[i] = this.array[i];
		}
		//inserção na posição desejada de x
		aux[pos] = x;
		//resto da cópia
		for(int i=pos+1; i<tam+1; i++){
			aux[i] = this.array[i-1];
		}

		setArray(aux);
		setTam(tam+1);
	}

	void InserirFim(int x){
                int[] aux = new int[this.tam+1];
                //cópia do array atual no aux
                for(int i=0; i<this.tam; i++){
                        aux[i] = this.array[i];
                }
                //inserção na posição desejada de x
                aux[this.tam] = x;

		setArray(aux);
		setTam(tam+1);
	}

	void InserirInicio(int x){

                int[] aux = new int[this.tam+1];
                //inserção na posição desejada de x
                aux[0] = x;

		//cópia do array atual no aux
                for(int i=1; i<tam+1; i++){
                        aux[i] = this.array[i-1];
                }

                setArray(aux);
                setTam(tam+1);
	}

	int RemoverInicio(){
		int[] aux = new int[tam-1];
		int removed = this.array[0];
		for(int i=1; i<tam; i++){
			aux[i-1] = this.array[i];
		} 
		
		setArray(aux);
		setTam(tam-1);
		return removed;
	}

        int RemoverFim(){
                int[] aux = new int[tam-1];
                int removed = this.array[tam-1];
		for(int i=0; i<tam-1; i++){
                        aux[i] = this.array[i];
                }
		
                setArray(aux);
                setTam(tam);
		return removed;
        }

	int Remover(int pos){
                int[] aux = new int[tam-1];
                int removed;
		for(int i=0; i<pos; i++){
                        aux[i] = this.array[i];
                }
		removed = aux[pos];
		for(int i=pos+1; i<tam; i++){
			aux[i-1] = this.array[i];
		}

                setArray(aux);
                setTam(tam-1);
		return removed;
	}

	void Mostrar(){
		System.out.println("\n");
		for(int i=0; i<tam-2; i++){
			System.out.print(this.array[i] + ", ");
		}
		System.out.print(this.array[tam-2]);
	}
}
