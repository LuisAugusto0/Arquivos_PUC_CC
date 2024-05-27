#x -> s0
#y -> s1
#z -> s2

ori $s0, $zero, 0x7FFF
sll $s0, $s0, 16
ori $s0, $s0, 0xFFFF
#x = maior valor possível!

ori $s1, $zero, 0x493E
sll $s1, $s1, 4 
#y = 300000

sll $t0, $s1, 2 #t0 = 4y
sub $s2, $s0, $t0 #z = x - t0 (4y)