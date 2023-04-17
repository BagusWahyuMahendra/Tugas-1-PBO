public class Menu {
    private String name;
    private int price;

    //Constructor menu yang memiliki parameter nama dan harga
    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //Method getter untuk mendapatkan nilai/value nama
    public String getName() {
        return this.name;
    }

    //Method getter untuk mendapatkan nilai/value price
    public int getPrice() {
        return this.price;
    }
}
