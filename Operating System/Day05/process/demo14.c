#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

// synchronization using mutex

pthread_mutex_t m;
int count = 0;

void* inc_func(void *param) {
    int i;
    for(i=1; i<=10; i++) {
        pthread_mutex_lock(&m);
        count++;
        printf("inc : %d\n", count);
        pthread_mutex_unlock(&m);
        sleep(1);
    }
    return NULL;
}

void* dec_func(void *param) {
    int i;
    for(i=1; i<=10; i++) {
        pthread_mutex_lock(&m);
        count--;
        printf("dec : %d\n", count);
        pthread_mutex_unlock(&m);
        sleep(1);
    }
    return NULL;
}

int main() {
    int i, ret;
    pthread_t t1, t2;
    pthread_mutex_init(&m, NULL);
    ret = pthread_create(&t1, NULL, inc_func, NULL);
    ret = pthread_create(&t2, NULL, dec_func, NULL);
    pthread_join(t1, NULL);
    pthread_join(t2, NULL);
    printf("final count = %d\n", count);
    pthread_mutex_destroy(&m);
    return 0;
}


