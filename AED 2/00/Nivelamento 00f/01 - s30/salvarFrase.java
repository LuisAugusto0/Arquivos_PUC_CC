import java.io.*;
class salvarFrase{
	public static void main (String[] args) throws Exception{
		String arquivo, frase;
		arquivo = MyIO.readLine("Escreva o nome do arquivo a ser criado/modificado: ");
		frase = MyIO.readLine("Escreva a frase a ser salvada no arquivo: ");
		RandomAccessFile raf = new RandomAccessFile(arquivo+".txt", "rw");
		raf.writeBytes(frase);
		raf.close();
		MyIO.println("Programa finalizado");
	} 
} 
