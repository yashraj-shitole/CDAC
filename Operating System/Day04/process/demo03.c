#include<stdio.h>
#include<unistd.h>

int main(void)
{
	int ret;
	printf("Program started\n");
	ret = fork();
	printf("ret = %d\n", ret);
	printf("Program finished\n");
	return 0;
}
