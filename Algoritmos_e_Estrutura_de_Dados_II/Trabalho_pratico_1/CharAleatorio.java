import java.util.Random;

class CharAleatorio{
	static Random gerador = new Random();
	static String trocaLetra(String original){
		String aux = "";
		//char charAntigo = (char) ( 97 + gerador.nextInt(26) );
		//char charNovo = (char) ( 97 + gerador.nextInt(26) );
		char charAntigo = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
		char charNovo = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
		for(int i=0; i<original.length(); i++){
			if(original.charAt(i) == charAntigo){
				aux += charNovo;
			} else {
				aux += original.charAt(i);
			}
		}	

		return aux;
	}
	public static void main (String[] args){
		gerador.setSeed(4);
		String str;
		str = MyIO.readLine();
		while(str.length()!=3 || str.charAt(0)!='F' || str.charAt(1)!='I' || str.charAt(2)!='M'){
			str = trocaLetra(str);
			MyIO.println(str);

			str = MyIO.readLine();
		}
	}
}
