import java.util.ArrayList;
import java.util.Scanner;

public class ListRestaurant {

    private ArrayList<Restaurant> restaurantList;

    public ListRestaurant() {
        restaurantList = new ArrayList<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantList.add(restaurant);
    }
    public void displayRestaurants() {
        System.out.println("Restaurant List:");
        for (Restaurant restaurant : restaurantList) {
            System.out.println(restaurant.getId() + " - " + restaurant.getName() + " - " + restaurant.getAddress());
        }
    }

    public static void adminCekResto(){
        Scanner scanner = new Scanner(System.in);
        ListRestaurant restaurantList = new ListRestaurant();

        Restaurant r1 = new Restaurant("001", "IndoResto.", "Denpasar, Bali");
        Restaurant r2 = new Restaurant("002", "JapanResto", "Tabanan, Bali");
        Restaurant r3 = new Restaurant("003", "WestResto", "Badung, Bali");
        restaurantList.addRestaurant(r1);
        restaurantList.addRestaurant(r2);
        restaurantList.addRestaurant(r3);

        while (true) {
            System.out.println("\t\t\t===============================================");
            System.out.println("\t\t\t==  1. Tambah Restaurant                     ==");
            System.out.println("\t\t\t==  2. Lihat Restaurant                      ==");
            System.out.println("\t\t\t==  3. Hapus Restaurant                      ==");
            System.out.println("\t\t\t==  4. Back                                  ==");
            System.out.println("\t\t\t==  5. Exit                                  ==");
            System.out.println("\t\t\t===============================================");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter restaurant id: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter restaurant name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter restaurant address: ");
                    String address = scanner.nextLine();
                    Restaurant restaurant = new Restaurant(id, name, address);
                    restaurantList.addRestaurant(restaurant);
                    System.out.println("Restaurant added successfully.");
                    break;
                case 2:
                    restaurantList.displayRestaurants();
                    break;
                case 3:
                    //call remove restaurant
                    break;
                case 4:
                    TampilanAwal awal = new TampilanAwal();
                    awal.awal();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    adminCekResto();
            }

            System.out.println();
        }
    }
}

