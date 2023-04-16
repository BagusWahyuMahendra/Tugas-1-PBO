import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Admin {
    private String username;
    private String password;
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> admins = new ArrayList<String>();
    public static HashMap<String, Restaurant> restaurants = new HashMap<>();

    public static HashMap<String, Restaurant> getRestaurants(){

        return restaurants;
    }

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
        System.out.print("\t\t\tUsername : ");
        String adminUsername = scanner.nextLine();
        System.out.print("\t\t\tPassword : ");
        String adminPassword = scanner.nextLine();

        //Melakukan pengecekan terhadap username dan password yang diinputkan
        if (admin.login(adminUsername, adminPassword)) {
            System.out.println("\n\n\t\t\tHello, you are logged in as Admin");
            tugasAdmin();
        } else {
            System.out.println("\t\t\tUsername or password Invalid!");
            System.out.println("\t\t\tTry Again");
            adminLogin();
        }
    }
    public static void inisiasiRestaurant(){
        // inisialisasi data restaurant
        Restaurant restaurant1 = new Restaurant("IndoResto", "Jl. Leko No. 35, Badung");
        restaurant1.addMenu(new Menu("Nasi Goreng", 25000));
        restaurant1.addMenu(new Menu("Ayam Goreng", 20000));
        restaurant1.addMenu(new Menu("Ayam Bakar", 25000));
        restaurant1.addMenu(new Menu("Nasi Kuning Manado", 40000));
        restaurant1.addMenu(new Menu("Es Teh", 10000));
        restaurant1.addMenu(new Menu("Es Jeruk", 12000));

        Restaurant restaurant2 = new Restaurant("JapanResto", "Jl. Mawar No. 100, Tabanan");
        restaurant2.addMenu(new Menu("Sushi", 35000));
        restaurant2.addMenu(new Menu("Sashimi", 40000));
        restaurant2.addMenu(new Menu("Takoyaki", 35000));
        restaurant2.addMenu(new Menu("Onigiri", 20000));
        restaurant2.addMenu(new Menu("Ocha", 15000));
        restaurant2.addMenu(new Menu("Green Tea", 25000));

        Restaurant restaurant3 = new Restaurant("WesternResto", "Jl. Kemerdekaan No. 112, Denpasar");
        restaurant3.addMenu(new Menu("Hamburger", 30000));
        restaurant3.addMenu(new Menu("Pizza", 50000));
        restaurant3.addMenu(new Menu("Steak", 55000));
        restaurant3.addMenu(new Menu("Fried Fries", 18000));
        restaurant3.addMenu(new Menu("Bakso Ayam", 18000));
        restaurant3.addMenu(new Menu("Bakso Ayam", 18000));


        // Menambahkan data restaurant ke dalam HashMap
        restaurants.put("IndoResto", restaurant1);
        restaurants.put("JapanResto", restaurant2);
        restaurants.put("WesternResto", restaurant3);
    }
    public static void tugasAdmin() {

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

            System.out.print("\t\t\tEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewRestaurants();
                    break;
                case 2:
                    addRestaurant();
                    break;
                case 3:
                    removeRestaurant();
                    break;
                case 4:
                    TampilanAwal.awal();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("\t\t\tInvalid choice!");
            }
        }
    }

    public static void viewRestaurants(){
        System.out.println("\n");
        System.out.println("====           Restaurant List           =====");
        for (String restaurantName : restaurants.keySet()) {
            System.out.println(restaurantName + ", " + restaurants.get(restaurantName).getAddress());
            System.out.println("*Menu*");
            for (Menu menu : restaurants.get(restaurantName).getMenus()) {
                System.out.println(menu.getName() +      "\t ---- " + menu.getPrice());
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void addRestaurant(){
        Scanner masukkan = new Scanner(System.in);

        System.out.print("\t\t\tEnter restaurant name: ");
        String name = masukkan.nextLine();
        System.out.print("\t\t\tEnter restaurant address: ");
        String address = masukkan.nextLine();
        Restaurant newRestaurant = new Restaurant(name, address);
        String inputUlang = "";
        while (!inputUlang.equals("stop")) {
            System.out.print("\t\t\tEnter menu (ex input format: menuName--menuPrice), input \"stop\" to finish: ");
            inputUlang = masukkan.nextLine();
            if (!inputUlang.equals("stop")) {
                String[] menuData = inputUlang.split("--");
                newRestaurant.addMenu(new Menu(menuData[0], Integer.parseInt(menuData[1])));
            }
        }
        restaurants.put(name, newRestaurant);
        System.out.println("\t\t\tRestaurant added successfully");
    }

    public static void removeRestaurant(){
        Scanner masukkan = new Scanner(System.in);

        System.out.print("\t\t\tEnter restaurant name: ");
        String restaurantName = masukkan.nextLine();
        if (restaurants.containsKey(restaurantName)) {
            restaurants.remove(restaurantName);
            System.out.println("\t\t\tRestaurant deleted successfully");
        } else {
            System.out.println("\t\t\tRestaurant not found");
        }
    }


}

