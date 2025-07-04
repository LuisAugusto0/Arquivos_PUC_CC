#// programa 17
# Para a expressão a seguir, escreva um programa que calcule o valor de k:
# k = x * y (Você deverá realizar a multiplicação através de somas!)
# O valor de x deve ser lido da primeira posição livre da memória e o valor de y deverá lido da
# segunda posição livre. O valor de k, após calculado, deverá ainda ser escrito na terceira posição
# livre da memória.

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
# guardar valores dos registradores na pilha
addi $sp, $sp, -4
sw $s0, 4($sp)
addi $sp, $sp, -4
sw $s1, 4($sp)
jal multi #chamada de função
# resgatar valores iniciais na pilha
addi $sp, $sp, 4
lw $s1, 0($sp)
addi $sp, $sp, 4
sw $s0, 0($sp)

or $s2, $zero, $v0 # k = x * y
sw $s2, 8($t0)

# Encerrar programa #
addi $v0, $zero, 10
syscall

multi:
	# guardar temporária 0
	addi $sp, $sp, -4
	sw $t0, 4($sp)
	
	or $t0, $zero, $zero 	#Acumulador
	srl $t1, $s1, 31 			#Bit de sinal
	beq $s0, $zero, fim     #Se multiplicando for igual a 0 ir pro fim
	beq $s1, $zero, fim     #Se multiplicador for igual a 0 ir pro fim
	bne $t1, $zero, negativo_preloop #Se bit de sinal for diferente de 0, multiplicador é negativo
	
	positivo_preloop:
		sub $s1, $zero, $s1  #Se positivo, transformar para negativo para melhor manipulação 
		j loop
	negativo_preloop:
		sub $s0, $zero, $s0  #se negativo, trocar sinal do multiplicando
	loop:
		add $t0, $t0, $s0    #Acumulador += x
		addi $s1, $s1, 1     #Contador++
		bne $s1, $zero, loop 
	fim:
	or $v0, $zero, $t0
	jr $ra
	
	# ler temporária 0
	addi $sp, $sp, 4
	lw $t0, 0($sp)
.data
x: .word 20
y: .word -10
k: .word -1