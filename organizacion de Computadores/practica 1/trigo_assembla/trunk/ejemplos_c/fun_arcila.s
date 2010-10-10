	.literal8
	.align 3
LC0:
	.long	-1571644103
	.long	1066524486
	.text
	.align 1,0x90
.globl __Z5toRadi
__Z5toRadi:
LFB18:
	pushl	%ebp
LCFI0:
	movl	%esp, %ebp
LCFI1:
	subl	$24, %esp
LCFI2:
	call	L3
"L00000000001$pb":
L3:
	popl	%ecx
	cvtsi2sd	8(%ebp), %xmm1
	leal	LC0-"L00000000001$pb"(%ecx), %eax
	movsd	(%eax), %xmm0
	mulsd	%xmm1, %xmm0
	cvtsd2ss	%xmm0, %xmm0
	movss	%xmm0, -12(%ebp)
	flds	-12(%ebp)
	leave
	ret
LFE18:
	.literal4
	.align 2
LC1:
	.long	1065353216
	.text
	.align 1,0x90
.globl __Z5trigofb
__Z5trigofb:
LFB19:
	pushl	%ebp
LCFI3:
	movl	%esp, %ebp
LCFI4:
	pushl	%ebx
LCFI5:
	subl	$68, %esp
LCFI6:
	call	L14
"L00000000002$pb":
L14:
	popl	%ebx
	movl	12(%ebp), %eax
	movb	%al, -44(%ebp)
	movl	8(%ebp), %eax
	movl	%eax, -32(%ebp)
	movzbl	-44(%ebp), %eax
	testl	%eax, %eax
	jne	L5
	leal	LC1-"L00000000002$pb"(%ebx), %eax
	movl	(%eax), %eax
	movl	%eax, -32(%ebp)
L5:
	movl	-32(%ebp), %eax
	movl	%eax, -28(%ebp)
	movss	8(%ebp), %xmm0
	mulss	8(%ebp), %xmm0
	movss	%xmm0, -24(%ebp)
	leal	LC1-"L00000000002$pb"(%ebx), %eax
	movl	(%eax), %eax
	movl	%eax, -20(%ebp)
	movl	$1, -16(%ebp)
	movl	$1, -12(%ebp)
	jmp	L7
L8:
	movl	-16(%ebp), %eax
	movl	$0, %edx
	movl	%edx, %ecx
	subl	%eax, %ecx
	movl	%ecx, %eax
	movl	%eax, -16(%ebp)
	cmpb	$0, -44(%ebp)
	je	L9
	movl	-12(%ebp), %eax
	addl	%eax, %eax
	incl	%eax
	imull	-12(%ebp), %eax
	addl	%eax, %eax
	cvtsi2ss	%eax, %xmm1
	movss	-20(%ebp), %xmm0
	mulss	%xmm1, %xmm0
	movss	%xmm0, -20(%ebp)
	jmp	L11
L9:
	movl	-12(%ebp), %eax
	addl	%eax, %eax
	decl	%eax
	imull	-12(%ebp), %eax
	addl	%eax, %eax
	cvtsi2ss	%eax, %xmm1
	movss	-20(%ebp), %xmm0
	mulss	%xmm1, %xmm0
	movss	%xmm0, -20(%ebp)
L11:
	movss	-28(%ebp), %xmm0
	mulss	-24(%ebp), %xmm0
	movss	%xmm0, -28(%ebp)
	cvtsi2ss	-16(%ebp), %xmm0
	mulss	-28(%ebp), %xmm0
	movaps	%xmm0, %xmm1
	divss	-20(%ebp), %xmm1
	movss	-32(%ebp), %xmm0
	addss	%xmm1, %xmm0
	movss	%xmm0, -32(%ebp)
	leal	-12(%ebp), %eax
	incl	(%eax)
L7:
	cmpl	$7, -12(%ebp)
	jle	L8
	movl	-32(%ebp), %eax
	movl	%eax, -60(%ebp)
	movss	-60(%ebp), %xmm0
	movss	%xmm0, -60(%ebp)
	flds	-60(%ebp)
	addl	$68, %esp
	popl	%ebx
	leave
	ret
LFE19:
	.align 1,0x90
.globl _main
_main:
LFB20:
	pushl	%ebp
LCFI7:
	movl	%esp, %ebp
LCFI8:
	subl	$8, %esp
LCFI9:
	movl	$0, %eax
	leave
	ret
LFE20:
	.globl __Z5toRadi.eh
__Z5toRadi.eh = 0
.no_dead_strip __Z5toRadi.eh
	.globl __Z5trigofb.eh
__Z5trigofb.eh = 0
.no_dead_strip __Z5trigofb.eh
	.globl _main.eh
_main.eh = 0
.no_dead_strip _main.eh
	.constructor
	.destructor
	.align 1
	.subsections_via_symbols
