/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
public class Principal {
   public static void main(String[] args) throws Exception {
      Trie trie = new Trie();

      trie.inserir("bear");
      trie.inserir("bell");
      trie.inserir("bid");
      trie.inserir("bull");
      trie.inserir("buy");
      trie.inserir("sell");
      trie.inserir("stock");
      trie.inserir("stop");

      trie.mostrar();

      System.out.println("stop: " + trie.pesquisar("stop"));
      System.out.println("sto: " + trie.pesquisar("sto"));
      System.out.println("stopp: " + trie.pesquisar("stopp"));
      System.out.println("sta: " + trie.pesquisar("sta"));
   }
}
