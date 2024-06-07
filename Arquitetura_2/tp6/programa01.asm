################
## associações
################
#  a -> $s0
#  b -> $s1
#  c -> $s2
#  d -> $s3
#  x -> $s4
#  y -> $s5

.text
.globl main
main:
addi $s0, $zero, 2 # a = 2
addi $s1, $zero, 3 # b = 3
addi $s2, $zero, 4 # c = 4
addi $s3, $zero, 5 # d = 5
add $t0, $s0, $s1 # tmp = (a+b)
sub $t0, $t0, $s2 #  tmp = (a+b) - c
sub $s4, $t0, $s3 # x = (a+b) - (c+d)
add $t0, $s0, $s4 # tmp = a + x
sub $s5, $t0, $s1 # y = a + x - b
sub $s1, $s4, $s5 # b = x - y