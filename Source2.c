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
        printf("庫存已滿，無法添加新商品。\n");
        return;
    }

    struct Item newItem;
    newItem.id = inv->itemCount + 1;

    printf("輸入商品名稱: ");
    scanf_s("%s", newItem.name);

    printf("輸入數量: ");
    scanf_s("%d", &newItem.quantity);

    printf("輸入價格: ");
    scanf_s("%f", &newItem.price);

    inv->items[inv->itemCount] = newItem;
    inv->itemCount++;

    printf("商品添加成功。\n");
}

void displayInventory(struct Inventory* inv) {
    printf("\n當前庫存:\n");
    printf("ID\t名稱\t\t數量\t價格\n");
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
        printf("\n庫存管理系統\n");
        printf("1. 添加商品\n");
        printf("2. 顯示庫存\n");
        printf("3. 退出\n");
        printf("請選擇操作: ");
        scanf_s("%d", &choice);

        switch (choice) {
        case 1:
            addItem(&inventory);
            break;
        case 2:
            displayInventory(&inventory);
            break;
        case 3:
            printf("謝謝使用，再見！\n");
            break;
        default:
            printf("無效選擇，請重試。\n");
        }
    } while (choice != 3);

    return 0;
}