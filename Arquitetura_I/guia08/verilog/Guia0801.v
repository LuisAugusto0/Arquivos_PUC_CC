// -------------------------
// Guia_0800 - FULL ADDER
// Nome: xxx yyy zzz
// Matricula: 999999

// -------------------------
// half adder
// -------------------------
module halfAdder (output s0, output s1, input a, input b);
    // descrever por portas
    xor XOR1 ( s0, a, b );
    and AND1 ( s1, a, b );
endmodule

// -------------------------
// full adder
// -------------------------
module fullAdder ( output s0, output s1, input a, input b, input carryIn );
    // descrever por portas e/ou modulos
    // (valores arbitrarios escolhidos apenas para exemplo)
    wire half_s1;
    wire half_s0;
    wire half_carry_s1;
    wire half_carry_s0;


    halfAdder MEIASOMA1(half_s0, half_s1, a, b);
    halfAdder MEIASOMA2(half_carry_s0, half_carry_s1, half_s0, carryIn);
    
    assign s0 = half_carry_s0;
    or OR_S1(s1, half_carry_s1, half_s1);

endmodule // fullAdder

// -------------------------
// Operations
// -------------------------

module operations ( output [5:0] s, output [5:1] carryIn, input [4:0] a, input [4:0] b, input First_carryIn );
   fullAdder FA1 (s[0], carryIn[1], a[0], b[0], First_carryIn);
   fullAdder FA2 (s[1], carryIn[2], a[1], b[1], carryIn[1]);
   fullAdder FA3 (s[2], carryIn[3], a[2], b[2], carryIn[2]);
   fullAdder FA4 (s[3], carryIn[4], a[3], b[3], carryIn[3]);
   fullAdder FA5 (s[4], carryIn[5], a[4], b[4], carryIn[4]);
   assign s[5] = carryIn[5];
endmodule //operations


module test_fullAdder;
    // ------------------------- definir dados
    reg [5:0] a;
    reg [4:0] b;
    reg First_carryIn;
    reg fim_repet;
    wire [5:0] carry; // “vai-um”
    wire [5:0] s;
    
    assign carry[0] = First_carryIn;
    
    // halfAdder HA0 ( carry, soma[0], x[0], y[0] );
    operations O1 ( s, carry[5:1], a[4:0], b[4:0], carry[0] );
    // ------------------------- parte principal
      
    initial begin
        $display("Guia_0800 - xxx yyy zzz - 999999");
        $display("Test ALU’s full adder\n");

        $display("---------------------------------------------------------------");
        $display("|      vai-um    +     a     +     b      |        soma       |");
        #1 $monitor("|      %6b        %5b       %5b    |       %5b      |", carry, a[4:0], b[4:0], s);
        #1 $display("---------------------------------------------------------------");
        #1 a=0; b=0; First_carryIn=0;
        fim_repet=0;
        while (fim_repet==0) begin
            while (b<5'b11111) begin
                #1 b++;
            end
            #1 $display("---------------------------------------------------------------");
            if(a<5'b11111) begin 
                #1 a++; b=0;
            end 
            else begin 
                #1 fim_repet=1;
            end
        end
 
        #1 a=0; b=0; First_carryIn=1;
        fim_repet=0;
        while (fim_repet==0) begin
             while (b<5'b11111) begin
                 #1 b++;
             end
             #1 $display("---------------------------------------------------------------");
             if(a<5'b11111) begin
                 #1 a++; b=0;
             end
             else begin
                 #1 fim_repet=1;
             end
         end

    end
endmodule // test_fullAdder
