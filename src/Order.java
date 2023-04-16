import java.util.HashMap;

public class Order {
    private String restaurantName;
    private Restaurant restaurant;
    private HashMap<Menu, Integer> menus;
    private double jarak;

    public Order(Restaurant restaurant){
        this.restaurant = restaurant;
        this.menus = new HashMap<>();
    }
    public Restaurant getRestaurant(){
        return this.restaurant;
    }

    public HashMap<Menu, Integer> getMenus(){
        return this.menus;
    }

    public double getJarak(){
        return this.jarak;
    }

    public void setJarak(double jarak){
        this.jarak = jarak;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Menu menu : this.menus.keySet()) {
            totalPrice += menu.getPrice() * this.menus.get(menu);
        }
        totalPrice = totalPrice + this.jarak * 10000; // assume delivery cost is 1000 per km
        return totalPrice;
    }

    public void addMenu(Menu menu, int quantity) {
        if (this.menus.containsKey(menu)) {
            int currentQuantity = this.menus.get(menu);
            this.menus.put(menu, currentQuantity + quantity);
        } else {
            this.menus.put(menu, quantity);
        }
    }

}
