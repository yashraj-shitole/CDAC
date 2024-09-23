#include <stdio.h>

struct Date {
    int day, month, year;
};

void initDate(struct Date* ptrDate) {
    ptrDate->day = 1;
    ptrDate->month = 1;
    ptrDate->year = 2000;
}

void printDateOnConsole(struct Date* ptrDate) {
    printf("Date: %d/%d/%d\n", ptrDate->day, ptrDate->month, ptrDate->year);
}

void acceptDateFromConsole(struct Date* ptrDate) {
    printf("Enter day: ");
    scanf("%d", &ptrDate->day);
    printf("Enter month: ");
    scanf("%d", &ptrDate->month);
    printf("Enter year: ");
    scanf("%d", &ptrDate->year);
}

int main() {
    struct Date date;
    int choice;

    while (1) {
        printf("\nMenu:\n");
        printf("1. Initialize Date\n");
        printf("2. Accept Date from Console\n");
        printf("3. Print Date\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                initDate(&date);
                printf("Date initialized.\n");
                break;
            case 2:
                acceptDateFromConsole(&date);
                break;
            case 3:
                printDateOnConsole(&date);
                break;
            case 4:
                return 0;
            default:
                printf("Invalid choice!\n");
        }
    }
    return 0;
}
