#testage

.data
.word 45, 34, 54
test: .space 55

.text

fuck:
fuck2:
    addi $a0, $zero, -9
    addi $a1, $zero, -3
test: addi $a0, $a0, 1
    slti $t0, $a0, -3
    bne $t0, $zero, test
