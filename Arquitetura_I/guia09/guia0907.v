// -------------------------
// Guia_0907
// Nome: Luís Augusto Lima de Oliveira
// Matricula: 805413
// -------------------------

`include "clock.v"
 
module pulse1 ( signal, clock );
    input clock;
    output signal;
    reg signal;
 
 
    initial signal = 1'b0;
    always @(clock) begin
        signal = ~signal;
        #5 signal = ~signal;
    end
endmodule // pulse1
 
module Guia_0907;
    wire clock;
    clock clk ( clock );
    wire p1;
    pulse1 pls1 ( p1, clock );

    initial begin
        $dumpfile ( "Guia_0907.vcd" );
        $dumpvars ( 1, clock, p1);
        #480 $finish;
    end
endmodule // Guia_0907
