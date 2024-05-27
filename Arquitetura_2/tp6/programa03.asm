#associação
#s0 -> X
#s1 -> Y
#s2 -> Z

#inicio
# x = 1
# a = 0 
# while(a < 4) { x = x+2; a++; }
#
#
# x = $s0
# a = &s1
.text
addi $s0, $zero, 1 # x = 1
add $s1, $zero, $zero # y = 0

LOOP: beq $s0, $s1, END

 addi $s0, $s0, 2 #x = x+2
 addi $s1, $s1, 1 #a = a+1
j LOOP
END:


.data

