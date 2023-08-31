class testes{

	static boolean ehVogal(char teste){
		return (teste=='a' || teste=='e' || teste=='i' || teste=='o' || teste == 'u');
	}	
	static String apenasVogais(String teste){
		String verdadeiro = "SIM";
		for(int i=0; i<teste.length(); i++){
			if( ! ehVogal(teste.charAt(i)) ){
				verdadeiro = "NAO";
				i = teste.length();			
			}
		}
		return verdadeiro;
	}
        static String apenasConsoante(String teste){
                String verdadeiro = "SIM";
                for(int i=0; i<teste.length(); i++){
                        if( ehVogal(teste.charAt(i)) ){
                                verdadeiro = "NAO";
                                i = teste.length();
                        }
                }
                return verdadeiro;
        }

	static String 


	public static void main(String[] args){
		String frase = MyIO.readLine();
		String x1, x2, x3, x4;
		while(frase.length!=3 || frase.charAt(0) != 'F' || frase.harAt(1) != 'I' || frase.charAt(2) != 'M'){
			x1 = apenasVogais(frase);
			x2 = apenasConsoantes(frase);
			x3 = 	
		}
	}
}
