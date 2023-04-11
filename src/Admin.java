import java.util.Scanner;

public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    /*public static void tugasAdmin() {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t===============================================");
        System.out.println("\t\t\t==  1. Lihat Restaurant                      ==");
        System.out.println("\t\t\t==  2. Tambah Restaurant                     ==");
        System.out.println("\t\t\t==  3. Hapus Restaurant                      ==");
        System.out.println("\t\t\t==  4. Back                                  ==");
        System.out.println("\t\t\t===============================================");

        System.out.print("\t\t\tYour choice : ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                //call lihat restaurant
                break;
            case 2:
                //call tambah restaurant
                break;
            case 3:
                //call hapus restaurant
                break;
            case 4:
                //main();
                break;
            default:
                System.out.println("Invalid Choice. Please Try Again (Number 1-4)");
        }
    }

     */

}
