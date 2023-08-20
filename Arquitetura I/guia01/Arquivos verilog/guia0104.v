/*
Guia_0104.v
Luís Augusto Lima de Oliveira - 805413
*/
module Guia_0104;
// define data
integer x = 0; // decimal
reg [7:0] b = 0; // binary
// actions
initial
begin : main
$display ( "Guia_0104 - Tests" );

x = 21;
b = x;
$display ( "x = %d" , x );
$display ( "b = [%4b] [%4b] = %x%x(16)", b[7:4], b[3:0], b[7:4], b[3:0] );

x = 26;
b = x;
$display ( "x = %d" , x );
$display ( "b = [%4b] [%4b] = %x%x(16) %o(8)", b[7:4], b[3:0], b[7:4], b[3:0], b);


x = 39;
b = x;
$display ( "x = %d" , x );
$display ( "b = [%4b] [%4b] = %x%x(16)", b[7:4], b[3:0], b[7:4], b[3:0] );

x = 41;
b = x;
$display ( "x = %d" , x );
$display ( "b = [%4b] [%4b] = %x%x(16) %o(8)", b[7:4], b[3:0], b[7:4], b[3:0], b );

x = 35;
b = x;
$display ( "x = %d" , x );
$display ( "b = [%4b] [%4b] = %x%x(16)", b[7:4], b[3:0], b[7:4], b[3:0] );

end // main
endmodule // Guia_0104
