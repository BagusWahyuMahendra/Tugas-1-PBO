import java.util.HashMap;

public class Order {
    private String restaurantName;
    private Restaurant restaurant;
    private HashMap<Menu, Integer> menus;
    private double jarak;

    //Method yang menjadi constructor
    public Order(Restaurant restaurant){
        this.restaurant = restaurant;
        this.menus = new HashMap<>();
    }

    //Method getter untuk restaurant
    public Restaurant getRestaurant(){
        return this.restaurant;
    }

    //Method yang berisikan HashMap untuk menyimpan data
    public HashMap<Menu, Integer> getMenus(){
        return this.menus;
    }

    //Method getter untuk jarak
    public double getJarak(){
        return this.jarak;
    }

    //Method setter untuk jarak
    public void setJarak(double jarak){
        this.jarak = jarak;
    }

    //Method getter untuk total harga
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Menu menu : this.menus.keySet()) {
            totalPrice += menu.getPrice() * this.menus.get(menu);
        }
        totalPrice = totalPrice + this.jarak * 10000; // assume delivery cost is 1000 per km
        return totalPrice;
    }

    //Method yang digunakan untuk menambahkan menu dan kuantitas setiap menu
    public void addMenu(Menu menu, int quantity) {
        if (this.menus.containsKey(menu)) {
            int currentQuantity = this.menus.get(menu);
            this.menus.put(menu, currentQuantity + quantity);
        } else {
            this.menus.put(menu, quantity);
        }
    }

}
