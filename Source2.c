#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ITEMS 100
#define MAX_NAME_LENGTH 50

struct Item {
    int id;
    char name[MAX_NAME_LENGTH];
    int quantity;
    float price;
};

struct Inventory {
    struct Item items[MAX_ITEMS];
    int itemCount;
};

void initInventory(struct Inventory* inv) {
    inv->itemCount = 0;
}

void addItem(struct Inventory* inv) {
    if (inv->itemCount >= MAX_ITEMS) {
        printf("�w�s�w���A�L�k�K�[�s�ӫ~�C\n");
        return;
    }

    struct Item newItem;
    newItem.id = inv->itemCount + 1;

    printf("��J�ӫ~�W��: ");
    scanf_s("%s", newItem.name);

    printf("��J�ƶq: ");
    scanf_s("%d", &newItem.quantity);

    printf("��J����: ");
    scanf_s("%f", &newItem.price);

    inv->items[inv->itemCount] = newItem;
    inv->itemCount++;

    printf("�ӫ~�K�[���\�C\n");
}

void displayInventory(struct Inventory* inv) {
    printf("\n��e�w�s:\n");
    printf("ID\t�W��\t\t�ƶq\t����\n");
    for (int i = 0; i < inv->itemCount; i++) {
        printf("%d\t%-15s\t%d\t%.2f\n",
            inv->items[i].id,
            inv->items[i].name,
            inv->items[i].quantity,
            inv->items[i].price);
    }
}

int main() {
    struct Inventory inventory;
    initInventory(&inventory);

    int choice;
    do {
        printf("\n�w�s�޲z�t��\n");
        printf("1. �K�[�ӫ~\n");
        printf("2. ��ܮw�s\n");
        printf("3. �h�X\n");
        printf("�п�ܾާ@: ");
        scanf_s("%d", &choice);

        switch (choice) {
        case 1:
            addItem(&inventory);
            break;
        case 2:
            displayInventory(&inventory);
            break;
        case 3:
            printf("���¨ϥΡA�A���I\n");
            break;
        default:
            printf("�L�Ŀ�ܡA�Э��աC\n");
        }
    } while (choice != 3);

    return 0;
}