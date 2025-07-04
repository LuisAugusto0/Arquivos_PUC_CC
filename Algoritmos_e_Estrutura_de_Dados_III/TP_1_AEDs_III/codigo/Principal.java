import java.io.*;

import aeds3.Arquivo;

class Principal {

  public static void main(String args[]) {

    new File("codigo/dados/livros.db").delete();
    new File("codigo/dados/livros.hash_d.db").delete();
    new File("codigo/dados/livros.hash_c.db").delete();
    new File("codigo/dados/livros.hash_lixo_d.db").delete();
    new File("codigo/dados/livros.hash_lixo_c.db").delete();

    Arquivo<Livro> arqLivros;
    Livro l1 = new Livro(-1, "9788563560278", "Odisseia", 15.99F);
    Livro l2 = new Livro(-1, "9788584290482", "Ensino Híbrido", 39.90F);
    Livro l3 = new Livro(-1, "9786559790005", "Modernidade Líquida", 48.1F);
    Livro l4 = new Livro(-1, "9788582714911", "Memória", 55.58F);
    Livro l5 = new Livro(-1, "9786587150062", "Com Amor", 48.9F);
    int id1, id2, id3, id4, id5;

    try {
      arqLivros = new Arquivo<>("livros", Livro.class.getConstructor());

      id1 = arqLivros.create(l1);

      id3 = arqLivros.create(l3);

      id4 = arqLivros.create(l4);

      System.out.println(arqLivros.delete(id3) ? "Livro excluído" : "Livro não encontrado!");

      l4.setTitulo("A Memória");
      System.out.println(arqLivros.update(l4) ? "Livro alterado" : "Livro não encontrado!");

      System.out.println(arqLivros.delete(id3) ? "Livro excluído" : "Livro não encontrado!");
      
      System.out.println(arqLivros.delete(id4) ? "Livro excluído" : "Livro não encontrado!");

      System.out.println(arqLivros.delete(id1) ? "Livro excluído" : "Livro não encontrado!");

      id1 = arqLivros.create(l1);

      id2 = arqLivros.create(l2);
        
      id3 = arqLivros.create(l3);

      id4 = arqLivros.create(l4);
        
      id5 = arqLivros.create(l5);

      System.out.println("Livro 1:\n" + arqLivros.read(id1));
      System.out.println("Livro 2:\n" + arqLivros.read(id2));
      System.out.println("Livro 3:\n" + arqLivros.read(id3));
      System.out.println("Livro 4:\n" + arqLivros.read(id4));
      System.out.println("Livro 5:\n" + arqLivros.read(id5));

      arqLivros.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}