#include<stdio.h>
#include<pthread.h>
#include<unistd.h>
#include<semaphore.h>

int count = 0;
sem_t s;

void *thread_fun1(void *param)
{
	// dec
	for(int i = 1 ; i <= 10 ; i++)
	{
		sem_wait(&s);
		int num = count;
		num--;
		count = num;
		printf("Thread1 : count = %d\n", count);
		sem_post(&s);
		sleep(1);
	}
}

void *thread_fun2(void *param)
{
	// inc
	for(int i = 1 ; i <= 10 ; i++)
	{
		sem_wait(&s);
		int num = count;
		num++;
		count = num;
		printf("Thread2 : count = %d\n", count);
		sem_post(&s);
		sleep(1);
	}

}

int main(void)
{
	pthread_t t1, t2;
	
	sem_init(&s, 0, 1);

	printf("Before threads :  count = %d\n", count);

	pthread_create(&t1, NULL, thread_fun1, NULL);
	pthread_create(&t2, NULL, thread_fun2, NULL);
	
	pthread_join(t1, NULL);
	pthread_join(t2, NULL);

	sem_destroy(&s);
	printf("Final count = %d\n", count);

	return 0;
}







