// -------------------------
// Guia_0700 - GATES
// Nome: Luís Augusto Lima de Oliveira
// Matricula: 805413

// -------------------------
// -------------------------
// f7_gates
// -------------------------
module f7AND ( output s, input a, input b, input select );
    assign s = a && b;
endmodule

 module f7NAND ( output s, input a, input b, input select );
     assign s = ~(a && b);
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
    and AND_AB ( An, a, b );
    nand NAND_AB ( Na, a, b );
    and AND_SELECT1 ( Sa, An, not_select ); //seleção para a.b
    and AND_SELECT2 ( Sb, Na, select ); //seleção para ~(a.b)
    or OR1 ( s , Sa, Sb );

endmodule // mux
    
module test_f7;
    // ------------------------- definir dados
    reg x;
    reg y;
    reg s;
    wire And;
    wire Nand;
    wire Mux;
    f7AND AND1 ( And, x, y, s );
    f7NAND NAND1 ( Nand, x, y, s ); 
    mux MUX1 ( Mux, x, y, s );// ------------------------- parte principal
    
    initial
    begin : main
        $display("Guia_0701 - Luís Augusto Lima de Oliveira - 805413");
        $display("Test LU's module");
        $display("\nPrevisão - ((x.y).s') + (~(x.y).s) \n\t - Para s=1 SoP(x,y) = (0,1,2) \n\t - Para s=0 SoP(x,y) = m(3)\n");
        
        $display("-------------------------------------------------------------------");
        $display("|   Entradas   |    Seleção   |   Saídas padrão    |   Saída MUX  |");
        $display("|    x     y   |       s      |     and    nand    |       s      |");
        // projetar testes do modulo
        #1 $monitor("| %4b  %4b   |    %4b      |   %4b    %4b     |    %4b      |", x, y, s, And, Nand, Mux);
        
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

