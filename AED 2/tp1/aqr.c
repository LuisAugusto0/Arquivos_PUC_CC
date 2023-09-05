#include <stdio.h>

int main()
{
    char nomeArq[20] = "teste.txt";
    int qtdeNum;
    FILE* arquivo = fopen(nomeArq, "w");
    
    scanf("%d", &qtdeNum);
    for(int i=0; i<qtdeNum; i++){
        float aux;
        scanf("%f", &aux);
        fprintf(arquivo, "%f\n", aux);
    }
    fclose(arquivo);

    arquivo = fopen(nomeArq, "r");
    fseek(arquivo, 0, SEEK_END);
    int cursor = ftell(arquivo)-2;
    fseek(arquivo, cursor, SEEK_SET);
    for(int i=0; i<qtdeNum; i++){
        float aux;
        while(fgetc(arquivo)!='\n' && cursor>=0){
            fseek(arquivo, --cursor, SEEK_SET);
        }
        fseek(arquivo, cursor+1, SEEK_SET);
        fscanf(arquivo,"%f", &aux);
        printf("%g\n", aux);
        fseek(arquivo, --cursor, SEEK_SET);
    }

    return 0;    
}
