// -------------------------
// Guia_0506.v
// Nome: Luís Augusto Lima de Oliveira
// Matricula: 805413
// -------------------------

   module f5a(output s, input a, input b);
     wire not_a, x, y;
     // Descrever por portas
     nand NAND1(not_a, a, a);
     nand NAND2(x, a, b);
     nand NAND4(y, x, x);
     nand NAND3(s, not_a, y);
 
   endmodule // f5a
 
   module f5b(output s, input a, input b);
     // Descrever por expressao
     wire v_xor;
     xor NOR1(v_xor, a, b);
     assign s = (a ^ b) == v_xor;
 
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
 
   endmodule
