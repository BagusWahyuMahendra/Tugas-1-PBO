import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    private String id;
    private String name;
    private String address;


    public Restaurant(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }
}
