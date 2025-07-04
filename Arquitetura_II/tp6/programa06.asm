#// programa 6
#	x = o maior inteiro possível;
#	y = 300000;
#	z = x - 4y

###################
# Associações
###################
#	x -> $s0
#  y -> $s1
#  z -> $s2

.text
.globl main
main:
ori $t0, $zero, 0x7FFF
sll $t0, $t0, 16
ori $s0, $t0, 0xFFFF # x = o maior inteiro possível;

ori $t0, $zero, 0x493E
sll $s1, $t0, 4 # y = 300000;

sll $t0, $s1, 2 # 2y
sub $s2, $s0, $t0 # z = x - 4y
