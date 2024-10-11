#include<stdio.h>
#include<unistd.h>
#include<pthread.h>

void *fun1(void *p)
{
	int num = 5;
	for(int i = 0 ; i <= 10 ; i++)
	{
		printf("fun1(%d) : %d \n", num, num * i);
		sleep(1);
	}
}

void *fun2(void *p)
{
	int num = 6;
	for(int i = 0 ; i <= 10 ; i++)
	{
		printf("fun1(%d) : %d \n", num, num * i);
		sleep(1);
	}
}

void *fun3(void *p)
{
	int num = 7;
	for(int i = 0 ; i <= 10 ; i++)
	{
		printf("fun1(%d) : %d \n", num, num * i);
		sleep(1);
	}
}

int main(void)
{
	pthread_t t1, t2, t3;

	pthread_create(&t1, NULL, fun1, NULL);
	pthread_create(&t2, NULL, fun2, NULL);
	pthread_create(&t3, NULL, fun3, NULL);
	
	pthread_join(t1, NULL);
	pthread_join(t2, NULL);
	pthread_join(t3, NULL);

	return 0;
}








