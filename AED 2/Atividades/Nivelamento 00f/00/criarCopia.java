import java.util.Scanner;
import java.io.;
class criarCopia{
	public static void main (String[] args){
		String aux;
		Arq.openRead("teste.txt", "us-ascii");
		while(Arq.hasNext()){
			aux += Arq.readLine() + '\n';
		}
		Arq.close();

		Arq.openWrite("copia.txt", "us-ascii");
		Arq.print(aux);
		Arq.close();
	}
}
