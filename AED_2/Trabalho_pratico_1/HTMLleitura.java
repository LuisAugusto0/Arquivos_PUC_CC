import java.io.*;
import java.net.*;

class HTMLleitura{
    
    static boolean ehConsoante(char teste){
        return ( !(teste=='a' || teste=='e' || teste=='i' || teste=='o' || teste == 'u') && (teste>='a' && teste<='z') );
    }

    public static String getHTML(String endereco){
        URL url;
        InputStream dadosURL = null; //fluxo de dados de entrada
        BufferedReader br;
        String html = "", line; 

        try{
            url = new URL(endereco); //criada instancia da classe que conecta com a url 
            dadosURL = url.openStream(); //retorna um fluxo de dados da url
            br = new BufferedReader(new InputStreamReader(dadosURL)); //BR  que lê o fluxo de dados com caracteres da tabela ASCII estendida
            while ((line = br.readLine()) != null) { //enquanto tiver conteúdo concatena na string html
                html += line + "\n";
            }
            br.close();
            dadosURL.close(); //fecha o fluxo de dados 
        } 
        catch (MalformedURLException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        return html;
    }

    public static void testes(String html, String titulo){
        int x1=0, x2=0, x3=0, x4=0, x5=0, x6=0, x7=0, x8=0, x9=0, x10=0, x11=0, x12=0, x13=0, x14=0, x15=0, x16=0, x17=0, x18=0, x19=0, x20=0, x21=0, x22=0, x23=0, x24=0, x25=0, x26=0; 
        for(int i=0; i<html.length(); i++){
            if(ehConsoante(html.charAt(i))){
                x23++;
            } else if(html.charAt(i) == 60){
                         if (html.charAt(i+1)=='b' && html.charAt(i+2)=='r' && html.charAt(i+3)==62){
                            i+=4;
                             x24++;
                         } else if (html.charAt(i+1)=='t' && html.charAt(i+2)=='a' && html.charAt(i+3)=='b' && html.charAt(i+4)=='l' && html.charAt(i+5)=='e' && html.charAt(i+6)==62){
                             x25++;
                             i+=7;
                         }
            } else {
                switch (html.charAt(i)){
                    case 'a':
                        x1++;
                        break;
                    case 'e':
                        x2++;
                        break;
                    case 'i':
                        x3++;
                        break;
                    case 'o':
                        x4++;
                        break;
                    case 'u':
                        x5++;
                        break;
                    case 225:
                        x6++;
                        break;
                    case 233:
                        x7++;
                        break;
                    case 237:
                        x8++;
                        break;
                    case 243:
                        x9++;
                        break;
                    case 250:
                        x10++;
                        break;
                    case 224:
                        x11++;
                        break;
                    case 232:
                        x12++;
                        break;
                    case 236:
                        x13++;
                        break;
                    case 242:
                        x14++;
                        break;
                    case 249:
                        x15++;
                        break;
                    case 227:
                        x16++;
                        break;
                    case 245:
                        x17++;
                        break;
                    case 226:
                        x18++;
                        break;
                    case 234:
                        x19++;
                        break;
                    case 238:
                        x20++;
                        break;
                    case 244:
                        x21++;
                        break;
                    case 251:
                        x22++;
                        break;
                }//fim switch case
                 
            } //fim else
        
        }//fim for
        
        	System.out.printf("a(%d) ", x1);
			System.out.printf("e(%d) ", x2);
			System.out.printf("i(%d) ", x3);
			System.out.printf("o(%d) ", x4);
			System.out.printf("u(%d) ", x5);
			System.out.printf("%c(%d) ", 225, x6);
			System.out.printf("%c(%d) ", 233, x7);
			System.out.printf("%c(%d) ", 237, x8);
			System.out.printf("%c(%d) ", 243, x9);
			System.out.printf("%c(%d) ", 250, x10);
			System.out.printf("%c(%d) ", 224, x11);
			System.out.printf("%c(%d) ", 232, x12);
			System.out.printf("%c(%d) ", 236, x13);
			System.out.printf("%c(%d) ", 242, x14);
			System.out.printf("%c(%d) ", 249, x15);
			System.out.printf("%c(%d) ", 227, x16);
			System.out.printf("%c(%d) ", 245, x17);
			System.out.printf("%c(%d) ", 226, x18);
			System.out.printf("%c(%d) ", 234, x19);
			System.out.printf("%c(%d) ", 238, x20);
			System.out.printf("%c(%d) ", 244, x21);
			System.out.printf("%c(%d) ", 251, x22);
            MyIO.print(
                        "consoante("+ x23 +") "+
                        "<br>("+ x24 +") "+
                        "<table>("+ x25 +") "+
                        titulo +
                        "\n"
                      );
   }

   public static void main (String[] args) {
        MyIO.setCharset("UTF-8");
        String endereco, titulo, html;
        titulo = MyIO.readLine();
        while (titulo.length()!=3 || titulo.charAt(0)!='F' || titulo.charAt(1)!='I' || titulo.charAt(2)!='M'){
            endereco = MyIO.readLine();
            html = getHTML(endereco);
            testes(html, titulo);
            titulo = MyIO.readLine();
        }
    }
}
