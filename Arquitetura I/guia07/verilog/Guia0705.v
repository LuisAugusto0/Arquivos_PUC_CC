// -------------------------
// Guia_0705 - GATES
// Nome: Luís Augusto Lima de Oliveira
// Matricula: 805413

// -------------------------
// multiplexer
// -------------------------
module mux ( output s, input a, input b, input [2:0] select);
    // definir dados locais
    wire not_select[2:0];
    wire not_selectGrupo;
    
    wire Not_a; //000
    wire Not_b; //001
    wire And; //010
    wire Nand; //011
    wire Xor; //100
    wire Xnor; //101
    wire Or; //110
    wire Nor; //111

    wire SNot_a; //000
    wire SNot_b; //001
    wire SAnd; //010
    wire SNand; //011
    wire SXor; //100
    wire SXnor; //101
    wire SOr; //110
    wire SNor; //111
    
    // descrever por portas
    not NOT1 ( not_select[0], select[0] );
    not NOT2 ( not_select[1], select[1] );
    not NOT3 ( not_select[2], select[2] );
    
    not NOT_A (Not_a, a);
    not NOT_B (Not_b, b);
    and AND_AB (And, a, b);
    nand NAND_AB (Nand, a, b);
    xor XOR_AB ( Xor, a, b );
    xnor XNOR_AB ( Xnor, a, b );
    or OR_AB ( Or, a, b );
    nor NOR_AB ( Nor, a, b );
    
    and AND_NOT_A (SNot_a, Not_a, not_select[2], not_select[1], not_select[0]);
    and AND_NOT_B (SNot_b, Not_b, not_select[2], not_select[1],     select[0]);
    and AND_AND   (SAnd,   And,   not_select[2],     select[1], not_select[0]);
    and AND_NAND  (SNand,  Nand,  not_select[2],     select[1],     select[0]);
    and AND_XOR   (SXor,   Xor,       select[2], not_select[1], not_select[0]);
    and AND_XNOR  (SXnor,  Xnor,      select[2], not_select[1],     select[0]);
    and AND_OR    (SOr,    Or,        select[2],     select[1], not_select[0]);
    and AND_NOR   (SNor,   Nor,       select[2],     select[1],     select[0]);
    
    or OR1 ( s , SNot_a, SNot_b, SAnd, SNand, SXor, SXnor, SOr, SNor );


endmodule // mux
    
module test_f7;
    // ------------------------- definir dados
    reg x;
    reg y;
    reg[2:0] s;
    wire s1;
    wire s2;
    wire s3;
    wire s4;
    wire Mux;

    mux MUX1 ( Mux, x, y, s[2:0] );// ------------------------- parte principal
    
    initial
    begin : main
        $display("Guia_0705 - Luís Augusto Lima de Oliveira - 805413");
        $display("Test LU's module");
        $display("\nPrevisão: \n\t - Para S=000   SoP(x,y) = m(0,1)  \t not x\n\t - Para S=001   SoP(x,y) = m(0,2)\t not y\n\t - Para S=010   SoP(x,y) = m(3)   \t AND \n\t - Para S=011   SoP(x,y) = m(0,1,2)  \t NAND\n\t - Para S=110   SoP(x,y) = m(1,2)  \t xor\n\t - Para S=101   SoP(x,y) = m(0,3)   \t xnor\n\t - Para S=110   SoP(x,y) = m(1,2,3)   \t or\n\t - Para S=111   SoP(x,y) = m(0)     \t nor\n");
        
        $display("---------------------------------------------------------");
        $display("|   Entradas   |    Seleção              |   Saída MUX  |");
        $display("|    x     y   |     s[2]  S[1]  S[0]    |       s      |");
        // projetar testes do modulo
        #1 $monitor("| %4b  %4b   |    %4b %4b %4b       |    %4b      |", x, y, s[2], s[1], s[0], Mux);
        
        #1 $display("|              |                         |              |");
        #1 x = 1'b0; y = 1'b0; s = 3'b000;
        #1 x = 1'b0; y = 1'b1; s = 3'b000;
        #1 x = 1'b1; y = 1'b0; s = 3'b000;
        #1 x = 1'b1; y = 1'b1; s = 3'b000;
        #1 $display("---------------------------------------------------------");

        repeat (7) begin
            #1 x = 1'b0; y = 1'b0; s += 1; 
            #1 x = 1'b0; y = 1'b1; 
            #1 x = 1'b1; y = 1'b0; 
            #1 x = 1'b1; y = 1'b1;
            #1 $display("---------------------------------------------------------");
        end
    end
endmodule // test_f7

