.text
#ori $t0, $zero, 0x1001
#sll $t0, $t0, 16
lui $t0, 0x1001


lw $s0, 0 ($t0) # s0 = x1(15)
lw $s1, 4 ($t0) # s1 = x2(25)
lw $s2, 8 ($t0) # s2 = x3(13)
lw $s3, 12 ($t0) # s3 = x4(17)

add $t1, $s0, $s1 #t1 = x1 + x2 
add $t1, $t1, $s2 #t1 = t1 + x3
add $s4, $t1, $s3 #s0 = t1 + x4

sw $s4, 16 ($t0) #MEM[T0+16] = soma

.data
x1: .word 15
x2: .word 25
x3: .word 13
x4: .word 17
soma: .word -1

