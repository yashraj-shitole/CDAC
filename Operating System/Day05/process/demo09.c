#include<stdio.h>
#include<unistd.h>
#include<sys/wait.h>

int main(void)
{
	int ret, s;
	printf("Program started\n");
	ret = fork();
	if(ret == 0)
	{
		printf("child : pid = %d, ppid = %d\n", getpid(), getppid());
		execl("./demo01.out", "demo01.out", NULL);
	}
	else
	{
		printf("parent : pid = %d, ppid = %d\n", getpid(), getppid());
		wait(&s);
	}

	printf("Program finished\n");
	return 0;
}
