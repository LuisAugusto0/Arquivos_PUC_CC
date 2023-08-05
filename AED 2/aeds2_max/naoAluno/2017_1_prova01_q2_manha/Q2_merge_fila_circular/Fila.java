/**
 * Fila estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Fila {
   private Elemento[] array;
   private int primeiro; // Remove do indice "primeiro".
   private int ultimo; // Insere no indice "ultimo".


   /**
    * Construtor da classe.
    */
   public Fila () {
      this(6);
   }


   /**
    * Construtor da classe.
    * @param tamanho Tamanho da fila.
    */
   public Fila (int tamanho){
      array = new Elemento[tamanho+1];
      primeiro = ultimo = 0;
   }


   /**
    * Insere um elemento na ultima posicao da fila.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a fila estiver cheia.
    */
   public void inserir(int x) throws Exception {
      inserir(new Elemento(x));
   }

   public void inserir(Elemento x) throws Exception {

      //validar insercao
      if (((ultimo + 1) % array.length) == primeiro) {
         throw new Exception("Erro ao inserir!");
      }

      array[ultimo] = x.clone();
      ultimo = (ultimo + 1) % array.length;
   }

   public Elemento remover() throws Exception {

      //validar remocao
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover!");
      }

      Elemento resp = array[primeiro];
      primeiro = (primeiro + 1) % array.length;
      return resp.clone();
   }


   public void mostrar (){
      for(int i = primeiro; i != ultimo; i = ((i + 1) % array.length)) {
         array[i].imprimir();
      }
   }

   public static Fila merge(Fila f1, Fila f2) throws Exception {
      Fila resp = new Fila(20);

      int i1 = f1.primeiro, i2 = f2.primeiro; 

      while (i1 != f1.ultimo || i2 != f2.ultimo){
         if (i1 != f1.ultimo && i2 != f2.ultimo) {
            if (f1.array[i1].timestamp < f2.array[i2].timestamp){
               resp.inserir(f1.array[i1]);
               i1 = ((i1 + 1) % f1.array.length);
            } else {
               resp.inserir(f2.array[i2]);
               i2 = ((i2 + 1) % f2.array.length);
            }
         } else if (i1 != f1.ultimo){
            resp.inserir(f1.array[i1]);
            i1 = ((i1 + 1) % f1.array.length);
         } else {
            resp.inserir(f2.array[i2]);
            i2 = ((i2 + 1) % f2.array.length);
         }
      }

      return resp;
   }
}
