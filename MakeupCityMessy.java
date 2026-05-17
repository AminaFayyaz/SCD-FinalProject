import java.util.*;

public class MakeupCityMessy {

    static Scanner sc = new Scanner(System.in);

    static String[] users = new String[50];
    static String[] passwords = new String[50];
    static int userCount = 0;

    static String[] products = {
        "Lipstick", "Foundation", "Face Wash", "Shampoo",
        "Brush Set", "Mascara", "Serum", "Compact Powder"
    };

    static double[] prices = {
        1200, 2500, 800, 1500,
        1800, 1300, 2200, 1700
    };

    static String[] cart = new String[100];
    static int cartCount = 0;

    // MAIN METHOD
    public static void main(String[] args) {

        int choice = 0;

        while (choice != 13) {

            System.out.println("\n===== MAKEUP CITY =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Show Products");
            System.out.println("4. Search Product");
            System.out.println("5. Add To Cart");
            System.out.println("6. View Cart");
            System.out.println("7. Remove From Cart");
            System.out.println("8. Place Order");
            System.out.println("9. Admin Add Product");
            System.out.println("10. Delete Product");
            System.out.println("11. Update Product Price");
            System.out.println("12. Order History");
            System.out.println("13. Exit");

            System.out.print("Enter Choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Please Enter Number Only");
                sc.nextLine();
                continue;
            }

            switch(choice) {

                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    showProducts();
                    break;

                case 4:
                    searchProduct();
                    break;

                case 5:
                    addToCart();
                    break;

                case 6:
                    viewCart();
                    break;

                case 7:
                    removeFromCart();
                    break;

                case 8:
                    placeOrder();
                    break;

                case 9:
                    adminAddProduct();
                    break;

                case 10:
                    deleteProduct();
                    break;

                case 11:
                    updatePrice();
                    break;

                case 12:
                    orderHistory();
                    break;

                case 13:
                    System.out.println("System Closed");
                    break;

                default:
                    System.out.println("Wrong Choice");
            }
        }
    }

    static void register() {

        System.out.print("Enter Username: ");
        String u = sc.nextLine();

        System.out.print("Enter Password: ");
        String p = sc.nextLine();

        users[userCount] = u;
        passwords[userCount] = p;

        userCount++;

        System.out.println("Registration Successful");
    }

    static void login() {

        System.out.print("Username: ");
        String uu = sc.nextLine();

        System.out.print("Password: ");
        String pp = sc.nextLine();

        boolean ok = false;

        for (int i = 0; i < userCount; i++) {

            if (users[i].equals(uu) && passwords[i].equals(pp)) {
                ok = true;
            }
        }

        if (ok) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Invalid Login");
        }
    }

    static void showProducts() {

        System.out.println("\nPRODUCTS:");

        for (int i = 0; i < products.length; i++) {

            if (products[i] != null) {
                System.out.println(i + " -> " + products[i] + " Price: " + prices[i]);
            }
        }
    }

    static void searchProduct() {

        System.out.print("Search Product Name: ");
        String s = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < products.length; i++) {

            if (products[i] != null &&
                products[i].toLowerCase().contains(s.toLowerCase())) {

                System.out.println(products[i] + " Found Price = " + prices[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Product Not Found");
        }
    }

    static void addToCart() {

        showProducts();

        System.out.print("Enter Product Index: ");
        int x = sc.nextInt();
        sc.nextLine();

        if (x >= 0 && x < products.length && products[x] != null) {

            cart[cartCount] = products[x];
            cartCount++;

            System.out.println("Added To Cart");

        } else {
            System.out.println("Wrong Product");
        }
    }

    static void viewCart() {

        System.out.println("\nYOUR CART:");

        if (cartCount == 0) {
            System.out.println("Cart Empty");
            return;
        }

        for (int i = 0; i < cartCount; i++) {
            System.out.println((i + 1) + ". " + cart[i]);
        }
    }

    static void removeFromCart() {

        viewCart();

        if (cartCount == 0) {
            return;
        }

        System.out.print("Enter Item Number Remove: ");
        int r = sc.nextInt();
        sc.nextLine();

        if (r > 0 && r <= cartCount) {

            for (int i = r - 1; i < cartCount - 1; i++) {
                cart[i] = cart[i + 1];
            }

            cartCount--;

            System.out.println("Removed");

        } else {
            System.out.println("Invalid Number");
        }
    }

    static void placeOrder() {

        if (cartCount == 0) {
            System.out.println("No Product In Cart");
            return;
        }

        double total = 0;

        for (int i = 0; i < cartCount; i++) {

            for (int j = 0; j < products.length; j++) {

                if (cart[i].equals(products[j])) {
                    total += prices[j];
                }
            }
        }

        System.out.println("Order Placed");
        System.out.println("Total Bill = " + total);

        cartCount = 0;
    }

    static void adminAddProduct() {

        System.out.print("Enter New Product Name: ");
        String np = sc.nextLine();

        System.out.print("Enter Product Price: ");
        double pr = sc.nextDouble();
        sc.nextLine();

        String[] newProducts = new String[products.length + 1];
        double[] newPrices = new double[prices.length + 1];

        for (int i = 0; i < products.length; i++) {

            newProducts[i] = products[i];
            newPrices[i] = prices[i];
        }

        newProducts[newProducts.length - 1] = np;
        newPrices[newPrices.length - 1] = pr;

        products = newProducts;
        prices = newPrices;

        System.out.println("Product Added");
    }

    static void deleteProduct() {

        showProducts();

        System.out.print("Enter Index Delete: ");
        int d = sc.nextInt();
        sc.nextLine();

        if (d >= 0 && d < products.length) {

            products[d] = null;
            prices[d] = 0;

            System.out.println("Deleted");

        } else {
            System.out.println("Invalid Index");
        }
    }

    static void updatePrice() {

        showProducts();

        System.out.print("Enter Product Index: ");
        int a = sc.nextInt();

        System.out.print("Enter New Price: ");
        double b = sc.nextDouble();
        sc.nextLine();

        if (a >= 0 && a < prices.length && products[a] != null) {

            prices[a] = b;
            System.out.println("Price Updated");

        } else {
            System.out.println("Wrong Product");
        }
    }

    static void orderHistory() {

        System.out.println("\nOLD ORDERS:");

        System.out.println("1. Lipstick x1");
        System.out.println("2. Face Wash x2");
        System.out.println("3. Serum x1");

        System.out.println("(Dummy History Added)");
    }
}