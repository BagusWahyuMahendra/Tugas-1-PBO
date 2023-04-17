import java.util.ArrayList;

public class Restaurant {
    //Properti pada class Restaurant
    private String name;
    private String address;
    private ArrayList<Menu> menus;

    //Method constructor
    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.menus = new ArrayList<>();
    }

    //Method getter untuk mendapatkan nilai name
    public String getName() {
        return name;
    }

    //Method getter untuk mendapatkan nilai address
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name +" "+ address;
    }
    public ArrayList<Menu> getMenus(){

        return this.menus;
    }

    //Method add menu digunakan saat menambah menu yang dapat dilakukan oleh admin
    public void addMenu(Menu menu){

        this.menus.add(menu);
    }

}
