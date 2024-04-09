class criarCopia{
	public static void main (String[] args){
		String nomeArq = MyIO.readLine("Escreva o nome do arquivo a ser copiado: ");
		String nomeCopia = MyIO.readLine("Escreva o nome do arquivo que armazena a copia: ");
		String aux = "";

		Arq.openRead(nomeArq, "UTF-8");
		while(Arq.hasNext()){
			aux += Arq.readLine() + '\n';
		}
		Arq.close();

		Arq.openWrite(nomeCopia, "UTF-8");
		Arq.print(aux);
		Arq.close();
	}
}
