/*
Guia_0303.v
LUÍS AUGUSTO LIMA DE OLIVEIRA - 805413
*/
module Guia_0303;
// define data
 reg signed [5:0] a = 0; // 6binary
 reg signed [4:0] b = 0; // 5binary
 reg signed [3:0] c = 0; // 4binary
 reg signed [5:0] d = 0; // binary
 reg signed [4:0] e = 0; // binary
 reg signed [3:0] f = 0; // binary
// actions
initial
begin : main
 $display ( "Guia_0303 - Tests" );
 
 c = 4'b0101;
 b = 5'b1_0101;
 f = ~(b-1);
 $display ( " a.) x = 1 %4b -> C1(a) = %4b -> C2(a) = %4b = %d(10) = %d(10)", c, ~c, f, ~b, (~(b-1)) );
 
 b = 5'b10011;
 e = ~(b-1);
 $display ( " b.) x = 1 %5b -> C1(a) = %5b -> C2(a) = %5b = %d(10) = %d(10)", b, ~b, e, ~b, e );

 b = 5'b00111;
 e = ~(b-1);
 $display ( " c.) x = 1 %5b -> C1(a) = %5b -> C2(a) = %5b", b, ~b, e );


 a = 6'b011011;
 d = ~(a-1);
 $display ( " d.) b = 1 %6b -> C1(b) = %6b -> C2(b) = %6b ", b, ~b, d);
 
 a = 6'b010001;
 d = ~(a-1);
 $display ( " e.) c = %6b -> C1(c) = %6b -> C2(c) = %6b = %X = %X", c, ~c, d, ~a, d );
end // main end // main
endmodule // Guia_0303
