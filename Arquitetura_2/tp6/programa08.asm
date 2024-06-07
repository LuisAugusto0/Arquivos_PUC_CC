#// programa 8
#	Inicialmente escreva um programa que faça:
#	$8 $t0 = 0x12345678.
#	A partir do registrador $8 acima, usando apenas instruções lógicas (or, ori, and, andi,
#	xor, xori) e instruções de deslocamento (sll, srl e sra), você deverá obter os seguintes
#	valores nos respectivos registradores:
#	$9  $t1 = 0x12
#	$10 $t2 = 0x34
#	$11 $t3 = 0x56
#	$12 $t4 = 0x78

.text
.globl main
main:

ori $13, $zero, 0x1234
sll $13, $13, 16
ori $8, $13, 0x5678 # $8 = 0x12345678

andi $12, $8, 0xFF # $12 = 0x78
srl $13, $8, 8
andi $11, $13, 0xFF # $11 = 0x56
srl $13, $13, 8
andi $10, $13, 0xFF # $10 = 0x34
srl $13, $13, 8
andi $9, $13, 0xFF # $10 = 0x12

