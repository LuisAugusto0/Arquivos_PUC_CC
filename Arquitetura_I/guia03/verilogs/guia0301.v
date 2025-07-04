/*
guia0301.v
LUÍS AUGUSTO LIMA DE OLIVEIRA - 805413
*/
module Guia_0301;
// define data
 reg [7:0] a = 0; // binary
 reg [6:0] b = 0; // binary
 reg [5:0] c = 0; // binary
 reg [7:0] d = 0; // binary
 reg [6:0] e = 0; // binary
 reg [5:0] f = 0; // binary

// actions
 initial
 begin : main
  $display ( "Guia_0301 - Tests" );

  c = 6'b001001;
  f = ~c+1;
  $display ( " a.) x = 0 %6b -> C1(a) = 1 %6b -> C2(a) = 1 %6b", c, ~c, f );
  
  a = 8'b00001100;
  d = ~a+1;
  $display ( " b.) x = 0 %8b -> C1(a) = 1 %8b -> C2(a) = 1 %8b", a, ~a, d );

  c = 6'b011101;
  f = ~(c-1);
  $display ( " c.) x = 1 %6b -> C1(a) = 0 %6b -> C2(a) = 0 %6b", c, ~c, f );

  b = 7'b0100111;
  e = ~b+1;
  $display ( " d.) x = 0 %6b -> C1(a) = 1 %6b -> C2(a) = 1 %6b", b, ~b, e );

  a = 8'b00110001;
  d = ~a+1;
  $display ( " e.) x = 0 %8b -> C1(a) = 1 %8b -> C2(a) = 1 %8b", a, ~a, d );

 end // main

endmodule // Guia_0301
