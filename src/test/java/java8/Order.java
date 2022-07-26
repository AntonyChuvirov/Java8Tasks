package java8;

public class Order {
    int price;
    boolean isVegan;
    String customerName;

    public Order(int price, boolean isVegan, String customerName) {
        this.price = price;
        this.isVegan = isVegan;
        this.customerName = customerName;
    }

    @Override
    public String toString(){
        return "your order price is " + price + ", is vegan? - " + isVegan + ", customer name is " + customerName;
    }
}
