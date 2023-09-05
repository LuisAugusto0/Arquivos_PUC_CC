#include <stdio.h>
int main()
{
    char c[20];
    int tam=0;
    scanf("%s", c);
    while(c[tam] !='\0'){
         tam++;
    }

    printf("Frase completa - %s\n Frase desmembrada:\n\n", c);

    for (int i=0; i<tam; i++){
        printf("%dº elemento - %c %d\n", i+1, c[i], (int)c[i]);
    }
}
