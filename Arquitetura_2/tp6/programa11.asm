#// programa 11
#	Considere o seguinte programa: y = x – z + 300000
#	Faça um programa que calcule o valor de y conhecendo os valores de x e z. Os valores de x e z
#	estão armazenados na memória e, na posição imediatamente a seguir, o valor de y deverá ser
#	escrito, ou seja:
#	.data
#	x: .word 100000
#	z: .word 200000
#	y: .word 0 # esse valor deverá ser sobrescrito após a execução do programa.

################
# Associação
################
# x -> $s0
# y -> $s1
# z -> $s2

.text
.globl main
main:
lui $t0, 0x1001

lw $s0, 0($t0) # x = 100000
lw $s2, 4($t0) # x = 200000
sub $t1, $s0, $s2 # x-z
ori $t2, $zero, 0x493E 
sll $t2, $t2, 4 # 300000
add $s1, $t1, $t2 # y = x – z + 300000
sw $s1, 8($t0)
.data 
x: .word 100000
z: .word 200000