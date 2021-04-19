##########################################################################################
# Rood Pointjour--4/23/20
# days_hours.asm
########## Data Segment ##################################################################
.data
user_hours:	.asciiz "\nEnter number of hours: "
days_hours:	.asciiz "\nThe time you entered is equivalent to  day(s) and  hour(s) "
######## Code Segment ####################################################################
.text
.globl main

	main:
	
		la $a0, user_hours
		li $v0, 4
		syscall
		
		li $v0, 5
		syscall
		
		move $t0, $v0
	
		li $s0, 24
		li $s1, 1
		
		
		
	convertHrs:
		beq $s1, $s0, hours_days
		bgt $t0, $s0, display
		
		
	hours_days:
		la $a0, days_hours
		li $v0, 4
		syscall
		j display
		
	display:
		subu $t1, $t0, $s0
		
		la $a0, days_hours
		li $v0, 4
		syscall
		
		li $v0, 1
		move $a0, $t1
		syscall
		
		
		
		
		
		