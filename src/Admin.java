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

    //Method khusus (Constructor)
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

        //Menginisiasi objek restaurant 1
        Restaurant restaurant1 = new Restaurant("IndoResto", "Jl. Leko No. 35, Badung");
        restaurant1.addMenu(new Menu("Nasi Goreng", 25000));
        restaurant1.addMenu(new Menu("Ayam Goreng", 20000));
        restaurant1.addMenu(new Menu("Ayam Bakar", 25000));
        restaurant1.addMenu(new Menu("Nasi Kuning Manado", 40000));
        restaurant1.addMenu(new Menu("Es Teh", 10000));
        restaurant1.addMenu(new Menu("Es Jeruk", 12000));

        //Menginisiasi objek restaurant 2
        Restaurant restaurant2 = new Restaurant("JapanResto", "Jl. Mawar No. 100, Tabanan");
        restaurant2.addMenu(new Menu("Sushi", 35000));
        restaurant2.addMenu(new Menu("Sashimi", 40000));
        restaurant2.addMenu(new Menu("Takoyaki", 35000));
        restaurant2.addMenu(new Menu("Onigiri", 20000));
        restaurant2.addMenu(new Menu("Ocha", 15000));
        restaurant2.addMenu(new Menu("Green Tea", 25000));

        //Menginisiasi objek restaurant 3
        Restaurant restaurant3 = new Restaurant("WesternResto", "Jl. Kemerdekaan No. 112, Denpasar");
        restaurant3.addMenu(new Menu("Hamburger", 30000));
        restaurant3.addMenu(new Menu("Pizza", 50000));
        restaurant3.addMenu(new Menu("Steak", 55000));
        restaurant3.addMenu(new Menu("Fried Fries", 18000));
        restaurant3.addMenu(new Menu("Soda", 20000));
        restaurant3.addMenu(new Menu("Americano", 25000));


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
                    //Memanggil method viewRestaurant untuk dapat memunculkan daftar restoran
                    viewRestaurants();
                    break;
                case 2:
                    //Memanggil method addRestaurant untuk dapat menambahkan restoran dan menunya
                    addRestaurant();
                    break;
                case 3:
                    //Memanggil method removeRestaurant untuk dapat menghapus restoran
                    removeRestaurant();
                    break;
                case 4:
                    //Memanggil method awal pada class TampilanAwal
                    TampilanAwal.awal();
                    break;
                case 0:
                    //Keluar atau exit
                    System.exit(0);
                default:
                    System.out.println("\t\t\tInvalid choice!");
            }
        }
    }

    //Method yang digunakan untuk menampilkan daftar restoran yang telah diinisiasi sebelumnya
    public static void viewRestaurants(){
        System.out.println("\n");
        System.out.println("\t\t\t====           Restaurant List           =====\n");
        for (String restaurantName : restaurants.keySet()) {
            System.out.println("\t\t\t** " +restaurantName + ", " + restaurants.get(restaurantName).getAddress()) ;
            System.out.println("\t\t\t====                Menu                 =====");
            for (Menu menu : restaurants.get(restaurantName).getMenus()) {
                System.out.println("\t\t\t" + menu.getName() + "                        \t-- Rp " + menu.getPrice() + ",-");
            }
            System.out.println("\t\t\t===============================================");
            System.out.println("");
        }
        System.out.println("");
    }

    //Method yang digunakkan untuk menambahkan restoran ke dalam Hash Map
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
        System.out.println("\t\t\tRestaurant added successfully\n\n");
    }

    //Method yang digunakan untuk menghapus restoran dengan memasukkan nama restoran yang ingin dihapus
    public static void removeRestaurant(){
        Scanner masukkan = new Scanner(System.in);

        System.out.print("\t\t\tEnter restaurant name: ");
        String restaurantName = masukkan.nextLine();
        if (restaurants.containsKey(restaurantName)) {
            restaurants.remove(restaurantName);
            System.out.println("\t\t\tRestaurant deleted successfully\n\n");
        } else {
            System.out.println("\t\t\tRestaurant not found");
        }
    }


}

