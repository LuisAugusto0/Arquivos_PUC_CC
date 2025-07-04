module f1 ( output s, input a, input b );
    /*
    nand ( nand(nor(a,a), b), nand(nor(a,a), b) )

    ( (a'.b)'. (a'.b)' )'
    ( (a+b') )'
    a'.b
    (a,b) = SoP(1);
    
    */
    wire w1, w2, w3, w4;
    nor NOR_1 (w1, a, a);
    nand NAND_1 (w2, w1, b);
    nand NAND_2 (w3, w1, b);
    nand NAND_3 (s, w2, w3);

endmodule 

module mux (output s, input a, input b, input key);
    wire not_key, w1, w2;
    
    not NOT_1 (not_key, key);
    and AND_1 (w1, a, not_key);
    and AND_2 (w2, b, key);
    or OR_1 (s, w1, w2);
endmodule

module f2 ( output s, input a, input b, input c );
    /*
    mux ( mux(b,b',c), mux(b',b,c'), a )
    
    mux ( xor(b, c), xor(b, c), a )

    xor(b, c)

    (a, b, c) = SoP(1, 2, 5, 6)

    */

    wire not_b, not_c, w1, w2;
    not NOT_1(not_b, b);
    not NOT_2(not_c, c);

    mux MUX_1 (w1, b, not_b, c);
    mux MUX_2 (w2, not_b, b, not_c);
    mux MUX_3 (s, w1, w2, a);    
endmodule




module q03;
    reg a; 
    reg b; 
    reg c;
    wire s1, s2;

    f1 OP1 (s1, a, b);
    f2 OP2 (s2, a, b, c);

    initial begin: start
        a=1'bx; b=1'bx; c=1'bx;
    end

    initial begin: main
        $display("Exercício 3 - Luís Augusto Lima de Oliveira - 805413"); 
        $display("\na.) (a,b) = SoP(1)\n");
        $display(" a  b =  s");
        $monitor("%2b %2b = %2b", a, b, s1);

        #1 a=0; b=0; 
        #1 a=0; b=1; 
        #1 a=1; b=0; 
        #1 a=1; b=1; 

        $display("\n\nb.) (a,b,c) = SoP(1,2,5,6)\n");
        $display(" a  b  c =  s");
        
        a=1'bx; b=1'bx; c=1'bx;
        $monitor("%2b %2b %2b = %2b", a, b, c, s2);

        #1 a=0; b=0; c=0;
        #1 a=0; b=0; c=1;
        #1 a=0; b=1; c=0;
        #1 a=0; b=1; c=1;
        #1 a=1; b=0; c=0;
        #1 a=1; b=0; c=1;
        #1 a=1; b=1; c=0;
        #1 a=1; b=1; c=1;

        

    end

endmodule
