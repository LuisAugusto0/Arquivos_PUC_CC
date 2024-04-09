// -------------------------
// Guia_0507.v
// Nome: Luís Augusto Lima de Oliveira
// Matricula: 805413
// -------------------------
 
    module f5a(output s, input a, input b);
      wire not_a, not_b, NnotA_B, NnotB_A, x, y;
      // Descrever por portas
      nor NOR1(not_a, a, a);
      nor NOR2(not_b, b, b);
      nor NOR3(NnotA_B, not_a, b);
      nor NOR4(NnotB_A, not_b, a);
      nor NOR5(x, NnotA_B, NnotB_A);
      nor NOR6(y, a, b);
      nor NOR7(s, x, y);
 
    endmodule // f5a
 
    module f5b(output s, input a, input b);
      // Descrever por expressao
      assign s = ~(a ^ ~b);
 
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
        #2
        x = 1'b0; y = 1'b1;
        #2
        x = 1'b1; y = 1'b0;
        #2
        x = 1'b1; y = 1'b1;
      end
 
    endmodule

