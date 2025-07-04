#// programa 13:
#	Escreva um programa que leia um valor A da memória, identifique se o número é negativo ou
#	não e encontre o seu módulo. O valor deverá ser reescrito sobre A.

################
# Associação
################
# A -> $s0

.text
.globl main
main:
	lui $t0, 0x1001
	lw $s0, 0($t0)
	add $t1, $zero, $s0
	srl $t1, $t1, 31 
	bne $t1, $zero, isPositive
isNegative:
	sub $s0, $zero, $s0
isPositive:
	sw $s0, 0($t0)
	
.data
A: .word 4