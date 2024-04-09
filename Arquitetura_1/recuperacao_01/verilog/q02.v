module f ( output s, input a, input b, input c );
    wire w1, w2, w3, w4;
    not NOT_1 (w1, b);
    not NOT_2 (w2, c);
    and AND_1 (w3, a, w2);
    and AND_2 (w4, a, w1, c);
    or OR__1 (s, w3 ,w4);
endmodule // s = f (a,b,c)

module q02;
    reg a; 
    reg b; 
    reg c;
    wire s1;
    
    f SOP1 (s1, a, b, c);
    initial begin: start
        a=1'bx; b=1'bx; c=1'bx;
    end

    initial begin: main
        $display("Exercício 2 - Luís Augusto Lima de Oliveira - 805413"); 
        $display("(a,b,c) = SoP(4,5,6)");
        $display(" a  b  c =  s");
        $monitor("%2b %2b %2b = %2b", a, b, c, s1);

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
