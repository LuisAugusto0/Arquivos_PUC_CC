`include "clock.v"
`include "Moore_1101.v"

module guia1101;
    wire clk;
    wire result;
    wire[2:0] E1;
    clock CLK( clk );
    reg x;
    reg reset;
    moore_1101 Mly( result, x, clk, reset, E1 );
    
    always @(posedge clk) begin
        #4 x = ~x;
    end

    initial begin
        x = 1'b1;
        reset = 1'b0;
        $dumpfile ( "Guia_0902.vcd" );
        $dumpvars ( 1, clk, x, reset, result, E1);
        #240 $finish;
    end
endmodule
