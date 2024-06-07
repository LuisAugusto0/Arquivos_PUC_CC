#// programa 3 (add, addi, sub, lógicas)
#	x = 3;
#	y = 4 ;
#	z = ( 15*x + 67*y)*4

###################
# Associações
###################
# x -> $s0
# y -> $s1
# z -> $s2

.text
.globl main
main:
	addi $s0, $zero, 3 # x = 3
	addi $s1, $zero, 4 # y = 4
	
	add $t0, $s0, $s0 # tmp0 = 2x
	add $t0, $t0, $t0 # tmp0 = 4x
	add $t0, $t0, $t0 # tmp0 = 8x
	add $t0, $t0, $t0 # tmp0 = 16x
	sub $t0, $t0, $s0 # tmp0 = 15x
	
	add $t1, $s1, $s1 # tmp1 = 2y
	add $t1, $t1, $t1 # tmp1 = 4y
	add $t1, $t1, $t1 # tmp1 = 8y
	add $t1, $t1, $t1 # tmp1 = 16y
	add $t1, $t1, $t1 # tmp1 = 32y
	add $t1, $t1, $t1 # tmp1 = 64y
	add $t1, $t1, $s1 # tmp1 = 65y
	add $t1, $t1, $s1 # tmp1 = 66y
	add $t1, $t1, $s1 # tmp1 = 67y
	
	add $t0, $t1, $t0 # tmp0 = tmp0 + tmp1
	add $t0, $t0, $t0 # tmp0 = 2 tmp0
	add $s2, $t0, $t0 # z = 4 tmp0