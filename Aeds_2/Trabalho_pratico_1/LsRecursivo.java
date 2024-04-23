class LsRecursivo{
	static boolean ehVogal(char teste){
        teste = Character.toLowerCase(teste);
		return ( (teste=='a' || teste=='e' || teste=='i' || teste=='o' || teste == 'u') );
	}	 
    static boolean ehInteiro(char teste){
         return (int)teste>='0' && (int)teste<='9';
    }
    static boolean ehConsoante(char teste){
        teste = Character.toLowerCase(teste);
        return ( !ehVogal(teste) && (teste>='a' && teste<='z') );
    }
	static boolean apenasVogais(String teste, int pos){
		boolean verdadeiro = ehVogal(teste.charAt(pos));
        if(verdadeiro && pos<teste.length()-1){
            verdadeiro = verdadeiro && apenasVogais(teste, pos+1);
        }
		
        return verdadeiro;
	}
    
    static boolean apenasConsoantes(String teste, int pos){
         boolean verdadeiro = ehConsoante(teste.charAt(pos));
         if(verdadeiro && pos<teste.length()-1){
             verdadeiro = verdadeiro && apenasConsoantes(teste, pos+1);
         }
 
         return verdadeiro;

    }

    static boolean numInteiro(String teste, int pos){
         boolean verdadeiro = ehInteiro(teste.charAt(pos));
         if(verdadeiro && pos<teste.length()-1){
             verdadeiro = verdadeiro && numInteiro(teste, pos+1);
         }
 
         return verdadeiro;

    }  

    static boolean numFloat(String teste, int pos, int qtdePts){
        boolean verdadeiro = (ehInteiro(teste.charAt(pos)) || teste.charAt(pos)=='.' || teste.charAt(pos)==',');
        
        if(qtdePts>1){
            verdadeiro = false;
        } else if (teste.charAt(pos)=='.' || teste.charAt(pos)==','){
            qtdePts++;
        }
        
        if(verdadeiro && pos<teste.length()-1){
             verdadeiro = verdadeiro && numFloat(teste, pos+1, qtdePts);
         }
 
        return verdadeiro;
    }


	public static void main(String[] args){
		boolean x1, x2, x3, x4;
        String frase = MyIO.readLine();
		while(frase.length()!=3 || frase.charAt(0) != 'F' || frase.charAt(1) != 'I' || frase.charAt(2) != 'M'){
			x1 = apenasVogais(frase, 0);
			x2 = apenasConsoantes(frase, 0);
            x3 = numInteiro(frase, 0);
            x4 = numFloat(frase, 0, 0);

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
