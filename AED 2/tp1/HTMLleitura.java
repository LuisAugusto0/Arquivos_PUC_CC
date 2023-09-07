import java.io.*;
import java.net.*;

class HTMLleitura{
    
    static boolean ehConsoante(char teste){
        teste = Character.toLowerCase(teste);
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

    public static void testes(String html){
        int x1=0, x2=0, x3=0, x4=0, x5=0, x6=0, x7=0, x8=0, x9=0, x10=0, x11=0, x12=0, x13=0, x14=0, x15=0, x16=0, x17=0, x18=0, x19=0, x20=0, x21=0, x22=0, x23=0, x24=0, x25=0, x26=0;
        for(int i=0; i<html.length(); i++){
            if(ehConsoante(html.charAt(i))){
                x23++;
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
                    case 


                }
            }
        }
    
    public static void main (String[] args) {
        String endereco, titulo, html;
        titulo = MyIO.readLine();
        endereco = MyIO.readLine();
        while(endereco.length()!=3 || endereco.charAt(0)!='F' || endereco.charAt(1)!='I' || endereco.charAt(2)!='M'){
            html = getHTML(endereco);
            MyIO.println(html);
            titulo = MyIO.readLine();
            if(endereco.length()!=3 || endereco.charAt(0)!='F' || endereco.charAt(1)!='I' || endereco.charAt(2)!='M'){
                endereco = MyIO.readLine();
            }
        }
    }
}
