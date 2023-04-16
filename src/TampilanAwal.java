import java.util.Scanner;

public class TampilanAwal {
    public static void main(String[] args){
        Admin.inisiasiRestaurant();
        awal();
    }


    public static void awal(){
        //Input Console
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
                //Memanggil method adminLogin dari kelas Admin
                Admin.adminLogin();

                break;
            case 2:
                //Memanggil method menuCustomer dari kelas Customer
                Customer.menuCustomer();
                break;
            default:
                //Validasi input apabila memasukkan input selain 1 dan 2
                System.out.println("Invalid Choice. Please Try Again (Number 1/2)");
                awal();
        }
    }
}
