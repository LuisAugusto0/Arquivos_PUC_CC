/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
import java.util.*;

public class Principal {
   public static void main(String[] args) throws Exception {
      ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

      System.out.println("NADA Altura: " + arvoreBinaria.getAltura());
      arvoreBinaria.inserir(3);
      System.out.println("[3] Altura: " + arvoreBinaria.getAltura());
      arvoreBinaria.inserir(5);
      System.out.println("[3, 5] Altura: " + arvoreBinaria.getAltura());
      arvoreBinaria.inserir(1);
      System.out.println("[3, 5, 1] Altura: " + arvoreBinaria.getAltura());
      arvoreBinaria.inserir(8);
      System.out.println("[3, 5, 1, 8] Altura: " + arvoreBinaria.getAltura());
      arvoreBinaria.inserir(2);
      System.out.println("[3, 5, 1, 8, 2] Altura: " + arvoreBinaria.getAltura());
      arvoreBinaria.inserir(4);
      System.out.println("[3, 5, 1, 8, 2, 4] Altura: " + arvoreBinaria.getAltura());
      arvoreBinaria.inserir(7);
      System.out.println("[3, 5, 1, 8, 2, 4, 7] Altura: " + arvoreBinaria.getAltura());
      arvoreBinaria.inserir(6);
      System.out.println("[3, 5, 1, 8, 2, 4, 7, 6] Altura: " + arvoreBinaria.getAltura());

      arvoreBinaria.remover(6);
      System.out.println("[3, 5, 1, 8, 2, 4, 7] Altura: " + arvoreBinaria.getAltura());
      arvoreBinaria.remover(2);
      System.out.println("[3, 5, 1, 8, 4, 7] Altura: " + arvoreBinaria.getAltura());
      arvoreBinaria.remover(4);
      System.out.println("[3, 5, 1, 8, 4] Altura: " + arvoreBinaria.getAltura());

      arvoreBinaria = new ArvoreBinaria();
      Random gerador = new Random();
      gerador.setSeed(4);
      for(int i = 0; i < 1000000; i++){
         int valor = Math.abs(gerador.nextInt());
         arvoreBinaria.inserir(valor);
         if(i == 10 || i == 100 || i % 1000 == 0){
            double log = Math.log(i+1) / Math.log(2);
            System.out.println("Inserindo(" + (i+1) + "): [ALTURA = " + arvoreBinaria.getAltura() + "/" + log + "]");
         } 
      }
   }

}
