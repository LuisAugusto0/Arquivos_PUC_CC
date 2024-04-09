class CifraCesarRecursivo{

	static String cifraRecursiva(String frase, int pos,  int tam){
		String convertida = "";
        char caractere = frase.charAt(pos);
        convertida += (char) ( (int) frase.charAt(pos) + 3);
		
        if(pos<tam-1){
		    convertida += cifraRecursiva(frase, pos+1, tam);
        }

		return convertida;
	}

    public static void main(String[] args){
		String frase;
		int tam;
		frase = MyIO.readLine();
		tam = frase.length();
		while(tam!=3 || frase.charAt(0)!= 'F' || frase.charAt(1)!= 'I' || frase.charAt(2) != 'M'){
			frase = cifraRecursiva(frase, 0, tam);
			MyIO.println(frase);
            
			frase = MyIO.readLine();
            tam = frase.length();
		}
	}
}
