import java.util.*;

public class InputService {

    Scanner sc;

    public InputService(Scanner sc) {
        this.sc = sc;
    }

    public int getInt() {
        return sc.nextInt();
    }

    public String getString() {
        return sc.nextLine();
    }
}