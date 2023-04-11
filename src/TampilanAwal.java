import java.util.Scanner;

public class TampilanAwal{
    public static void main(String[] args){
       awal();
    }

    public static void awal(){
        Scanner input = new Scanner(System.in);
        Login masuk = new Login();
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
                masuk.adminLogin();
                break;
            case 2:
                masuk.customerLogin();
                break;
            default:
                System.out.println("Invalid Choice. Please Try Again (Number 1/2)");
        }
    }
}

