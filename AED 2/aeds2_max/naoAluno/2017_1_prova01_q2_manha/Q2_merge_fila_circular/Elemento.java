import java.util.*;
class Elemento {
   int valor;
   long timestamp;

   public Elemento (int valor){
      this(valor, now());
   }
   public Elemento (int valor, long timestamp){
      this.valor = valor;
      this.timestamp = timestamp;
   }
   public static long now(){
      return new Date().getTime();
   }
   public Elemento clone() {
      return new Elemento(this.valor, this.timestamp);
   }
   public void imprimir(){
      System.out.println(valor + "/" + timestamp);
   }
}
