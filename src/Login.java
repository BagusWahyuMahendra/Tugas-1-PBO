import java.util.Scanner;
import java.util.ArrayList;

public class Login {
    private static Scanner scanner = new Scanner(System.in);
    //private static ArrayList<String> customers = new ArrayList<String>();
    private static ArrayList<String> admins = new ArrayList<String>();

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


    public static void customerLogin(){
        Scanner input = new Scanner(System.in);
        TampilanAwal awal = new TampilanAwal();

        System.out.println("\n\nYour Name : ");
        String name = input.nextLine();
        System.out.println("Your Address : ");
        String address = input.nextLine();


        System.out.println("\n\t\t\tHello "+name+", you are logged in as Customer");
        System.out.println("\t\t\t===============================================");
        System.out.println("\t\t\t==  1. Buat Pesanan                          ==");
        System.out.println("\t\t\t==  2. Back                                  ==");
        System.out.println("\t\t\t===============================================");

        System.out.print("\t\t\tYour choice : ");
        int choice = input.nextInt();

        if(choice==1){
            //call buatPesanan
        }
        else if(choice==2){
            awal.awal();
        }
        else{
            System.out.println("Invalid choice, Try Again!");
            customerLogin();
        }

    }

}

