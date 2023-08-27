
/*
Guia_0401.v
LUÍS AUGUSTO LIMA DE OLIVEIRA - 805413
*/

// ---------------------
// -- expressões
// ---------------------
module fxy (output s, input x, y, w, z, input [3:0] letra);
  reg aux;  
  always @(*) begin
        case (letra) 
            4'hc: aux =     (~x & ~y & ~w & z) |
    (~x & ~y & w & z) |
    (~x & y & ~w & ~z) |
    (~x & y & w & ~z) |
    (x & ~y & ~w & z) |
    (x & ~y & w & ~z) |
    (x & y & w & z);
    
            4'hd: aux =    (~x & ~y & ~w & z) |
    (~x & ~y & w & ~z) |
    (~x & y & ~w & z) |
    (~x & y & w & ~z) |
    (x & ~y & ~w & ~z) |
    (x & ~y & w & ~z) |
    (x & y & ~w & ~z);
    
            4'he:     (~x & ~y & ~w & ~z) |
    (~x & ~y & w & ~z) |
    (~x & ~y & w & z) |
    (~x & y & w & z) |
    (x & ~y & ~w & ~z) |
    (x & y & ~w & z);
        endcase
    end
   assign s = aux;
endmodule // fxy

// ---------------------
// -- test_module
// ---------------------
module test_module;
    
    reg x, y, w, z; 
    reg c1, c2;
    reg [3:0] letra;
    wire s;

    // instancias
    fxy FXY1 (s, x, y, w, z, letra);
 
    // valores iniciais
    initial begin: start
      x=1'bx; y=1'bx; z=1'bx; letra=4'bxxxx; // indefinidos
    end

    // parte principal
    initial begin: main
      // identificacao
      $display("Test 0401");
      letra = 4'hc; 
      x=0; y=0; w=0; z=0;

      // monitoramento
      $monitor("  %2b %2b %2b %2b = %2b", x, y, w, z, s);
  
      // sinalizacao
      repeat (3) begin
	$display("%x.)", letra);
        $display("   x  y  w  z =  s");
	
	#1 x=0; y=0; w=0; z=1;
	#1 x=0; y=0; w=1; z=0;
	#1 x=0; y=0; w=1; z=1;
	#1 x=0; y=1; w=0; z=0;
	#1 x=0; y=1; w=0; z=1;
	#1 x=0; y=1; w=1; z=0;
	#1 x=0; y=1; w=1; z=1;
	#1 x=1; y=0; w=0; z=0;
	#1 x=1; y=0; w=0; z=1;
	#1 x=1; y=0; w=1; z=0;
	#1 x=1; y=0; w=1; z=1;
	#1 x=1; y=1; w=0; z=0;
	#1 x=1; y=1; w=0; z=1;
	#1 x=1; y=1; w=1; z=0;
	#1 x=1; y=1; w=1; z=1;
	#1 x=0; y=0; w=0; z=0; letra = letra + 1;
      end
      $display("Aviso: Numero a mais, desconsiderar o ultimo número extra");
     end// begin
 endmodule // test_module
