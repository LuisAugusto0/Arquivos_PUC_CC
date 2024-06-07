#// programa 5
#x = 100000;
#y = 200000;
#z = x + y;

###################
# Associações
###################
#	x -> $s0
#  y -> $s1
#  z -> $s2

.text
.globl main
main:
ori $t0, $zero, 0x186A 
sll $s0, $t0, 4 # x = 100000;

ori $t0, $zero, 0x30D4
sll $s1, $t0, 4 # Y = 200000;

add $s2, $s0, $s1 # z = x + y;