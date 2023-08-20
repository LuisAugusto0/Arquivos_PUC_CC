/*
Guia_0203.v
LUÍS AUGUSTO LIMA DE OLIVEIRA - 805413
*/
module Guia_0203;
// define data
integer in = 0, contador = 7, pow2 = 1; // inteiro
real x = 0.0; // decimal
reg [7:0] bB = 8'b00000000 ; //binary antes da virgula
reg [11:0] bA = 12'b000000000000 ; // binary depois da virgula
// actions
initial
 begin : main
  $display ( "Guia_0203 - Tests" );
  
  //questão A
  bB = 8'b00000000;
  bA = 12'b110110000000;
  x = 0.0;
  in = bB;
  pow2 = 1;

  contador = 7;
  while ( contador >= 0 )
   begin
    pow2 *= 2;
    if ( bA[contador] == 1 )
     begin
      x += 1.0/pow2; 
     end //end if
    contador -= 1;
   end // end while
  $display ( "a) %f = %8b.%8b (2)" , x, bB, bA );
  $display ( "  hex = %x%x.%x%x%x (16)", bB[7:4], bB[3:0], bA[11:8],bA[7:4], bA[3:0]);
  $display ( "  oct = %o%o%o.%o%o%o%o (8) ",  bB[7:6], bB[5:3], bB[2:0], bA[11:9],bA[8:6],bA[5:3], bA[2:0]);
  $display ( "  qua = %d%d%d%d.%d%d%d%d%d%d (4)", bB[7:6], bB[5:4], bB[3:2], bB[1:0], bA[11:10], bA[9:8], bA[7:6], bA[5:4], bA[3:2], bA[1:0]);
 
  //questao B
  bB = 8'b00000000;
  bA = 12'b001111100111;
  x = 0.0;
  in = bB;
  pow2 = 1;

  contador = 7;
  while ( contador >= 0 )
   begin
    pow2 *= 2;
    if ( bA[contador] == 1 )
     begin
      x += 1.0/pow2;
     end //end if
    contador -= 1;
   end // end while

  $display ( "b) %f = %8b.%8b (2)" , x, bB, bA );
  $display ( "  hex = %x%x.%x%x%x (16)", bB[7:4], bB[3:0], bA[11:8],bA[7:4], bA[3:0]);
  $display ( "  oct = %o%o%o.%o%o%o%o (8) ",  bB[7:6], bB[5:3], bB[2:0], bA[11:9],bA[8:6],bA[5:3], bA[2:0]);
  $display ( "  qua = %d%d%d%d.%d%d%d%d%d%d (4)", bB[7:6], bB[5:4], bB[3:2], bB[1:0], bA[11:10], bA[9:8], bA[7:6], bA[5:4], bA[3:2], bA[1:0]);


  //questao C
  bB = 8'b00000000;
  bA = 12'b111101001000;
  x = 0.0;
  in = bB;
  pow2 = 1;

  contador = 7;
  while ( contador >= 0 )
   begin
    pow2 *= 2;
    if ( bA[contador] == 1 )
     begin
      x += 1.0/pow2;
     end //end if
    contador -= 1;
   end // end while

  $display ( "c) %f = %8b.%8b (2)" , x, bB, bA );
  $display ( "  hex = %x%x.%x%x%x (16)", bB[7:4], bB[3:0], bA[11:8],bA[7:4], bA[3:0]);
  $display ( "  oct = %o%o%o.%o%o%o%o (8) ",  bB[7:6], bB[5:3], bB[2:0], bA[11:9],bA[8:6],bA[5:3], bA[2:0]);
  $display ( "  qua = %d%d%d%d.%d%d%d%d%d%d (4)", bB[7:6], bB[5:4], bB[3:2], bB[1:0], bA[11:10], bA[9:8], bA[7:6], bA[5:4], bA[3:2], bA[1:0]);


  //questao D
  bB = 8'b00000111;
  bA = 12'b010011001000;
  x = 0.0;
  in = bB;
  pow2 = 1;

  contador = 7;
  while ( contador >= 0 )
   begin
    pow2 *= 2;
    if ( bA[contador] == 1 )
     begin
      x += 1.0/pow2;
     end //end if
    contador -= 1;
   end // end while

  $display ( "d) %f = %8b.%8b (2)" , x, bB, bA );
  $display ( "  hex = %x%x.%x%x%x (16)", bB[7:4], bB[3:0], bA[11:8],bA[7:4], bA[3:0]);
  $display ( "  oct = %o%o%o.%o%o%o%o (8) ",  bB[7:6], bB[5:3], bB[2:0], bA[11:9],bA[8:6],bA[5:3], bA[2:0]);
  $display ( "  qua = %d%d%d%d.%d%d%d%d%d%d (4)", bB[7:6], bB[5:4], bB[3:2], bB[1:0], bA[11:10], bA[9:8], bA[7:6], bA[5:4], bA[3:2], bA[1:0]);

  //questao E
  bB = 8'b00001010;
  bA = 12'b101101010010;
  x = 0.0;
  in = bB;
  pow2 = 1;

  contador = 7;
  while ( contador >= 0 )
   begin
    pow2 *= 2;
    if ( bA[contador] == 1 )
     begin
      x += 1.0/pow2;
     end //end if
    contador -= 1;
   end // end while

  $display ( "e) %f = %8b.%8b (2)" , x, bB, bA );
  $display ( "  hex = %x%x.%x%x%x (16)", bB[7:4], bB[3:0], bA[11:8],bA[7:4], bA[3:0]);
  $display ( "  oct = %o%o%o.%o%o%o%o (8) ",  bB[7:6], bB[5:3], bB[2:0], bA[11:9],bA[8:6],bA[5:3], bA[2:0]);
  $display ( "  qua = %d%d%d%d.%d%d%d%d%d%d (4)", bB[7:6], bB[5:4], bB[3:2], bB[1:0], bA[11:10], bA[9:8], bA[7:6], bA[5:4], bA[3:2], bA[1:0]);



 end // main
endmodule // Guia_0203
