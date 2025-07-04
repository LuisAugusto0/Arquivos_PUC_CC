#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

void trocaLetra (char str[], int tam){
    char charAntigo = ('a' + abs(rand()) % 26 );
    char charNovo = ('a' + abs(rand()) % 26 );

    for (int i = 0; i < tam; i++) {
        if(str[i] == charAntigo){
            str[i] = charNovo;
        }   
    }

}

int main()
{
    int Max_char = 400;
    int tam = 0;
    char str[Max_char];

    srand(4);
    
    fgets(str, Max_char, stdin);
    while(str[tam] !='\0'){
        tam++;
    }  
    tam--;

    while(tam!=3 || str[0]!='F' || str[1]!='I' || str[2]!='M'){
        trocaLetra(str, tam);
        printf("%s", str);

        fgets(str, Max_char, stdin);
        tam=0;
        while(str[tam] != '\0'){
            tam++;
        }
        tam--;
    }
}
