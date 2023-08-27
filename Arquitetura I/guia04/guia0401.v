
/*
Guia_0303.v
LUÍS AUGUSTO LIMA DE OLIVEIRA - 805413
*/

// ---------------------
// -- expressão
// ---------------------

module fxy (output s, input x, y, z, input [3:0] letra);
  reg aux;  
  always @(*) begin
        case (letra) 
            4'b1010: aux = x & (y | z);
            4'b1011: aux = x & (y | z);
            4'b1100: aux = x & (y | z);
            4'b1101: aux = x & (y | z);
            4'b1110: aux = x & (y | z);
            default: aux = 0; // Valor padrão caso letra não seja 'a' a 'e
        endcase
    end
   assign s = aux;
endmodule // fxy
// ---------------------
// -- test_module
// ---------------------
module test_module;
 
    reg x, y, z;
    reg c1, c2;
    reg [3:0] letra;
    wire s;

    // instancias
    fxy FXY1 (s, x, y, z, letra);
 
    // valores iniciais
    initial begin: start
      x=1'bx; y=1'bx; z=1'bx; letra=4'bxxxx; // indefinidos
    end

    // parte principal
    initial begin: main
      // identificacao
      $display("Test 0401");
   
      // monitoramento
      $display("  x   y   z  =  s");
      $monitor("  %2b %2b %2b = %2b", x, y, z, s);
  
      // sinalizacao
      letra = 4'h9;
      repeat (5) begin
        letra = letra + 1;
        $display("%x.)", letra);
        #1 x=0; y=0; z=0;
        #1 x=0; y=0; z=1;
        #1 x=0; y=1; z=0;
        #1 x=0; y=1; z=1;
        #1 x=1; y=0; z=0;
        #1 x=1; y=0; z=1;
        #1 x=1; y=1; z=0;
        #1 x=1; y=1; z=1;
        #1 x=1'bx; y=1'bx; z=1'bx; 
      end
     end// begin
 endmodule // test_module
