// -------------------------
// Guia_0700 - GATES
// Nome: Luís Augusto Lima de Oliveira
// Matricula: 805413

// -------------------------
// -------------------------
// f7_gates
// -------------------------
module f71 ( output s, input a, input b );
    assign s = a || b;
endmodule

module f72 ( output s, input a, input b );
    assign s = ~(a || b);
endmodule

module f73 ( output s, input a, input b );
     assign s = a ^ b;
 endmodule

 module f74 ( output s, input a, input b );
     assign s = ~(a ^ b);
 endmodule


// -------------------------
// multiplexer
// -------------------------
module mux ( output s, input a, input b, input [1:0] select);
    // definir dados locais
    wire not_select[1:0];
    wire not_selectGrupo;
    
    wire Xor;
    wire Xnor;
    wire Or;
    wire Nor;

    wire SOr;
    wire SNor;
    wire SXor;
    wire SXnor;
    
    
    // descrever por portas
    not NOT1 ( not_select[0], select[0] );
    not NOT2 (not_select[1], select[1]);
    
    or OR_AB ( Or, a, b );
    nor NOR_AB ( Nor, a, b );
    xor AND_AB ( Xor, a, b );
    xnor NAND_AB ( Xnor, a, b );
    
    and AND_SELECT1_1 ( SXor, Xor, not_select[1], not_select[0] ); //seleção para a^b
    and AND_SELECT1_2 ( SXnor, Xnor, not_select[1], select[0] ); //seleção para ~(a^b)
    and AND_SELECT2_1 ( SOr, Or, select[1], not_select[0] ); //seleção para a+b
    and AND_SELECT2_2 ( SNor, Nor, select[1], select[0] ); //seleção para ~(a+b)

    or OR1 ( s , SXor, SXnor, SOr, SNor );

endmodule // mux
    
module test_f7;
    // ------------------------- definir dados
    reg x;
    reg y;
    reg[1:0] s;
    wire s1;
    wire s2;
    wire s3;
    wire s4;
    wire Mux;
    f71 F71 ( s1, x, y );
    f72 F72 ( s2, x, y ); 
    f73 F73 ( s3, x, y );
    f74 F74 ( s4, x, y );

    mux MUX1 ( Mux, x, y, s[1:0] );// ------------------------- parte principal
    
    initial
    begin : main
        $display("Guia_0701 - Luís Augusto Lima de Oliveira - 805413");
        $display("Test LU's module");
        $display("\nPrevisão - ( (a^b) . s[0]' . s[1]' )  +  ( ~(a^b) . s[0] . s[1]' ) + ( (a+b) . s[0]' . s[1] ) + ( ~(a+b) . s[0] . s[1] ) \n\t - Para S=00   SoP(x,y) = m(1,2)\t XOR\n\t - Para S=01   SoP(x,y) = m(0,3)\t XNOR\n\t - Para S=10   SoP(x,y) = m(1,2,3)\t OR \n\t - Para S=11   SoP(x,y) = m(0)  \t NOR\n");
        
        $display("-------------------------------------------------------------------------------------");
        $display("|   Entradas   |    Seleção        |          Saídas padrão          |   Saída MUX  |");
        $display("|    x     y   |     s[1]  S[0]    |     xor    xnor    or    nor    |       s      |");
        // projetar testes do modulo
        #1 $monitor("| %4b  %4b   |    %4b %4b      |   %4b    %4b   %4b   %4b    |    %4b      |", x, y, s[1], s[0], s3, s4, s1, s2, Mux);
        
        #1 $display("|              |                   |                                 |              |");
        
        // XOR
        #1 x = 1'b0; y = 1'b0; s = 3'b00; 
        #1 x = 1'b0; y = 1'b1; s = 3'b00; 
        #1 x = 1'b1; y = 1'b0; s = 3'b00; 
        #1 x = 1'b1; y = 1'b1; s = 3'b00;
        #1 $display("-------------------------------------------------------------------------------------");
        
        // XNOR
        #1 x = 1'b0; y = 1'b0; s = 3'b01;
        #1 x = 1'b0; y = 1'b1; s = 3'b01;
        #1 x = 1'b1; y = 1'b0; s = 3'b01;
        #1 x = 1'b1; y = 1'b1; s = 3'b01;
        #1 $display("-------------------------------------------------------------------------------------");
        
        // OR
        #1 x = 1'b0; y = 1'b0; s = 3'b10;
        #1 x = 1'b0; y = 1'b1; s = 3'b10;
        #1 x = 1'b1; y = 1'b0; s = 3'b10;
        #1 x = 1'b1; y = 1'b1; s = 3'b10;
        #1 $display("-------------------------------------------------------------------------------------");
            
        // NOR
        #1 x = 1'b0; y = 1'b0; s = 3'b11;
        #1 x = 1'b0; y = 1'b1; s = 3'b11;
        #1 x = 1'b1; y = 1'b0; s = 3'b11;
        #1 x = 1'b1; y = 1'b1; s = 3'b11;
        #1 $display("-------------------------------------------------------------------------------------");


    end
endmodule // test_f7

