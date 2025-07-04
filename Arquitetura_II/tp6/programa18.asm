#// programa 18
# Para a expressão a seguir, escreva um programa que calcule o valor de k:
# k = x^y
# Obs: Você poderá utilizar o exercício anterior.

################
# Associações
################
# x -> $s0
# y -> &s1
# k -> $s2

.text
.globl main

main:
	lui $t0, 0x1001
	lw $s0, 0($t0) # x = MEM[0]
	lw $s1, 4($t0) # y = MEM[1]
	beq $s1, $zero, is_zero 
	slt $t2, $zero, $s1   # Se zero for menor que s1 o resultado é = 1
	beq $t2, $zero, error # Se menor que zero, um erro ocorreu (não é calculado valor em float)
	
	pre_loop:
		or $t1, $s0, $s0 # Valor inicial (x)
		addi $t2, $s1, -1 # Contador = y-1
		
	main_loop:
		beq $t2, $zero, end_loop # se contador não for igual a 0, continuar loop
		mul $t1, $t1, $s0 # armazenar valor da multiplicação em t1
		mfhi $t3 # overflow
		bne $t3, $zero, error #se o t3 for diferente de zero, houve overflow, portanto será considerado um erro
		addi $t2, $t2, -1 #Contador--
		j main_loop
	
	error:
		addi $t1, $zero, -1 # Acumulador = -1
		j end_loop
	
	is_zero:
		ori $t1, $zero, 1 # Acumulador = 1
		
	end_loop:

	or $s2, $zero, $t1 # k = x ^ y
	sw $s2, 8($t0) # MEM[2] = k
.data
x: .word 102
y: .word 90
k: .word 0