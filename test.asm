fuck:
fuck2:
    add $a0, $zero, $zero
    addi $a1, $zero, 9
test: addi $a0, $a0, 1
    slti $t0, $a0, 9
    bne $t0, $zero, test
