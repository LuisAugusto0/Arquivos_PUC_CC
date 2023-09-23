// -------------------------
// Guia_0800 - FULL ADDER
// Nome: xxx yyy zzz
// Matricula: 999999

// -------------------------
// half subtractor
// -------------------------
module halfSubtractor (output s0, output s1, input a, input b);
    wire not_a;
    not (not_a, a);
    xor XOR1 ( s0, a, b );
    and AND1 ( s1, not_a, b );
endmodule

// -------------------------
// full subtractor
// -------------------------
module fullSubtractor ( output s0, output s1, input a, input b, input carry );
    wire half_s1;
    wire half_s0;
    wire half_carry_s1;
    wire half_carry_s0;


    halfSubtractor MEIASUBTRACAO1(half_s0, half_s1, a, b);
    halfSubtractor MEIASUBTRACAO2(half_carry_s0, half_carry_s1, half_s0, carry);
    
    assign s0 = half_carry_s0;
    or OR_S1(s1, half_carry_s1, half_s1);

endmodule // fullSubtractor

// -------------------------
// Operations
// -------------------------

module operations ( output [6:0] s, output [6:1] carry, input [5:0] a, input [5:0] b, input First_carry );
   fullSubtractor FS1 (s[0], carry[1], a[0], b[0], First_carry);
   fullSubtractor FS2 (s[1], carry[2], a[1], b[1], carry[1]);
   fullSubtractor FS3 (s[2], carry[3], a[2], b[2], carry[2]);
   fullSubtractor FS4 (s[3], carry[4], a[3], b[3], carry[3]);
   fullSubtractor FS5 (s[4], carry[5], a[4], b[4], carry[4]);
   fullSubtractor FS6 (s[5], carry[6], a[5], b[5], carry[5]);
   assign s[6] = carry[6];
endmodule //operations


module test_fullAdder;
    // ------------------------- definir dados
    reg [6:0] a;
    reg [5:0] b;
    reg First_carry;
    reg fim_repet;
    wire [6:0] carry; // “vai-um”
    wire [6:0] s;
    
    assign carry[0] = First_carry;
    // halfAdder HA0 ( carry, soma[0], x[0], y[0] );
    operations O1 ( s, carry[6:1], a[5:0], b[5:0], carry[0] );
    // ------------------------- parte principal
      
    initial begin
        $display("Guia_0800 - xxx yyy zzz - 999999");
        $display("Test ALU’s full adder\n");

        $display("-------------------------------------------------------------------");
        $display("|         a     -      b      -    carry     |        soma        |");
        #1 $monitor("|      %6b        %6b       %7b    |       %6b      |", a[5:0], b[5:0], carry, s);
        #1 $display("-------------------------------------------------------------------");
        #1 a=0; b=0; First_carry=0;
        fim_repet=0;
        while (fim_repet==0) begin
            while (b<63) begin
                #1 b++;
            end
            #1 $display("-------------------------------------------------------------------");
            if(a<63) begin 
                #1 a++; b=0;
            end 
            else begin 
                #1 fim_repet=1;
            end
        end
 
        #1 a=0; b=0; First_carry=1;
        fim_repet=0;
        while (fim_repet==0) begin
             while (b<63) begin
                 #1 b++;
             end
             #1 $display("-------------------------------------------------------------------");
             if(a<63) begin
                 #1 a++; b=0;
             end
             else begin
                 #1 fim_repet=1;
             end
         end

    end
endmodule // test_fullAdder
