// -------------------------
// Guia_0505.v
// Nome: Luís Augusto Lima de Oliveira
// Matricula: 805413
// -------------------------
 
  module f5a(output s, input a, input b);
    wire not_a, x, y, z;
    // Descrever por portas
    nor NOR1(not_a, a, a);
    nor NOR2(x, a, b);
    nor NOR4(y, x, x);
    nor NOR3(z, not_a, y);
    nor NOR5(s, z, z);
    
  endmodule // f5a
 
  module f5b(output s, input a, input b);
    // Descrever por expressao
    wire v_xnor;
    xnor XNOR1(v_xnor, a, b);
    assign s = (~(a ^ b)) == v_xnor;
 
  endmodule // f5b
 
  module test_f5;
    // ------------------------- Definir dados
    reg x;
    reg y;
    wire a, b;
 
    f5a moduloA(a, x, y);
    f5b moduloB(b, x, y);
 
    // ------------------------- Parte principal
    initial begin : main
      $display("Guia_0501 - Luis Augsuto Lima de Oliveira - 805413:");
      $display("Test module");
      $display("Obs: \n a --> Saída com as portas lógicas \n b --> Saída com a expressão\n\n");
      $display("   x    y    a    b\n");
 
      // Projetar testes do modulo
      $monitor("%4b %4b %4b %4b", x, y, a, b);
 
      x = 1'b0; y = 1'b0;
      #1
      x = 1'b0; y = 1'b1;
      #1
      x = 1'b1; y = 1'b0;
      #1
      x = 1'b1; y = 1'b1;
    end
 
  endmodule // test_f5

