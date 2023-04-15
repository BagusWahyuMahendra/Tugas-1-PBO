public class Menu {
        private String name;
        private double price;
        private boolean makanan;

        public Menu(String name, double price, boolean makanan) {
            this.name = name;
            this.price = price;
            this.makanan = makanan;
        }

        public String getName() {

            return this.name;
        }

        public double getPrice() {

            return this.price;
        }

        public boolean getMakanan() {

        return this.makanan;
        }

        public void display() {
           // System.out.println((menus.indexOf(this) + 1) + ". " + this.name + ": " + this.item.getPrice());
        }
    }

