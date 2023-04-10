import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Menampilkan tampilan awal program Food Order..

        System.out.println("\t\t\t===============================================");
        System.out.println("\t\t\t==         Welcome to Foodtify,              ==");
        System.out.println("\t\t\t==      Easy Order, Feeling Better           ==");
        System.out.println("\t\t\t==  Your favorite food, now just click away  ==");
        System.out.println("\t\t\t==                                           ==");
        System.out.println("\t\t\t==  Login :                                  ==");
        System.out.println("\t\t\t==  1. Admin                                 ==");
        System.out.println("\t\t\t==  2. Customer                              ==");
        System.out.println("\t\t\t===============================================");

        System.out.print("\t\t\tYour choice : ");
        int choice = input.nextInt();

        switch (choice){
            case 1:
                adminLogin();
                break;
            case 2:
                customerLogin();
                break;
            default:
                System.out.println("Invalid Choice. Please Try Again (Number 1/2)");
        }
    }

    public static void adminLogin(){
        Scanner input = new Scanner(System.in);

        System.out.println("\t\t\tInput Username and Password");
        System.out.println("Username : ");
        System.out.println("Password : ");

        //Memasukkan usn dan password, jika benar maka lanjut
        System.out.println("\n\n\t\t\tHello, you are logged in as Admin");

        System.out.println("\t\t\t===============================================");
        System.out.println("\t\t\t==  1. Lihat Restaurant                      ==");
        System.out.println("\t\t\t==  2. Tambah Restaurant                     ==");
        System.out.println("\t\t\t==  3. Hapus Restaurant                      ==");
        System.out.println("\t\t\t==  4. Back                                  ==");
        System.out.println("\t\t\t===============================================");

        System.out.print("\t\t\tYour choice : ");
        int choice = input.nextInt();

        switch(choice){
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


    public static void customerLogin(){
        Scanner input = new Scanner(System.in);

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
    }

    public static void pilihRestoran(){
        Scanner input = new Scanner(System.in);

        System.out.println("\t\t\t===============================================");
        System.out.println("\t\t\t==  Restaurant List:                         ==");
        System.out.println("\t\t\t==  1. IndoResto                             ==");
        System.out.println("\t\t\t==  2. JapanResto                            ==");
        System.out.println("\t\t\t==  3. WestResto                             ==");
        System.out.println("\t\t\t===============================================");

        System.out.print("\t\t\tYour choice : ");
        int choice = input.nextInt();

        switch(choice){
            case 1:
                //call Indo Resto di class restoran, id resto 001
                /*
                System.out.println("\t\t\t===============================================");
                System.out.println("\t\t\t==  IndoResto Menu:                          ==");
                System.out.println("\t\t\t==  1. Nasi Goreng  - Rp 25.000              ==");
                System.out.println("\t\t\t==  2. Ayam Goreng  - Rp 30.000              ==");
                System.out.println("\t\t\t==  3. Ayam Bakar   - Rp 30.000              ==");
                System.out.println("\t\t\t==  4. Gudeg        - Rp 20.000              ==");
                System.out.println("\t\t\t==  5. Nasi Pecel   - Rp 25.000              ==");
                System.out.println("\t\t\t==  6. Es Teh       - Rp 10.000              ==");
                System.out.println("\t\t\t==  7. Es Jeruk     - Rp 10.000              ==");
                System.out.println("\t\t\t===============================================");
                 */
            case 2:
                //call Japan Resto di class restoran, id resto 002
                   /*
                System.out.println("\t\t\t===============================================");
                System.out.println("\t\t\t==  JapanResto Menu:                         ==");
                System.out.println("\t\t\t==  1. Sushi        - Rp 30.000              ==");
                System.out.println("\t\t\t==  2. Ramen        - Rp 35.000              ==");
                System.out.println("\t\t\t==  3. Takoyaki     - Rp 25.000              ==");
                System.out.println("\t\t\t==  4. Sashimi      - Rp 35.000              ==");
                System.out.println("\t\t\t==  5. Onigiri      - Rp 20.000              ==");
                System.out.println("\t\t\t==  6. Green Tea    - Rp 25.000              ==");
                System.out.println("\t\t\t==  7. Calpis       - Rp 20.000              ==");
                System.out.println("\t\t\t===============================================");
                 */
            case 3:
                //call West Resto di class restoran, id resto 003
                   /*
                System.out.println("\t\t\t===============================================");
                System.out.println("\t\t\t==  WestResto Menu:                          ==");
                System.out.println("\t\t\t==  1. Hamburger    - Rp 30.000              ==");
                System.out.println("\t\t\t==  2. Pizza        - Rp 45.000              ==");
                System.out.println("\t\t\t==  3. Steak        - Rp 55.000              ==");
                System.out.println("\t\t\t==  4. Spaghetti    - Rp 35.000              ==");
                System.out.println("\t\t\t==  5. Salad        - Rp 30.000              ==");
                System.out.println("\t\t\t==  6. Cola         - Rp 15.000              ==");
                System.out.println("\t\t\t==  7. Americano    - Rp 20.000              ==");
                System.out.println("\t\t\t===============================================");
                 */
        }

    }
}

