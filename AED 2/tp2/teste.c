#include <stdio.h>

int main()
{
    char string[20], inteiro[20];
    int valorFinal;
    scanf("%s", string);
    printf("\n%s\n", string);
    
    for(int i=0, pos=0; string[i]!='\0'; i++){
        if(string[i]>='0' && string[i]<='9')
           inteiro[pos++] = string[i];
    }
    
    valorFinal = atoi(inteiro);
    printf("\n valor final = %d", valorFinal);

    return 0;
}
