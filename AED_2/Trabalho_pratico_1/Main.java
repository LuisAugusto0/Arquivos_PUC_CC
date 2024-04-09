import java.util.*;

public class Main{

    public static void main(String[] args){
        Random rand = new Random();
        rand.setSeed(4);
        
        String input = new String();
        
        Scanner sc = new Scanner(System.in);
        
        while( !(input = sc.nextLine()).equals("FIM")){
            System.out.println(randString(input, rand));
        }
        
        sc.close();
    }
    
    static String randString(String input, Random rand){

        char randChar = (char)('a' + Math.abs(rand.nextInt() % 26));
        char newChar = (char)('a' + Math.abs(rand.nextInt() % 26));

        char[] array = input.toCharArray();

        for ( int i = 0; i < input.length(); i++ ){
            if ( array[i] == randChar )  array[i] = newChar;
        }

        return new String(array);
    }
}
