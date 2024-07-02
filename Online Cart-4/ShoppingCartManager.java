import java.util.Scanner;

public class ShoppingCartManager {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter Customer's Name:");
        String customerName = scnr.nextLine();
        System.out.println("Enter Today's Date:");
        String currentDate = scnr.nextLine();
        System.out.println();

        System.out.println("Customer Name: " + customerName);
        System.out.println("Today's Date: " + currentDate);
        System.out.println();

        ShoppingCart cart = new ShoppingCart(customerName, currentDate);

        printMenu(cart, scnr);

        scnr.close();
    }

    public static void printMenu(ShoppingCart cart, Scanner scnr) {
        char choice = ' ';

        while (choice != 'q') {
            System.out.println("MENU");
            System.out.println("a - Add item to cart");
            System.out.println("d - Remove item from cart");
            System.out.println("c - Change item quantity");
            System.out.println("i - Output items' descriptions");
            System.out.println("o - Output shopping cart");
            System.out.println("q - Quit");
            System.out.println();

            System.out.print("Choose an option:");
            choice = scnr.nextLine().charAt(0);

            while (choice != 'a' && choice != 'd' && choice != 'c' && choice != 'i' && choice != 'o' && choice != 'q') {
                System.out.println();
                System.out.print("Choose an option:");
                choice = scnr.nextLine().charAt(0);
            }

            System.out.println();

            switch (choice) {
                case 'a':
                    addItemToCart(cart, scnr);
                    break;
                case 'd':
                    removeItemFromCart(cart, scnr);
                    break;
                case 'c':
                    changeItemQuantity(cart, scnr);
                    break;
                case 'i':
                    outputItemDescriptions(cart);
                    break;
                case 'o':
                    outputShoppingCart(cart);
                    break;
                case 'q':
                    break;
                default:
                    break;
            }
        }
    }

    public static void addItemToCart(ShoppingCart cart, Scanner scnr) {
        System.out.println("ADD ITEM TO CART");
        System.out.println("Enter the item name:");
        String itemName = scnr.nextLine();
        System.out.println("Enter the item description:");
        String itemDescription = scnr.nextLine();
        System.out.println("Enter the item price:");
        int itemPrice = Integer.parseInt(scnr.nextLine());
        System.out.println("Enter the item quantity:");
        int itemQuantity = Integer.parseInt(scnr.nextLine());
        System.out.println();

        ItemToPurchase item = new ItemToPurchase(itemName, itemDescription, itemPrice, itemQuantity);
        cart.addItem(item);
    }

    public static void removeItemFromCart(ShoppingCart cart, Scanner scnr) {
        System.out.println("REMOVE ITEM FROM CART");
        System.out.println("Enter name of item to remove:");
        String itemName = scnr.nextLine();
        cart.removeItem(itemName);
        System.out.println();
    }

    public static void changeItemQuantity(ShoppingCart cart, Scanner scnr) {
        System.out.println("CHANGE ITEM QUANTITY");
        System.out.println("Enter the item name:");
        String itemName = scnr.nextLine();
        System.out.println("Enter the new quantity:");
        int newQuantity = Integer.parseInt(scnr.nextLine());

        ItemToPurchase newItem = new ItemToPurchase();
        newItem.setName(itemName);
        newItem.setQuantity(newQuantity);

        cart.modifyItem(newItem);
        System.out.println();
    }

    public static void outputItemDescriptions(ShoppingCart cart) {
        System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
        cart.printDescriptions();
        System.out.println();
    }

    public static void outputShoppingCart(ShoppingCart cart) {
        System.out.println("OUTPUT SHOPPING CART");
        cart.printTotal();
        System.out.println();
    }
}
