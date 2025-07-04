###################
# Associações
###################
# x -> $s0
# y -> $s1

.text
.globl main
main:
	addi $s0, $zero, 1 #x = 1
	add $t0, $s0, $s0  #tmp = 2x
	add $t0, $t0, $t0  #tmp = 4x
	add $t0, $t0, $s0  #tmp = 5x
	addi $s1, $t0, 15  #tmp = 5x + 15