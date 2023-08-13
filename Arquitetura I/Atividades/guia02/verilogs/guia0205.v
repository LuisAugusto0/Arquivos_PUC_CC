/*
LUÍS AUGUSTO LIMA DE OLIVEIRA - 805413
*/
module Guia_0205;
// define data
reg [7:0] a = 8'b0000000 ; // binary
reg [7:0] b = 8'b0000000 ; // binary
reg [9:0] c;
// actions
initial
begin : main
 $display ( "Guia_0205 - Tests" );
 
 // letra a
 a = 8'b00101010;
 b = 8'b00011111;
 $display ( "a) a = %5b,%3b", a[7:3], a[2:0] );
 $display ( "   b = %5b,%3b", b[7:3], b[2:0] );
 c = a+b;
 $display ( "   a+b = %7b,%3b", c[9:3], c[2:0] );
 c = a-b;
 $display ( "   a-b = %7b,%3b", c[9:3], c[2:0] );
 c = b-a;
 $display ( "   b-a = %7b,%3b", c[9:3], c[2:0] );
 c = a*b;
 $display ( "   a*b = %5b,%5b", c[9:4], c[5:0] );
 c = a/b;
 $display ( "   a/b = %10b", c );

 // letra b
 a = 8'b01001111;
 b = 8'b00010110;
 $display ( "b) a = %5b,%3b", a[7:3], a[2:0] );
 $display ( "   b = %5b,%3b", b[7:3], b[2:0] );
 c = a+b;
 $display ( "   a+b = %7b,%3b", c[9:3], c[2:0] );
 c = a-b;
 $display ( "   a-b = %7b,%3b", c[9:3], c[2:0] );
 c = b-a;
 $display ( "   b-a = %7b,%3b", c[9:3], c[2:0] );
 c = a*b;
 $display ( "   a*b = %5b,%5b", c[9:4], c[5:0] );
 c = a/b;
 $display ( "   a/b = %10b", c );

 // letra c
 a = 8'b00100101;
 b = 8'b00011110;
 $display ( "c) a = %5b,%3b", a[7:3], a[2:0] );
 $display ( "   b = %5b,%3b", b[7:3], b[2:0] );
 c = a+b;
 $display ( "   a+b = %7b,%3b", c[9:3], c[2:0] );
 c = a-b;
 $display ( "   a-b = %7b,%3b", c[9:3], c[2:0] );
 c = b-a;
 $display ( "   b-a = %7b,%3b", c[9:3], c[2:0] );
 c = a*b;
 $display ( "   a*b = %5b,%5b", c[9:4], c[5:0] );
 c = a/b;
 $display ( "   a/b = %10b", c );

 // letra d
 a = 8'b10110010;
 b = 8'b00010011;
 $display ( "c) a = %5b,%3b", a[7:3], a[2:0] );
 $display ( "   b = %5b,%3b", b[7:3], b[2:0] );
 c = a+b;
 $display ( "   a+b = %7b,%3b", c[9:3], c[2:0] );
 c = a-b;
 $display ( "   a-b = %7b,%3b", c[9:3], c[2:0] );
 c = b-a;
 $display ( "   b-a = %7b,%3b", c[9:3], c[2:0] );
 c = a*b;
 $display ( "   a*b = %5b,%5b", c[9:4], c[5:0] );
 c = a/b;
 $display ( "   a/b = %10b", c );

  // letra e
 a = 8'b01101101;
 b = 8'b00001011;
 $display ( "e) a = %8b", a );
 $display ( "   b = %8b", b );
 c = a+b;
 $display ( "   a+b = %8b", c );
 c = a-b;
 $display ( "   a-b = %8b", c );
 c = b-a;
 $display ( "   b-a = %8b", c );
 c = a*b;
 $display ( "   a*b = %8b", c );
 c = a/b;
 $display ( "   a/b = %8b", c );
 c = a%b; 
 $display ( "   a%%b = %8b", c );

end // main
endmodule // Guia_0205
