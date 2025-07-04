#// programa 14:
#	Escreva um programa que leia um valor A da memória, identifique se o número é par ou não.
#	Um valor deverá ser escrito na segunda posição livre da memória (0 para par e 1 para ímpar).

################
# Associação
################
# A -> $s0

.text
.globl main
main:
	lui $t0, 0x1001
	lw $s0, 0 ($t0) # A = MEM[0]
	andi $t1, $s0, 0x1
	sw $t1, 4 ($t0) # MEM[1] = verividação

.data
A: .word -2