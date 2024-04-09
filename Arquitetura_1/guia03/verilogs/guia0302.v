/*
Guia_0302.v
LUÍS AUGUSTO LIMA DE OLIVEIRA - 805413
*/
module Guia_0302;
 // define data
 reg [9:0] A = 0; // 10bin
 reg [7:0] a = 0; // 8bin
 reg [6:0] b = 0; // 7bin
 reg [5:0] c = 0; // 6bin
 
 reg [9:0] D = 0; 
 reg [7:0] d = 0; // binary
 reg [6:0] e = 0; // binary
 reg [5:0] f = 0; // binary
 // actions
 initial
 begin : main
  $display ( "Guia_0302 - Tests" );
  
  c = 6'b110110; //base4
  f = ~c+1;
  $display ( " a.) a = %d%d%d(4) = %6b -> C1(a) = %6b -> C2(a) = %6b", c[5:4], c[3:2], c[1:0], c, ~c, f );
 
  a = 8'h5f; //hexa
  b = ~a+1;
  $display ( " b.) a = %h%h(16) = %8b -> C1(a) = %8b -> C2(a) = %8b", a[7:4], a[3:0], a, ~a, b );

  c = 8'b011011; //base4
  f = ~c+1;
  $display ( " c.) a = %d%d%d(4) = %6b -> C1(a) = %6b -> C2(a) = %6b", c[5:4], c[3:2], c[1:0], c, ~c, f );

  A = 10'o147; //oct
  D = ~A+1;
  $display ( " d.) a = %o%o%o%o = %10b -> C1(a) = %10b -> C2(a) = %10b", A[9], A[8:6], A[5:3], A[2:0], A, ~A, D );

  a = 8'hD5; //hexa
  b = ~a+1;
  $display ( " e.) a = %h%h(16) = %8b -> C1(a) = %8b -> C2(a) = %8b", a[7:4], a[3:0], a, ~a, b );
  end // main
 endmodule // Guia_0302
