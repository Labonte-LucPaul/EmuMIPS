#testage

.data
lbl1: .asciiz "test #1"
lbl2: .asciiz "Ceci est un test!"
val: .word -125, 125, 0

.text

main:
fuck:
fuck2:
    addi $a0, $zero, -9
    addi $a1, $zero, -3
test: addi $a0, $a0, 1
    slti $t0, $a0, -3
    bne $t0, $zero, test
    la $a3, val
    sw $a0, 8($a3)
    lw $t0, 0($a3)
    lw $t1, 4($a3)
    lb $t3, 0($a3)
