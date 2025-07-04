/*
LUÍS AUGUSTO LIMA DE OLIVEIRA - 805413
*/
module Guia_0305;
// define data
reg [11:0] a = 8'b0000000 ; // binary
reg [11:0] b = 8'b0000000 ; // binary
reg [9:0] c;
// actions
initial
begin : main
 $display ( "Guia_0304 - Tests" );

 // letra a
 a = 6'b101011;
 b = 4'b1110;
 $display ( "a) a = %6b", a );
 $display ( "   b = %4b", b );
 c = a-b;
 $display ( "   a-b = %6b = %o(8)", c, c );

 // letra b
 a = 9'b101_101100;
 b = 9'b011_100000;
 $display ( "b) a = %3b,%4b", a[8:6], a[5:2] );
 $display ( "   b = %3b,%4b = %o,%o(8)", b[8:6], b[5:2], b[8:6], b[5:3] );
 c = a-b;
 $display ( "   a-b = %3b,%4b = %o,%o%o(8)", c[8:6], c[5:0], c[8:6], c[5:3], c[2:0] );

 // letra c
 a = 8'b00110110;
 b = 8'hd;
 $display ( "c) a = %6b = %d%d%d", a, a[5:4], a[3:2], a[1:0] );
 $display ( "   b = %4b = %X ", b, b);
 c = a-b;
 $display ( "   a-b = %6b = %o(8)", c, c );

 // letra d
 a = 8'hc3;
 b = 8'b01011001;
 $display ( "d) a = %8b = %x", a, a);
 $display ( "   b = %8b", b );
 c = a-b;
 $display ( "   a-b = %8b = %o(8)", c, c );

  // letra e
 a = 8'b110011;
 b = 8'b00101101;
 $display ( "e) a = %8b = %d", a, a );
 $display ( "   b = %X", b );
 c = a-b;
 $display ( "   a-b = %o(8)", c );

end // main
endmodule // Guia_0305

