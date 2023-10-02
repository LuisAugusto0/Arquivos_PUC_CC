// -------------------------
// Guia_0900 - clock generator
// Nome: Luís Augusto Lima de Oliveira
// Matricula: 805413
// -------------------------


module clock(output clk);
    reg clk;

    initial begin
        clk = 1'b0;
    end

    always begin
        #12 clk = ~clk;
    end
endmodule // clock()
