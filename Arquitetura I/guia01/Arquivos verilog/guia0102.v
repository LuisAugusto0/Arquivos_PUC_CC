/*
 Guia_0102.v
 Luís Augusto Lima de Oliveira - 805413
*/
module Guia_0102;
// define data
 integer x = 0; // decimal
 reg [5:0] b = 6'b000000; // binary (bits - little endian)
// actions
 initial
 begin : main
 $display ( "Guia_0102 - Tests" );
 
 b = 6'b010110;
 x = b;
 $display ( "b = %8b", b );
 $display ( "b = %d", x );
  
 b = 6'b011011;
 x = b;
 $display ( "b = %8b", b );
 $display ( "b = %d", x );

 b = 6'b100100;
 x = b;
 $display ( "b = %8b", b );
 $display ( "b = %d", x );

 b = 6'b101001;
 x = b;
 $display ( "b = %8b", b );
 $display ( "b = %d", x );

 b = 6'b110111;
 x = b;
 $display ( "b = %8b", b );
 $display ( "b = %d", x );

 end // main
endmodule // Guia_0102
