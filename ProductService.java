public class ProductService {

    public void showProducts() {

        for (int i = 0; i < Database.products.length; i++) {
            if (Database.products[i] != null) {
                System.out.println(i + " " + Database.products[i]);
            }
        }
    }

    public void search(String key) {

        boolean found = false;

        for (String p : Database.products) {
            if (p != null && p.toLowerCase().contains(key.toLowerCase())) {
                System.out.println("Found: " + p);
                found = true;
            }
        }

        if (!found) System.out.println("Not Found");
    }
}