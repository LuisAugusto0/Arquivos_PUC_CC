/**
 * Algoritmo de ordenacao por insercao
 * @author Max do Val Machado
 * @version 2 01/2015
 */

class InsercaoComPesqBinaria extends Geracao {

	/**
	 * Construtor.
	 */
   public InsercaoComPesqBinaria(){
      super();
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public InsercaoComPesqBinaria(int tamanho){
      super(tamanho);
   }



	/**
	 * Metodo baseado na pesquisa binaria que retorna a posicao do primeiro elemento
    * do array entre as posicoes [esq] e [dir] cujo valor é maior que x
	 * @param int x elemento procurado
	 * @param int esq menor posicao de procura 
	 * @param int dir maior posicao de procura
	 * @param int meio posicao do primeiro elemento entre [esq, dir] maior que x
	 */
   public static int pesquisaBinariaAdaptada(int x, int esq, int dir) {
      int meio;

      do{
         meio = (esq + dir)/2;
         if (x == array[meio]){
            esq = n;
            meio++;
         }else if (x > array[meio]){
            esq = meio + 1;
            meio++;
         }else{ 
            dir = meio - 1;
         }
      }while (esq <= dir);

      return meio;
   }

   public static int pesquisaBinariaAdaptadaRec(int x, int esq, int dir) {
      int meio = (esq + dir)/2;

      if (x == array[meio]){
         esq = n;
         meio++;
      }else if (x > array[meio]){
         esq = meio + 1;
         meio++;
      }else{ 
         dir = meio - 1;
      }

      if (esq <= dir){
         meio = pesquisaBinariaAdaptadaRec(x, esq, dir);
      }

      return meio;
   }


	/**
	 * Algoritmo de ordenacao por insercao.
	 */
	public static void insercao() {
		for (int i = 1; i < n; i++) {
			int tmp = array[i];
         int j = i - 1;
         int pos = pesquisaBinariaAdaptadaRec(tmp, 0, j);

         for(int k = i; k > pos; k--){
            array[k] = array[k-1];
         }

         array[pos] = tmp;
      }
	}


	public static void main(String[] args) {
      InsercaoComPesqBinaria insercao = new InsercaoComPesqBinaria(1000);
		insercao.aleatorio();
		//insercao.mostrar();
		
		long comeco = now();
		insercao.insercao();
		long fim = now();
		
		//insercao.mostrar();
		System.out.println("Tempo para ordenar (" + insercao.isOrdenado() + "): " + (fim-comeco)/1000.0 + " s.");
	}
}
