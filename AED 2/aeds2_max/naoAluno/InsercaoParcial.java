/**
 * Algoritmo de ordenacao por insercao
 * @author Max do Val Machado
 * @version 2 01/2015
 */

class InsercaoParcial extends Geracao {

	/**
	 * Construtor.
	 */
   public InsercaoParcial(){
      super();
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public InsercaoParcial(int tamanho){
      super(tamanho);
   }


	/**
	 * Algoritmo de ordenacao parcial por insercao.
	 */
	public static void insercaoParcial(int k) {
		for (int i = 1; i < n; i++) {
			int tmp = array[i];
         int j = i - 1;

         if(i > k && array[k-1] > tmp){
            array[i] = array[k-1];
            j = k - 1;
         }
         while ((j >= 0) && (array[j] > tmp)) {
            array[j + 1] = array[j];
            j--;
         }
         array[j + 1] = tmp;
		}
	}


	public static void main(String[] args) {
      InsercaoParcial insercaoParcial = new InsercaoParcial(100);
      int k = 10;

		insercaoParcial.aleatorio();
		insercaoParcial.mostrar();
		
		long comeco = now();
		insercaoParcial.insercaoParcial(k);
		long fim = now();
		
		insercaoParcial.mostrar();
		insercaoParcial.mostrar(k);
		System.out.println("Tempo para ordenar: " + (fim-comeco)/1000.0 + " s.");
	}
}
