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


// -------------------------
// multiplexer
// -------------------------
module mux ( output s, input a, input b, input select );
    // definir dados locais
    wire not_select;
    wire An;
    wire Na;
    wire Sa;
    wire Sb;
    
    // descrever por portas
    not NOT1 ( not_select, select );
    or OR_AB ( An, a, b );
    nor NOR_AB ( Na, a, b );
    and AND_SELECT1 ( Sa, An, not_select ); //seleção para a+b
    and AND_SELECT2 ( Sb, Na, select ); //seleção para ~(a+b)
    or OR1 ( s , Sa, Sb );

endmodule // mux
    
module test_f7;
    // ------------------------- definir dados
    reg x;
    reg y;
    reg s;
    wire s1;
    wire s2;
    wire Mux;
    f71 F71 ( s1, x, y, s );
    f72 F72 ( s2, x, y, s ); 
    mux MUX1 ( Mux, x, y, s );// ------------------------- parte principal
    
    initial
    begin : main
        $display("Guia_0701 - Luís Augusto Lima de Oliveira - 805413");
        $display("Test LU's module");
        $display("\nPrevisão - ((x+y).s') + (~(x+y).s) \n\t - Para s=1 SoP(1,2,3) \n\t - Para s=0 SoP(0)\n");
        
        $display("-------------------------------------------------------------------");
        $display("|   Entradas   |    Seleção   |   Saídas padrão    |   Saída MUX  |");
        $display("|    x     y   |       s      |     and    nand    |       s      |");
        // projetar testes do modulo
        #1 $monitor("| %4b  %4b   |    %4b      |   %4b    %4b     |    %4b      |", x, y, s, s1, s2, Mux);
        
        #1 $display("|              |              |                    |              |");
        #1 x = 1'b0; y = 1'b0; s = 1'b1;
        #1 x = 1'b0; y = 1'b1; s = 1'b1;
        #1 x = 1'b1; y = 1'b0; s = 1'b1;
        #1 x = 1'b1; y = 1'b1; s = 1'b1;
        #1 $display("-------------------------------------------------------------------");
        #1 x = 1'b0; y = 1'b0; s = 1'b0;
        #1 x = 1'b0; y = 1'b1; s = 1'b0;
        #1 x = 1'b1; y = 1'b0; s = 1'b0;
        #1 x = 1'b1; y = 1'b1; s = 1'b0;
        #1 $display("-------------------------------------------------------------------");
    end
endmodule // test_f7

