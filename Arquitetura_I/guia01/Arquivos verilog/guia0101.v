/*
Guia_0101.v
Luís Augusto Lima de Oliveira - 805413
*/
module Guia_0101;
// define data
integer x = 0; // decimal
reg [9:0] b = 0; // binary (bits - little endian)
// actions
initial
begin : main
$display ( "Guia_0101 - Tests" );

x = 26;
b = x;
$display ( "x = %d" , x );
$display ( "b = %8b", b );

x = 53;
b = x;
$display ( "x = %d" , x );
$display ( "b = %8b", b );

x = 723;
b = x;
$display ( "x = %d" , x );
$display ( "b = %8b", b );

x = 312;
b = x;
$display ( "x = %d" , x );
$display ( "b = %8b", b );

x = 365;
b = x;
$display ( "x = %d" , x );
$display ( "b = %8b", b );

end // main
endmodule // Guia_0101
