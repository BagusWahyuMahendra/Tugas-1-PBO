import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Customer {
    private String username;
    private String password;
    private static HashMap<String, String> users = new HashMap<>();  //membuat objek HashMap untuk menyimpan data user
    public static HashMap<String, Restaurant> restaurants = Admin.getRestaurants();
    public static void menuCustomer() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            //Menampilkan menu Sign Up dan Login untuk customer
            System.out.println("\t\t\t===============================================");
            System.out.println("\t\t\t==  Menu :                                   ==");
            System.out.println("\t\t\t==  1. Sign Up                               ==");
            System.out.println("\t\t\t==  2. Login                                 ==");
            System.out.println("\t\t\t==  3. Back                                  ==");
            System.out.println("\t\t\t===============================================");

            System.out.print("\t\t\tYour choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();  //menghapus newline yang tersisa dari input sebelumnya

            switch (choice) {
                case 1:
                    signup(scanner);
                    //menuCustomer();
                    break;
                case 2:
                    login(scanner);
                    makeOrder();
                    running = false;
                    //call daftar restaurant dan menu-menu
                    break;
                case 3:
                    running = false;
                    TampilanAwal back = new TampilanAwal();
                    back.awal();
                    break;
                default:
                    System.out.println("\t\t\tInvalid Choice. Please Try Again (Number 1-3)");
                    break;
            }
        }

        scanner.close();
    }

    private static void login(Scanner scanner) {
        int i=0;
        do {
            System.out.print("\t\t\tUsername: ");
            String username = scanner.nextLine();
            System.out.print("\t\t\tPassword: ");
            String password = scanner.nextLine();

            if (users.containsKey(username) && users.get(username).equals(password)) {  //memeriksa apakah username dan password sesuai
                System.out.println("\t\t\tLogin successfully!\n\n");
                i=1;
            } else {
                System.out.println("\t\t\tLogin unsuccessfully, please try again.\n\n");
            }
        }while(i==0);
    }

    private static void signup(Scanner scanner) {
        System.out.print("\t\t\tUsername: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {  //memeriksa apakah username sudah terdaftar
            System.out.println("\t\t\tUsername already registered, please try again.");
            return;
        }
        System.out.print("\t\t\tPassword: ");
        String password = scanner.nextLine();
        users.put(username, password);  //menambahkan data user baru ke dalam HashMap
        System.out.println("\t\t\tSignup was successful! Please login.\n\n");
    }

    public static void makeOrder() {
        ArrayList<Order> orders = new ArrayList<>();

        int pilihan=0;
        Scanner scanner = new Scanner(System.in);

        while(pilihan != 3){
            System.out.println("\t\t\t===============================================");
            System.out.println("\t\t\t==  1. Make Order                            ==");
            System.out.println("\t\t\t==  2. View Order                            ==");
            System.out.println("\t\t\t==  3. Back                                  ==");
            System.out.println("\t\t\t===============================================");

            System.out.print("\t\t\tYour choice : ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    Scanner input = new Scanner(System.in);

                    System.out.println("\n\n\t\t\t================ Restaurants ==================");
                    for (String restaurantName : restaurants.keySet()) {
                        System.out.println("\t\t\t"+restaurantName + " --- " + restaurants.get(restaurantName).getAddress());
                    }
                    System.out.println("\t\t\t===============================================");
                    System.out.print("\t\t\tEnter restaurant name: ");
                    String restaurantName = input.nextLine();
                    if (!restaurants.containsKey(restaurantName)) {
                        System.out.println("\t\t\tRestaurant not found");
                        break;
                    }

                    Restaurant restaurant = restaurants.get(restaurantName);
                    Order newOrder = new Order(restaurant);

                    String menuInput = "";
                    while (!menuInput.equals("n")) {
                        System.out.println("\n\n\t\t\t=======\t\t " + restaurant.getName() + " \t\t=======");
                        System.out.println("\t\t\t=================== Menu ======================");
                        int menuNumber = 1;
                        for (Menu menu : restaurant.getMenus()) {
                            System.out.println("\t\t\t"+menuNumber + "\t-" + menu.getName() + "\t- " + menu.getPrice());
                            menuNumber++;
                        }
                        System.out.println("\t\t\t===============================================");
                        System.out.print("\t\t\tEnter menu number: ");
                        int menuIndex = input.nextInt();
                        System.out.print("\t\t\tEnter quantity: ");
                        int quantity = input.nextInt();
                        input.nextLine(); // consume newline character

                        newOrder.addMenu(restaurant.getMenus().get(menuIndex - 1), quantity);

                        System.out.print("\n\t\t\tAdd more menu? (y/n): ");
                        menuInput = input.nextLine();
                    }

                    System.out.print("\t\t\tEnter distance (in km): ");
                    double jarak = input.nextInt();

                    newOrder.setJarak(jarak);
                    orders.add(newOrder);
                    System.out.println("\t\t\tOrder placed successfully");

                    break;
                case 2:
                    System.out.println("\n\n\t\t\t================== Order ======================");
                    for (int i = 0; i < orders.size(); i++) {
                        Order order = orders.get(i);
                        System.out.println("\t\t\t" + (i + 1) + ". " + order.getRestaurant().getName());
                        System.out.println("\t\t\tMenu:");
                        for (Menu menu : order.getMenus().keySet()) {
                            System.out.println("\t\t\t" + menu.getName() + " x " + order.getMenus().get(menu));
                        }
                        System.out.println("\t\t\tDistance (Shipping: 10000/km): " + order.getJarak() + " km");
                        System.out.println("\t\t\tTotal Price: " + order.getTotalPrice());
                        }
                    pilihan = 3;
                    System.out.print("\t\t\tWould you like to order again? y/n  ");
                    String pesan = scanner.nextLine();
                    if(pesan.equals("n") || pesan.equals("N")) {
                        pilihan = 3;
                        System.out.println("\n\t\t\tPlease Make Payment");
                        System.out.println("\t\t\tThankYou For Order <3 :)");
                    } else{
                        pilihan = 0;
                    }

                    break;
                case 3:
                    menuCustomer();
                    break;

                default:
                    System.out.println("\t\t\tInvalid Choice. Please Try Again (Number 1-3)");
                    break;
            }
        }
    }
}

