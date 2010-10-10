	.text
.globl _cosa
_cosa:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$8, %esp
	leave
	ret
.globl _main
_main:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$8, %esp
	movl	$0, %eax
	leave
	ret
	.subsections_via_symbols
