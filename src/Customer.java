import java.util.Scanner;
import java.util.HashMap;

public class Customer {
    private String name;
    private String alamat;
   private static HashMap<String, String> users = new HashMap<>();  //membuat objek HashMap untuk menyimpan data user

    public static void menuCustomer(){
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\t\t\t===============================================");
                System.out.println("\t\t\t==  Menu :                                   ==");
                System.out.println("\t\t\t==  1. Sign Up                               ==");
                System.out.println("\t\t\t==  2. Login                                 ==");
                System.out.println("\t\t\t==  3. Back                                  ==");
                System.out.println("\t\t\t===============================================");

                int choice = scanner.nextInt();
                scanner.nextLine();  //menghapus newline yang tersisa dari input sebelumnya

                switch (choice) {
                    case 1:
                        signup(scanner);
                        menuCustomer();
                        break;
                    case 2:
                        login(scanner);
                        running = false;

                        //call daftar restaurant dan menu-menu
                        buatPesanan();
                        break;
                    case 3:
                        running = false;
                        TampilanAwal back = new TampilanAwal();
                        back.awal();
                        break;
                    default:
                        System.out.println("Invalid Choice. Please Try Again (Number 1-3)");
                        break;
                }
            }

            scanner.close();
        }

        private static void login(Scanner scanner) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (users.containsKey(username) && users.get(username).equals(password)) {  //memeriksa apakah username dan password sesuai
                System.out.println("Login successfully!");
            } else {
                System.out.println("Login unsuccessfully, please try again.");
                login(scanner);
            }
        }

        private static void signup(Scanner scanner) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            if (users.containsKey(username)) {  //memeriksa apakah username sudah terdaftar
                System.out.println("Username already registered, please try again.");
                return;
            }
            System.out.print("Password: ");
            String password = scanner.nextLine();
            users.put(username, password);  //menambahkan data user baru ke dalam HashMap
            System.out.println("Signup was successful! Please login.");
        }

        public static void buatPesanan(){
        Scanner scanner = new Scanner(System.in);
        TampilanAwal awal = new TampilanAwal();

            System.out.println("\t\t\t===============================================");
            System.out.println("\t\t\t==  1. Buat Pesanan                          ==");
            System.out.println("\t\t\t==  2. Back                                  ==");
            System.out.println("\t\t\t===============================================");

            System.out.print("\t\t\tYour choice : ");
            int choice = scanner.nextInt();

            if(choice==1){
                ListRestaurant restaurantList = new ListRestaurant();
                restaurantList.displayRestaurants();
            }
            else if(choice==2){
                awal.awal();
            }
            else{
                System.out.println("Invalid choice, Try Again!");
                buatPesanan();
            }
        }
    }

