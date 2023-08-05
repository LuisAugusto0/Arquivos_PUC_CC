/*
 Guia_0102.v
 999999 - Xxx Yyy Zzz
*/
module Guia_0102;
// define data
 integer x = 0; // decimal
 reg [9:0] b = 10'b000000000; // binary (bits - little endian)
// actions
 initial
 begin : main
 $display ( "Guia_0102 - Tests" );
 
 b = 10'b000001101;
 x = b;
 $display ( "b = %8b", b );
 $display ( "b = %d", x );
 end // main
endmodule // Guia_0102
