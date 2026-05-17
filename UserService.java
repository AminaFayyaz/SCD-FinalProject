import java.util.*;

public class UserService {

    Scanner sc;

    public UserService(Scanner sc) {
        this.sc = sc;
    }

    public void register() {

        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        Database.users[Database.userCount] = u;
        Database.passwords[Database.userCount] = p;
        Database.userCount++;

        System.out.println("Registered");
    }

    public boolean login() {

        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        for (int i = 0; i < Database.userCount; i++) {
            if (Database.users[i].equals(u)
                && Database.passwords[i].equals(p)) {

                System.out.println("Login Success");
                return true;
            }
        }

        System.out.println("Login Failed");
        return false;
    }
}