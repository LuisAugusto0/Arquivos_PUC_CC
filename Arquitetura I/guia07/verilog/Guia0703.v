// -------------------------
// Guia_0700 - GATES
// Nome: Luís Augusto Lima de Oliveira
// Matricula: 805413

// -------------------------
// -------------------------
// f7_gates
// -------------------------
module f71 ( output s, input a, input b, input select );
    assign s = a || b;
endmodule

module f72 ( output s, input a, input b, input select );
    assign s = ~(a || b);
endmodule

module f73 ( output s, input a, input b, input select );
     assign s = a && b;
 endmodule

 module f74 ( output s, input a, input b, input select );
     assign s = ~(a && b);
 endmodule


// -------------------------
// multiplexer
// -------------------------
module mux ( output s, input a, input b, input select , input selectGrupo);
    // definir dados locais
    wire not_select;
    wire not_selectGrupo;
    
    wire Nor;
    wire Or;
    wire And;
    wire Nand;

    wire SOr;
    wire SNor;
    wire SAnd;
    wire SNand;
    
    wire Sfinal1;
    wire Sfinal2;
    wire Sfinal3;
    wire Sfinal4;
    
    // descrever por portas
    not NOT1 ( not_select, select );
    not NOT2 (not_selectGrupo, selectGrupo);
    
    or OR_AB ( Or, a, b );
    nor NOR_AB ( Nor, a, b );
    and AND_AB ( And, a, b );
    nand NAND_AB ( Nand, a, b );
    
    and AND_SELECT1_1 ( SOr, Or, not_select ); //seleção para a+b
    and AND_SELECT1_2 ( SAnd, And, not_select ); //seleção para a.b
    and AND_SELECT2_1 ( SNor, Nor, select ); //seleção para ~(a+b)
    and AND_SELECT2_2 ( SNand, Nand, select ); //seleção para ~(a.b)
    
    or OR_OPERATION1 ( Sfinal1, SOr, SNor ); 
    or OR_OPERATION2 ( Sfinal2, SAnd, SNand );

    and AND_SELECT3_1 ( Sfinal3, Sfinal1, not_selectGrupo ); //seleção para NOR/OR
    and AND_SELECT3_2 ( Sfinal4, Sfinal2, selectGrupo ); //sleção para NAND/AND

    or OR1 ( s , Sfinal3, Sfinal4 );

endmodule // mux
    
module test_f7;
    // ------------------------- definir dados
    reg x;
    reg y;
    reg s;
    reg Sporta;
    wire s1;
    wire s2;
    wire s3;
    wire s4;
    wire Mux;
    f71 F71 ( s1, x, y, s );
    f72 F72 ( s2, x, y, s ); 
    f73 F73 ( s3, x, y, s );
    f74 F74 ( s4, x, y, s );

    mux MUX1 ( Mux, x, y, s, Sporta );// ------------------------- parte principal
    
    initial
    begin : main
        $display("Guia_0701 - Luís Augusto Lima de Oliveira - 805413");
        $display("Test LU's module");
        $display("\nPrevisão - ( ((x+y).s') + (~(x+y).s) ).Sgrupo' + ( ((x.y).s') + (~(x.y).s) ).Sgrupo \n\t - Para Sgrupo=0 e s=0 SoP(1,2,3) OR\n\t - Para Sgrupo=0 e s=1 SoP(0) NOR\n\t - Para Sgrupo=1 e s=0 SoP(3) AND \n\t - Para Sgrupo=1 e s=1 SoP(0,1,2)  NAND\n");
        
        $display("-------------------------------------------------------------------------------------");
        $display("|   Entradas   |    Seleção        |          Saídas padrão          |   Saída MUX  |");
        $display("|    x     y   |       s  Sporta   |     and    nand    or    nor    |       s      |");
        // projetar testes do modulo
        #1 $monitor("| %4b  %4b   |    %4b %4b      |   %4b    %4b   %4b   %4b    |    %4b      |", x, y, s, Sporta, s3, s4, s1, s2, Mux);
        
        #1 $display("|              |                   |                                 |              |");
        
        // or/nor
        #1 x = 1'b0; y = 1'b0; s = 1'b0; Sporta = 1'b0;
        #1 x = 1'b0; y = 1'b1; s = 1'b0; Sporta = 1'b0;
        #1 x = 1'b1; y = 1'b0; s = 1'b0; Sporta = 1'b0;
        #1 x = 1'b1; y = 1'b1; s = 1'b0; Sporta = 1'b0;
        #1 $display("-------------------------------------------------------------------------------------");
        #1 x = 1'b0; y = 1'b0; s = 1'b1; Sporta = 1'b0;
        #1 x = 1'b0; y = 1'b1; s = 1'b1; Sporta = 1'b0;
        #1 x = 1'b1; y = 1'b0; s = 1'b1; Sporta = 1'b0;
        #1 x = 1'b1; y = 1'b1; s = 1'b1; Sporta = 1'b0;
        #1 $display("-------------------------------------------------------------------------------------");
        
        //  and/nand
        #1 x = 1'b0; y = 1'b0; s = 1'b0; Sporta = 1'b1;
        #1 x = 1'b0; y = 1'b1; s = 1'b0; Sporta = 1'b1;
        #1 x = 1'b1; y = 1'b0; s = 1'b0; Sporta = 1'b1;
        #1 x = 1'b1; y = 1'b1; s = 1'b0; Sporta = 1'b1;
        #1 $display("-------------------------------------------------------------------------------------");
        #1 x = 1'b0; y = 1'b0; s = 1'b1; Sporta = 1'b1;
        #1 x = 1'b0; y = 1'b1; s = 1'b1; Sporta = 1'b1;
        #1 x = 1'b1; y = 1'b0; s = 1'b1; Sporta = 1'b1;
        #1 x = 1'b1; y = 1'b1; s = 1'b1; Sporta = 1'b1;
        #1 $display("-------------------------------------------------------------------------------------");

    end
endmodule // test_f7

