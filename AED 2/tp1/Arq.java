import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

class Arq{
    public static void main (String[] args) {
        int qtde = MyIO.readInt();
        try{
            RandomAccessFile arquivo = new RandomAccessFile("teste.txt", "rw");
            for (int i=0; i<qtde; i++){
                float leitura = MyIO.readFloat();
                arquivo.writeFloat(leitura);
            } 
            for (int i=qtde-1; i>=0; i--){
                arquivo.seek((long)i*4);
                float valor = arquivo.readFloat();
                if((valor*10)%10==0 && (valor*100)%10==0 ){
                    MyIO.println((int)valor);
                }else{
                    MyIO.println(valor);
                }
            }
            arquivo.close();
        }
        catch(IOException e){
            MyIO.println("Um erro ocorreu\n");
            e.printStackTrace();
        }
    }
}
