class No {
   char letra;
   No[] filho;
   boolean folha;
   static final int TAMALFABETO = 255;

   public No (){
      this(' ');
   }

   public No (char letra){
      this.letra = letra;
      this.filho = new No[TAMALFABETO];
      folha = false;
      for(int i = 0; i < TAMALFABETO; i++){
         filho[i] = null;
      }
   }

   public static int hash (char x){
      return (x);
   }
}

class Trie {
   private No raiz;

   public Trie (){
      raiz = new No();
   }


   public void inserir(String s) throws Exception {
      int i = 0;
      No no = raiz;

      //System.out.println("Inserindo (" + s + ")...");

      while(i < s.length() && 
            no.filho[s.charAt(i)] != null && 
            no.filho[s.charAt(i)].folha == false){
         //System.out.println("Existe no(" + s.charAt(i) + ").");
         no = no.filho[s.charAt(i)];
         i++;
      }

      if(i == s.length()){
         throw new Exception("Erro ao inserir s(" + s + ") porque ela ela estah contida!");

      }else if (no.filho[s.charAt(i)] == null){
         while (i < s.length()){
            //System.out.println("Inserindo no(" + s.charAt(i) + ")");
            no.filho[s.charAt(i)] = new No(s.charAt(i));
            no = no.filho[s.charAt(i)];
            i++;
         }
         no.folha = true;

      }else if (no.filho[s.charAt(i)].folha == true){
         throw new Exception("Erro ao inserir s(" + s + ") porque existe o prefixo(" + s.substring(0, i + 1) + ")!");

      } else {
         throw new Exception("Invalido!!!");
      }
   }

   public boolean pesquisar(String s){
      boolean resp = false;
      int i = 0;
      No no = raiz;

      while(i < s.length() && no.filho[s.charAt(i)] != null){
         no = no.filho[s.charAt(i)];
         i++;
      }

      if(i == s.length() && no.folha == true){
         resp = true;
      }

      return resp;   
   }


   public void mostrar(){
      System.out.print("[");
      mostrar(raiz, "");
      System.out.println("]");
   }

   public void mostrar(No no, String s){
      if(no != null){
         s += no.letra;
         if(no.folha == true){
            System.out.print(s + " ");
         } else {
            for(int i = 0; i < No.TAMALFABETO; i++){
               if(no.filho[i] != null){
                  mostrar(no.filho[i], s);
               }
            }
         }
      }
   }


   /*
   public No inserir(No no, String s, int i){

      if(no == null){

         //criar um no com o caractere s.charAt(i)
         //para os demais caracteres encadear seus respectivos nos
         //fazer com que o no ultimo no seja final

      } else if (i == s.length()){
         //erro nao pode inserir pela palavra ser um prefixo

      } else{
         inserir(no.filho[s.charAt(i)],  ){
      }

      return no;
   }
   */
}
