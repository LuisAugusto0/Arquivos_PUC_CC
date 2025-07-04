/*
Guia_0202.v
LUÍS AUGUSTO LIMA DE OLIVEIRA - 805413
*/
module Guia_0202;
// define data
 integer in = 0; //parte inteira
 real x = 0, aux = 0; // decimal
 integer y = 7 ; // counter
 reg [7:0] bB = 0; //binary antes da vírgula
 reg [7:0] bA = 0 ; // binary após virgula
// actions
initial
begin : main
	$display ( "Guia_0202 - Tests" );

	
	in = 0;
	x = 0.75;
	aux = x;
	bB = in;
	y = 7;
	bA = 0;
	
	while ( aux > 0 && aux >= 0 )
	begin
		if ( aux*2 >= 1 )
		 begin
			bA[y] = 1;
			aux = aux*2.0 - 1.0;
		 end
		else
		 begin
			bA[y] = 0;
			aux = aux*2.0;
		 end // end if
		y=y-1;
	end // end while
        $display ( "a) %f = %b.%b" , x+in, bB, bA );

        in = 1;
        x = 0.375;
        aux = x;
        bB = in;
        y = 7;
        bA = 0;

        while ( aux > 0 && aux >= 0 )
        begin
                if ( aux*2 >= 1 )
                 begin
                        bA[y] = 1;
                        aux = aux*2.0 - 1.0;
                 end
                else
                 begin
                        bA[y] = 0;
                        aux = aux*2.0;
                 end // end if
                y=y-1;
        end // end while
        $display ( "b) %f = %b.%b" , x+in, bB, bA );

        in = 2;
        x = 0.625;
        aux = x;
        bB = in;
        y = 7;
        bA = 0;

        while ( aux > 0 && aux >= 0 )
        begin
                if ( aux*2 >= 1 )
                 begin
                        bA[y] = 1;
                        aux = aux*2.0 - 1.0;
                 end
                else
                 begin
                        bA[y] = 0;
                        aux = aux*2.0;
                 end // end if
                y=y-1;
        end // end while
        $display ( "c) %f = %b.%b" , x+in, bB, bA );

        in = 6;
        x = 0.875;
        aux = x;
        bB = in;
        y = 7;
        bA = 0;

        while ( aux > 0 && aux >= 0 )
        begin
                if ( aux*2 >= 1 )
                 begin
                        bA[y] = 1;
                        aux = aux*2.0 - 1.0;
                 end
                else
                 begin
                        bA[y] = 0;
                        aux = aux*2.0;
                 end // end if
                y=y-1;
        end // end while
        $display ( "d) %f = %b.%b" , x+in, bB, bA );

        in = 11;
        x = 0.03125;
        aux = x;
        bB = in;
        y = 7;
        bA = 0;

        while ( aux > 0 && aux >= 0 )
        begin
                if ( aux*2 >= 1 )
                 begin
                        bA[y] = 1;
                        aux = aux*2.0 - 1.0;
                 end
                else
                 begin
                        bA[y] = 0;
                        aux = aux*2.0;
                 end // end if
                y=y-1;
        end // end while
        $display ( "e) %f = %b.%b" , x+in, bB, bA );

end // main
endmodule // Guia_0202
