/**
 * Fila estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class PrincipalFila {
   public static void main(String[] args) throws Exception {
      Fila f1 = new Fila(10);
      Fila f2 = new Fila(10);
      for(int i = 0; i < 6; i++){
         f1.inserir(0);
         Thread.sleep(100);
         f2.inserir(0);
         Thread.sleep(100);
         System.out.print(".");
      }
      for(int i = 0; i < 4; i++){
         f1.remover();
         f2.remover();
      }
      
      for(int i = 6; i < 16; i++){
         f1.inserir(i++);
         Thread.sleep(100);
         f2.inserir(i);
         Thread.sleep(100);
         System.out.print(".");

         if(i % 3 == 0){
            f1.remover();
         }
      }

      f1.inserir(21);
      f1.inserir(22);


      System.out.println("=====================");
      f1.mostrar();
      System.out.println("=====================");
      f2.mostrar();
      System.out.println("=====================");
      
      Fila f3 = Fila.merge(f1, f2);
      f3.mostrar();
   }
}
