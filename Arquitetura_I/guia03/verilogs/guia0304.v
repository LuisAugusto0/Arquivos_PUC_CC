/*
LUÍS AUGUSTO LIMA DE OLIVEIRA - 805413
*/
module Guia_0304;
// define data
reg [11:0] a = 8'b0000000 ; // binary
reg [11:0] b = 8'b0000000 ; // binary
reg [9:0] c;
// actions
initial
begin : main
 $display ( "Guia_0304 - Tests" );
 
 // letra a
 a = 8'b00011100;
 b = 8'b00001101;
 $display ( "a) a = %5b", a[4:0] );
 $display ( "   b = %5b", b[4:0] );
 c = a-b;
 $display ( "   a-b = %5b", c[4:0] );

 // letra b
 a = 8'b01010111;
 b = 8'b00101100;
 $display ( "b) a = %3b,%4b", a[6:4], a[3:0] );
 $display ( "   b = %3b,%4b", b[6:4], b[3:0] );
 c = a-b;
 $display ( "   a-b = %3b,%4b", c[6:4], c[3:0] );

 // letra c
 a = 8'b00101101;
 b = 8'b00011110;
 $display ( "c) a = %d%d%d", a[5:4], a[3:2], a[1:0] );
 $display ( "   b = %d%d%d", b[5:4], b[3:2], b[1:0] );
 c = a-b;
 $display ( "   a-b = %d%d%d", c[5:4], c[3:2], c[1:0] );

 // letra d
 a = 9'b101001011;
 b = 9'b001111011;
 $display ( "d) a = %o", a);
 $display ( "   b = %o", b );
 c = a-b;
 $display ( "   a-b = %o", c );

  // letra e
 a = 12'b100010110011;
 b = 12'b110001001111;
 $display ( "e) a = %X", a );
 $display ( "   b = %X", b );
 c = b-a;
 $display ( "   a-b = -%X", c );

end // main
endmodule // Guia_0304
