	.text
.globl _main
_main:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$24, %esp
	leave
	ret
	.subsections_via_symbols
