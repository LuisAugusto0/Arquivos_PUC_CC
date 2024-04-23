class escreverNaTela{
	public static void main (String[] args){
		MyIO.setCharset("UTF-8");
		String nomeArq = MyIO.readLine("Escreva o nome do arquivo a ser mostrado na tela: ");
		String aux = "";
		Arq.openRead(nomeArq, "UTF-8");
		while(Arq.hasNext()){
			aux += Arq.readLine() + '\n';
		}
		Arq.close();
		MyIO.print("Conteúdo do arquivo:\n"+aux);
	}
}
