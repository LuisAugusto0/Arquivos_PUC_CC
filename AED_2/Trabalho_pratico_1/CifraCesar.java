class CifraCesar{

	static String cifra(String frase, int tam){
		String convertida = "";
		
		for(int i=0; i<=tam-1; i++){
			convertida += (char) ( (int) frase.charAt(i) + 3);
		}
		return convertida;
	}
	public static void main(String[] args){
		String frase;
		int tam;

		frase = MyIO.readLine();
		tam = frase.length();
		while(tam!=3 || frase.charAt(0)!= 'F' || frase.charAt(1)!= 'I' || frase.charAt(2) != 'M'){
			frase = cifra(frase, tam);

			MyIO.println(frase);

			frase = MyIO.readLine();
                	tam = frase.length();
		}
	}
}
