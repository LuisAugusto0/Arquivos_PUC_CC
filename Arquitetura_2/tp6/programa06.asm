#associação
#s0 -> X
#s1 -> Y
#s2 -> Z

#inicio
.text
.globl main
main:
ori $t0, $zero, 0x7FFF
sll $t0, $t0, 16
ori $s0, $t0, 0xFFFF # x = maior inteiro possível
ori $t1, $zero, 0x493E
sll $s1, $t1, 4 # y = 300.000
sll $t2, $s1, 2 # t2 = 4y
sub $s2, $s0, $t2 # z = x - 4y
