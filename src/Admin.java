import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private String username;
    private String password;
    private static Scanner scanner = new Scanner(System.in);
    //private static ArrayList<String> customers = new ArrayList<String>();
    private static ArrayList<String> admins = new ArrayList<String>();
    private RestaurantManager restaurantManager;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public static void adminLogin() {
        //Menginisiasi dan memasukkan parameter dengan username dan password untuk admin
        Admin admin = new Admin("baguswahyu", "2205551002");

        System.out.println("\t\t\tInput Username and Password");
        System.out.print("Username : ");
        String adminUsername = scanner.nextLine();
        System.out.print("Password : ");
        String adminPassword = scanner.nextLine();

        //Melakukan pengecekan terhadap username dan password yang diinputkan
        if (admin.login(adminUsername, adminPassword)) {
            System.out.println("\n\n\t\t\tHello, you are logged in as Admin");
            //tugasAdmin.adminCekResto();
            tugasAdmin();
        } else {
            System.out.println("Username or password Invalid!");
            System.out.println("Try Again");
            adminLogin();
        }
    }


    public Admin(RestaurantManager restaurantManager) {
        this.restaurantManager = restaurantManager;
    }

    public static void viewRestaurants() {

        RestaurantManager.printRestaurants();
    }

    public static void viewMenus() {

        RestaurantManager.printMenus();
    }

    public void addRestaurant() {
        Scanner scanner = new Scanner(System.in);

        //Memasukkan nama dan alamat restaurant yang ingin ditambahkan
        System.out.print("Enter restaurant name: ");
        String name = scanner.nextLine();
        System.out.print("Enter restaurant address: ");
        String address = scanner.nextLine();
        Restaurant restaurant = new Restaurant(name, address);
        restaurantManager.addRestaurant(restaurant);
        System.out.println("Restaurant added successfully!");
        System.out.println("Add Menus :");
        do{
            System.out.println("Choose Food/Drink ");
            String category = scanner.nextLine();
            System.out.print("Enter menu name: ");
            String nameMenu = scanner.nextLine();
            System.out.print("Enter price menu: ");
            double price = scanner.nextInt();
            if (category.equals("Food") || category.equals("food")) {
                 restaurant.addMenu(new Menu(nameMenu,price,true));

            }else if(category.equals("Drink") || category.equals("drink")){
                 restaurant.addMenu(new Menu(nameMenu,price,false));
            }
            System.out.println("Add More Menu");
            System.out.println("1. Yes \n2. No");
            int ulang = scanner.nextInt();
            if(ulang==2){
                break;
            }
        }while(true);
    }

    public void removeRestaurant() {
        Scanner scanner = new Scanner(System.in);

        //Menghapus restaurant dengan memilih nomor yang sesuai dengan restaurant list
        System.out.print("Enter the number of the restaurant you want to remove: ");
        int index = scanner.nextInt() - 1;
        restaurantManager.removeRestaurant(index);
        System.out.println("Restaurant removed successfully!");
    }

    public static void tugasAdmin() {
        RestaurantManager restaurantManager = new RestaurantManager();
        Admin admin = new Admin(restaurantManager);

        //Memasukkan atau addRestaurant dengan nama dan alamat resto
        restaurantManager.addRestaurant(new Restaurant("IndoResto", "Denpasar, Bali"));
        restaurantManager.addRestaurant(new Restaurant("JapanResto", "Tabanan, Bali"));
        restaurantManager.addRestaurant(new Restaurant("WesternResto", "Badung, Bali"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            //Menu yang dapat dilakukan oleh admin
            System.out.println("\t\t\t===============================================");
            System.out.println("\t\t\t==  1. Restaurant List                       ==");
            System.out.println("\t\t\t==  2. Add Restaurant                        ==");
            System.out.println("\t\t\t==  3. Delete Restaurant                     ==");
            System.out.println("\t\t\t==  4. Back                                  ==");
            System.out.println("\t\t\t==  0. Exit                                  ==");
            System.out.println("\t\t\t===============================================");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    admin.viewRestaurants();
                    admin.viewMenus();
                    break;
                case 2:
                    admin.addRestaurant();
                    break;
                case 3:
                    admin.removeRestaurant();
                    break;
                case 4:
                    TampilanAwal back = new TampilanAwal();
                    back.awal();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

