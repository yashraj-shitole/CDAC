#include<stdio.h>
#include<unistd.h>

int main(void)
{
	int ret;
	printf("Program started\n");
	ret = fork();
	if(ret == 0)
	{
		// child process
		printf("child : pid = %d\n", getpid());
		for(int i = 1 ; i <= 7 ; i++)
		{
			printf("child : i = %d\n", i);
			sleep(1);
		}
	}
	else
	{
		// parent process
		printf("parent : pid = %d\n", getpid());
		for(int i = 15 ; i >= 1 ; i--)
		{
			printf("parent : i = %d\n", i);
			sleep(1);
		}
	}

	printf("Program finished\n");
	return 0;
}




