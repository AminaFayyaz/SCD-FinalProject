public class AdminService {

    public void add(String name, double price) {

        String[] np = new String[Database.products.length + 1];
        double[] pp = new double[Database.prices.length + 1];

        for (int i = 0; i < Database.products.length; i++) {
            np[i] = Database.products[i];
            pp[i] = Database.prices[i];
        }

        np[np.length - 1] = name;
        pp[pp.length - 1] = price;

        Database.products = np;
        Database.prices = pp;
    }

    public void delete(int i) {
        Database.products[i] = null;
    }

    public void update(int i, double p) {
        Database.prices[i] = p;
    }
}