import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private String username;
    private String password;
    private static Scanner scanner = new Scanner(System.in);
    //private static ArrayList<String> customers = new ArrayList<String>();
    private static ArrayList<String> admins = new ArrayList<String>();

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin() {

    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public static void adminLogin() {
        Admin admin = new Admin("baguswahyu", "2205551002");
        ListRestaurant tugasAdmin = new ListRestaurant();

        System.out.println("\t\t\tInput Username and Password");
        System.out.println("Username : ");
        String adminUsername = scanner.nextLine();
        System.out.println("Password : ");
        String adminPassword = scanner.nextLine();


        if (admin.login(adminUsername, adminPassword)) {
            System.out.println("\n\n\t\t\tHello, you are logged in as Admin");
            tugasAdmin.adminCekResto();
        } else {
            System.out.println("Username or password Invalid!");
            System.out.println("Try Again");
            adminLogin();
        }
    }
}

