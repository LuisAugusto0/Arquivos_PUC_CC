ori  $t0, $zero, 0x1234 #t0 = 0x1234
sll  $t0, $t0, 16 #t0 = 0x12340000
ori  $t0, $t0, 0x5678 #t0 = 0x12345678

andi $t4, $t0, 0x00FF #t4 = 0x0078
andi $t3, $t0, 0xFF00 #t3 = 0x5600
srl $t5, $t0, 16 #t5 = 0x1234
andi $t2, $t5, 0x00FF #t2 = 0x0034
srl $t1, $t0, 24 #t1 = 0x0012
srl $t3, $t3, 8 #t3 = 0x0056


#Abordagem do professor
#andi $t4, $t0, 0x00FF
#srl  $t3, $t3, 8
#andi $t3, $t0, 0xFF00
#srl  $t2, $t2, 24
#sll $t2, $t0, 8
#srl $t1, $t0, 24
