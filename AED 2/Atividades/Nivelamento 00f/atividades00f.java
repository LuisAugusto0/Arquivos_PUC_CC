import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

class atividades00f{
	public static void main(String args[]){
		try{
			File arquivo = new File("exemplo.txt");
			File arquivoc = new File("copia.txt");
			FileWriter arquivocEscrita = new FileWriter("copia.txt");
			Scanner lerArquivo = new Scanner(arquivo);
			String aux= "";

			while(lerArquivo.hasNextLine()){
				aux += lerArquivo.nextLine();
				aux += '\n';
			}
			arquivoc.createNewFile();
			arquivocEscrita.write(aux);
			arquivocEscrita.close();
		}
		catch(IOException error){
			MyIO.print("Um erro ocorreu.");
			error.printStackTrace();
		}
	}
}
