#testage

.data
lbl1: .asciiz "test #1"
lbl2: .asciiz "Ceci est un test!"
.word -125, 125

.text

fuck:
fuck2:
    addi $a0, $zero, -9
    addi $a1, $zero, -3
test: addi $a0, $a0, 1
    slti $t0, $a0, -3
    bne $t0, $zero, test
    la $a3, lbl2
