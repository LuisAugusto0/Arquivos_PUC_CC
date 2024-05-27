#t0 = 0x01
ori $t0, $zero, 0x01 #t0 = 0x01
sll $t0, $t0, 31 #t0 = 0x10000000
sra $t0, $t0, 31 #t0 = 0x11111111