class AlgebraBool{
    static boolean algebraRecursiva(String params){

    }
    static int algebra(String params){
		int qtdeElementos = params.charAt(0);
        int[] valor = new int[params.charAt(0)];

		int c=2;
		for(int i=0; i<qtdeElementos; i++, c+=2){
			valor[i] = params.charAt(i);
		}
        
        if(qtdeElementos == 3){
            for(int i=params.length(); i>c; i--){
                if(params.charAt(i) == ')'){
                    int aux;
                    while(params.charAt(i) != '('){
                        if()
                    }
                } 
            }
        }
	}
	public static void main (String[] args){
	        String params;
       		params = MyIO.readLine();
       	 	while(params != '0'){
				
	        }
	}
}
