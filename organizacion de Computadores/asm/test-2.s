	.text
.globl _main
_main:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$24, %esp
	movl	$7, -12(%ebp)
	leave
	ret
	.subsections_via_symbols
