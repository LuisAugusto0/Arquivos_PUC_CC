
/*
Guia_0401.v
LUÍS AUGUSTO LIMA DE OLIVEIRA - 805413
*/

// ---------------------
// -- expressões
// ---------------------
module fxy (output s, s2, input x, y, input [3:0] letra);
    reg aux, aux2;
    
    always @(*) begin
        case (letra)
            4'ha: begin
                aux = ~x & (~x | y);
                aux2 = ~x | (~x & y);
            end
            4'hb: begin
                aux =  (~x | ~y) | (x & ~y);
                aux2 = ~(x & y);
            end
            4'hc: begin
                aux = ~(x & y) & (~x | ~y);
                aux2 = (~x | ~y) ;
            end
            4'hd: begin
                aux = ~(x & y) | ~(x | y);
                aux2 = ~(x&y);
            end
            4'he: begin
                aux = ~(y | x) & (~y | ~x);
                aux2 = (~y & ~x);
            end
        endcase
    end
    
    assign s = aux;
    assign s2 = aux2;
endmodule // fxy

// ---------------------
// -- test_module
// ---------------------
module test_module;
    
    reg x, y; 
    reg c1, c2;
    reg [3:0] letra;
    wire s, s2;

    // instancias
    fxy FXY1 (s, s2, x, y, letra);
 
    // valores iniciais
    initial begin: start
      x=1'bx; y=1'bx; letra=4'bxxxx; // indefinidos
    end

    // parte principal
    initial begin: main
      // identificacao
      $display("Test 0401");
      letra = 4'ha; 
      x=0; y=0;

      // monitoramento
      $monitor("  %2b %2b = %2b               %2b %2b = %2b", x, y, s, x, y, s2);
  
      // sinalizacao
      repeat (5) begin
	$display("%x.)", letra);
  	case (letra)
            4'ha: begin
            	$display("   ~x & (~x | y)   =    ~(x & y)\n");
	    end
            4'hb: begin
		$display("(~x | ~y)|(x & ~y) =   ~(x & y) | (x & ~y)\n");
            end
            4'hc: begin
		$display(" ~(x&y) & (~x|~y)  =   (~x|~y)\n");
            end
            4'hd: begin
		$display(" ~(x&y) | ~(x|y)   =    ~(x&y)\n");
            end
            4'he: begin
		$display(" ~(y|x) & (~y|~x)  =    (~x & ~y)\n");
            end
        endcase

        $display("   x  y =  s                x  y =  s");
	
        #1 x=0; y=1;
        #1 x=1; y=0;
        #1 x=1; y=1;
	#1 x=0; y=0; letra = letra + 1;
      end
      $display("Aviso: Numero a mais, desconsiderar o ultimo número extra"); 
    end// begin
 endmodule // test_module
