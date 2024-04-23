class maiorArray{
	static int maior(int[] array, int pos){
		int maior = array[pos];
		if (pos>0){
			int aux = maior(array, pos-1);
			if(maior<aux){
				maior = aux; 
			}
		}
		return maior;
	}
	public static void main(String[] args){
		MyIO.setCharset("UTF-8");
		int[] array = {1,3,2,5,8,12,9};
		int maior = maior(array, (array.length)-1);
		MyIO.println("O maior valor do array é "+maior);
	}
}
