dtmc

module dice

s : [0..7] init 0;
value : [0..6] init 0;
	
[] s=0 -> 0.5 : (s'=1) + 0.5 : (s'=2);
[] s=1 -> 0.5 : (s'=3) + 0.5 : (s'=4);
[] s=2 -> 0.5 : (s'=5) + 0.5 : (s'=6);
[] s=3 -> 0.5 : (s'=1) + 0.5 : (s'=7) & (value'=1);
[] s=4 -> 0.5 : (s'=7) & (value'=2) + 0.5 : (s'=7) & (value'=3);
[] s=5 -> 0.5 : (s'=7) & (value'=4) + 0.5 : (s'=7) & (value'=5);
[] s=6 -> 0.5 : (s'=2) + 0.5 : (s'=7) & (value'=6);
[] s=7 -> (s'=7);
	
endmodule