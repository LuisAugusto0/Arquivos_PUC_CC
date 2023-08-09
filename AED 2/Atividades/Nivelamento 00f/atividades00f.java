class atividades00f{
	static int flag = 0;

	// Início exercício 1 //
	// Exercício resulvido - faça um programa que abra um arquio e cria uma cópia //
	static void questao01(){
		Arq.openRead("exemplo.txt");
		StringBuilder texto = new StringBuilder("");
		String str = Arq.readAll();
		//while(Arq.hasNext() == true){
		
		//}	
		MyIO.println(str);
		str = texto.toString();
		MyIO.println(str);
		Arq.close();

		Arq.openWrite("copia.txt");
		Arq.print(str);
		Arq.close();
	}


	// Fim exercício 1 //
	
	// Início exercício 2 //
	//
	// Fim exercicio 2 //

        static int mainMenu(){
		MyIO.print("\nDigite qual menu deseja acessar:" +
                                "\n[0] - Encerrar o programa" +
                                "\n[1] - Exercício 1" +
                                "\n[2] - Exercício 2" +
                                "\n[3] - Exercício 3" +
                                "\n[4] - Exercício 4  ");

		

		int valor = MyIO.readInt();
		return valor;
        }
        public static void main(String[] args){
                MyIO.setCharset("UTF-8");
		int opcao;
                opcao = mainMenu();
                while(opcao!=flag){
                        switch (opcao){
                                case 1:
                                        questao01();
                                        break;
                                case 2:
                                        break;
                                case 3:
                                       
                                        break;
                                case 4:
                                       
                                        break;
                                default:
                                        MyIO.println("Opção incorreta, digite novamente");
                                        break;
                        }
                        opcao = mainMenu();
                }
        }

} 
