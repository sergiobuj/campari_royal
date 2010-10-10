	.text
.globl _main
_main:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$24, %esp
	movl	$1, -16(%ebp)
	movl	$3, -12(%ebp)
	movl	-16(%ebp), %eax
	imull	-12(%ebp), %eax
	movl	%eax, -16(%ebp)
	leave
	ret
	.subsections_via_symbols
