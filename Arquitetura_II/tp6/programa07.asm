#// programa 7
#	Considere a seguinte instrução iniciando um programa:
#	ori $8, $0, 0x01
#	Usando apenas instruções reg-reg lógicas e/ou instruções de deslocamento (sll, srl e
#	sra), continuar o programa de forma que ao final, tenhamos o seguinte conteúdo no
#	registrador $8:
#	$8 = 0xFFFFFFFF

###################
# Associações
###################
#	x -> $s0


.text
.globl main
main:
ori $8, $zero, 1
sub $8, $zero, $8