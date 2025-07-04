class Palindromo{
	//método iterativo que verifica se o todos as posições de i e tam-i-1 são iguais até a metade da frase/palavra
	static boolean palindromoIterativo(String frase){
                boolean palindromo = true;
		int tam=frase.length();
                
		for(int i=0; i<=(tam-1)/2; i++){
                        if(frase.charAt(i) != frase.charAt(tam-i-1)){
				palindromo = false;
				i=tam;
                        }
                }
		return palindromo;
	}
	
	public static void main(String[] args){
		MyIO.setCharset("UTF-8");
		String frase;
		boolean palindromo = true;
		frase = MyIO.readLine();
		int tam = frase.length();
		while(frase.length()!=3 || frase.charAt(0)!='F' || frase.charAt(1)!='I' || frase.charAt(2)!='M'){
			palindromo = palindromoIterativo(frase);
			if(palindromo){
				MyIO.println("SIM");
			}else {
				MyIO.println("NAO");
			}
			frase = MyIO.readLine();	
		}
		
		
	}
}
