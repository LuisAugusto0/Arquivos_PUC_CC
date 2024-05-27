#associação
#s0 -> X
#s1 -> Y
#s2 -> Z

#inicio
.text
.globl main
main:
ori $t0, $zero, 0x186A
sll $s0, $t0, 4 # x = 100.000
ori $t2, $zero, 0x30D4
sll $s1, $t2, 4 # y = 200.000

add $s2, $s0, $s1 # z = x + y