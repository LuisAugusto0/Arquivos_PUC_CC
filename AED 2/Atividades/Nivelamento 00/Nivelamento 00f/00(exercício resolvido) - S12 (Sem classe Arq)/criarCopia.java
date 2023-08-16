import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class criarCopia{
	public static void main (String[] args){
		String nomeArq = MyIO.readLine("Escreva o nome do arquivo a ser copiado: ");
		String nomeCopia = MyIO.readLine("Escreva o nome do arquivo que armazena a copia: ");
		
		File arq = new File(nomeArq);
		
		try{
	                Scanner lerArquivo = new Scanner(arq);
			FileWriter newArq = new FileWriter(nomeCopia);

			String aux = "";
			while(lerArquivo.hasNext()){
				aux += lerArquivo.nextInt() + '\n';
			}
			newArq.write(aux);
			newArq.close();

		}
		catch (IOException e){
			MyIO.println("Um erro ocorreu");
			e.printStackTrace();
		}	
		finally{
			MyIO.println("Fim do código");
		}
	}
}
