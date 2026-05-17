public class CartService {

    String[] cart = new String[100];
    int count = 0;

    public void add(int index) {

        if (index >= 0 && index < Database.products.length
                && Database.products[index] != null) {

            cart[count++] = Database.products[index];
            System.out.println("Added");
        }
    }

    public void view() {

        if (count == 0) {
            System.out.println("Cart Empty");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + cart[i]);
        }
    }

    public void remove(int r) {

        for (int i = r - 1; i < count - 1; i++) {
            cart[i] = cart[i + 1];
        }

        count--;
    }

    public void clear() {
        count = 0;
    }
}