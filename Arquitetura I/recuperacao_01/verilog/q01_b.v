module PoS (output S, input A, B, C, D); // MAXTERMOS
    assign S = (A|B|C|D) & (A|B|C|~D) & (A|~B|~C|~D) & (A|~B|~C|D) & (~A|~B|C|D) & (~A|~B|~C|D) & (~A|B|C|D) & (~A|B|C|~D);
endmodule // PoS

// ---------------------
// -- test_module
// ---------------------
module test_module;
    reg a, b, c, d;
    wire s1;
    
    PoS POS1 (s1, a, b, c, d);
    
    initial begin: start
        a=1'bx; b=1'bx; c=1'bx; d=1'bx; // indefinidos
    end

    initial begin: main
        // identificacao
        $display("Exemplo - Luís Augusto Lima de Oliveira - 805413");
        $display("Test boolean expression");
        $display("\nf (a,b,c,d) = PoS(0,1,6,7,8,9,C,E)\n");
        // monitoramento
        $display(" a  b  c  d =  s");
        $monitor("%2b %2b %2b %2b = %2b", a, b, c, d, s1);
        // sinalizacao
        #1 a=0; b=0; c=0; d=0;
        #1 a=0; b=0; c=0; d=1;
        #1 a=0; b=0; c=1; d=0;
        #1 a=0; b=0; c=1; d=1;
        #1 a=0; b=1; c=0; d=0;
        #1 a=0; b=1; c=0; d=1;
        #1 a=0; b=1; c=1; d=0;
        #1 a=0; b=1; c=1; d=1;
        #1 a=1; b=0; c=0; d=0;
        #1 a=1; b=0; c=0; d=1;
        #1 a=1; b=0; c=1; d=0;
        #1 a=1; b=0; c=1; d=1;
        #1 a=1; b=1; c=0; d=0;
        #1 a=1; b=1; c=0; d=1;
        #1 a=1; b=1; c=1; d=0;
        #1 a=1; b=1; c=1; d=1;
    end
endmodule // test_module

