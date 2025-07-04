// -------------------------
// Guia_0800 - FULL ADDER
// Nome: xxx yyy zzz
// Matricula: 999999

// -------------------------
// half adder
// -------------------------
module equals (output s, input a, input b);
    // descrever por portas
    xnor XNOR1 ( s, a, b );
endmodule

// -------------------------
// Operations
// -------------------------

module operations ( output [4:0] s, input [4:0] a, input [4:0] b );
   equals FA1 (s[0], a[0], b[0]);
   equals FA2 (s[1], a[1], b[1]);
   equals FA3 (s[2], a[2], b[2]);
   equals FA4 (s[3], a[3], b[3]);
   equals FA5 (s[4], a[4], b[4]);
endmodule //operations


module test_fullAdder;
    // ------------------------- definir dados
    reg [5:0] a;
    reg [4:0] b;
    reg fim_repet;
    wire [4:0] s;
     
    // halfAdder HA0 ( carry, soma[0], x[0], y[0] );
    operations O1 ( s, a[4:0], b[4:0] );
    // ------------------------- parte principal
      
    initial begin
        $display("Guia_0800 - xxx yyy zzz - 999999");
        $display("Test ALU’s full adder\n");

        $display("------------------------------------------------");
        $display("|        a     +     b      |     igualdade    |");
        #1 $monitor("|      %5b       %5b    |       %5b      |", a[4:0], b[4:0], s);
        #1 $display("------------------------------------------------");
        #1 a=0; b=0;
        fim_repet=0;
        while (fim_repet==0) begin
            while (b<5'b11111) begin
                #1 b++;
            end
            #1 $display("------------------------------------------------");
            if(a<5'b11111) begin 
                #1 a++; b=0;
            end 
            else begin 
                #1 fim_repet=1;
            end
        end
 
    end
endmodule // test_fullAdder
