 // ---------------------------
 // -- test clock generator (3)
 // ---------------------------
 `include "clock.v"
 
 module pulse1 ( signal, clock );
     input clock;
     output signal;
     reg signal;
     
     initial signal = 1'b0;
     
     always @(clock) begin
         #36 signal = ~signal;
     end
 endmodule // pulse1
 
 module Guia_0903;
     wire clock;
     clock clk ( clock );
     wire p1;
 
     pulse1 pls1 ( p1, clock );
 
     initial begin
         $dumpfile ( "Guia_0903.vcd" );
         $dumpvars ( 1, clock, p1);
         #480 $finish;
     end
 endmodule // Guia_0903

