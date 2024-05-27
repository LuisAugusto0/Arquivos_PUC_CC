# t0 = 8
# t1 = 9
# t2 = 10
# t3 = 11
# t4 = 12

.text
ori $t0, $zero, 0x1234
sll $t0, $t0, 16
ori $t0, $t0, 0x5678
andi $t4, $t0, 0xFF
srl $t5, $t0, 8
andi $t3, $t5, 0xFF
srl $t5, $t5, 8
andi $t2, $t5, 0xFF
srl $t5, $t5, 8
andi $t1, $t5, 0xFF
.data