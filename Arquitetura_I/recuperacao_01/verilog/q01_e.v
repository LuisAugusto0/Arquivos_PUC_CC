module SoP (output s, input a, b, c, d); // mintermos
    assign s = ~(~(~a&b&~c) & ~(a&b&d) & ~(~b&c));
endmodule // SoP

// ---------------------
// -- test_module
// ---------------------
module test_module;
    reg a, b, c, d;
    wire s1;
    
    SoP SOP1 (s1, a, b, c, d);
    
    initial begin: start
        a=1'bx; b=1'bx; c=1'bx; d=1'bx; // indefinidos
    end
    // parte principal
    initial begin: main
        // identificacao
        $display("Exemplo - Luís Augusto Lima de Oliveira - 805413");
        $display("\nf (a,b,c,d) = SoP(2,3,4,5,A,B,D,F)\n");
        
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
