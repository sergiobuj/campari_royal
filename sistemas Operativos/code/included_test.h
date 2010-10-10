/* @(#)included_test.h
 */

#ifndef _INCLUDED_TEST_H
#define _INCLUDED_TEST_H 1
#include <pthread.h>
#include <stdio.h>

typedef struct {
  long p_one;
  int p_two;
} params;

pthread_mutex_t mtx[4];
pthread_mutex_t only_mtx;
int fin;
void* return_sum( void *);

#endif /* _INCLUDED_TEST_H */

