#// programa 16
#	Escreva um programa que avalie a expressão: (x*y)/z.
#	Use x = 1600000 (=0x186A00), y = 80000 (=0x13880), e z = 400000 (=0x61A80). Inicializar os
#	registradores com os valores acima.

################
# Associações
################
# x -> $s0
# y -> &s1
# z -> $s2
# result -> $s3

.text
.globl main
main:
ori $t0, $zero, 0x186A  # TMPx = 0x186A
sll $s0, $t0, 8 			# x = 0x186A00

ori $t0, $zero, 0x1388	# TMPy = 0x1388
sll $s1, $t0, 4			# y = 0x13880

ori $t0, $zero, 0x61A8  # TMPz = 0x61A8
sll $s2, $t0, 4         # z = 0x61A80

div $s0, $s2 				# x/z

mflo $t1
mul $s3, $t1, $s1				# x/z * y

.data