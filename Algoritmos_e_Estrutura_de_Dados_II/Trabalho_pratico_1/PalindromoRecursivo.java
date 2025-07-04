class PalindromoRecursivo{
    static boolean palindromoRecursivo(String teste, int pos, int tam){
        boolean ehPalindromo = teste.charAt(pos) == teste.charAt(tam-pos-1);
        if(pos < (tam+1)/2 && ehPalindromo){
            ehPalindromo = ehPalindromo && palindromoRecursivo(teste, pos+1, tam);
        }  
        return ehPalindromo;
    }
    public static void main (String[] args) {
		MyIO.setCharset("UTF-8");
        String frase;
        boolean palindromo = true;
		frase = MyIO.readLine();
		int tam = frase.length();
		while(frase.length()!=3 || frase.charAt(0)!='F' || frase.charAt(1)!='I' || frase.charAt(2)!='M'){
			palindromo = palindromoRecursivo(frase, 0, tam);
			if(palindromo){
				MyIO.println("SIM");
			}else {
				MyIO.println("NAO");
			}
			frase = MyIO.readLine();
            tam = frase.length();
		}
    }
}
