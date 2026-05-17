import java.util.*;

public class MakeupCityApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserService user = new UserService(sc);
        ProductService product = new ProductService();
        CartService cart = new CartService();
        OrderService order = new OrderService(cart);
        AdminService admin = new AdminService();
        MenuService menu = new MenuService();

        int ch = 0;

        while (ch != 13) {

            try {

                menu.printMenu();

                System.out.print("Enter choice: ");
                ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {

                    case 1:
                        user.register();
                        break;

                    case 2:
                        user.login();
                        break;

                    case 3:
                        product.showProducts();
                        break;

                    case 4:
                        System.out.print("Search: ");
                        product.search(sc.nextLine());
                        break;

                    case 5:
                        System.out.print("Enter product index: ");
                        cart.add(sc.nextInt());
                        sc.nextLine();
                        break;

                    case 6:
                        cart.view();
                        break;

                    case 7:
                        System.out.print("Enter item number to remove: ");
                        cart.remove(sc.nextInt());
                        sc.nextLine();
                        break;

                    case 8:
                        order.placeOrder();
                        break;

                    case 9:
                        System.out.print("Enter product name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter price: ");
                        double price = sc.nextDouble();
                        sc.nextLine();

                        admin.add(name, price);
                        break;

                    case 10:
                        System.out.print("Enter index to delete: ");
                        admin.delete(sc.nextInt());
                        sc.nextLine();
                        break;

                    case 11:
                        System.out.print("Enter index to update: ");
                        int idx = sc.nextInt();

                        System.out.print("Enter new price: ");
                        double newPrice = sc.nextDouble();
                        sc.nextLine();

                        admin.update(idx, newPrice);
                        break;

                    case 12:
                        order.history();
                        break;

                    case 13:
                        System.out.println("System Closed");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter numbers only.");
                sc.nextLine(); // clear wrong input buffer
            } catch (Exception e) {
                System.out.println("❌ Something went wrong: " + e.getMessage());
                sc.nextLine();
            }
        }

        sc.close();
    }
}