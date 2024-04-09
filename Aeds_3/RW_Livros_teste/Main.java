import java.io.*;

class Livro{
    private int ID;
    private String autor;
    private String titulo;
    private float preco;

    public Livro(){

    }
    public Livro(int ID, String autor, String titulo, float preco){
        
    }

}

class Main{
    public static void main(String args[]){
        RandomAccessFile arq;
        int indice;
        float preco;
        String titulo;

        
        try{
            arq = new RandomAccessFile("dados/teste.bd", "rw");
            arq.setLength(0);
            arq.seek(0);
            arq.writeInt(1);
            arq.writeUTF("Odisséia");
            arq.writeFloat(34.56F);

            arq.seek(0);
            indice = arq.readInt();
            titulo = arq.readUTF();
            preco = arq.readFloat();

            System.out.println("Indice " + indice +"\nPreco - " + preco + "\nTitulo -" + titulo);
            arq.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}