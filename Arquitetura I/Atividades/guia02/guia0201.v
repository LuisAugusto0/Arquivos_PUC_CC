/*
Guia_0201.v
999999 - Xxx Yyy Zzz
*/
module Guia_0201;
// define data
real
x = 0 ; // decimal
real power2 = 1.0; // power of 2
integer
y = 7 ; // counter
reg [7:0] a = 8'b00000000; // binary (only integral part, Big Endian)
reg [7:0] b = 8'b00000000; // binary (only fraction part, Big Endian)
// actions
initial
begin : main

 power2 = 1.0;
 y = 7;
 x = 0;
 a = 8'b00000000;
 b = 8'b01101000;
 $display ( "Guia_0201 - Tests" );
 while ( y >= 0 )
  begin
   power2 = power2 / 2.0;
   if ( b[y] == 1 )
   begin
    x = x + power2;
   end
   y=y-1;
  end // end while
 $display ( "a) %8b,%8b = %d + %f", a, b, a, x );
 power2 = 1.0; 
 y = 7; 
 x = 0;
 a = 8'b00000000;
 b = 8'b10011000;
 while ( y >= 0 )
  begin
   power2 = power2 / 2.0;
   if ( b[y] == 1 )
   begin
    x = x + power2;
   end
   y=y-1;
  end // end while
 $display ( "b) %8b,%8b = %d + %f", a, b, a, x );

 power2 = 1.0;
 y = 7;
 x = 0;
 a = 8'b00000000;
 b = 8'b10101000;
 while ( y >= 0 )
  begin
   power2 = power2 / 2.0;
   if ( b[y] == 1 )
   begin
    x = x + power2;
   end
   y=y-1;
  end // end while
 $display ( "c) %8b,%8b = %d + %f", a, b, a, x );

 power2 = 1.0;
 y = 7;
 x = 0;
 a = 8'b00000001;
 b = 8'b11011000;
 while ( y >= 0 )
  begin
   power2 = power2 / 2.0;
   if ( b[y] == 1 )
   begin
    x = x + power2;
   end
   y=y-1;
  end // end while
 $display ( "d) %8b,%8b = %d + %f", a, b, a, x );

 power2 = 1.0;
 y = 7;
 x = 0;
 a = 8'b00000011;
 b = 8'b11011000;
 while ( y >= 0 )
  begin
   power2 = power2 / 2.0;
   if ( b[y] == 1 )
   begin
    x = x + power2;
   end
   y=y-1;
  end // end while
 $display ( "e) %8b,%8b = %d + %f", a, b, a, x );

 end // main
endmodule // Guia_0201
