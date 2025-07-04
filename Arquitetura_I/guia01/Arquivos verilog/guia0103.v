/*
Guia_0103.v
Luís Augusto Lima de Oliveira - 805413
*/
module Guia_0103;
// define data
integer x = 0; // decimal
integer base4 = 0; // resposta em base4
reg [7:0] b = 0; // binary
// actions
initial
begin : main
$display ( "Guia_0103 - Tests" );

x = 61;
b = x;

$display ( "x = %d" , x );
$display ( "b = %B (2) = %o (8) = %x (16) = %X (16)", b, b, b, b );

x = 54;
b = x;

$display ( "x = %d" , x );
$display ( "b = %B (2) = %o (8) = %x (16) = %X (16)", b, b, b, b );

x = 77;
b = x;

$display ( "x = %d" , x );
$display ( "b = %B (2) = %o (8) = %x (16) = %X (16)", b, b, b, b );

x = 151;
b = x;

$display ( "x = %d" , x );
$display ( "b = %B (2) = %o (8) = %x (16) = %X (16)", b, b, b, b );

x = 738;
b = x;

$display ( "x = %d" , x );
$display ( "b = %B (2) = %o (8) = %x (16) = %X (16)", b, b, b, b );

end // main
endmodule // Guia_0103
