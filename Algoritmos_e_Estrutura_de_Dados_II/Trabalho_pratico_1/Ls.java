class Ls{

	static boolean ehVogal(char teste){
        teste = Character.toLowerCase(teste);
		return ( (teste=='a' || teste=='e' || teste=='i' || teste=='o' || teste == 'u') );
	}	 
    static boolean ehNum(char teste){
         return teste>47 && teste<58;
    }
    static boolean ehConsoante(char teste){
        teste = Character.toLowerCase(teste);
        return ( !ehVogal(teste) && (teste>='a' && teste<='z') );
    }


	static boolean apenasVogais(String teste){
		boolean verdadeiro = true;
		for(int i=0; i<teste.length(); i++){
			if( ! ehVogal(teste.charAt(i)) ){
				verdadeiro = false;
				i = teste.length();			
			}
		}
		return verdadeiro;
	}
    
    static boolean apenasConsoantes(String teste){
        boolean verdadeiro = true;
        for(int i=0; i<teste.length(); i++){
            if( !ehConsoante(teste.charAt(i)) ){
                verdadeiro = false;
                i = teste.length();
            }
        }
        return verdadeiro;
    }

    static boolean numInteiro(String teste){
        boolean verdadeiro = true;
        for(int i=0; i<teste.length(); i++){
            if( !ehNum(teste.charAt(i))  || teste.charAt(i)=='.' ){
                verdadeiro = false;
                i = teste.length();
            }
        }

       return verdadeiro;
    }  

    static boolean numFloat(String teste){
         boolean verdadeiro = true;
         int qtdePnts = 0;
         for(int i=0; i<teste.length(); i++){
             if( !ehNum(teste.charAt(i)) ){
                 qtdePnts++;
                 if ( (teste.charAt(i) !='.' && teste.charAt(i) !=',') || qtdePnts>1 ){
                    verdadeiro = false;
                    i = teste.length();
                 } 
             }
         }

        return verdadeiro;
    }


	public static void main(String[] args){
		boolean x1, x2, x3, x4;
        String frase = MyIO.readLine();
		while(frase.length()!=3 || frase.charAt(0) != 'F' || frase.charAt(1) != 'I' || frase.charAt(2) != 'M'){
			x1 = apenasVogais(frase);
			x2 = apenasConsoantes(frase);
            x3 = numInteiro(frase);
            x4 = numFloat(frase);

            if(x1) MyIO.print("SIM "); 
            else MyIO.print("NAO ");
            
            if(x2) MyIO.print("SIM ");
		    else MyIO.print("NAO ");

            if(x3) MyIO.print("SIM ");
            else MyIO.print("NAO ");
            
            if(x4) MyIO.print("SIM\n");
            else MyIO.print("NAO\n");

            frase = MyIO.readLine();
        }
    }
}
