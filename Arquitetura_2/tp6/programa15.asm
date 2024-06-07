#// programa 15:
#	Escrever um programa que crie um vetor de 100 elementos na memória onde vetor[i] = 2*i + 1. 
#  Após a última posição do vetor criado, escrever a soma de todos os valores armazenados
#	do vetor.
#	Use o MARS para verificar a quantidade de instruções conforme o tipo (ULA, Desvios, Mem ou
#	Outras)

################
# Associação
################
# i -> $s0

.text
.globl main
main:
	add $s0, $zero, $zero #i = 0 
	ori $t0, $zero, 100 #condição de parada
	add $t3, $zero, $zero #acumulador
	lui $t1, 0x1001 #posição gravada
	loop:
		add $t2, $s0, $s0
		addi $t2, $t2, 1 # 2*i + 1
		add $t3, $t3, $t2 # acumulador = acmld + t2
		sw $t2, 0 ($t1) # MEM[i] = 2*i + 1
		addi $s0, $s0, 1 #aumentar condição de parada
		addi $t1, $t1, 4 #aumentar posição de gravação
		bne $s0, $t0, loop
	end_loop:
		sw $t3, 0 ($t1) #guardar acumulador na memoria