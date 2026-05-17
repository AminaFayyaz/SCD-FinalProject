public class OrderService {

    CartService cart;

    public OrderService(CartService cart) {
        this.cart = cart;
    }

    public void placeOrder() {

        double total = 0;

        for (int i = 0; i < cart.count; i++) {

            for (int j = 0; j < Database.products.length; j++) {

                if (Database.products[j] != null &&
                    cart.cart[i].equals(Database.products[j])) {

                    total += Database.prices[j];
                }
            }
        }

        System.out.println("Total = " + total);
        cart.clear();
    }

    public void history() {
        System.out.println("Dummy Order History");
    }
}