#associação
#s0 -> X
#s1 -> Y
#s2 -> Z

#inicio
.text
.globl main
main:
ori $s0, $zero, 3 # x = 3
ori $s1, $zero, 4 # y = 4
sll $t0, $s0, 4 # t0 = x * 16
sub $t0, $t0, $s0 #t0 = t0 - x = 15x

sll $t1, $s1, 6 #t1 = y * 64
add $t1, $t1, $s1 #t1 = t1 + y = 65y
add $t1, $t1, $s1 #t1 = t1 + y = 66y
add $t1, $t1, $s1 #t1 = t1 + y = 67y
add $t2, $t0, $t1 #t2 = 15x + 67y

sll $s2, $t2, 2 #z = (15x + 67y) * 4

