class mRecursiva{
	static int multiplicacao(int x, int y){
		int resultado = x;
		if(y>1){
			resultado += multiplicacao(x, y-1); 
		}
		return resultado;
	}
	public static void main(String[] args){
		int x, y;
		MyIO.setCharset("UTF-8");
		MyIO.println("Escreva dois números para serem multiplicados:");
		x = MyIO.readInt("Primeiro valor: ");
		y = MyIO.readInt("Segundo valor: ");
		
		MyIO.println( x + "*"+ y + "=" + multiplicacao(x,y) ); 

	}
}
